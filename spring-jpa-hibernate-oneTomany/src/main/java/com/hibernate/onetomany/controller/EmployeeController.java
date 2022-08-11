package com.hibernate.onetomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.onetomany.entities.Account;
import com.hibernate.onetomany.entities.Employee;
import com.hibernate.onetomany.services.AccountService;
import com.hibernate.onetomany.services.EmployeeService;

@RestController
@RequestMapping(value="employee")
public class EmployeeController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(value = "/getemployee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {

		Employee employee = employeeService.getEmployee(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getallemployee")
	public ResponseEntity<List<Employee>> getAllAccount() {

		List<Employee> employee = employeeService.getAllEmployee();
		return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
	}

	@PostMapping(value = "/addemployee")
	public ResponseEntity<Employee> addAccount(@RequestBody Employee employee) {

		Employee employeeDetails = employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeDetails, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{empId}/account/{accId}")
	public ResponseEntity<Employee> assignAccountToEmployee(@PathVariable Integer empId, @PathVariable Integer accId) {

		Employee employee = employeeService.getEmployee(empId);
		Account account = accountService.getAccount(accId);
		employee.setAccount(account);
		Employee employeeDetails= employeeService.assignAccountToEmployee(employee);
		return new ResponseEntity<Employee>(employeeDetails, HttpStatus.CREATED);
	}


}
