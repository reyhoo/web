package com.spring.ass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.ass.pojo.ComplexAssembly;
import com.spring.ass.pojo.JuiceMaker2;
import com.spring.ass.pojo.Role;

public class Test {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app.xml");
		Role role = (Role) applicationContext.getBean("role1");
		System.out.println(role);
		
		JuiceMaker2 juiceMaker2 =(JuiceMaker2) applicationContext.getBean("juiceMaker2");
		System.out.println(juiceMaker2.makeJuice());
		
		ComplexAssembly assembly = (ComplexAssembly) applicationContext.getBean("complexAssembly");
		System.out.println(assembly);
		
		
	}
}
