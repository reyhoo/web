package com.annotation.redis.mapper;

import java.util.List;

import javax.servlet.annotation.HandlesTypes;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.stereotype.Repository;

import com.annotation.redis.pojo.Role;
@Repository
public interface RoleDao {

	Role getRole(Long id);
	
	int deleteRole(Long id);
	
	int insertRole(Role role);
	
	int updateRole(Role role);
	
	List<Role>findRoles(@Param("roleName")String roleName,@Param("note")String note);
}
