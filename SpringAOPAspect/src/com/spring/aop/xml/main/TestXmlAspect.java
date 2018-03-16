package com.spring.aop.xml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.pojo.Role;
import com.spring.aop.verifier.RoleVerifier;
import com.spring.aop.xml.service.RoleService;

public class TestXmlAspect {

	
	public static void main(String[] args) {
		
		ApplicationContext cxt = new ClassPathXmlApplicationContext("aspect.xml");
		
		RoleService roleService = cxt.getBean(RoleService.class);
		RoleVerifier roleVerifier = (RoleVerifier) roleService;
		Role role = new Role();
		role.setId(2l);
		role.setRoleName("role_name_2");
		role.setNote("note_2");
		if(roleVerifier.verify(role)){
			roleService.printRole(role);
		}
		
		role = null;
		System.out.println("###########################");
		if(roleVerifier.verify(role)){
			roleService.printRole(role);
		}else{
			System.out.println("not pass verify");
		}
	}
}
