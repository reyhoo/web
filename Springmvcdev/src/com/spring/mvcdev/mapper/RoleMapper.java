package com.spring.mvcdev.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.spring.mvcdev.pojo.Role;

@Repository
public interface RoleMapper {


	Role getRoleById(Long id);
	
	int insertRole(Role role);
	
	List<Role> getAll();
	
	List<Role> findRoles(Role roleParams);
	
	int deleteRoles(@Param("ids")List<Long>id);
}
