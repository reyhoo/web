package com.spring.mybatis.main;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.mybatis.config.AppConfig;
import com.spring.mybatis.mapper.RoleMapper;
import com.spring.mybatis.pojo.Role;

public class TestMain {

	
	public static void main(String[] args) {
		ApplicationContext cxt = new AnnotationConfigApplicationContext(AppConfig.class);
		//使用SqlSessionTemplate直接查询
		//		SqlSessionTemplate sqlSessionTemplate = cxt.getBean(SqlSessionTemplate.class);
//		Role role = new Role();
//		role.setRoleName("role_name_sqlSessionTemplate");
//		role.setNote("note_sqlSessionTemplate");
//		sqlSessionTemplate.insert("com.spring.mybatis.mapper.RoleMapper.insertRole", role);
//		Long id = role.getId();
//		role = sqlSessionTemplate.selectOne("com.spring.mybatis.mapper.RoleMapper.getRole", id);
//		role.setNote("update_sqlSessionTemplate");
//		role.setRoleName("");
//		sqlSessionTemplate.update("com.spring.mybatis.mapper.RoleMapper.updateRole",role);
//		sqlSessionTemplate.delete("com.spring.mybatis.mapper.RoleMapper.deleteRole",id);
	//使用MapperFactoryBean
		RoleMapper roleMapper = cxt.getBean(RoleMapper.class);
		roleMapper.getAllRole();
		roleMapper.getAllRole();
		
	}
}
