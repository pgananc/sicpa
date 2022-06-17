package com.sicpa.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sicpa.exception.ModelNotFoundException;
import com.sicpa.model.Enterprise;
import com.sicpa.repository.IEnterpriseRepository;

/**
 * Test for enterprise service.
 * 
 * @author PABI1
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class EnterpriseServiceTest {

	@Autowired
	private IEnterpriseService enterpriseService;

	@MockBean
	private IEnterpriseRepository enterpriseRepository;

	@BeforeEach
	public void setUp() {
		Enterprise enterprise = Enterprise.builder().id(1L).name("Enterprise ABC").address("Address 1")
				.phone("12323112").build();
		List<Enterprise> enterprises = Arrays.asList(enterprise);
		Mockito.when(enterpriseRepository.findAll()).thenReturn(enterprises);

	}

	@Test
	public void whenEnterEnterprise_returnSave() {
		Enterprise enterprise = Enterprise.builder().id(1L).build();
		enterpriseService.save(enterprise);
		Mockito.verify(enterpriseRepository, VerificationModeFactory.times(1)).save(enterprise);
	}

	@Test
	public void whenUpdateIdEnterpriseNotExist_returnException() {
		Enterprise enterprise = Enterprise.builder().id(1L).build();
		Throwable exception = assertThrows(ModelNotFoundException.class,
				() -> enterpriseService.update(enterprise, 2L));
		assertEquals("Enterprise not found for this id : 2", exception.getMessage());
	}

	@Test
	public void whenSearchEnterprise_returnGreaterThanZero() {
		List<Enterprise> enterprises = enterpriseService.findAll();
		assertThat(enterprises.size()).isGreaterThan(0);
	}
}
