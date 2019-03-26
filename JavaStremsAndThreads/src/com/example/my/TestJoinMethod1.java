package com.example.my;

import org.junit.Test;

public class TestJoinMethod1 extends Thread{  
	public void run(){  
		for(int i=1;i<=5;i++){  
			try{  
				Thread.sleep(500);  
				Thread.currentThread().interrupt();
			}catch(InterruptedException e){
				System.out.println(e);
			}  
			System.out.println(i+" thead name "+this.getName());  
		}  
	}  



}  