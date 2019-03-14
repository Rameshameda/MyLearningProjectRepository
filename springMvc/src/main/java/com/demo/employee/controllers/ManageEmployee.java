package com.demo.employee.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.demo.employee.Employee;
import com.demo.employee.Test;
import com.demo.employee.ineterfaces.EmployeeManager;

@Controller
//@SessionAttributes("employee")
@RequestMapping("/manageemp")
public class ManageEmployee {
	
	@Autowired
	EmployeeManager employeeManeger;
	@Autowired
	Test test;
	@RequestMapping("/myxmlviews")
	public String name() {
		return "WelcomePage";		
	}

	@RequestMapping("/custs")
	public String getcust() {
		test.test();
		System.out.println("yah yah");
		return "redirect:getallemps";
	}

	@RequestMapping(method=RequestMethod.GET,value="/getallemps")
	public String getEmployees(Model model) {
		model.addAttribute("employees", employeeManeger.getAllEmployees());
		return "showAllEmps";
	}

	@RequestMapping(method=RequestMethod.GET,value="/addemp")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmployee";
	}

	@RequestMapping(method=RequestMethod.POST,value="/newemp")
	public String submitForm(@Valid @ModelAttribute("employee") Employee employee,BindingResult result, SessionStatus status) {
		test.addemp(employee);
		System.out.println("here in post"+employee);
		//validator.validate(employee, result);
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "addEmployee";
		}
		/*
		 * Validator validator =
		 * Validation.buildDefaultValidatorFactory().getValidator();
		 * Set<ConstraintViolation<Employee>> error = validator.validate(employee);
		 * System.err.println(employee.getFirstName().length());
		 * System.err.println(employee.getLastName().length()); for
		 * (ConstraintViolation<Employee> violation : error) { String propertyPath =
		 * violation.getPropertyPath().toString(); String message =
		 * violation.getMessage(); // Add JSR-303 errors to BindingResult // This allows
		 * Spring to display them in view via a FieldError
		 * System.out.println(propertyPath); System.out.println(message); }
		 */
		return "redirect:success";
	}
	@RequestMapping("/success") 
	public String resdirectToSuccess() {
		return "addSuccess";
	}
	
	@ExceptionHandler(Exception.class)
	public String genaralException(HttpServletRequest request,Exception exception) {
		exception.printStackTrace();
		return "myException4";
	}
}
