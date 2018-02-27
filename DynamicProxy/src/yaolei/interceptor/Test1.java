package yaolei.interceptor;

import yaolei.jdk.proxy.HelloWorld;
import yaolei.jdk.proxy.HelloWorldImpl;

public class Test1 {

	
	public static void main(String[] args) {
		HelloWorld proxy1 = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), "yaolei.interceptor.Interceptor1");
		HelloWorld proxy2 = (HelloWorld) InterceptorJdkProxy.bind(proxy1, "yaolei.interceptor.Interceptor2");
		HelloWorld proxy3 = (HelloWorld) InterceptorJdkProxy.bind(proxy2, "yaolei.interceptor.Interceptor3");
		proxy3.sayHello();
	}
}
