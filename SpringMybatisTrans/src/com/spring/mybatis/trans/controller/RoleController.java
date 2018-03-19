package com.spring.mybatis.trans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.mybatis.trans.pojo.Role;
import com.spring.mybatis.trans.service.RoleListService;
import com.spring.mybatis.trans.service.RoleService;

@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleListService roleListService;

	public void errerUseServices() {
		Role role = new Role();
		role.setNote("note_3");
		role.setRoleName("role_name_3");
		roleService.insertRole(role);
		role = new Role();
		role.setNote("note_4");
		role.setRoleName("role_name_4");
		roleService.insertRole(role);
	}
}
