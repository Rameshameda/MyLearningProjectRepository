package com.demo.springMvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyFirstSpringMvcController {
	@RequestMapping(value="/welcome")
	public String sayWelcome() {
		return "welcome";
	}
	@RequestMapping("/bye")
	public String sayBye() {
		return "bye";
	}
}
