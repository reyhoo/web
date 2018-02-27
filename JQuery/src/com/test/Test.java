package com.test;

public class Test {
	
	public static void main(String[] args) {
		HelloWorldProxyHandler handler = new HelloWorldProxyHandler();
		HelloWorld h = (HelloWorld) handler.getProxy(new HelloWorldImpl());
		
		h.sayHello();
		
	}
}
