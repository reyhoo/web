package com.jstl.tag.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jstl.tag.pojo.User;
import com.jstl.tag.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	@RequestMapping("/details")
	public String details(Long id,Model model) {
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		return "user_details";
	}
}
