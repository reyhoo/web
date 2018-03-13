package com.spring.ass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.ass.annotation.config.ApplicationConfig;
import com.spring.ass.annotation.controller.RoleController;
import com.spring.ass.annotation.controller.RoleController2;
import com.spring.ass.annotation.pojo.Role;
import com.spring.ass.annotation.service.RoleService;

public class AnnotationMain {

	
	public static void main(String[] args) {
		
		ApplicationContext cxt = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		//装配bean
//		Role role = (Role) cxt.getBean("role");
		Role role1 = (Role) cxt.getBean(Role.class);
//		System.out.println(role);
//		System.out.println(role == role1);
//		RoleService roleService = cxt.getBean(RoleService.class);
//		roleService.printRoleInfo(role1);
		
		//自己装配对象属性
//		RoleService2 roleService2 = cxt.getBean(RoleService2.class);
//		roleService2.printRoleInfo();
//		((AbstractApplicationContext) cxt).close();
		
//		cxt.getBean(RoleService.class);当有两个实现类的时候用类型是不能查找Bean的
//		RoleService roleService = (RoleService) cxt.getBean("roleServiceImpl3");
//		roleService.printRoleInfo(role1);
		
//		当出现多个实现类时,在需要的实现类(RoleServiceImpl3)上加@Primary注解,如果多个实现类都加了该注解就要使用@Qualifier用id查找
		RoleController roleController= cxt.getBean(RoleController.class);
		roleController.printRole(role1);
		System.out.println("-----------------------------------------");
		//装配带有构造参数的类
		RoleController2 roleController2 = cxt.getBean(RoleController2.class);
		roleController2.printRole(role1);
		System.out.println("-----------------------------------------");
		
		
	}
}
