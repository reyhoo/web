package com.mvc.exe.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import com.mvc.exe.pojo.Sex;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(Sex.class)
public class SexTypeHandler implements TypeHandler<Sex>{

	@Override
	public Sex getResult(ResultSet arg0, String arg1) throws SQLException {
		return Sex.getSexById(arg0.getInt(arg1));
	}

	@Override
	public Sex getResult(ResultSet arg0, int arg1) throws SQLException {
		return Sex.getSexById(arg0.getInt(arg1));
	}

	@Override
	public Sex getResult(CallableStatement arg0, int arg1) throws SQLException {
		return Sex.getSexById(arg0.getInt(arg1));
	}

	@Override
	public void setParameter(PreparedStatement arg0, int arg1, Sex arg2, JdbcType arg3) throws SQLException {
		if(arg2 == null) {
			arg0.setBigDecimal(arg1, null);
		}
		int sex = arg2.getId();
		arg0.setInt(arg1, sex);
	}

}
