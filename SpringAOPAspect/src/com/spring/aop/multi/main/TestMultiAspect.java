package com.spring.aop.multi.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aop.multi.bean.MultiBean;
import com.spring.aop.multi.config.MultiAspectConfig;

public class TestMultiAspect {

	public static void main(String[] args) {
		ApplicationContext cxt = new AnnotationConfigApplicationContext(MultiAspectConfig.class);
		MultiBean multiBean = cxt.getBean(MultiBean.class);
		multiBean.testMulti();
	}
}
