package com.mvc.annotation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.annotation.pojo.Role;
import com.mvc.annotation.service.RoleService;


@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/list")
	public String roleList(ModelMap modelMap){
		List<Role> list = roleService.getRoleList();
		modelMap.addAttribute("roleList", list);
		return "roleList";
	}
	@RequestMapping("/add")
	public String addRole(String roleName,String note){
		roleService.addRole(roleName, note);
		return "redirect:/role/list";
	}
}
