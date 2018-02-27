package yaolei.jdk.proxy;

public class Test {

	public static void main(String[] args) {
		JdkProxyExample jdkProxyExample = new JdkProxyExample();
		HelloWorld helloworld = (HelloWorld) jdkProxyExample.bind(new HelloWorldImpl());
		helloworld.sayHello();
	}
}
