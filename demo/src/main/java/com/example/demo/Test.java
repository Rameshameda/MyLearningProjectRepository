package com.example.demo;

import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Integer> number = Arrays.asList(2,3,4,5,6);
		int even = (int) (number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i));


		System.out.println(even);
	}
	private static void doproc(int i,myLamda lamda) {
		lamda.process(i);

	}
	interface myLamda{
		void process(int a);
	}
}
