package yaolei.interceptor;

import yaolei.jdk.proxy.HelloWorld;
import yaolei.jdk.proxy.HelloWorldImpl;

public class Test {

	
	public static void main(String[] args) {
		HelloWorld helloworld = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), "yaolei.interceptor.MyInterceptor");
		helloworld.sayHello();
	}
}
