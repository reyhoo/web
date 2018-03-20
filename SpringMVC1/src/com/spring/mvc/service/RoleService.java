package com.spring.mvc.service;

import java.util.List;

import com.spring.mvc.pojo.Role;


public interface RoleService {

	Role getRole(Long id);
	
	int addRole(Role role);
	
	List<Role>getRoleList();
}
