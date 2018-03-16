package com.interfac.test;

public  abstract class PClass implements Inter1,Inter2 {
 
	
	public void sayHello(){
		System.out.println(getClass()+"PClass::hello..................");
	}
	@Override
	public void inter1() {
		System.out.println(getClass()+"PClass:inter1..................");
		sayHello();
	}
	
	@Override
	public void inter2() {
		System.out.println(getClass()+"PClass:inter2..................");
	}
}
