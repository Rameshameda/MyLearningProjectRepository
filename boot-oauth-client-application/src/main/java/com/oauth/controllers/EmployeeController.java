package com.oauth.controllers;

import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oauth.model.Employee;

@Controller
public class EmployeeController {

	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
	public ModelAndView getEmployeeInfo() {
		return new ModelAndView("getEmployees");
	}

	@RequestMapping(value = "/showEmployees", method = RequestMethod.GET)
	public ModelAndView showEmployees(@RequestParam("code") String code) throws JsonProcessingException, IOException {
		System.out.println("how may times");
		String url = "http://localhost:8080/user/getEmployeesList";
		String token = getAccessTokenByAuthCode(code);
		// Use the access token for authentication
		HttpHeaders headers1 = new HttpHeaders();
		headers1.add("Authorization", "Bearer " + token);
		HttpEntity<String> entity = new HttpEntity<>(headers1);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Employee[]> employees = restTemplate.exchange(url, HttpMethod.GET, entity, Employee[].class);
		System.out.println(employees);
		Employee[] employeeArray = employees.getBody();

		ModelAndView model = new ModelAndView("showEmployees");
		model.addObject("employees", Arrays.asList(employeeArray));
		return model;
	}

	public static String getAccessTokenByAuthCode(String code) throws JsonProcessingException, IOException{
		ResponseEntity<String> response = null;
		System.out.println("Authorization code------" + code);

		RestTemplate restTemplate = new RestTemplate();

		String credentials = "javainuse:secret";
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Basic " + encodedCredentials);

		HttpEntity<String> request = new HttpEntity<String>(headers);

		String access_token_url = "http://localhost:8080/oauth/token";
		access_token_url += "?code=" + code;
		access_token_url += "&grant_type=authorization_code";
		access_token_url += "&redirect_uri=http://localhost:8090/showEmployees";

		response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);

		System.out.println("Access Token Response ---------" + response.getBody());

		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(response.getBody());
		String token = node.path("access_token").asText();

		return token;
	}


	public static String refreashToken(String token) throws JsonProcessingException, IOException{
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();
		
		String credentials = "javainuse-client:javainuse-secret";
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Basic " + encodedCredentials);

		HttpEntity<String> request = new HttpEntity<String>(headers);
		
		String access_token_url = "http://localhost:8081/oauth/token?grant_type=refresh_token&refresh_token="+token;
		response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);
		System.out.println("Access Token Response ---------" + response.getBody());

		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(response.getBody());
		String refreashedtoken = node.path("access_token").asText();

		return refreashedtoken;
	}

	public static String getAccessTokenByCredencials(String userName,String password) throws JsonProcessingException, IOException{
		ResponseEntity<String> response = null;

		RestTemplate restTemplate = new RestTemplate();
		
		String credentials = "javainuse-client:javainuse-secret";
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Basic " + encodedCredentials);

		HttpEntity<String> request = new HttpEntity<String>(headers);


		String access_token_url = "http://localhost:8081/oauth/token?grant_type=password&username="+userName+"&password="+password;


		response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);

		System.out.println("Access Token Response ---------" + response.getBody());

		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(response.getBody());
		String token = node.path("access_token").asText();

		return token;
	}


	public static void main(String[] args) throws JsonProcessingException, IOException {
		String token = getAccessTokenByCredencials("javainuse-user", "javainuse-pass");
		System.out.println(token);
System.out.println(refreashToken("c9937099-d0e5-4873-b9ee-bf17c05a7165"));
		/*
		 * Employee[] employeeArray = employees.getBody();
		 * 
		 * ModelAndView model = new ModelAndView("showEmployees");
		 * model.addObject("employees", Arrays.asList(employeeArray)); return model;
		 */
	} 

}