package com.spring.ass.exe.annotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.ass.exe.annotation.config.ApplicationConfig;
import com.spring.ass.exe.annotation.controller.RoleController2;
import com.spring.ass.exe.annotation.pojo.Role;
import com.spring.ass.exe.annotation.service.RoleDataSourceService;

public class AnnotationMain {

	
	public static void main(String[] args) {
		
//		ApplicationContext cxt = new AnnotationConfigApplicationContext(PojoConfig.class);
//		Role role = cxt.getBean(Role.class);
//		System.out.println(role);
//		
		
		//basePackagesָ����ɨ�跶Χ
		ApplicationContext cxt = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Role role = cxt.getBean(Role.class);
//		System.out.println(role);
//		RoleService roleService = cxt.getBean(RoleService.class);
//		roleService.printRoleInfo(role);
		
		//ʹ��@Autowiredװ���������
		//���ʹ��@Autowired��ioc������û���ҵ���Ӧ��bean��spring�ͻᱨ�����ǿ���ʹ��
		//required=false�����ã����ǾͲ��ܱ�֤�����ǲ���Ϊ�գ����Ǿ�Ҫ�Լ��ж�
//		RoleService2 roleService2 = cxt.getBean(RoleService2.class);
//		roleService2.printRoleInfo();
		// @Primary 
//		RoleService roleService = cxt.getBean(RoleService.class);
//		roleService.printRoleInfo(role);
		
//		RoleController roleController = cxt.getBean(RoleController.class);
//		roleController.printRole(role);
		
		RoleController2 roleController2 = cxt.getBean(RoleController2.class);
		roleController2.printRole(role);
		
//		RoleDataSourceService roleDataSourceService = cxt.getBean(RoleDataSourceService.class);
		RoleDataSourceService roleDataSourceService = (RoleDataSourceService) cxt.getBean("roleDataSourceService2");
		role = roleDataSourceService.getRole(1l);
		System.out.println(role);
	}
}
