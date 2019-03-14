package com.example.hibernate.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="employee_table")
public class EmployeeBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 97692271556125499L;
	@Id
	@Column(name="employee_id")
	int empId;
	@Column(name="first_name")
	String  fName;
	@Column(name="last_name")
	String lName;
	
	public EmployeeBean() {}
	
	public EmployeeBean(int empId, String fName, String lName) {
		super();
		this.empId = empId;
		this.fName = fName;
		this.lName = lName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	
	
}
