package com.example.demo;

import org.springframework.beans.factory.annotation.Value;

public class Address {
	
	/*
	 * public Address(String address) { this.address = address; }
	 */
	@Override
	public String toString() {
		return "Address [address=" + address + "]";
	}
	String address;

	public String getAddress() {
		return address;
	}
@Value(value="my m m hills")
	public void setAddress(String address) {
		this.address = address;
	}
	
}
