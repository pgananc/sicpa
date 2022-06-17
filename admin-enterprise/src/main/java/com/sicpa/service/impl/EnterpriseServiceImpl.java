package com.sicpa.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sicpa.exception.ModelNotFoundException;
import com.sicpa.model.Enterprise;
import com.sicpa.repository.IEnterpriseRepository;
import com.sicpa.service.IEnterpriseService;

/**
 * Service for enterprise.
 * 
 * @author PABI1
 *
 */
@Service
public class EnterpriseServiceImpl implements IEnterpriseService {

	@Autowired
	private IEnterpriseRepository enterpriseRepository;

	@Override
	public Enterprise save(Enterprise entity) {
		entity.setCreatedDate(LocalDateTime.now());
		entity.setStatus(true);
		return enterpriseRepository.save(entity);
	}

	@Override
	public Enterprise update(Enterprise entity, Long id) {
		Enterprise enterprise = findById(id);
		entity.setCreatedBy(enterprise.getCreatedBy());
		entity.setCreatedDate(enterprise.getCreatedDate());
		entity.setModifiedDate(LocalDateTime.now());
		return enterpriseRepository.save(entity);
	}

	@Override
	public List<Enterprise> findAll() {
		return enterpriseRepository.findAll();
	}

	@Override
	public Enterprise findById(Long id) {
		return enterpriseRepository.findById(id)
				.orElseThrow(() -> new ModelNotFoundException("Enterprise not found for this id : " + id));

	}

}
