package com.grade.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.grade.mvc.service.RoleService;


@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping("/add")
	public ModelAndView addRole(){
		ModelAndView mv= new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		roleService.addRole(null);
		mv.addObject("total", 10);
		return mv;
	}
}
