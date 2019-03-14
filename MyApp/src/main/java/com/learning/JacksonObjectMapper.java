package com.learning;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.bean.EmploayeeBean;

public class JacksonObjectMapper {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String emplaoyeeJson = "{\r\n" + 
				"    \"id\": 1,\r\n" + 
				"    \"firstName\": \"$#\",\r\n" + 
				"    \"hobbies\": [\r\n" + 
				"        \"tik tok\",\r\n" + 
				"        \"face Book\",\r\n" + 
				"        \"whatsapp\"\r\n" + 
				"    ],\r\n" + 
				"    \"lastName\": \"bysani\"\r\n" + 
				"}";
		EmploayeeBean bean = mapper.readValue(emplaoyeeJson, EmploayeeBean.class);
		System.out.println(bean);
		
	}
}
