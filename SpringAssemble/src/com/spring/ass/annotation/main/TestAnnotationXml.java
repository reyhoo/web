package com.spring.ass.annotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.ass.annotation.service.RoleDataSourceService;

public class TestAnnotationXml {

	
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("annotation-beans.xml");
		RoleDataSourceService service = cxt.getBean(RoleDataSourceService.class);
		System.out.println(service.getRole(1l));
	}
}
