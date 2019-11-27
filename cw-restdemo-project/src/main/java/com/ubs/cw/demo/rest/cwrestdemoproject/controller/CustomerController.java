package com.ubs.cw.demo.rest.cwrestdemoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.cw.demo.rest.cwrestdemoproject.domain.Customer;
import com.ubs.cw.demo.rest.cwrestdemoproject.exceptions.CustomerNotFoundException;
import com.ubs.cw.demo.rest.cwrestdemoproject.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		final List<Customer> list = customerService.getAllCustomers();

		return new ResponseEntity<List<Customer>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") final Long id)
			throws CustomerNotFoundException {
		final Customer entity = customerService.getCustomerById(id);

		return new ResponseEntity<Customer>(entity, new HttpHeaders(), HttpStatus.OK);
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
