package com.mvc.exe.service;

import com.mvc.exe.pojo.User;

public interface UserService {

	User login(String username,String password);
	
	
	User findById(Long id);
	
	

	
}
