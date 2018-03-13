package com.spring.ass.exe.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.ass.exe.pojo.UserRoleAssembly;

public class ObjectAssemblyTest {

	
	public static void main(String[] args) {
//		ApplicationContext cxt = new ClassPathXmlApplicationContext("app-object.xml");
//		UserRoleAssembly userRoleAssembly = cxt.getBean(UserRoleAssembly.class);
//		System.out.println(userRoleAssembly);
		ApplicationContext cxt = new ClassPathXmlApplicationContext("app-xmlns-object.xml");
		UserRoleAssembly userRoleAssembly = cxt.getBean(UserRoleAssembly.class);
		System.out.println(userRoleAssembly);
	}
}
