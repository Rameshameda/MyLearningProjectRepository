package com.learning.bean;

import java.io.Serializable;

import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;

public class UserBean implements Serializable {
	@FormParam("username")
	String username;
	@FormParam("password")
	String password;
	@HeaderParam("user-agent")
	String userAgent;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailAddress() {
		return userAgent;
	}
	public void setEmailAddress(String emailAddress) {
		this.userAgent = emailAddress;
	}
	
	

}
