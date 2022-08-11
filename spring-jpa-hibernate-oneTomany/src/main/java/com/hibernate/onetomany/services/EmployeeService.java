package com.hibernate.onetomany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.onetomany.entities.Account;
import com.hibernate.onetomany.entities.Employee;
import com.hibernate.onetomany.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee getEmployee(Integer empId) {
		return employeeRepository.findById(empId).get();
	}
	
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee assignAccountToEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
}
