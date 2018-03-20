package com.spring.mvc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.spring.mvc.pojo.Role;

@Repository
public interface RoleMapper {

	Role getRoleById(@Param("id")Long id);
	
	int insertRole(Role role);
	
	List<Role> getAll();
}
