package com.mvc.exe.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.SessionHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.method.annotation.SessionAttributesHandler;

import com.mvc.exe.pojo.User;
import com.mvc.exe.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes(names= {"user"})
public class UserController {

	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public String login(@Valid User u,Model model) {
		User user = userService.login(u.getUsername(), u.getPassword());
		if(user == null) {
			throw new RuntimeException("用户不存在");
		}
		model.addAttribute("user", user);
		return "redirect:/role/list";
	}
	@RequestMapping("/logout")
	public String logout() {
		return "logout";
	}
}
