package com.spring.ass.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.ass.annotation.pojo.Role;
@Component
public class RoleServiceImpl2 implements RoleService2{

//	@Autowired
	private Role role ;
	//û��setter����Ҳ�ǿ��Ե�
	@Override
	public void printRoleInfo() {
		System.out.println("id ="+role.getId());
		System.out.println("roleName ="+role.getRoleName());
		System.out.println("note ="+role.getNote());
	}

	@Autowired
	public void setRole(Role role) {
		this.role = role;
	}
}
