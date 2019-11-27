package com.ubs.cw.demo.cwdemoproject.service;

import java.util.List;

import com.ubs.cw.demo.cwdemoproject.domain.Customer;
import com.ubs.cw.demo.cwdemoproject.exceptions.CustomerNotFoundException;

public interface CustomerService {

	List<Customer> findByName(String name);

	List<Customer> getAllCustomer();

	Customer getCustomerById(Long id) throws CustomerNotFoundException;

	Customer createOrUpdateCustomer(Customer CustomerEntity);

	Customer createCustomer(Customer CustomerEntity);

	void deleteCustomerById(Long id) throws CustomerNotFoundException;
}
