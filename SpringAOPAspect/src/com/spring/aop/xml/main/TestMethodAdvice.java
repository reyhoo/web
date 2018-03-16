package com.spring.aop.xml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.pojo.Role;
import com.spring.aop.service.RoleService;

public class TestMethodAdvice {

	
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("method-advice.xml");
		RoleService roleService = cxt.getBean(RoleService.class);
		roleService.printRole(new Role());
	}
}
