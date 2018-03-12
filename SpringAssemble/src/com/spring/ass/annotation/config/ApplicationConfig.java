package com.spring.ass.annotation.config;

import org.springframework.context.annotation.ComponentScan;

import com.spring.ass.annotation.pojo.Role;
import com.spring.ass.annotation.service.RoleServiceImpl;


//@ComponentScan(basePackageClasses={Role.class,RoleServiceImpl.class})
@ComponentScan(basePackages={"com.spring.ass.annotation.pojo","com.spring.ass.annotation.service"
		,"com.spring.ass.annotation.controller"})
public class ApplicationConfig {

	
}
