package com.sicpa.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicpa.exception.ModelNotFoundException;
import com.sicpa.model.Employee;
import com.sicpa.repository.IEmployeeRepository;
import com.sicpa.service.IEmployeeService;

/**
 * Service for employee.
 * 
 * @author PABI1
 *
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee entity) {
		entity.setCreatedDate(LocalDateTime.now());
		entity.setStatus(true);
		return employeeRepository.save(entity);
	}

	@Override
	public Employee update(Employee entity, Long id) {
		Employee employee = findById(id);
		entity.setCreatedBy(employee.getCreatedBy());
		entity.setCreatedDate(employee.getCreatedDate());
		entity.setModifiedDate(LocalDateTime.now());
		return employeeRepository.save(entity);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(Long id) {
		return this.employeeRepository.findById(id)
				.orElseThrow(() -> new ModelNotFoundException("Employee not found for this id :: " + id));
	}

}
