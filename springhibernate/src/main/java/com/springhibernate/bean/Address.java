package com.springhibernate.bean;

import javax.persistence.Embeddable;
@Embeddable
public class Address {
	String houseNumber;
	String houseName;
	String street;
	String area;
	String city;
	String state;
	
	public Address() {}
	
	public Address(String houseNumber, String houseName, String street, String area, String city, String state) {
		super();
		this.houseNumber = houseNumber;
		this.houseName = houseName;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
	}
	
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	/*
	 * @Override public String toString() { return "Address [houseNumber=" +
	 * houseNumber + ", houseName=" + houseName + ", street=" + street + ", area=" +
	 * area + ", city=" + city + ", state=" + state + "]"; }
	 */
	

	
}
