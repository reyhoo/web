package com.myec.service;

import com.myec.pojo.User;

public interface UserService {

	int regist(User user);
	
	User login(String username,String password);
	
	User getByUsername(String username);
	
	User getById(Long id);
}
