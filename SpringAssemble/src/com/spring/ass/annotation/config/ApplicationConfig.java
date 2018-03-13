package com.spring.ass.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.spring.ass.annotation.controller.ControllerConfig;
import com.spring.ass.annotation.pojo.PojoConfig;
import com.spring.ass.annotation.service.ServiceConfig;


//@ComponentScan(basePackageClasses={Role.class,RoleServiceImpl.class})
//@ComponentScan(basePackages={"com.spring.ass.annotation"})
@Import({PojoConfig.class,ServiceConfig.class,ControllerConfig.class})
//@ImportResource({"classpath:jdbc-bean.xml"})
//@ImportResource({"classpath:spring-beans.xml"})
@ComponentScan(basePackages={"com.spring.ass.prop.pojo"})
@PropertySource({"classpath:database-config1.properties","classpath:database-config2.properties"})
public class ApplicationConfig {

	
}
