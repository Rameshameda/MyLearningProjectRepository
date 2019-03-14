package com.java.streams;

import java.util.stream.IntStream;

public class Test {
public static void main(String[] args) {
	int sum = IntStream.of(1, 2, 3, 4).reduce(5, (a, b) -> a + b);
System.out.println(sum);
}
}
