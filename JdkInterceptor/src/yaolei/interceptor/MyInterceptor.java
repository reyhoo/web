package yaolei.interceptor;

import java.lang.reflect.Method;

public class MyInterceptor implements Interceptor{

	@Override
	public boolean before(Object proxy, Object target, Method method,
			Object[] args) {
		System.out.println("��ʵ����ִ��ǰ������");
		return true;
	}

	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("ȡ����ʵ����ִ�С�����");
	}

	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		System.out.println("��ʵ����ִ�к󡣡���");
		
	}

}
