package com.mvcdev.exe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.mvcdev.exe.pojo.Role;
import com.mvcdev.exe.service.RoleService;

@Controller
@RequestMapping("/attribute")
public class AttributeController {

	@Autowired
	private RoleService roleService;
	@RequestMapping(value="/requestAttribute")
	public ModelAndView requestAttr(@RequestAttribute("id") Long id){
		Role role = roleService.getRole(id);
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		mv.addObject("role", role);
		return mv;
	}
}
