package com.spring.ass.recode.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.ass.recode.pojo.Role;
public class RoleServiceImpl2 implements RoleService {

	private DataSource dataSource;
	@Override
	public Role getRoleById(Long id) {
		System.out.println("RoleServiceImpl2...");
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		try{
			conn = dataSource.getConnection();
			stat = conn.prepareStatement("select * from t_role where id=?");
			stat.setLong(1, id);
			rs = stat.executeQuery();
			if(rs.next()){
				Role role = new Role();
				role.setId(rs.getLong("id"));
				role.setNote(rs.getString("note"));
				role.setRoleName(rs.getString("role_name"));
				return role;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Role> findAll() {
		System.out.println("RoleServiceImpl2...");
		List<Role>list = new ArrayList<Role>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try{
			conn = dataSource.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from t_role");
			while(rs.next()){
				Role role = new Role();
				role.setId(rs.getLong("id"));
				role.setNote(rs.getString("note"));
				role.setRoleName(rs.getString("role_name"));
				list.add(role);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
