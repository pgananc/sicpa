package com.sicpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sicpa.model.Enterprise;
/**
 * Repository for the department entity.
 * @author PABI1
 *
 */

public interface IEnterpriseRepository extends JpaRepository<Enterprise, Long> {

}
