package com.spring.mybatis.exe.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.mybatis.exe.pojo.Role;
@Repository
public interface RoleMapper {

	
	int insertRole(Role role);
	Role getRole(Long id);
	int updateRole(Role role);
	int deleteRole(Long id);
	List<Role>getAllRole();
}
