package com.grade.mvc.service;

import com.grade.mvc.pojo.Role;

public interface RoleService {

	int addRole(Role role);
	Role getRole(Long id);
}
