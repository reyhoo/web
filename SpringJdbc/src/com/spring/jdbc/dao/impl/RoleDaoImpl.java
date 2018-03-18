package com.spring.jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.dao.RoleDao;
import com.spring.jdbc.pojo.Role;
@Component
public class RoleDaoImpl implements RoleDao {

	private JdbcTemplate template;
	
	@Autowired
	@Qualifier("simpleDataSource")
	public void setDataSource(DataSource dataSource){
		template = new JdbcTemplate(dataSource);
	}
	@Override
	public List<Role> findAll() {
		List<Role> list = template.query("select * from t_role", new RoleRowMapper());
		return list;
	}

	@Override
	public Role findById(Long id) {
		return template.queryForObject("select * from t_role where id=?", new Object[]{id},  new RoleRowMapper());
		 
	}

	private class RoleRowMapper implements RowMapper<Role>{

		@Override
		public Role mapRow(ResultSet rs, int arg1) throws SQLException {
			Role role = new Role();
			role.setId(rs.getLong("id"));
			role.setRoleName(rs.getString("role_name"));
			role.setNote(rs.getString("note"));
			return role;
		}}
}
