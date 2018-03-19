package com.spring.mybatis.trans.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.mybatis.trans.controller.RoleController;
import com.spring.mybatis.trans.pojo.Role;
import com.spring.mybatis.trans.service.RoleListService;
import com.spring.mybatis.trans.service.RoleService;

public class TransactionMain {

	
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("spring-cfg.xml");
//		RoleListService roleListService= cxt.getBean(RoleListService.class);
//		List<Role>roleList = new ArrayList<Role>();
//		for (int i = 1; i <=2; i++) {
//			Role role = new Role();
//			role.setNote("note_"+i);
//			role.setRoleName("role_name_"+i);
//			roleList.add(role);
//		}
//		int count = roleListService.insertRoleList(roleList);
//		System.out.println(count);
		
		//���������������ʧЧ
//		List<Role>roleList = new ArrayList<Role>();
//		for (int i = 1; i <=2; i++) {
//			Role role = new Role();
//			role.setNote("note_"+i);
//			role.setRoleName("role_name_"+i);
//			roleList.add(role);
//		}
//		RoleService roleService = cxt.getBean(RoleService.class);
//		roleService.insertRoleList(roleList);
		
		//����ʹ��Service����Controller�е�������Service�ķ����������κ�����ɵĵ��á�����������
		RoleController roleController = cxt.getBean(RoleController.class);
		roleController.errerUseServices();
		
	}
}
