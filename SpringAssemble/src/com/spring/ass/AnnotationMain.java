package com.spring.ass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.spring.ass.annotation.config.ApplicationConfig;
import com.spring.ass.annotation.service.RoleService2;

public class AnnotationMain {

	
	public static void main(String[] args) {
		
		ApplicationContext cxt = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//		Role role = (Role) cxt.getBean("role");
//		Role role1 = (Role) cxt.getBean(Role.class);
//		System.out.println(role);
//		System.out.println(role == role1);
		
//		RoleService roleService = cxt.getBean(RoleService.class);
//		roleService.printRoleInfo(role1);
		
//		RoleService2 roleService2 = cxt.getBean(RoleService2.class);
//		roleService2.printRoleInfo();
//		((AbstractApplicationContext) cxt).close();
		
	}
}
