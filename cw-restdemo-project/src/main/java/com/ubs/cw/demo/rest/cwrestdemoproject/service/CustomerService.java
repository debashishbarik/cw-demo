package com.ubs.cw.demo.rest.cwrestdemoproject.service;

import java.util.List;
import java.util.Optional;

import com.ubs.cw.demo.rest.cwrestdemoproject.domain.Customer;
import com.ubs.cw.demo.rest.cwrestdemoproject.exceptions.CustomerNotFoundException;

public interface CustomerService {

	List<Customer> findByName(String name);

	List<Customer> getAllCustomers();

	Optional<Customer> getCustomerById(Long id) throws CustomerNotFoundException;

	Customer createOrUpdateCustomer(Customer CustomerEntity);

	Customer createCustomer(Customer CustomerEntity);

	void deleteCustomerById(Long id) throws CustomerNotFoundException;
}
