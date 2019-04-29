package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class RestCont {
	@RequestMapping("/hello")
	public String name() {
		return "Ramesha M V";
	}
}
