package com.spring.ass.exe.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.ass.exe.annotation.pojo.Role;
import com.spring.ass.exe.annotation.service.RoleService;
@Component
public class RoleController {

	@Autowired
	@Qualifier("roleServiceImpl3")
	private RoleService roleService;
	
	public void printRole(Role role){
		roleService.printRoleInfo(role);
	}
}
