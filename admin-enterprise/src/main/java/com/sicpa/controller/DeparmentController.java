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

import com.sicpa.model.Department;
import com.sicpa.service.IDepartmentService;

/**
 * Controller for enterprise
 * 
 * @author PABI1
 *
 */
@RestController
@RequestMapping("api/v1/departments")
public class DeparmentController {

	@Autowired
	private IDepartmentService deparmentService;

	@PostMapping
	public ResponseEntity<Department> save(@Valid @RequestBody Department department) {
		deparmentService.save(department);
		return new ResponseEntity<Department>(department, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Department> update(@Valid @RequestBody Department department, @PathVariable Long id) {
		deparmentService.update(department, id);
		return new ResponseEntity<Department>(department, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Department>> findAll() {
		List<Department> deparments = deparmentService.findAll();
		return new ResponseEntity<List<Department>>(deparments, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Department> findById(@PathVariable Long id) {
		Department deparment = deparmentService.findById(id);
		return new ResponseEntity<Department>(deparment, HttpStatus.OK);
	}

}
