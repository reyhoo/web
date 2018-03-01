package com.mybatis2.exe.mapper;

import java.util.List;

import com.mybatis2.exe.pojo.User;

public interface UserMapper {

	
	int insert(User u);
	
	int delete(Long i);
	
	int update(User user);
	
	User getById(Long _id);
	
	List<User> findAll();
	
	List<User> findByName(String n);
}
