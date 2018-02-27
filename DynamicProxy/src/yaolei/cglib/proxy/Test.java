package yaolei.cglib.proxy;

import yaolei.reflect.ReflectServiceImpl;

public class Test {

	public static void main(String[] args) {
		CglibProxyExample cglibProxyExample = new CglibProxyExample();
		ReflectServiceImpl reflectServiceImpl = (ReflectServiceImpl) cglibProxyExample.getProxy(ReflectServiceImpl.class);
		reflectServiceImpl.sayHello();
	}
}
