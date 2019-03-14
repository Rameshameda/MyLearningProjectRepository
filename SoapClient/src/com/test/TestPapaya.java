package com.test;

import com.test.impl.SayPapaya;
import com.test.impl.SayPapayaaService;

public class TestPapaya {
	
	public static void main(String[] args) {
		SayPapayaaService papayaaService = new SayPapayaaService();
		SayPapaya papaya  = papayaaService.getSayPapayaaPort();
		System.out.println(papaya.sayPapaya("chubby"));
	}
	
}
