package com.spring.mybatis.trans.mapper;

import org.springframework.stereotype.Repository;

import com.spring.mybatis.trans.pojo.Role;
@Repository
public interface RoleMapper {

	int insertRole(Role role);
}
