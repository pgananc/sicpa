package com.sicpa.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.sicpa.model.Employee;
import com.sicpa.service.IEmployeeService;
import com.sicpa.util.JsonUtil;

/**
 * Test controller employee.
 * 
 * @author PABI1
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

	private static final String END_POINT = "/api/v1/employees";
	@Autowired
	private MockMvc mvc;

	@MockBean
	private IEmployeeService employeeService;

	@Test
	public void whenCreateEmployeePost_returnCreatedEmployee() throws Exception {
		Employee employee = Employee.builder().id(1L).name("peter").build();
		given(employeeService.save(Mockito.any())).willReturn(employee);

		mvc.perform(post(END_POINT).contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toBytes(employee)))
				.andExpect(status().isCreated()).andExpect(jsonPath("$.name", is("peter")));
		verify(employeeService, VerificationModeFactory.times(1)).save(Mockito.any());
	}

	@Test
	public void whenUpdatedEmployee_returnUpdateEmployee() throws Exception {
		Employee employee = Employee.builder().id(1L).name("peter").build();
		Mockito.when(employeeService.update(employee, 1L)).thenReturn(employee);

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put(END_POINT + "/1", employee)
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8").content(JsonUtil.toBytes(employee));

		mvc.perform(builder).andExpect(status().isOk()).andExpect(jsonPath("$.id", is(1)))
				.andExpect(MockMvcResultMatchers.content().string(JsonUtil.toString(employee)));
	}

	@Test
	public void whenSearchEmployee_returnJsonArray() throws Exception {
		Employee employeeOne = Employee.builder().id(1L).name("peter").build();
		Employee employeeTwo = Employee.builder().id(1L).name("paul").build();

		List<Employee> employees = Arrays.asList(employeeOne, employeeTwo);

		given(employeeService.findAll()).willReturn(employees);

		mvc.perform(get(END_POINT).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2))).andExpect(jsonPath("$[0].name", is(employeeOne.getName())))
				.andExpect(jsonPath("$[1].name", is(employeeTwo.getName())));
		verify(employeeService, VerificationModeFactory.times(1)).findAll();
	}
}
