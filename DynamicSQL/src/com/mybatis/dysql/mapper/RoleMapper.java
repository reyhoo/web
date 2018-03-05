package com.mybatis.dysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mybatis.dysql.pojo.Role;

public interface RoleMapper {

	
	List<Role> getRoleByRoleName(@Param("roleName")String r);
	Role getRoleBean(Role r);
}
