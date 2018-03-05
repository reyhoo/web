package com.mybatis.dysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mybatis.dysql.pojo.Role;

public interface RoleMapper {

	
	List<Role> getRoleByRoleName(@Param("roleName")String r);
	List<Role> getRoleByBean(Role r);
	List<Role> findsRoles(@Param("roleName") String roleName,@Param("note") String note);
	/**
	 * ��trim��ǩ
	 * @param roleName
	 * @param note
	 * @return
	 */
	List<Role> findsRolesByTrim(@Param("roleName") String roleName,@Param("note") String note);
	
}
