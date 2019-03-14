package com.example.demo;

import java.util.List;
import java.util.Map;

public class Student {
	String studentName;
	List<Subject> subjects;
	Map<Quetion, Answer> questionAns;
	Map<String, Subject> teachSub;
	
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	public Map<Quetion, Answer> getQuestionAns() {
		return questionAns;
	}
	public void setQuestionAns(Map<Quetion, Answer> questionAns) {
		this.questionAns = questionAns;
	}
	public Map<String, Subject> getTeachSub() {
		return teachSub;
	}
	public void setTeachSub(Map<String, Subject> teachSub) {
		this.teachSub = teachSub;
	}
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", subjects=" + subjects + ", questionAns=" + questionAns
				+ ", teachSub=" + teachSub + "]";
	}
	
	
	

}
