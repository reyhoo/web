package com.grade.mvc.service;

import com.grade.mvc.pojo.Role;

public interface RoleService {

	Integer addRole(Role role);
	Role getRole(Long id);
	Integer updateRole(Role role);
}
