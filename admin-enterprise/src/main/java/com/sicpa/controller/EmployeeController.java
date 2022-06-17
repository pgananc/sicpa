package com.sicpa.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.sicpa.model.Employee;
import com.sicpa.service.IEmployeeService;

/**
 * Controller for enterprise
 * 
 * @author PABI1
 *
 */
@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@PostMapping
	public ResponseEntity<Employee> save(@Valid @RequestBody Employee employee) {
		employeeService.save(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> update(@Valid @RequestBody Employee employee, @PathVariable Long id) {
		employeeService.update(employee, id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Employee>> findAll() {
		List<Employee> employees = employeeService.findAll();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> findById(@PathVariable Long id) {
		Employee deparment = employeeService.findById(id);
		return new ResponseEntity<Employee>(deparment, HttpStatus.OK);
	}

}
