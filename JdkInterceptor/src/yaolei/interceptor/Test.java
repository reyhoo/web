package yaolei.interceptor;

public class Test {

	
	public static void main(String[] args) {
		HelloWorld helloWorld = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), "yaolei.interceptor.MyInterceptor");
		helloWorld.sayHelloWorld();
	
	}
}
