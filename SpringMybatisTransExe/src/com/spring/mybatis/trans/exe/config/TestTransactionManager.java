package com.spring.mybatis.trans.exe.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.mybatis.trans.exe.pojo.Role;
import com.spring.mybatis.trans.exe.service.RoleListService;

public class TestTransactionManager {

	
	public static void main(String[] args) {
//		ApplicationContext cxt = new AnnotationConfigApplicationContext(AppConfig.class);
		ApplicationContext cxt = new ClassPathXmlApplicationContext("spring-cfg.xml");
		RoleListService roleListService = cxt.getBean(RoleListService.class);
		List<Role>roleList = new ArrayList<Role>();
		for (int i = 1; i <= 3; i++) {
			Role role = new Role();
			role.setRoleName("test_transactional_role_name_"+i);
			role.setNote("test_transactional_note_"+i);
			roleList.add(role);
		}
		int count = roleListService.insertRoleList(roleList);
		System.out.println(count);
	}
}
