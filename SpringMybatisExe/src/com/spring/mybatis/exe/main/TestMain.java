package com.spring.mybatis.exe.main;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.mybatis.exe.mapper.RoleMapper;

public class TestMain {

	
	public static void main(String[] args) {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("spring-beans.xml");
		RoleMapper roleMapper = cxt.getBean(RoleMapper.class);
		roleMapper.getAllRole();
		roleMapper.getAllRole();
	}
}
