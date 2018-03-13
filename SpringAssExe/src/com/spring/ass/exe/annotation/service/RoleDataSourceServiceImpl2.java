package com.spring.ass.exe.annotation.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.ass.exe.annotation.pojo.Role;

//@Component
public class RoleDataSourceServiceImpl2 implements RoleDataSourceService {

//	@Autowired
	private DataSource dataSource = null;
	@Override
	public Role getRole(Long id) {
		System.out.println("RoleDataSourceServiceImpl2");
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Role role = null;
		try{
			conn = dataSource.getConnection();
			ps = conn.prepareStatement("select * from t_role where id=?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				role = new Role();
				role.setId(rs.getLong("id"));
				role.setRoleName(rs.getString("role_name"));
				role.setNote(rs.getString("note"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return role;
	}

	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
