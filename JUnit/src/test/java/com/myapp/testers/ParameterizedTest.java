package com.myapp.testers;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.myapp.service.StringUtils;

@RunWith(Parameterized.class)
public class ParameterizedTest {
	boolean expected; String inpuString;int a;


	public ParameterizedTest(int a,boolean expected, String inpuString)  {
		this.expected = expected;
		this.inpuString = inpuString;
		this.a = a;
	}
	@Parameters
	public static Collection getParameters() {
		return Arrays.asList(new Object[][] {
			{1,true,"Madam"},
			{2,false,"dam"},
			{3,true,"dum"},
			{4,false,"women"}
			
		});
	}
	@Test
	public void name() {
		StringUtils stringUtils = new StringUtils();
		assertEquals(expected, stringUtils.isPalendrome(inpuString,a));
	}
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(ParameterizedTest.class);
		for(Failure failure : result.getFailures()) {
			System.out.println(failure);
		}
	}
}
