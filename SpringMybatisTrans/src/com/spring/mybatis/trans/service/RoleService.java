package com.spring.mybatis.trans.service;

import java.util.List;

import com.spring.mybatis.trans.pojo.Role;

public interface RoleService {

	int insertRole(Role role);
	int insertRoleList(List<Role>roleList);
}
