package com.mybatis.cascade.mapper;

import java.util.List;

import com.mybatis.cascade.pojo.Role;
import com.mybatis.cascade.pojo.User;

public interface UserMapper {
	User findUser(Long id);

	List<Role> findUserByRoleId(Long roleId);
}
