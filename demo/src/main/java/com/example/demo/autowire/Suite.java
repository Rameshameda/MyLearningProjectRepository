package com.example.demo.autowire;

public class Suite {
	Shirt shirt;
	Phant phant;
	Blazer blazer;
	
	/*
	 * public Suite(Shirt shirt, Phant phant, Blazer blazer) { super(); this.shirt =
	 * shirt; this.phant = phant; this.blazer = blazer; }
	 */
	public Shirt getShirt() {
		return shirt;
	}
	public void setShirt(Shirt shirt) {
		this.shirt = shirt;
	}
	public Phant getPhant() {
		return phant;
	}
	public void setPhant(Phant phant) {
		this.phant = phant;
	}
	public Blazer getBlazer() {
		return blazer;
	}
	public void setBlazer(Blazer blazer) {
		this.blazer = blazer;
	}
	@Override
	public String toString() {
		return "Suite [shirt=" + shirt + ", phant=" + phant + ", blazer=" + blazer + "]";
	}
	

}
