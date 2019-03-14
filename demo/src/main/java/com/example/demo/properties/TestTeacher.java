package com.example.demo.properties;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestTeacher {

	public static void main(String[] args) {
		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("propPlace.xml");
		 * System.out.println(context.getBean("teacher"));
		 */
		
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.example.demo.*");
		List<String> subs = ((Teacher)annotationConfigApplicationContext.getBean(Teacher.class)).subject.getSubjectName();
		 System.out.println(subs);
	}

}
