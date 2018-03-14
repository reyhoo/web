package com.spring.aop.game.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.spring.aop.game.interceptor.Interceptor;

public class BeanProxyUtil implements InvocationHandler{

	private Interceptor interceptor;
	
	private Object obj;
	
	public static Object getBean(Object obj,Interceptor interceptor){
		BeanProxyUtil _this = new BeanProxyUtil();
		_this.obj = obj;
		_this.interceptor = interceptor;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), _this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object retobj = null;
		boolean exceptionFlag = false;
		interceptor.before(obj);
		try {
			retobj = method.invoke(obj, args);
		} catch (Exception e) {
			e.printStackTrace();
			exceptionFlag = true;
		}finally{
			interceptor.after(obj);
		}
		if(exceptionFlag){
			interceptor.afterThrowing(obj);
		}else{
			interceptor.afterRetuning(obj);
		}
		return retobj;
	}

}
