package com.example.designPattrens;

import java.io.Serializable;

public class Singleton implements Serializable  
{ 
	private static final long serialVersionUID = -8991946391298905928L;
	// public instance initialized when loading the class 
    private static volatile Singleton instance ; 
      String name;
      
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Singleton()  
    { 
		
		  if (instance != null){ throw new
		  RuntimeException("Use getInstance() method to get the single instance of this class."
		  ); }
		 
    } 
    
    public static Singleton getObject() {
    	if (instance == null) { //Check for the first time
            
            synchronized (Singleton.class) {   //Check for the second time.
              //if there is no instance available... create new one
              if (instance == null) instance = new Singleton();
            }
        }
    	return instance;
	}
      
    // implement readResolve method 
	
	  protected Object readResolve() { return instance; }
}