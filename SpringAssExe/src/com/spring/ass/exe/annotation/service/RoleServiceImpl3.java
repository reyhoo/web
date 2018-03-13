package com.spring.ass.exe.annotation.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.spring.ass.exe.annotation.pojo.Role;

@Component
@Primary
public class RoleServiceImpl3 implements RoleService {

	@Override
	public void printRoleInfo(Role role) {
		System.out.print("{id="+role.getId());
		System.out.print(",roleName="+role.getRoleName());
		System.out.println(",note="+role.getNote()+"}");
	}

}
