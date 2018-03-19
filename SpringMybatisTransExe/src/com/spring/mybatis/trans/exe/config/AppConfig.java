package com.spring.mybatis.trans.exe.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
@Configuration
@ComponentScan(basePackages={"com.spring.mybatis.trans.exe"})
@PropertySource("classpath:db.properties")
@ImportResource("classpath:spring-cfg.xml")
public class AppConfig {

}
