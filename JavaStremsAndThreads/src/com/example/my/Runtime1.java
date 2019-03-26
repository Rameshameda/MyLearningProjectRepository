package com.example.my;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runtime1{  
 public static void main(String args[])throws Exception{  
  //Runtime.getRuntime().exec("notepad");//will open a new notepad
	 ExecutorService executorService =Executors.newSingleThreadScheduledExecutor();
	Future<Integer> callable =  executorService.submit(new MyCallable());
	Future runnable =  Executors.newSingleThreadScheduledExecutor().submit(new MyRunnable()); 
	executorService.invokeAll(new ArrayList<Callable<String>>());
	System.out.println(callable.get());
	System.out.println(runnable.get());
 }  
}  

class MyCallable implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		return 10;
	}
	
}

class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("in runnable :10");
		
	}
	
}
