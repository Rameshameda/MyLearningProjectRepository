package com.demo.employee.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyGlobalExceptionHandler {
	
	@ExceptionHandler(DuplicateKeyException.class)
	public String myExceptionHnadler(HttpServletRequest request,DuplicateKeyException exception) {
		exception.printStackTrace();
		return "myException2";
	}
	
	@ExceptionHandler(Exception.class)
	public String genaralException(HttpServletRequest request,Exception exception) {
		exception.printStackTrace();
		return "myException1";
	}
}
