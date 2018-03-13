package com.spring.ass.exe.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.ass.exe.annotation.pojo.Role;


@Component
public class RoleServiceImpl2 implements RoleService2 {

	@Autowired(required=false)
	private Role role;
	
	
	@Override
	public void printRoleInfo() {
		if(role == null){
			System.out.println("role is null");
			return;
		}
		System.out.println("id = "+role.getId());
		System.out.println("roleName = "+role.getRoleName());
		System.out.println("note = "+role.getNote());
	}
	
//	@Autowired
	public void setRole(Role role) {
		this.role = role;
	}

}
