package com.example.demo.factory;

public class A {
	
	private A(){
		System.out.println("constuctor called");
	}
	
	public static A getA() {
		System.out.println("Factory is called");
		return new A();
	}
	
}
