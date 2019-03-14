package com.myapp.service;

public class StringUtils {
	
	Calculator calculator ;
	public boolean isPalendrome(String string,int a) {
		String input = string; 
		char [] strAsByteArray = input.toCharArray(); 
		char [] result = new char [strAsByteArray.length]; 
		int res = calculator.add(1,2);
System.out.println(res+":this one is called :"+string);

		for (int i = strAsByteArray.length-1; i>=0; i--) 
			result[i] = strAsByteArray[i]; 
		return string.equalsIgnoreCase(new String(result));
	}
}
