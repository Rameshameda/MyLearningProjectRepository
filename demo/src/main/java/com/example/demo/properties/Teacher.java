package com.example.demo.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
@Configuration
@PropertySource(value="classpath:teacher.properties")
public class Teacher {
	@Value("${teacher.name}")
	String name;
	@Autowired
	Subject subject;
	@Value("${teacher.school}")
	String school;
	/*
	 * public String getName() { return name; } public void setName(String name) {
	 * this.name = name; } public String getSubject() { return subject; } public
	 * void setSubject(String subject) { this.subject = subject; } public String
	 * getSchool() { return school; } public void setSchool(String school) {
	 * this.school = school; }
	 */
	
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", subject=" + subject + ", school=" + school + "]";
	}
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	   return new PropertySourcesPlaceholderConfigurer();
	}

	
}
