package com.spring.aop.multi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

import com.spring.aop.multi.aspect.Aspect1;
import com.spring.aop.multi.aspect.Aspect2;
import com.spring.aop.multi.aspect.Aspect3;

@ComponentScan(basePackages = { "com.spring.aop.multi" })
@EnableAspectJAutoProxy
@Configuration
public class MultiAspectConfig {
	@Bean
	public Aspect1 getAspect1() {
		return new Aspect1();
	}
	@Bean
	public Aspect3 getAspect3() {
		return new Aspect3();
	}
	@Bean(name={"aspect2"})
	public Aspect2 getAspect2() {
		return new Aspect2();
	}

	
}
