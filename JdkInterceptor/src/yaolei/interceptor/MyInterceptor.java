package yaolei.interceptor;

import java.lang.reflect.Method;

public class MyInterceptor implements Interceptor{

	@Override
	public boolean before(Object proxy, Object target, Method method,
			Object[] args) {
		System.out.println("真实对象执行前。。。");
		return true;
	}

	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("取消真实对象执行。。。");
	}

	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("真实对象执行后。。。");
		
	}

}
