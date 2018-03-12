package com.spring.ass.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.ass.annotation.pojo.Role;
import com.spring.ass.annotation.service.RoleService;
@Component
public class RoleController {
//	当出现多个实现类时,在需要的实现类(RoleServiceImpl3)上加@Primary注解,如果多个实现类都加了该注解就要使用@Qualifier用id查找
	@Autowired
	@Qualifier("roleServiceImpl3")
	private RoleService roleService=null;
	
	public void printRole(Role role){
		roleService.printRoleInfo(role);
	}
}
