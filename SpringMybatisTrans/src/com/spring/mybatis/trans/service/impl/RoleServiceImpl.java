package com.spring.mybatis.trans.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mybatis.trans.mapper.RoleMapper;
import com.spring.mybatis.trans.pojo.Role;
import com.spring.mybatis.trans.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;

	
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	@Override
	public int insertRole(Role role) {
		return roleMapper.insertRole(role);
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	@Override
	public int insertRoleList(List<Role> roleList) {
		int count = 0;
		for (Role role : roleList) {
			try {
				//在这里调用insertRole是直接调用自身的方法，方法中的Transactional注解失效
				count += insertRole(role);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return count;
	}

}
