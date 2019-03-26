package com.example.my;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJoinMethod1Test {

	@Test(expected=InterruptedException.class)
	public void test() {
		Thread.currentThread().interrupt();
		new TestJoinMethod1().run();
	}

}
