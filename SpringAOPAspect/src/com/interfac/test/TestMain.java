package com.interfac.test;

public class TestMain {

	
	public static void main(String[] args) {
		PClass pcls = new CClass();
		pcls.inter1();
		pcls.inter2();
		pcls.sayHello();
		System.out.println(pcls);
		System.out.println(pcls.getClass());
		for (Class cls : pcls.getClass().getClasses()) {
			System.out.println(cls);
		}
		System.out.println(pcls.getClass().getClassLoader());
		
		for (Class cls : pcls.getClass().getInterfaces()) {
			System.out.println(cls);
		}
		
	}
}
