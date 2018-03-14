package com.mybatis.cache.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mybatis.cache.pojo.Role;

public interface RoleMapper {
	List<Role> findAll();
	
	Role findById(Long id);
	
	int insertRole(@Param("role")Role role);
	int updateRole(@Param("role")Role role);
	int delete(Long id);
}
