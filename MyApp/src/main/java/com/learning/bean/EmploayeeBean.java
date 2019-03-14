package com.learning.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder={"id","firstName","middleName","lastName","hobbies"})
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class EmploayeeBean {
	
	@XmlElement(name="EmployeeID")
	int id;
	String firstName;
	@XmlTransient
	String middleName;
	String lastName;
	/*
	 * @XmlElementWrapper(name="hobbies")
	 * 
	 * @XmlElement(name="hobby")
	 */
	@XmlList
	ArrayList<String> hobbies;
	
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}
	public int getId() {
		return id;
	}
	@JsonSetter("EmployeeID")
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	@Override
	 @JsonValue
	public String toString() {
		return "EmploayeeBean [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", hobbies=" + hobbies + "]";
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
