package com.myapp.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
	Calculator calc = new Calculator();
	@Test
	public void testAdd() {
		assertEquals(2, calc.add(1, 1));
	}

	@Test
	public void testSubtract() {
		assertEquals(0, calc.subtract(1, 1));
	}

	@Test
	public void testDivide() {
		assertEquals(1, calc.divide(1, 1));
	}

	@Test
	public void testMultiply() {
		assertEquals(1, calc.multiply(1, 1));
	}

	@Test
	public void testIsPrimeNum() {
		assertEquals(true, calc.isPrimeNum(7));
	}

}
