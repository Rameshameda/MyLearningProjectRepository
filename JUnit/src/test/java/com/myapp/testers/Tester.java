package com.myapp.testers;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.myapp.service.CalculatorTest;
import com.myapp.service.StringUtilsTest;

public class Tester {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(StringUtilsTest.class,CalculatorTest.class);
		
		for(Failure failure:result.getFailures()) {
			System.out.println(failure);
		}
	}

}
