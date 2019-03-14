package com.test.impl;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.test.SayPapaya;
@WebService(endpointInterface="com.test.SayPapaya")
public class SayPapayaa implements SayPapaya {
	 @Resource
	    WebServiceContext wsctx;

	@Override
	public String sayPapaya(String fName) {
		// TODO Auto-generated method stub
		/*
		 * MessageContext context = wsctx.getMessageContext(); Map<String, Object> map =
		 * (Map<String, Object>) context.get(MessageContext.HTTP_REQUEST_HEADERS); try {
		 * System.out.println(map.get("authorization")); System.out.println(new
		 * String(Base64.getDecoder().decode(map.get("authorization").toString().
		 * replace("[Basic ", "").replace("]", "")),"UTF-8")); } catch
		 * (UnsupportedEncodingException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * System.out.println(wsctx.getMessageContext().get(MessageContext.
		 * HTTP_REQUEST_HEADERS));
		 */
		return name()+" mr/mrs :"+fName+": wanna eat papaya";
	}
	
	private String name() {
		return "hey";
	}

	@Override
	public String sayPotato(String fName) {
		// TODO Auto-generated method stub
		return name()+" mr/mrs :"+fName+": wanna eat Potato";
	}

}
