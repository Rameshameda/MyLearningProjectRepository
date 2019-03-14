package com.example.demo.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestEmp {
	public static void main(String[] args) {	

		
		/*
		 * Resource resource = new ClassPathResource("MyApp.xml"); BeanFactory
		 * beanFactory = new XmlBeanFactory(resource);
		 * 
		 * System.out.println(beanFactory.getBean("constEmp"));
		 */
		 
		
		
		  ClassPathXmlApplicationContext applicationContext = new
		  ClassPathXmlApplicationContext("MyApp.xml");
		  System.out.println(applicationContext.getBean("constEmp"));
		  applicationContext.registerShutdownHook();
		 
	}

}
