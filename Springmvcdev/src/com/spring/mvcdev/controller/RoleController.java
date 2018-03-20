package com.spring.mvcdev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.spring.mvcdev.pojo.Role;
import com.spring.mvcdev.service.RoleService;
@Controller
@RequestMapping("/params")
public class RoleController {

	@Autowired
	private RoleService roleService;
	/**
	 * 接收普通参数
	 * @param roleName
	 * @param note
	 * @return
	 */
	@RequestMapping("/commonParams")
//	public ModelAndView commonParams(String roleName,String note){
	public ModelAndView commonParams(@RequestParam(name="role_name")String roleName,String note){
		System.out.println("roleName => "+roleName);
		System.out.println("note => "+note);
		Role role = new Role();
		role.setRoleName(roleName);
		role.setNote(note);
		roleService.addRole(role);
		List<Role> roleList = roleService.getRoleList();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("roleList");
		mv.addObject("roleList", roleList);
		return mv;
	}
	
	@RequestMapping("/commonParamPojo")
	public ModelAndView commonParamPojo(Role role){
		System.out.println("role => "+role);
		roleService.addRole(role);
		List<Role> roleList = roleService.getRoleList();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("roleList");
		mv.addObject("roleList", roleList);
		return mv;
	}
	
	@RequestMapping("/getRole/{id}")
	public ModelAndView getRole(@PathVariable("id")Long id){
		System.out.println("id => "+id);
		Role role = roleService.getRole(id);
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());;
		mv.addObject("role", role);
		return mv;
	}
	@RequestMapping("/findRoles")
	public ModelAndView findRoles(@RequestBody Role roleParams){
		System.out.println("roleParams => "+roleParams);
		List<Role> list = roleService.findRoles(roleParams);
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());;
		mv.addObject(list);
		return mv;
	}
}
