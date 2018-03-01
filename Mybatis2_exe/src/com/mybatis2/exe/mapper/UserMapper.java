package com.mybatis2.exe.mapper;

import java.util.List;

import com.mybatis2.exe.pojo.User;

public interface UserMapper {

	
	int insert(User user);
	
	int delete(Long id);
	
	int update(User user);
	
	User getById(Long id);
	
	List<User> findAll();
	
	List<User> findByName(String name);
}
