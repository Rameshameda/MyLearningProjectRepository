package com.myapp.service;

public class Calculator {

	public int add(int a,int b) {
		System.out.println("here it comes");
		return a+b;
	}
	public int subtract(int a,int b) {
		return a-b;

	}
	public int divide(int a,int b) {
		return a/b;

	}
	public int multiply(int a,int b) {
		return a*b;

	}
	
	public boolean isPrimeNum(int a) {
		for(int i =2;i<= a/2;i++) {
			if(a%i==0) {
				return false;
			}
		}
		return true;

	}
}
