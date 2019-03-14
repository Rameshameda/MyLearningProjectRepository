package com.example.demo.autowire;

public class Shirt {
	String shirt;

	public String getShirt() {
		return shirt;
	}

	public void setShirt(String shirt) {
		this.shirt = shirt;
	}

	@Override
	public String toString() {
		return "Shirt [shirt=" + shirt + "]";
	}


}
