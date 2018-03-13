package com.spring.ass.exe.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.ass.exe.pojo.ComplexAssembly;
import com.spring.ass.exe.pojo.JuiceMaker2;
import com.spring.ass.exe.pojo.Role;

public class MainTest {

	
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("app.xml");
		Role role = (Role) cxt.getBean("role");
		Role role1 = (Role) cxt.getBean("role1");
		System.out.println(role);
		System.out.println(role1);
		
		JuiceMaker2 juiceMaker2 = cxt.getBean(JuiceMaker2.class);
		String juice = juiceMaker2.makeJuice();
		System.out.println(juice);
		
		
		ComplexAssembly complexAssembly = cxt.getBean(ComplexAssembly.class);
		System.out.println(complexAssembly);
		
		
		
	}
}
