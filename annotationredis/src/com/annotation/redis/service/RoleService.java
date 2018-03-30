package com.annotation.redis.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.annotation.redis.pojo.Role;

public interface RoleService {

	
Role getRole(Long id);
	
	int deleteRole(Long id);
	
	Role insertRole(Role role);
	
	Role updateRole(Role role);
	
	List<Role>findRoles(String roleName,String note);
}
