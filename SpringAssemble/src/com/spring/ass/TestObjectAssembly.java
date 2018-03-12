package com.spring.ass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.ass.pojo.UserRoleAssembly;

public class TestObjectAssembly {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-assembly-beans.xml");
		UserRoleAssembly userRoleAssembly = (UserRoleAssembly) applicationContext.getBean("userRoleAssembly");
		System.out.println(userRoleAssembly);
	}
}
