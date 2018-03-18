
package com.spring.mybatis.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//@ComponentScan(basePackages={"com.spring.mybatis"})
//@PropertySource("classpath:db.properties")
@ImportResource("spring-beans.xml")
//@Configuration
public class AppConfig {
//	@Bean
//	public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
//		return new PropertyPlaceholderConfigurer();
//	}
}
