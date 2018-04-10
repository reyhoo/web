package com.mvc.exe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.exe.mapper.UserMapper;
import com.mvc.exe.pojo.User;
import com.mvc.exe.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(String username, String password) {
		return userMapper.findByUsernameAndPassword(username, password);
	}
	@Override
	public User findById(Long id) {
		return userMapper.findById(id);
	}

}
