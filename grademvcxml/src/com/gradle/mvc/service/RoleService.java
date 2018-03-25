package com.gradle.mvc.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gradle.mvc.pojo.Role;

public interface RoleService {

	Role getRoleById(Long id);
	
	int insertRole(Role role);
	
	List<Role> getAll();
	
	int deleteRoles(@Param("ids")List<Long>id);
	
	int updateRole(Role role);
}
