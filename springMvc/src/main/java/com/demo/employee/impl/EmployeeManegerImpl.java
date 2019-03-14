package com.demo.employee.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.employee.Employee;
import com.demo.employee.ineterfaces.EmployeeManager;
@Service
public class EmployeeManegerImpl implements EmployeeManager {

	public List<Employee> getAllEmployees() {
		return new EmployeeDaoImpl().getAllEmployees();
	}

}
