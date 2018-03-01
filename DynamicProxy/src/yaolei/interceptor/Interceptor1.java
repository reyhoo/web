package yaolei.interceptor;

import java.lang.reflect.Method;

public class Interceptor1 implements Interceptor {

	@Override
	public boolean before(Object proxy, Object target, Method method,
			Object[] args) {
		System.out.println("��������1����before����");
		return true;
	}

	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("��������1����after����");

	}

}