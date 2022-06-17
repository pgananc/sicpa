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

import com.sicpa.model.Enterprise;
import com.sicpa.service.IEnterpriseService;

/**
 * Controller for enterprise
 * 
 * @author PABI1
 *
 */
@RestController
@RequestMapping("api/v1/enterprises")
public class EnterpriseController {

	@Autowired
	private IEnterpriseService enterpriseService;

	@PostMapping
	public ResponseEntity<Enterprise> save(@Valid @RequestBody Enterprise enterprise) {
		enterpriseService.save(enterprise);
		return new ResponseEntity<Enterprise>(enterprise, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Enterprise> update(@Valid @RequestBody Enterprise enterprise, @PathVariable Long id) {
		enterpriseService.update(enterprise, id);
		return new ResponseEntity<Enterprise>(enterprise, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Enterprise>> findAll() {
		List<Enterprise> enterprises = enterpriseService.findAll();
		return new ResponseEntity<List<Enterprise>>(enterprises, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Enterprise> findById(@PathVariable Long id) {
		Enterprise enterprise = enterpriseService.findById(id);
		return new ResponseEntity<Enterprise>(enterprise, HttpStatus.OK);
	}

}
