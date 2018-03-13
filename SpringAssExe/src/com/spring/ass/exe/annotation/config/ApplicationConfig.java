package com.spring.ass.exe.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


@ComponentScan(basePackages={"com.spring.ass.exe.annotation.pojo",
		"com.spring.ass.exe.annotation.service","com.spring.ass.exe.annotation.controller"})
//@PropertySource(value={"classpath:db-config-base64.properties"})
//@Configuration
@ImportResource({"classpath:service-beans.xml"})
public class ApplicationConfig {

//	@Bean
//	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
//		return new PropertySourcesPlaceholderConfigurer();
//	}
}
