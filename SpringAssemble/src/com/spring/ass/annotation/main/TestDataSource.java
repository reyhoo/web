package com.spring.ass.annotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.ass.annotation.config.ApplicationConfig;
import com.spring.ass.annotation.pojo.Role;
import com.spring.ass.annotation.service.RoleDataSourceService;

public class TestDataSource {

	
	public static void main(String[] args) {
		ApplicationContext cxt = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleDataSourceService service = cxt.getBean(RoleDataSourceService.class);
		RoleDataSourceService service2 = cxt.getBean(RoleDataSourceService.class);
		System.out.println(service == service2);
		Role role = service.getRole(1l);
		System.out.println(role);
	}
}
