package com.demo.employee;


import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;
@Entity
public class Employee {
	@Id
	int id;
	@Length(min=4,max=20,message="first name must be between 4 and 8 chars")
	String firstName;
	@MyAnnotation
	String lastName;
	String age;
	public Employee() {
		
	}
	public Employee(String firstName, String lastName, String age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
	
	

}
