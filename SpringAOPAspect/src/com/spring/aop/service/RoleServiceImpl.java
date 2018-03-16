package com.spring.aop.service;

import org.springframework.stereotype.Component;

import com.spring.aop.pojo.Role;

@Component
public class RoleServiceImpl

implements RoleService

{

	@Override
	public void printRole(Role role) {
		role.getId();
		System.out.println(role);
	}

////	@Override
//	public void printRole(Role role,int s) {
//		role.getId();
//		System.out.println(role);
//	}
	
	

}
