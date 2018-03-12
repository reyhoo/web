package com.spring.ass.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.ass.annotation.pojo.Role;
import com.spring.ass.annotation.service.RoleService;
@Component
public class RoleController2 {

	private RoleService roleService=null;
	
	public RoleController2(@Autowired @Qualifier("roleServiceImpl") RoleService roleService){
		this.roleService = roleService;
	}
	public void printRole(Role role){
		roleService.printRoleInfo(role);
	}
}
