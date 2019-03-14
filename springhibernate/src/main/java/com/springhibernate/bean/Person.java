package com.springhibernate.bean;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
@Entity
public class Person {
	@Id
	@GeneratedValue
	int aadharId;
	@Column()
	String firstName;
	String secoundName;
	String lastName;
	@ElementCollection
	@JoinTable(name="PersonHobbies",joinColumns= {@JoinColumn(name="aadhar_id")})
	@GenericGenerator(name="hilogen",strategy="hilo")
	@CollectionId(generator="hilogen",columns= {@Column(name="hobby_id")},type=@Type(type="long"))
	List<String> hobbies;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="houseName",column=@Column(name="HOUSE_name"))
		
	})
	Address address;
	
	public Person() {}
	
	public Person(String firstName, String secoundName, String lastName, List<String> hobbies,Address address) {
		super();
		this.firstName = firstName;
		this.secoundName = secoundName;
		this.lastName = lastName;
		this.hobbies = hobbies;
		this.address = address;
	}
	
	public int getAadharId() {
		return aadharId;
	}
	public void setAadharId(int aadharId) {
		this.aadharId = aadharId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecoundName() {
		return secoundName;
	}
	public void setSecoundName(String secoundName) {
		this.secoundName = secoundName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	/*
	 * @Override public String toString() { return "Person [aadharId=" + aadharId +
	 * ", firstName=" + firstName + ", secoundName=" + secoundName + ", lastName=" +
	 * lastName + ", hobbies=" + getHobbies() + ", address=" + address + "]"; }
	 */
	
}
