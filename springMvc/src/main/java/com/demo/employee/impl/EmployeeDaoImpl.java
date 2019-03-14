package com.demo.employee.impl;

import java.util.ArrayList;
import java.util.List;

import com.demo.employee.Employee;
import com.demo.employee.ineterfaces.EmployeeDao;

public class EmployeeDaoImpl implements EmployeeDao {

	public List<Employee> getAllEmployees() {
		Employee employee1 = new Employee("Ramesh", "Meda", "29");
		Employee employee2 = new Employee("Rajendra", "Bathina", "35");
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee1);
		employees.add(employee2);
		return employees;
	}

}
