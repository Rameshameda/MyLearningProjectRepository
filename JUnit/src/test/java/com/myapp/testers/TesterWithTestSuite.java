package com.myapp.testers;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.myapp.service.CalculatorTest;
import com.myapp.service.StringUtilsTest;

@RunWith(Suite.class)
@SuiteClasses({StringUtilsTest.class,CalculatorTest.class})
public class TesterWithTestSuite {
public static void main(String[] args) {
	Result result = JUnitCore.runClasses(TesterWithTestSuite.class);
	for(Failure failure : result.getFailures()) {
		System.out.println(failure);
	}
}
}
