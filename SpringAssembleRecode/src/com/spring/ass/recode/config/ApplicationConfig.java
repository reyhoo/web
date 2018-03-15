package com.spring.ass.recode.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.PropertyPlaceholderHelper;

//@ComponentScan(basePackages = { "com.spring.ass.recode.pojo",
//		"com.spring.ass.recode.service" })
//@PropertySource({ "classpath:db.properties" })
//@ImportResource(locations = { "classpath:app.xml" })
//@Configuration
@ImportResource(locations={"classpath:config/app.xml"})
public class ApplicationConfig {
//	@Bean
//	public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
//		return new PropertyPlaceholderConfigurer();
//	}

}
