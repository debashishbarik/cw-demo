package com.ubs.cw.demo.rest.cwrestdemoproject;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ubs.cw.demo.rest.cwrestdemoproject.domain.Customer;
import com.ubs.cw.demo.rest.cwrestdemoproject.service.CustomerService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

	@MockBean
	CustomerService customerService;

	@Autowired
	MockMvc mockMvc;

	@Test
	@DisplayName("POST /customers - Success")
	void testCreateCustomer() throws Exception {

		// setup mocked service
		final Customer postCustomer = new Customer();
		postCustomer.setId(1L);
		postCustomer.setName("Padmja");

		final Customer mockedCustomer = new Customer();
		mockedCustomer.setId(1L);
		mockedCustomer.setName("Padmja");

		final String jsonString = asJsonString(postCustomer);
		System.out.println(jsonString);
		doReturn(mockedCustomer).when(customerService).createCustomer(Mockito.any(Customer.class));

		mockMvc.perform(post("/customers").contentType(MediaType.APPLICATION_JSON).content(jsonString))
				.andExpect(status().isCreated()).andExpect(header().string(HttpHeaders.LOCATION, "/customers/1"))

				.andExpect(jsonPath("$.id", is(1))).andExpect(jsonPath("$.firstName", is("Padmja")));

	}

	static String asJsonString(final Object obj) {

		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (final JsonProcessingException e) {
			throw new RuntimeException(e);
		}

	}

	@Test
	@DisplayName("GET /customers/1 - Found")
	void testCustomerByIdFound() throws Exception {
		// setup mocked service
		final Customer mockedCustomer = new Customer();
		mockedCustomer.setId(1L);
		mockedCustomer.setName("Padmja");

		doReturn(Optional.of(mockedCustomer)).when(customerService).getCustomerById(1L);

		// Execute Get Request

		mockMvc.perform(get("/customers/{id}", 1))
				// validate response code and content type
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))

				// validate headers

				.andExpect(header().string(HttpHeaders.LOCATION, "/customers/1"))
				// validate return fields

				.andExpect(jsonPath("$.id", is(1))).andExpect(jsonPath("$.firstName", is("Padmja")));

	}

	@Test
	@DisplayName("GET /customers/1 - NotFound")
	void testCustomerByIdNotFound() throws Exception {
		// setup mocked service
		doReturn(Optional.empty()).when(customerService).getCustomerById(1L);

		// Execute Get request

		mockMvc.perform(get("/customers/{id}", 1))
				// validate that we get 404 Not found response
				.andExpect(status().isNotFound());

	}

	@Test
	@DisplayName("Delete /customers/1 - Success")
	void testCustomerDeleteSuceess() throws Exception {
		final Customer mockedCustomer = new Customer();
		mockedCustomer.setId(1L);
		mockedCustomer.setName("Padmja");

		doReturn(Optional.of(mockedCustomer)).when(customerService).getCustomerById(1L);
		doReturn(true).when(customerService).deleteCustomerById(1L);

		mockMvc.perform(delete("/customers/{id}", 1)).andExpect(status().isOk());

	}

	@Test
	@DisplayName("Delete /customers/1 - Not Found")
	void testCustomerDeleteNotFound() throws Exception {

		doReturn(Optional.empty()).when(customerService).getCustomerById(1L);

		mockMvc.perform(delete("/customers/{id}", 1)).andExpect(status().isNotFound());

	}

	@Test
	@DisplayName("Delete /customers/1 - Failure")
	void testCustomerDeleteFailure() throws Exception {
		final Customer mockedCustomer = new Customer();
		mockedCustomer.setId(1L);
		mockedCustomer.setName("Padmja");

		doReturn(Optional.of(mockedCustomer)).when(customerService).getCustomerById(1L);
		doReturn(false).when(customerService).deleteCustomerById(1L);

		mockMvc.perform(delete("/customers/{id}", 1)).andExpect(status().isInternalServerError());
	}

}
