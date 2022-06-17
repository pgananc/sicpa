package com.sicpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sicpa.model.Department;
/**
 * Repository for the department entity.
 * @author PABI1
 *
 */

public interface IDeparmentRepository extends JpaRepository<Department, Long> {

}
