package com.spring.aop.aspect.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.aop.pojo.Role;
@Component
public class RoleDao extends JdbcTemplate {
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	public Role findRoleById(Long id){
		query("select * from t_role where id="+id,new RowMapper<Role>(){

			@Override
			public Role mapRow(ResultSet rs, int index) throws SQLException {
				Role role = new Role();
				role.setId(rs.getLong(index));
				role.setRoleName(rs.getString(index));
				role.setNote(rs.getString(index));
				return role;
			}});
		return null;
	}

}
