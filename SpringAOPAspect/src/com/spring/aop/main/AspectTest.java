package com.spring.aop.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.config.AopConfig;
import com.spring.aop.pojo.Role;
import com.spring.aop.service.RoleService;
import com.spring.aop.verifier.RoleVerifier;

public class AspectTest {

	public static void main(String[] args) {
		ApplicationContext cxt = new AnnotationConfigApplicationContext(AopConfig.class);
		RoleService roleService = cxt.getBean(RoleService.class);
		RoleVerifier roleVerifier = (RoleVerifier) roleService;
		Role role = new Role();
		role.setId(1l);
		role.setRoleName("role_name_1");
		role.setNote("note_1");
		if(roleVerifier.verify(role)){
			roleService.printRole(role);
		}
		
		System.out.println("##################################");
		role = null;
		if(roleVerifier.verify(role)){
			roleService.printRole(role);
		}else{
			System.out.println("不满足执行条件。。。。。。");
		}
	}
}
