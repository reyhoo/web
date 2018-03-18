package com.spring.jdbc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan(basePackages={"com.spring.jdbc"})
@ImportResource("spring-prop.xml")
public class AppConfig {

}
