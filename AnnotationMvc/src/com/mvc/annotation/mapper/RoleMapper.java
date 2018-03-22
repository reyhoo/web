package com.mvc.annotation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mvc.annotation.pojo.Role;

@Repository
public interface RoleMapper {


	Role getRoleById(Long id);
	
	int insertRole(Role role);
	
	List<Role> getAll();
	
	List<Role> findRoles(Role roleParams);
	
	int deleteRoles(@Param("ids")List<Long>id);
}
