package com.example.demo;

public class Person {

	int id;
	String fName,lName;


	public Person() {}
	public Person(int id, String fName, String lName) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
	}

	

	@Override
	public int hashCode() {
		return lName.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		Person other = (Person) obj;
		return lName.equals(other.lName);
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", fName=" + fName + ", lName=" + lName + "]";
	}

}
