package com.springhibernate.bean;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private User id;
	
	@Column(name="location")
	private String location;
	
	public Student(User id, String location){
		this.id=id;
		this.location=location;
	}
	public User getId() {
		return id;
	}
	public void setId(User id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}