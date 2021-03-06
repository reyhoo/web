package com.grade.mvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.grade.mvc.pojo.Role;
import com.grade.mvc.service.RoleService;


@Controller
@RequestMapping("/role")
@SessionAttributes(names="roleList")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String, Object> addRole(Role role){
		Map<String , Object>map = new HashMap<String, Object>();
//			Integer count = roleService.addRole(role);
			map.put("total", 0);
			map.put("role", role);
		
		return map;
	}
	@ResponseBody
	@RequestMapping(value="/bodyAdd",method=RequestMethod.POST)
	public Map<String, Object> bodyAddRole(@RequestBody Role role){
		System.err.println(role);
		Map<String , Object>map = new HashMap<String, Object>();
		Integer count = roleService.addRole(role);
		map.put("total", count);
		map.put("role", role);
		return map;
	}
	@ResponseBody
	@RequestMapping("/getRole/{id}")
	public Role getRole(@PathVariable("id")Long id){
		return roleService.getRole(id);
	}
	
	
	/***
	 * 用自定义一对一数据转换器@StringToRoleConverter解析成Role对象
	 * 访问格式 :http://localhost:8080/grademvc/role/updateRole?role=125-helldfdfdfo-fafadsfadsfasd
	 * @param r
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateRole")
	public Map<String, Object> updateRole(Role role){
		Map<String , Object>map = new HashMap<String, Object>();
		Integer count = roleService.updateRole(role);
		map.put("total", count);
		return map;
	}
	@ResponseBody
	@RequestMapping("/updateRoleList")
	public Map<String, Object>updateRoleList(@RequestParam(required=false)List<Role>roleList){
		Map<String , Object>map = new HashMap<String, Object>();
		if(roleList == null||roleList.isEmpty()){
			map.put("total", 0);
			return map;
		}
		Integer totle = roleService.updateRoleList(roleList);
		map.put("total", totle);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/updateRoleArr")
	public Map<String, Object>updateRoleArr(Role[] roleArr){
		Map<String , Object>map = new HashMap<String, Object>();
		if(roleArr == null||roleArr.length==0){
			map.put("total", 0);
			return map;
		}
		Integer totle = roleService.updateRoleList(Arrays.asList(roleArr));
		map.put("total", totle);
		return map;
	}
	
	@RequestMapping("/list")
	public String list(@RequestParam(required=false)String name,Role role,ModelMap map){
		try {
			System.err.println("name:"+name);
			System.err.println("role:"+role);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Role> list = roleService.getAll();
		map.addAttribute("roleList",list);
		return "roleList";
	}
}
