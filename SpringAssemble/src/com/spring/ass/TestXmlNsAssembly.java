package com.spring.ass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.ass.pojo.Role;
import com.spring.ass.pojo.User;
import com.spring.ass.pojo.UserRoleAssembly;

public class TestXmlnsAssembly {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"app-xmlns-assembly-beans.xml");
		UserRoleAssembly userRoleAssembly = (UserRoleAssembly) applicationContext
				.getBean("userRoleAssembly");
		System.out.println(userRoleAssembly);
		Role role = new Role();
		role.setId(1l);
		User user = userRoleAssembly.getMap().get(role);
		System.out.println(user);
	}
}
