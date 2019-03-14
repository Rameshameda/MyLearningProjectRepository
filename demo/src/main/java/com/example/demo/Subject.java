package com.example.demo;

public class Subject {

	String subjectName;

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "Subject [subjectName=" + subjectName + "]";
	}
	
}
