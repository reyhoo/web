package com.spring.ass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.ass.annotation.config.ApplicationConfig;
import com.spring.ass.annotation.controller.RoleController;
import com.spring.ass.annotation.controller.RoleController2;
import com.spring.ass.annotation.pojo.Role;

public class AnnotationMain {

	
	public static void main(String[] args) {
		
		ApplicationContext cxt = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		//װ��bean
//		Role role = (Role) cxt.getBean("role");
		Role role1 = (Role) cxt.getBean(Role.class);
//		System.out.println(role);
//		System.out.println(role == role1);
//		RoleService roleService = cxt.getBean(RoleService.class);
//		roleService.printRoleInfo(role1);
		
		//�Լ�װ���������
//		RoleService2 roleService2 = cxt.getBean(RoleService2.class);
//		roleService2.printRoleInfo();
//		((AbstractApplicationContext) cxt).close();
		
//		cxt.getBean(RoleService.class);��������ʵ�����ʱ���������ǲ��ܲ���Bean��
//		RoleService roleService = (RoleService) cxt.getBean("roleServiceImpl3");
//		roleService.printRoleInfo(role1);
		
//		�����ֶ��ʵ����ʱ,����Ҫ��ʵ����(RoleServiceImpl3)�ϼ�@Primaryע��,������ʵ���඼���˸�ע���Ҫʹ��@Qualifier��id����
		RoleController roleController= cxt.getBean(RoleController.class);
		roleController.printRole(role1);
		System.out.println("-----------------------------------------");
		//װ����й����������
		RoleController2 roleController2 = cxt.getBean(RoleController2.class);
		roleController2.printRole(role1);
	}
}
