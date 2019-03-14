package com.jax.ws.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.jax.ws.MyFristJaxWs;
@WebService(endpointInterface="com.jax.ws.MyFristJaxWs")

public class MyFristJaxWsImpl implements MyFristJaxWs {
@WebMethod
	public String getMsg(String fName) {
		return "Welcome To matrix Mr/Mrs : "+fName;
	}

}
