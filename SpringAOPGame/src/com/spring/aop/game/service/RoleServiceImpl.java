package com.spring.aop.game.service;

import com.spring.aop.game.pojo.Role;

public class RoleServiceImpl implements RoleService {

	@Override
	public void printRole(Role role) {
		role.getId();
		System.out.println(role.toString());
	}

}
