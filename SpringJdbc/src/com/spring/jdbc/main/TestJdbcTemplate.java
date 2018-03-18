package com.spring.jdbc.main;

import java.sql.SQLException;
import java.util.List;

import javax.faces.application.Application;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.config.AppConfig;
import com.spring.jdbc.dao.RoleDao;
import com.spring.jdbc.pojo.Role;

public class TestJdbcTemplate {

	public static void main(String[] args) {
		ApplicationContext cxt = new AnnotationConfigApplicationContext(AppConfig.class);
		RoleDao roleDao = cxt.getBean(RoleDao.class);
		List<Role> list = roleDao.findAll();
		System.out.println(list);
		Role role = roleDao.findById(3l);
		System.out.println(role);
	}
}
