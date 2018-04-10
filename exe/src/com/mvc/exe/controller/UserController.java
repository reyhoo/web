package com.mvc.exe.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.SessionHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.method.annotation.SessionAttributesHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.exe.pojo.User;
import com.mvc.exe.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes(names= {"loginUser"})
public class UserController {

	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public ModelAndView login(@Valid User u,Errors erros) {
		ModelAndView mv = new ModelAndView();
		if(erros.hasFieldErrors("username")) {
			mv.addObject("usernameErrInfo", erros.getFieldError("username"));
			mv.setViewName("login");
			return mv;
		}
		if(erros.hasFieldErrors("password")) {
			mv.addObject("passwordErrInfo", erros.getFieldError("password"));
			mv.setViewName("login");
			return mv;
		}
		User user = userService.login(u.getUsername(), u.getPassword());
		if(user == null) {
			mv.addObject("errInfo", "用户不存在");
			mv.setViewName("login");
			return mv;
		}
		mv.addObject("loginUser", user);
		mv.setViewName("redirect:/role/list");
		return mv;
	}
	@RequestMapping("/logout")
	public String logout() {
		return "logout";
	}
}
