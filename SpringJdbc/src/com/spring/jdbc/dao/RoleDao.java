package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.pojo.Role;

public interface RoleDao {

	List<Role>findAll();
	Role findById(Long id);
}
