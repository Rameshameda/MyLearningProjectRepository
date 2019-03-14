package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class TestGenerics<RM> {
	RM r;

	public RM getR() {
		return r;
	}

	public void setR(RM r) {
		this.r = r;
	}

	
	public static void main(String[] args) {
		/*
		 * TestGenerics<String> s = new TestGenerics<String>(); s.setR("Rameshmeda");
		 * String myname = s.getR(); System.out.println(myname);
		 */
		int oldCapacity=11;
		System.out.println(oldCapacity + (oldCapacity >> 1));
	}
}
