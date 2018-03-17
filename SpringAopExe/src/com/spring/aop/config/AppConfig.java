package com.spring.aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

import com.spring.aop.aspect.RoleAspect;

@Configuration

@EnableAspectJAutoProxy
@ComponentScan(basePackages={"com.spring.aop.service.impl"
		
		,"com.spring.aop.aspect"
		
})
@ImportResource(locations={"aspect-bean.xml"})
public class AppConfig {

	@Bean
	public RoleAspect getRoleAspect(){
//		org.springframework.context.event.
		return new RoleAspect();
	}
}
