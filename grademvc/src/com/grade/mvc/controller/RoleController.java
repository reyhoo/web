package com.grade.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.grade.mvc.pojo.Role;
import com.grade.mvc.service.RoleService;


@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String, Object> addRole(Role role){
		Map<String , Object>map = new HashMap<String, Object>();
		Integer count = roleService.addRole(role);
		map.put("total", count);
		return map;
	}
	@ResponseBody
	@RequestMapping("/getRole/{id}")
	public Role getRole(@PathVariable("id")Long id){
		return roleService.getRole(id);
	}
	
	
	/***
	 * ���ʸ�ʽ :http://localhost:8080/grademvc/role/updateRole?hello=164-helldfdfdfo-fafadsfadsfasd
	 * @param r
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateRole")
	public Map<String, Object> updateRole(@RequestParam("hello")Role r){
		Map<String , Object>map = new HashMap<String, Object>();
		Integer count = roleService.updateRole(r);
		map.put("total", count);
		return map;
	}
}
