package com.ubs.cw.demo.rest.cwrestdemoproject.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ubs.cw.demo.rest.cwrestdemoproject.domain.Customer;
import com.ubs.cw.demo.rest.cwrestdemoproject.exceptions.CustomerNotFoundException;
import com.ubs.cw.demo.rest.cwrestdemoproject.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	private RestTemplate template;

	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		log.debug("Inside getAllCustomers-->");
		final List<Customer> list = customerService.getAllCustomers();

		return new ResponseEntity<List<Customer>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(value = "hello-world-hi", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getGreeting() {
		log.debug("Inside hello-world-hi-->");
		return new ResponseEntity<String>("Hi Hello World", HttpStatus.OK);
	}

	@GetMapping(value = "hello-world", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getGreetings() {
		log.debug("Inside hello-world greetings-->");
		final String uri = "http://localhost:8080/customers/hello-world-hi";
		// final List<Customer> list = customerService.getAllCustomers();
		// final RestTemplate restTemplate = new RestTemplate();
		final HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		final HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		final ResponseEntity<String> result = template.exchange(uri, HttpMethod.GET, entity, String.class);
		System.out.println(result);

		return result;// new ResponseEntity<String>("Hello", new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") final Long id)
			throws CustomerNotFoundException {
		final Optional<Customer> entity = customerService.getCustomerById(id);
		ResponseEntity<Customer> customerEntity = null;
		if (entity.isPresent()) {
			customerEntity = new ResponseEntity<Customer>(entity.get(), new HttpHeaders(), HttpStatus.OK);
		} else {
			customerEntity = new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}

		return customerEntity;
	}

	@PostMapping
	public ResponseEntity<Customer> createOrUpdateCustomer(final Customer customer) throws CustomerNotFoundException {
		final Customer updated = customerService.createCustomer(customer);
		return new ResponseEntity<Customer>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteCustomerById(@PathVariable("id") final Long id) throws CustomerNotFoundException {
		customerService.deleteCustomerById(id);
		return HttpStatus.FORBIDDEN;
	}
}
