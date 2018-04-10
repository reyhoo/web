package com.mvc.exe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.mvc.exe.mapper.RoleMapper;
import com.mvc.exe.mapper.UserMapper;
import com.mvc.exe.pojo.Role;
import com.mvc.exe.pojo.User;
import com.mvc.exe.service.RoleService;
import com.mvc.exe.service.UserService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private UserService userService;
	
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/list")
	public String list(@SessionAttribute("user") User user,Model model) {
		List<Role> roleList = userService.findById(user.getId()).getRoleList();
		model.addAttribute("roleList", roleList);
		return "role_list";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam Long id) {
		roleService.delete(id);
		return "redirect:/role/list";
	}
	
	
}
