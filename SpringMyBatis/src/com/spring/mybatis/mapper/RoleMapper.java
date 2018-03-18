package com.spring.mybatis.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.mybatis.base.BaseMapper;
import com.spring.mybatis.pojo.Role;
//@Repository   
public interface RoleMapper extends BaseMapper {
	
	int insertRole(Role role);
	Role getRole(Long id);
	int updateRole(Role role);
	int deleteRole(Long id);
	List<Role>getAllRole();
	
}
