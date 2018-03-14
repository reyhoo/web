package com.spring.aop.game.interceptor;

public interface Interceptor {
	void before(Object obj);
	void after(Object obj);
	void afterRetuning(Object obj);
	void afterThrowing(Object obj);
}
