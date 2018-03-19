package com.spring.mybatis.trans.exe.mapper;

import org.springframework.stereotype.Repository;

import com.spring.mybatis.trans.exe.pojo.Role;
@Repository
public interface RoleMapper {

	int insertRole(Role role);
}
