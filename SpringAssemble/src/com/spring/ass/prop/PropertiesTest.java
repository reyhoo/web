package com.spring.ass.prop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.ass.prop.config.PropConfig;

public class PropertiesTest {

	
	public static void main(String[] args) {
		ApplicationContext cxt = new AnnotationConfigApplicationContext(PropConfig.class);
		String url = cxt.getEnvironment().getProperty("jdbc.database.url");
		System.out.println(url);
	}
}
