package com.example.springboot.service;



import java.util.List;

import com.example.springboot.model.Employee;

public interface EmployeeService {

	// method name and return type 
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee , long id);
	void deleteEmployee(long id);
}
