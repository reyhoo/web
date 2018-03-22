package com.mvcdev.exe.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.mvcdev.exe.pojo.Role;
import com.mvcdev.exe.service.RoleService;

@Controller
@RequestMapping("/model")
public class ModelController {
	
	@Value("#{roleService}")
	private RoleService roleService;
	@RequestMapping("/getRoleByModelMap")
	public String getRoleByModelMap(@RequestParam(value="id") Long id,ModelMap modelMap){
		Role role = roleService.getRole(id);
		modelMap.addAttribute("role",role);
		return "roleDetails";
	}
	
	@RequestMapping("/getRoleByModel")
	public ModelAndView getRoleByModel(@RequestParam(value="id") Long id,Model model){
		Role role = roleService.getRole(id);
		model.addAttribute("role",role);
		ModelAndView mv = new ModelAndView();
//		mv.setViewName("roleDetails");
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
	@RequestMapping("/getRoleByMv/{id}")
	public ModelAndView getRoleByMv(@PathVariable("id") Long id,ModelAndView mv){
		Role role = roleService.getRole(id);
		mv.addObject("role",role);
		mv.setViewName("roleDetails");
		return mv;
	}
}
