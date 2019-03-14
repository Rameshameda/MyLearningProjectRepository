package com.example.demo.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Factory.xml");
		System.out.println(context.getBean("a"));
	}

}
