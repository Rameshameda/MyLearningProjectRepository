package com.springhibernate.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Teacher {
	@Id
	@GeneratedValue
	int teacherId;
	String name;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "teacher_subject_id" )
	Subject subject;
	
	public int getTeacherId() {
		return teacherId;
	}
	
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
}
