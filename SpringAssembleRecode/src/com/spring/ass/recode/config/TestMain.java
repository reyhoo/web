package com.spring.ass.recode.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.ass.recode.service.RoleService;

public class TestMain {

	
	public static void main(String[] args) {
		ApplicationContext cxt = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//		RoleService roleService = cxt.getBean(RoleService.class);
//		RoleService roleService = (RoleService) cxt.getBean("roleService2");
//		System.out.println(roleService);
//		System.out.println(roleService.getRoleById(1l));
//		System.out.println(roleService.findAll().size());
		
//		RoleService roleService = (RoleService) cxt.getBean("roleService2");
		RoleService roleService = (RoleService) cxt.getBean("roleServiceImpl");
		System.out.println(roleService.getRoleById(1l));
		System.out.println(roleService.findAll().size());
	}
}
