package com.spring.aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.spring.aop.aspect.RoleAspect;

@Configuration
@ComponentScan(basePackages={"com.spring.aop"})
@EnableAspectJAutoProxy
public class AopConfig {
	
	@Bean
	public RoleAspect getRoleAspect(){
		return new RoleAspect();
	}
}
