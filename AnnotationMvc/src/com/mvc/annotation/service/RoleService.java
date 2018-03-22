package com.mvc.annotation.service;

import java.util.List;

import com.mvc.annotation.pojo.Role;


public interface RoleService {

	Role getRole(Long id);
	
	int addRole(Role role);
	
	Role addRole(String roleName,String note);
	
	List<Role>getRoleList();
	
	
	List<Role>findRoles(Role role);
	
	int deleteRoles(List<Long>id);
	int addRoles(List<Role> roleList);
}
