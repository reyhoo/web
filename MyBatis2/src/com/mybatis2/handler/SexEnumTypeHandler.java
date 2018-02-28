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

import com.mybatis2.pojo.SexEnum;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(SexEnum.class)
public class SexEnumTypeHandler implements TypeHandler<SexEnum> {

	Logger logger = Logger.getLogger(SexEnumTypeHandler.class);
	@Override
	public SexEnum getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		int i = rs.getInt(columnName);
		logger.info(SexEnum.getSexById(i));
		return SexEnum.getSexById(i);
	}

	@Override
	public SexEnum getResult(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		int i = rs.getInt(arg1);
		logger.info(SexEnum.getSexById(i));
		return SexEnum.getSexById(i);
	}

	@Override
	public SexEnum getResult(CallableStatement arg0, int arg1)
			throws SQLException {
		int i = arg0.getInt(arg1);
		logger.info(SexEnum.getSexById(i));
		return SexEnum.getSexById(i);
	}

	@Override
	public void setParameter(PreparedStatement arg0, int arg1, SexEnum arg2,
			JdbcType arg3) throws SQLException {
		logger.info(arg2);
		arg0.setInt(arg1, arg2.getId());
		
		
	}

}
