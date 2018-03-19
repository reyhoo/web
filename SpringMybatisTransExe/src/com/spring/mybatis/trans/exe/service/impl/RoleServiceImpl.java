package com.spring.mybatis.trans.exe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mybatis.trans.exe.mapper.RoleMapper;
import com.spring.mybatis.trans.exe.pojo.Role;
import com.spring.mybatis.trans.exe.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;

	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	@Override
	public int insertRole(Role role) {
		return roleMapper.insertRole(role);
	}

}
