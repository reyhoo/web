package com.mybatis.plugin.plugin;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;

import com.mybatis.plugin.pojo.PageParams;


@Intercepts({
	@Signature(
			type=StatementHandler.class,
			method="prepare",
			args={Connection.class,Integer.class})})
public class PagePlugin implements Interceptor{

	
	/***
	 * 插件默认参数，可配置默认值
	 */
	
	private Integer defaultPage;
	private Integer defaultPageSize;
	private Boolean defaultUseFlag;
	private Boolean defaultCheckFlag;
	private Boolean defaultCleanOrderBy;
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler stmtHandler = (StatementHandler) getUnProxyObject(invocation.getTarget());
		MetaObject metaStatementHandler = SystemMetaObject.forObject(stmtHandler);
		String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
		MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
		if(!checkSelect(sql)){
			return invocation.proceed();
		}
		BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
		Object parameterObject = boundSql.getParameterObject();
		PageParams pageParams = getPageParamsForParamObj(parameterObject);
		if(pageParams == null){
			return invocation.proceed();
		}
		Boolean useFlag = pageParams.getUseFlag() == null?defaultUseFlag:pageParams.getUseFlag();
		if(!useFlag){
			return invocation.proceed();
		}
		Integer pageNum = pageParams.getPage() == null ? defaultPage : pageParams.getPage();
		Integer pageSize = pageParams.getPageSize() == null ? defaultPageSize: pageParams.getPageSize();
		Boolean checkFlag = pageParams.getCheckFlag() == null ? defaultCheckFlag:pageParams.getCheckFlag();
		Boolean cleanOrderBy = pageParams.getCleanOrderBy() == null? defaultCleanOrderBy:pageParams.getCleanOrderBy();
		int total = getTotal(invocation, metaStatementHandler, boundSql, cleanOrderBy);
		pageParams.setTotal(total);
		int totalPage = total % pageSize == 0?total/pageSize : total/pageSize+1;
		pageParams.setTotalPage(totalPage);
		checkPage(checkFlag,pageNum,totalPage);
		
		return preparedSQL(invocation,metaStatementHandler,boundSql,pageNum,pageSize,cleanOrderBy);
	}
	
	
	private Object preparedSQL(Invocation invocation,MetaObject metaStatementHandler,BoundSql boundSql,
			int pageNum,int pageSize,boolean cleanOrderBy)throws Exception{
		String sql = boundSql.getSql();
		if(cleanOrderBy){
			sql = this.cleanOrderByForSql(sql);
		}
		String newSql = "select * from ("+sql+") $_paging_table limit ?,?";
		metaStatementHandler.setValue("delegate.boundSql.sql", newSql);
		Object statementObj = invocation.proceed();
		this.preparePageDataParams((PreparedStatement) statementObj,pageNum,pageSize);
		return statementObj;
	}
	private void preparePageDataParams(PreparedStatement ps,int pageNum,int pageSize)throws Exception{
		int idx = ps.getParameterMetaData().getParameterCount();
		ps.setInt(idx-1, (pageNum-1) * pageSize);
		ps.setInt(idx, pageSize);
	}
	private void checkPage(Boolean checkFlag,Integer pageNum,Integer totalPage) throws Exception{
		if(checkFlag){
			if(pageNum > totalPage){
				throw new Exception("查询失败，查询页码【"+pageNum+"】大于总页数【"+totalPage+"】!!");
			}
		}
	}
	
	private int getTotal(Invocation ivt,MetaObject metaStatementHandler,BoundSql boundSql,Boolean  cleanOrderBy)
		throws Throwable
	{
		MappedStatement mappedStatement =
				(MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
		Configuration cfg = mappedStatement.getConfiguration();
		String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
		if(cleanOrderBy){
			sql = this.cleanOrderByForSql(sql);
		}
		String countSql = "select count(*) as total from ("+sql+") $_paging";
		Connection connection = (Connection) ivt.getArgs()[0];
		PreparedStatement ps = null;
		int total = 0;
		try{
			ps = connection.prepareStatement(countSql);
			BoundSql countBoundSql = new BoundSql(cfg, countSql, boundSql.getParameterMappings(), boundSql.getParameterObject());
			ParameterHandler handler = new DefaultParameterHandler(mappedStatement, boundSql.getParameterObject(), countBoundSql);
			handler.setParameters(ps);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				total = rs.getInt("total");
			}
		}finally{
			if(ps!=null){
				ps.close();
			}
		}
		return total;
		
	}
	
	private String cleanOrderByForSql(String sql){
		StringBuilder sb = new StringBuilder(sql);
		String newSql = sql.toLowerCase();
		if(newSql.indexOf("order") == -1){
			return sql;
		}
		int idx = newSql.lastIndexOf("order");
		return sb.substring(0,idx).toString();
	}
	
	private PageParams getPageParamsForParamObj(Object parameterObject)throws Exception{
		PageParams pageParams = null;
		if(parameterObject == null){
			return null;
		}
		if(parameterObject instanceof Map){
			Map<String, Object>paramMap = (Map<String, Object>) parameterObject;
			Set<String>keySet = paramMap.keySet();
			Iterator<String> iterator = keySet.iterator();
			while(iterator.hasNext()){
				String key = iterator.next();
				Object value = paramMap.get(key);
				if(value instanceof PageParams){
					return (PageParams) value;
				}
			}
		}else if(parameterObject instanceof PageParams){
			return (PageParams) parameterObject;
		}else{
			Field[] fields = parameterObject.getClass().getDeclaredFields();
			for (Field field : fields) {
				if(field.getType() == PageParams.class){
					PropertyDescriptor pd = new PropertyDescriptor(field.getName(), parameterObject.getClass());
					Method method = pd.getReadMethod();
					return (PageParams) method.invoke(parameterObject);
				}
			}
		}
		return pageParams;
	}

	private boolean checkSelect(String sql) {
		String trimSql = sql.trim();
		int idx = trimSql.toLowerCase().indexOf("select");
		return idx == 0;
	}

	@Override
	public Object plugin(Object arg0) {
		return Plugin.wrap(arg0, this);
	}

	@Override
	public void setProperties(Properties props) {
		String strDefaultPage = props.getProperty("default.page", "1");
		String strDefaultPageSize = props.getProperty("default.pageSize", "50");
		String strDefaultUseFlag = props.getProperty("default.useFlag", "false");
		String strDefaultCheckFlag = props.getProperty("default.checkFlag", "false");
		String strDefaultCleanOrderBy=props.getProperty("default.cleanOrderBy", "false");
		this.defaultCheckFlag = Boolean.parseBoolean(strDefaultCheckFlag);
		this.defaultCleanOrderBy = Boolean.parseBoolean(strDefaultCleanOrderBy);
		this.defaultPage = Integer.parseInt(strDefaultPage);
		this.defaultPageSize = Integer.parseInt(strDefaultPageSize);
		this.defaultUseFlag = Boolean.parseBoolean(strDefaultUseFlag);
	}
	
	private Object getUnProxyObject(Object target){
		MetaObject metaStatementHandler = SystemMetaObject.forObject(target);
		Object object = null;
		while(metaStatementHandler.hasGetter("h")){
			object = metaStatementHandler.getValue("h");
			metaStatementHandler = SystemMetaObject.forObject(object);
		}
		if(object == null){
			return target;
		}
		return object;
	}
	
}
