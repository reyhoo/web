package com.gradle.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gradle.mvc.pojo.Role;
import com.gradle.mvc.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	/**
	 * 加上Valid注解，就是按照配置校验，校验不过报错(400)
	 * 如果再方法里加Errors参数，就不报错。
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public Role add(@Valid Role role) {
		roleService.insertRole(role);
		return role;
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public Role update(Role role) {
		roleService.updateRole(role);
		return role;
	}
}
