package com.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.spring.mvc.pojo.Role;
import com.spring.mvc.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping("/getById")
	public ModelAndView getRole(@RequestParam(required=false,name="id") Long id){
		Role role = roleService.getRole(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("roleDetails");
		//指定视图类型
//		mv.setView(new MappingJackson2JsonView());
		mv.addObject("role", role);
		return mv;
	}
	
	@RequestMapping("/getAll")
	public ModelAndView getRoleList(){
		List<Role> roleList = roleService.getRoleList();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("roleList");
		mv.addObject("roleList", roleList);
		return mv;
	}
}
