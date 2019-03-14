package com.example.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.text.ParseException;
import java.util.StringJoiner;

public class TestIO {
public static void main(String[] args) {
	try {
		Files.lines(
				FileSystems.getDefault().getPath("C:\\Users\\rameshacp12429\\Documents\\workspace-spring-tool-suite-4-4.1.1.RELEASE\\demo\\src\\main\\java\\com\\example\\demo\\TestIO.java"))
		.forEach(p -> System.out.println(p));
		Files.lines(
				FileSystems.getDefault().getPath("C:\\Users\\rameshacp12429\\documents\\saypapaya1-soapui-project.xml"))
		.forEach(p -> System.out.println(p));
	} catch (IOException  ex) {
		
	}
	try{    
        int array[] = new int[10];    
        array[10] = 30/0;    
    }    
    catch(ArithmeticException | ArrayIndexOutOfBoundsException e){  
        System.out.println(e.getMessage());  
    }    
	
	StringJoiner joiner = new StringJoiner("-", "res", "suf");
	joiner.add("ramesh");
	joiner.add("meda");
	joiner.add("chubby");
	System.out.println(joiner);
 }   
}
