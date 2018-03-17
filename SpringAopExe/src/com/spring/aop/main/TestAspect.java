package com.spring.aop.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.config.AppConfig;
import com.spring.aop.pojo.Role;
import com.spring.aop.service.RoleService;
import com.spring.aop.verifier.RoleVerifier;

public class TestAspect {

	
	public static void main(String[] args) {
		ApplicationContext cxt = new AnnotationConfigApplicationContext(AppConfig.class);
		RoleService roleService = cxt.getBean(RoleService.class);
		RoleVerifier roleVerifier = (RoleVerifier) roleService;
		Role role =  new Role();
		role.setId(2l);
		role.setRoleName("rolename");
		role.setNote("note");
		if(roleVerifier.verify(role)){
			roleService.printRole(role);
		}else{
			System.out.println("not pass verify");
		}
		
	}
}
