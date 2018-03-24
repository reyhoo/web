package com.grade.mvc.service;

import java.util.List;

import com.grade.mvc.pojo.Role;

public interface RoleService {

	Integer addRole(Role role);
	Role getRole(Long id);
	Integer updateRole(Role role);
	List<Role> getAll();
	
	Integer updateRoleList(List<Role>roleList);
}
