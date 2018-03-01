package com.mybatis2.exe.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import com.mybatis2.exe.pojo.SexEnum;


@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(SexEnum.class)
public class SexEnumTypeHandler implements TypeHandler<SexEnum> {

	private Logger logger = Logger.getLogger(SexEnumTypeHandler.class);
	@Override
	public SexEnum getResult(ResultSet arg0, String arg1) throws SQLException {
		int id = arg0.getInt(arg1);
		SexEnum sex = SexEnum.getSexById(id);
		logger.info("getResult:sex:"+sex);
		return sex;
	}

	@Override
	public SexEnum getResult(ResultSet arg0, int arg1) throws SQLException {
		int id = arg0.getInt(arg1);
		SexEnum sex = SexEnum.getSexById(id);
		logger.info("getResult:sex:"+sex);
		return sex;
	}

	@Override
	public SexEnum getResult(CallableStatement arg0, int arg1)
			throws SQLException {
		int id = arg0.getInt(arg1);
		SexEnum sex = SexEnum.getSexById(id);
		logger.info("getResult:sex:"+sex);
		return sex;
	}

	@Override
	public void setParameter(PreparedStatement arg0, int arg1, SexEnum arg2,
			JdbcType arg3) throws SQLException {
		logger.info("setParameter:sex:"+arg2);
		arg0.setInt(arg1,arg2.getId() );
	}

}
