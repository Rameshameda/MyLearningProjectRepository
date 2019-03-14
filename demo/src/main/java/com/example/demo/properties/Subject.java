package com.example.demo.properties;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Subject {
@Value("new subject,old subject")
	List<String> subjects;

	public List<String> getSubjectName() {
		return subjects;
	}

	public void setSubjectName(List<String> subjectName) {
		this.subjects = subjectName;
	}

	@Override
	public String toString() {
		return "Subject [subjectName=" + subjects + "]";
	}
	
}
