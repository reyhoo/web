package com.spring.el.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.el.config.ApplicationConfig;
import com.spring.el.pojo.ElBean;
import com.spring.el.pojo.OperationBean;
import com.spring.el.pojo.Role;
import com.spring.el.pojo.StaticBean;

public class AnnotationTest {

	
	public static void main(String[] args) {
		ApplicationContext cxt = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Role role = cxt.getBean(Role.class);
		System.out.println(role);
	
		ElBean elBean = cxt.getBean(ElBean.class);
		System.out.println(elBean);
		
		StaticBean staticBean = cxt.getBean(StaticBean.class);
		System.out.println(staticBean.getPi());
		System.out.println(staticBean.getRandom());
		staticBean = cxt.getBean(StaticBean.class);
		System.out.println(staticBean.getPi());
		System.out.println(staticBean.getRandom());
		
		OperationBean operationBean = cxt.getBean(OperationBean.class);
		System.out.println(operationBean.getNum());
		System.out.println(operationBean.getStr());
		System.out.println(operationBean.isEqualNum());
		System.out.println(operationBean.isEqualString());
		System.out.println(operationBean.getMax());
		System.out.println(operationBean.getDefaultString());
	}
}
