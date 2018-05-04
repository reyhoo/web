package com.myec.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import com.myec.pojo.OrderStatusEnum;
//
//@MappedJdbcTypes(JdbcType.VARCHAR)
//@MappedTypes(OrderStatusEnum.class)
public class OrderStatusEnumTypeHandler implements TypeHandler<OrderStatusEnum>{

	@Override
	public OrderStatusEnum getResult(ResultSet arg0, String arg1) throws SQLException {
		return OrderStatusEnum.getStatusByValue(arg0.getString(arg1));
	}

	@Override
	public OrderStatusEnum getResult(ResultSet arg0, int arg1) throws SQLException {
		return OrderStatusEnum.getStatusByValue(arg0.getString(arg1));
	}

	@Override
	public OrderStatusEnum getResult(CallableStatement arg0, int arg1) throws SQLException {
		return OrderStatusEnum.getStatusByValue(arg0.getString(arg1));
	}

	@Override
	public void setParameter(PreparedStatement arg0, int arg1, OrderStatusEnum arg2, JdbcType arg3)
			throws SQLException {
		if(arg2 == null) {
			arg0.setString(arg1, null);
		}else {
			String status = arg2.getValue();
			arg0.setString(arg1, status);
		}
	}

}
