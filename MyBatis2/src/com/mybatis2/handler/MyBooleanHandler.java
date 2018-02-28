package com.mybatis2.handler;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;


@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(Boolean.class)
public class MyBooleanHandler implements TypeHandler<Boolean> {

	Logger logger = Logger.getLogger(MyBooleanHandler.class);
	@Override
	public Boolean getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		BigDecimal i = rs.getBigDecimal(columnName);
		logger.info(i);
		if(i!=null){
			int r = i.intValue();
			return r == 100;
		}
		return null;
	}

	@Override
	public Boolean getResult(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		BigDecimal i = rs.getBigDecimal(arg1);
		logger.info(i);
		if(i!=null){
			int r = i.intValue();
			return r == 100;
		}
		return null;
	}

	@Override
	public Boolean getResult(CallableStatement arg0, int arg1)
			throws SQLException {
		BigDecimal i = arg0.getBigDecimal(arg1);
		logger.info(i);
		if(i!=null){
			int r = i.intValue();
			return r == 100;
		}
		return null;
	}

	@Override
	public void setParameter(PreparedStatement arg0, int arg1, Boolean arg2,
			JdbcType arg3) throws SQLException {
		logger.info(arg2);

		if(arg2 == null){
			arg0.setBigDecimal(arg1, null);
		}else{
			arg0.setInt(arg1, arg2?100:-100);
		}
		
	}

}
