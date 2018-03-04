package com.mybatis.cascade.mapper;

import java.util.List;

import com.mybatis.cascade.pojo.Role;

public interface RoleMapper {

	
	Role findRole(Long id);
	
	List<Role>findRoleByUserId(Long userId);
}
