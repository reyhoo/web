package com.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloWorldProxyHandler implements InvocationHandler {

	
	private Object target;
	
	public Object getProxy(Object target){
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		System.out.println("before");
		
		Object obj = method.invoke(target, args);
		System.out.println("after");
		return obj;
	}

}
