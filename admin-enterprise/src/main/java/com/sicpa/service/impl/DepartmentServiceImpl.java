package com.sicpa.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicpa.exception.ModelNotFoundException;
import com.sicpa.model.Department;
import com.sicpa.repository.IDeparmentRepository;
import com.sicpa.service.IDepartmentService;

/**
 * Service for enterprise.
 * 
 * @author PABI1
 *
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	private IDeparmentRepository departmentRepository;

	@Override
	public Department save(Department entity) {
		entity.setCreatedDate(LocalDateTime.now());
		entity.setStatus(true);
		return departmentRepository.save(entity);
	}

	@Override
	public Department update(Department entity, Long id) {
		Department department = findById(id);
		entity.setCreatedBy(department.getCreatedBy());
		entity.setCreatedDate(department.getCreatedDate());
		entity.setModifiedDate(LocalDateTime.now());
		return departmentRepository.save(entity);
	}

	@Override
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	@Override
	public Department findById(Long id) {
		return this.departmentRepository.findById(id)
				.orElseThrow(() -> new ModelNotFoundException("Department not found for this id :: " + id));
	}

}
