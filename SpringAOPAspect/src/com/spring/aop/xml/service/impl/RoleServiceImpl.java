package com.spring.aop.xml.service.impl;

import com.spring.aop.pojo.Role;
import com.spring.aop.xml.service.RoleService;

public class RoleServiceImpl implements RoleService {

	@Override
	public void printRole(Role role) {
		System.out.print("id = "+role.getId()+",");
		System.out.print("roleName = "+role.getRoleName()+",");
		System.out.println("note = "+role.getNote());
	}

}
