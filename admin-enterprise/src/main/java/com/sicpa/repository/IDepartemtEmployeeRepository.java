package com.sicpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sicpa.model.DepartmentEmployee;
/**
 * Repository for the department and employee entity.
 * @author PABI1
 *
 */

public interface IDepartemtEmployeeRepository extends JpaRepository<DepartmentEmployee, Long> {

}
