package com.spring.aop.game.util;

import com.spring.aop.game.interceptor.Interceptor;

public class ProxyBeanFactory {

	public static <T> T getBean(T obj,Interceptor interceptor){
			return (T) BeanProxyUtil.getBean(obj, interceptor);
	}
}
