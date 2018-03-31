package com.annotation.redis.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.annotation.redis.pojo.Role;
import com.annotation.redis.service.RoleService;

public class TestMain {

	
	public static void main(String[] args) {
		ApplicationContext cxt =new AnnotationConfigApplicationContext(RootConfig.class,RedisConfig.class);
		RoleService roleService = cxt.getBean(RoleService.class);
		
		Role role = new Role();
//		role.setRoleName("role_name_1");
//		role.setNote("note_1");
//		roleService.insertRole(role);
//		
//		Role getRole = roleService.getRole(role.getId());
//		getRole.setNote("role_note_1_update");
		Role getRole = new Role();
		getRole.setRoleName("role_Ò¦ÀÚ");
		getRole.setId(138l);
		roleService.updateRole(getRole);
		
	}
}
