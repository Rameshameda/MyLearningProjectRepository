package com.example.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("MyApp.xml");
		System.out.println(applicationContext.getBean("student1"));
		System.out.println(applicationContext.getBean("student2"));
		((ClassPathXmlApplicationContext)applicationContext).close();
	}

}
