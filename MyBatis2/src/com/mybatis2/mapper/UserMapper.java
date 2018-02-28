package com.mybatis2.mapper;

import java.util.List;

import com.mybatis2.pojo.User;

public interface UserMapper {

	
	int insert(User user);
	
	List<User>findAll();
}
