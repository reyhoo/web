package com.mybatis2.mapper;

import java.util.List;

import com.mybatis2.pojo.Role;

public interface RoleMapper {
	Role getRole(Long id);
	int insert(Role role);
	List<Role>findAll();
}
