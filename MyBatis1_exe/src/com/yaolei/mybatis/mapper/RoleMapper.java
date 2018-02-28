package com.yaolei.mybatis.mapper;

import java.util.List;

import com.yaolei.mybatis.pojo.Role;

public interface RoleMapper {

	
	int insertRole(Role role);
	int deleteRole(Long id);
	int updateRole(Role role);
	Role getRole(Long id);
	List<Role>findRoles(String roleName);
}
