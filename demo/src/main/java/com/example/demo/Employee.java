package com.example.demo;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Qualifier;
public class Employee {
	
	private int empId;
	private String empName;
	Address address;
	List<String> hobbies;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	Employee(int empId,String empName,Address address,List<String> hobbies){
		this.empId = empId;
		this.empName=empName;
		this.address = address;
		this.hobbies = hobbies;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", address=" + address + ", hobbies=" + hobbies + "]";
	}
	
	@PostConstruct
	public void initIt() throws Exception {
	  System.out.println("Init method after properties are set : " );
	}
	
	@PreDestroy
	public void cleanUp() throws Exception {
	  System.out.println("Spring Container is destroy! Customer clean up");
	}

}
