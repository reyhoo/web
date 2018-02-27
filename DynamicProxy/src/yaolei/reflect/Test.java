package yaolei.reflect;

import java.lang.reflect.Method;

public class Test {

	
	public static void main(String[] args)throws Exception {
		Object obj = Class.forName("yaolei.reflect.ReflectServiceImpl").newInstance();
		
		Method method = obj.getClass().getMethod("sayHello");
		Object result = method.invoke(obj);
		System.out.println(result);
		
		Object obj1 = Class.forName("yaolei.reflect.ReflectServiceImpl").getConstructor(String.class)
				.newInstance("уехЩ");

		Method method1 = obj.getClass().getMethod("sayHello");
		method1.invoke(obj1);
	}
}
