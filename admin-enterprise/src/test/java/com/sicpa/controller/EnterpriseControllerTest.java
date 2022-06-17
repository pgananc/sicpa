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

import com.sicpa.model.Enterprise;
import com.sicpa.service.IEnterpriseService;
import com.sicpa.util.JsonUtil;

/**
 * Test controller enterprise.
 * 
 * @author PABI1
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class EnterpriseControllerTest {

	private static final String END_POINT = "/api/v1/enterprises";
	@Autowired
	private MockMvc mvc;

	@MockBean
	private IEnterpriseService enterpriseService;

	@Test
	public void whenCreateEnterprisePost_returnCreatedEnterprise() throws Exception {
		Enterprise enterprise = Enterprise.builder().id(1L).name("sicpa").build();
		given(enterpriseService.save(Mockito.any())).willReturn(enterprise);

		mvc.perform(post(END_POINT).contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toBytes(enterprise)))
				.andExpect(status().isCreated()).andExpect(jsonPath("$.name", is("sicpa")));
		verify(enterpriseService, VerificationModeFactory.times(1)).save(Mockito.any());
	}

	@Test
	public void whenUpdatedEnterprise_returnUpdateEnterprise() throws Exception {
		Enterprise enterprise = Enterprise.builder().id(1L).name("sicpa").build();
		Mockito.when(enterpriseService.update(enterprise, 1L)).thenReturn(enterprise);

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put(END_POINT + "/1", enterprise)
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8").content(JsonUtil.toBytes(enterprise));

		mvc.perform(builder).andExpect(status().isOk()).andExpect(jsonPath("$.id", is(1)))
				.andExpect(MockMvcResultMatchers.content().string(JsonUtil.toString(enterprise)));
	}

	@Test
	public void whenSearchEnterprise_returnJsonArray() throws Exception {
		Enterprise enterpriseOne = Enterprise.builder().id(1L).name("sicpa").build();
		Enterprise enterpriseTwo = Enterprise.builder().id(1L).name("nouxes").build();

		List<Enterprise> enterprises = Arrays.asList(enterpriseOne, enterpriseTwo);

		given(enterpriseService.findAll()).willReturn(enterprises);

		mvc.perform(get(END_POINT).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2))).andExpect(jsonPath("$[0].name", is(enterpriseOne.getName())))
				.andExpect(jsonPath("$[1].name", is(enterpriseTwo.getName())));
		verify(enterpriseService, VerificationModeFactory.times(1)).findAll();
	}
}
