package com.mvc.exe.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mvc.exe.pojo.Role;

public interface RoleService {

	List<Role>findByUserId(Long userId);
	
	int add(@Param("userId")Long userId,@Param("role")Role role);
	
	int update(Role role);
	
	int delete(Long id);
	
	Role findById(Long id);
}
