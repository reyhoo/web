package com.jstl.tag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jstl.tag.mapper.UserMapper;
import com.jstl.tag.pojo.PageData;
import com.jstl.tag.pojo.User;
import com.jstl.tag.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;

	@Transactional
	@Override
	public PageData<User> getAllUser(int start, int limit) {
		List<User> list = userMapper.getAll(start, limit);
		int total = userMapper.getCount();
		PageData<User> pageData = new PageData<>();
		pageData.setStart(start);
		pageData.setLimit(limit);
		pageData.setTotal(total);
		pageData.setDataList(list);
		return pageData;
	}
	@Transactional
	@Override
	public User getUser(Long id) {
		return userMapper.getUser(id);
	}

}
