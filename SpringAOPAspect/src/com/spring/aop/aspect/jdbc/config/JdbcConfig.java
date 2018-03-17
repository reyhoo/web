package com.spring.aop.aspect.jdbc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;


@ComponentScan(basePackages={"com.spring.aop.aspect.jdbc"})
@PropertySource({"classpath:db.properties"})
public class JdbcConfig {

}
