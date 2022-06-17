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

import com.sicpa.model.Department;
import com.sicpa.repository.IDeparmentRepository;

/**
 * Test for deparment service.
 * 
 * @author PABI1
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentServiceTest {

	@Autowired
	private IDepartmentService departmentService;

	@MockBean
	private IDeparmentRepository deparmentRepository;

	@BeforeEach
	public void setUp() {
		Department department = Department.builder().id(1L).name("sales").build();
		department.setStatus(true);
		List<Department> departments = Arrays.asList(department);
		Mockito.when(deparmentRepository.findAll()).thenReturn(departments);
		Mockito.when(deparmentRepository.findById(1L)).thenReturn(Optional.of(department));

	}

	@Test
	public void whenEnterDepartment_returnSaved() {
		Department department = Department.builder().id(1L).build();
		departmentService.save(department);
		Mockito.verify(deparmentRepository, VerificationModeFactory.times(1)).save(department);
	}

	@Test
	public void whenUpdateDepartment_returnDepartmentUpdated() {
		Department department = Department.builder().id(1L).build();
		departmentService.update(department, 1L);
		Mockito.verify(deparmentRepository, VerificationModeFactory.times(1)).save(department);

	}

	@Test
	public void whenSearchDeparment_returnGreaterThanZero() {
		List<Department> departments = departmentService.findAll();
		assertThat(departments.size()).isGreaterThan(0);
	}
}
