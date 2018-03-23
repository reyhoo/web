package com.grade.mvc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.grade.mvc.pojo.Role;

@Repository
public interface RoleMapper {


	Role getRoleById(Long id);
	
	int insertRole(Role role);
	
	List<Role> getAll();
	
	int deleteRoles(@Param("ids")List<Long>id);
}
