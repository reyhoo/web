package com.interfac.test;

public class CClass extends PClass{

	
	@Override
	public void sayHello() {
		super.sayHello();
		System.out.println(getClass()+"CClass::hello..................");
	}
}
