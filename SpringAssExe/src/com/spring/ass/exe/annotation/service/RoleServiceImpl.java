package com.spring.ass.exe.annotation.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.spring.ass.exe.annotation.pojo.Role;

@Component
@Primary
public class RoleServiceImpl implements RoleService {

	
	@Override
	public void printRoleInfo(Role role) {
		System.out.println("id = "+role.getId());
		System.out.println("roleName = "+role.getRoleName());
		System.out.println("note = "+role.getNote());
	}

}
