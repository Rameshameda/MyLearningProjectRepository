package com.springhibernate.bean;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("FourCycleEngine")
public class FourStrokeEngine extends Engine {
	String twoCycles;

	public String getTwoCycles() {
		return twoCycles;
	}

	public void setTwoCycles(String twoCycles) {
		this.twoCycles = twoCycles;
	}
	
	
}
