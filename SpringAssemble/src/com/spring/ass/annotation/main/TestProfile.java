package com.spring.ass.annotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.ass.annotation.pojo.Role;
import com.spring.ass.annotation.service.RoleDataSourceService;

public class TestProfile {

	
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("profile-beans.xml");
		
		RoleDataSourceService service = cxt.getBean(RoleDataSourceService.class);
		Role role = service.getRole(21l);
		System.out.println(role);
	}
}
