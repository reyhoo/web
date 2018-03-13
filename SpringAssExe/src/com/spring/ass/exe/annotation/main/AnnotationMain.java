package com.spring.ass.exe.annotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.ass.exe.annotation.config.ApplicationConfig;
import com.spring.ass.exe.annotation.controller.RoleController2;
import com.spring.ass.exe.annotation.pojo.Role;

public class AnnotationMain {

	
	public static void main(String[] args) {
		
//		ApplicationContext cxt = new AnnotationConfigApplicationContext(PojoConfig.class);
//		Role role = cxt.getBean(Role.class);
//		System.out.println(role);
//		
		
		//basePackages指定的扫描范围
		ApplicationContext cxt = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Role role = cxt.getBean(Role.class);
//		System.out.println(role);
//		RoleService roleService = cxt.getBean(RoleService.class);
//		roleService.printRoleInfo(role);
		
		//使用@Autowired装配对象属性
		//如果使用@Autowired在ioc容器中没有找到对应的bean，spring就会报错；我们可以使用
		//required=false来设置，但是就不能保证属性是不是为空，我们就要自己判断
//		RoleService2 roleService2 = cxt.getBean(RoleService2.class);
//		roleService2.printRoleInfo();
		// @Primary 
//		RoleService roleService = cxt.getBean(RoleService.class);
//		roleService.printRoleInfo(role);
		
//		RoleController roleController = cxt.getBean(RoleController.class);
//		roleController.printRole(role);
		
		RoleController2 roleController2 = cxt.getBean(RoleController2.class);
		roleController2.printRole(role);
	}
}
