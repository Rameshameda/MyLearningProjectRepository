package com.learning.impl;

import javax.jws.WebService;

import com.learning.MyFirstWS;
@WebService(endpointInterface="com.learning.MyFirstWS")
public class MyFirstWSImpl implements MyFirstWS {

	@Override
	public String sayBanana() {
		return "hi banana";
	}

}
