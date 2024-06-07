package com.example.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRepository;
import com.example.springboot.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository ;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		return employeeRepository.findById(id).orElseThrow(() ->
		                                     new ResourceNotFoundException("Employee" , "Id" , "Id"));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		//check whether the employee with given id exists
		Employee  existingEmployee =  employeeRepository.findById(id).orElseThrow(() ->
                                              new ResourceNotFoundException("Employee" , "Id" , "Id"));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		//save existingEmployee to the DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;
		
	}

	@Override
	public void deleteEmployee(long id) {
		
		//check whether employee with given id exists or not 
		employeeRepository.findById(id).orElseThrow(() ->
                                            new ResourceNotFoundException("Employee" , "Id" , "Id"));
		 employeeRepository.deleteById(id);
		
	}

	
}
