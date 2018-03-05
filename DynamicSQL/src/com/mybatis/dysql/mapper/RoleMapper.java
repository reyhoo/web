package com.mybatis.dysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mybatis.dysql.pojo.Role;
import com.mybatis.dysql.pojo.User;

public interface RoleMapper {

	
	List<Role> getRoleByRoleName(@Param("roleName")String r);
	List<Role> getRoleByBean(Role r);
	List<Role> findsRoles(@Param("roleName") String roleName,@Param("note") String note);
	/**
	 * ”√trim±Í«©
	 * @param roleName
	 * @param note
	 * @return
	 */
	List<Role> findsRolesByTrim(@Param("roleName") String roleName,@Param("note") String note);
	
	
	int updateRole(Role role);
	
	int updateRoleByTrim(Role role);
	
	int updateUser(User user);
}
