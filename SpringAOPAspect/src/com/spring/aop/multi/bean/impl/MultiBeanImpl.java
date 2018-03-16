package com.spring.aop.multi.bean.impl;

import org.springframework.stereotype.Component;

import com.spring.aop.multi.bean.MultiBean;



@Component
public class MultiBeanImpl implements MultiBean {

	@Override
	public void testMulti() {
		System.out.println("test multi aspects!");
	}

}
