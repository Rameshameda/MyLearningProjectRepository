package com.learning;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTestTest {

	@Test(expected=ArithmeticException.class)
	public void testAdd() {
		JUnitTest jUnitTest = new JUnitTest();
		assertEquals ("add method adds two numbers",2, jUnitTest.add(0, 1));
		assertEquals(1, jUnitTest.add(0, 1));
		assertEquals(2, jUnitTest.add(1, 1));
	}

}
