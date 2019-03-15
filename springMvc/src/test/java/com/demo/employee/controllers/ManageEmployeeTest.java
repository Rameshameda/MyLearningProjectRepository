package com.demo.employee.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import com.demo.employee.impl.EmployeeDaoImpl;
import com.demo.employee.ineterfaces.EmployeeManager;
@RunWith(MockitoJUnitRunner.class)
public class ManageEmployeeTest {
	@Mock
	Model model;
	@Mock
	EmployeeManager employeeManeger;
	@InjectMocks
ManageEmployee test ; 
	@Test
	public void test() {
		when(employeeManeger.getAllEmployees()).thenReturn(new EmployeeDaoImpl().getAllEmployees());
		assertEquals("showAllEmps", test.getEmployees(model));
	}

}
