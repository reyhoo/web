package com.spring.ass.annotation.service;

import org.springframework.stereotype.Component;

import com.spring.ass.annotation.pojo.Role;

@Component
public class RoleServiceImpl implements RoleService {

	@Override
	public void printRoleInfo(Role role) {
		System.out.println("id ="+role.getId());
		System.out.println("roleName ="+role.getRoleName());
		System.out.println("note ="+role.getNote());
	}

}
