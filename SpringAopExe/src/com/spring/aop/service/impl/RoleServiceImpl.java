package com.spring.aop.service.impl;

import org.springframework.stereotype.Component;

import com.spring.aop.pojo.Role;
import com.spring.aop.service.RoleService;
@Component
public class RoleServiceImpl implements RoleService {

	@Override
	public void printRole(Role role) {
		role.getId();
		System.out.println(role);
	}

}
