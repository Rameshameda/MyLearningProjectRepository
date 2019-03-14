package com.springhibernate.bean;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("TwoCycleEngine")
public class TwoStrokeEngine extends Engine {
	
	String fourCycles;

	public String getFourCycles() {
		return fourCycles;
	}

	public void setFourCycles(String fourCycles) {
		this.fourCycles = fourCycles;
	}

}
