package com.mvcdev.exe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.mvcdev.exe.pojo.Role;
import com.mvcdev.exe.service.RoleService;

@Controller
@RequestMapping("/json")
public class JsonRequestController {

	@Value("#{roleService}")
	private RoleService roleService;
	@RequestMapping(value="/findRoles",method=RequestMethod.POST)
	public ModelAndView findRoles(@RequestBody(required=true)Role roleParams){
		List<Role> l = roleService.findRoles(roleParams);
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		mv.addObject(l);
		return mv;
	}
	@RequestMapping(value="/deleteBatch",method=RequestMethod.POST)
	public ModelAndView deleteBatch(@RequestBody List<Long>ids){
		ModelAndView mv = new ModelAndView();
		int count = roleService.deleteRoles(ids);
		mv.setView(new MappingJackson2JsonView());
		mv.addObject("total",count);
		return mv;
	}
	@RequestMapping(value="/addRoles",method=RequestMethod.POST)
	public ModelAndView addRoles(@RequestBody List<Role>roleList){
		ModelAndView mv = new ModelAndView();
		int count = roleService.addRoles(roleList);
		mv.setView(new MappingJackson2JsonView());
		mv.addObject("total",count);
		return mv;
	}
}
