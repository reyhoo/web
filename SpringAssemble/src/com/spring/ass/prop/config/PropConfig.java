package com.spring.ass.prop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//@Configuration ʹ��xml����propertiesע�͵�
//@ComponentScan(basePackages={"com.spring.ass.prop"})
//@PropertySource(value={"classpath:database-config.properties"}) ʹ��xml����propertiesע�͵�
@ImportResource({"classpath:prop-beans.xml"})
public class PropConfig {

//	@Bean
//	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
//		return new PropertySourcesPlaceholderConfigurer();
//	} ʹ��xml����propertiesע�͵�
}
