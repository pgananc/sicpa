package com.sicpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sicpa.model.Employee;
/**
 * Repository for the employee entity.
 * @author PABI1
 *
 */

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
