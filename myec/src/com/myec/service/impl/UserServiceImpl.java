package com.myec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myec.mapper.UserMapper;
import com.myec.pojo.User;
import com.myec.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Transactional
	@Override
	public int regist(User user) {
		return userMapper.add(user);
	}

	@Override
	public User login(String username, String password) {
		return userMapper.getForLogin(username, password);
	}

	@Override
	public User getByUsername(String username) {
		return userMapper.getByUsername(username);
	}

	@Override
	public User getById(Long id) {
		return userMapper.getById(id);
	}

}
