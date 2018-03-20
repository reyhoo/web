package com.spring.mvcdev.service;

import java.util.List;

import com.spring.mvcdev.pojo.Role;


public interface RoleService {

	Role getRole(Long id);
	
	int addRole(Role role);
	
	List<Role>getRoleList();
	
	
	List<Role>findRoles(Role role);
}
