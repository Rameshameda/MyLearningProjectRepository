package com.example.demo.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutoWire {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("autowire.xml");
		System.out.println(context.getBean("suite"));
	}

}
