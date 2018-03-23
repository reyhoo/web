package com.mvc.annotation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

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
	@RequestMapping("/getRole/{id}")
	public ModelAndView getRole(@PathVariable("id")Long id){
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		Role role = roleService.getRole(id);
		mv.addObject("role", role==null?new Role():role);
		return mv;
	}
	@RequestMapping(value="/addBatch",method=RequestMethod.POST)
	public ModelAndView addBatch(@RequestBody List<Role> roleList){
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		Integer total = roleService.addRoles(roleList);
		mv.addObject("total",total==null?-1:total);
		return mv;
	}
	@RequestMapping("/add")
	public String addRole(String roleName,String note){
		roleService.addRole(roleName, note);
		return "redirect:/role/list";
	}
	@RequestMapping("/sendJsonPage")
	public String sendJsonPage(){
		return "sendJson";
	}
}
