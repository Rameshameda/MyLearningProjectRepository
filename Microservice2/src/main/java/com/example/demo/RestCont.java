package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/userForMic1")
public class RestCont {
	
	@Autowired
	RestTemplate restTemplate; 
	
	@HystrixCommand(fallbackMethod="fallBack")
	@RequestMapping("/hello")
	public String name() {
		return restTemplate.getForEntity("http://localhost:8083/user/hello", String.class).getBody();
	}
	
	private String fallBack() {
		return "nithin ellidiaya?";
	}
}
