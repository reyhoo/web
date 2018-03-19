package com.spring.mybatis.trans.exe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mybatis.trans.exe.pojo.Role;
import com.spring.mybatis.trans.exe.service.RoleListService;
import com.spring.mybatis.trans.exe.service.RoleService;

@Service
public class RoleListServiceImpl implements RoleListService {
	@Autowired
	private RoleService roleService;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	@Override
	public int insertRoleList(List<Role> roleList) {
		int count = 0;
		for (Role role : roleList) {
			try {
				count += roleService.insertRole(role);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return count;
	}

}
