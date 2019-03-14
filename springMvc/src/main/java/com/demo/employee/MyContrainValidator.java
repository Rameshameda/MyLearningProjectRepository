package com.demo.employee;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyContrainValidator implements ConstraintValidator<MyAnnotation, String> {

	public void initialize(MyAnnotation constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return value.contains("meda");
	}

}
