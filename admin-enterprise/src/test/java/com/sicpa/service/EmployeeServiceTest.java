package com.sicpa.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sicpa.model.Employee;
import com.sicpa.repository.IEmployeeRepository;

/**
 * Test for employee service.
 * 
 * @author PABI1
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeServiceTest {

	@Autowired
	private IEmployeeService employeeService;

	@MockBean
	private IEmployeeRepository employeeRepository;

	@BeforeEach
	public void setUp() {
		Employee employee = Employee.builder().id(1L).name("pepito").build();
		employee.setStatus(true);
		List<Employee> Employees = Arrays.asList(employee);
		Mockito.when(employeeRepository.findAll()).thenReturn(Employees);
		Mockito.when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

	}

	@Test
	public void whenEnterEmployee_returnSaved() {
		Employee employee = Employee.builder().id(1L).build();
		employeeService.save(employee);
		Mockito.verify(employeeRepository, VerificationModeFactory.times(1)).save(employee);
	}

	@Test
	public void whenUpdateEmployee_returnEmployeeUpdated() {
		Employee employee = Employee.builder().id(1L).build();
		employeeService.update(employee, 1L);
		Mockito.verify(employeeRepository, VerificationModeFactory.times(1)).save(employee);

	}

	@Test
	public void whenSearchEmployee_returnGreaterThanZero() {
		List<Employee> Employees = employeeService.findAll();
		assertThat(Employees.size()).isGreaterThan(0);
	}
}
