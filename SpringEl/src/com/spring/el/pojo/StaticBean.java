package com.spring.el.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class StaticBean {
	@Value("#{T(java.lang.Math).PI}")
	private double pi;
	@Value("#{T(Math).random()}")//0��1֮ǰ�������
	private double random;

	public double getPi() {
	
		return pi;
	}

	public double getRandom() {
		return random;
	}
}
