package com.annotation.redis.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.annotation.redis.pojo.Role;
import com.annotation.redis.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@RequestMapping("/add")
	@ResponseBody
	public Map<String, Object> add(Role role) {
		Map<String, Object> map = new HashMap<>();
		roleService.insertRole(role);
		map.put("role", role);
		return map;
	}
	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object>update(Role role){
		Map<String, Object> map = new HashMap<>();
		roleService.updateRole(role);
		map.put("role", role);
		return map;
	}
	
	@RequestMapping("/get/{id}")
	@ResponseBody
	public Map<String, Object> get(@PathVariable("id")Long id) {
		Map<String, Object> map = new HashMap<>();
		map.put("role", roleService.getRole(id));
		return map;
	}
	
	@RequestMapping("/upload")
	@ResponseBody
	public Map<String, Object> get(MultipartFile file,String name) {
		Map<String, Object> map = new HashMap<>();
		map.put("file", file.getOriginalFilename());
		map.put("name", name);
		try {
			file.transferTo(new File("D:\\"+file.getOriginalFilename()));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping("/page")
	public String page() {
		return "upload";
	}
}
