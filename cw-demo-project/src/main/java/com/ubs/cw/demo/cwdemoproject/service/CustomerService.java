package com.ubs.cw.demo.cwdemoproject.service;

import java.util.List;

import com.ubs.cw.demo.cwdemoproject.domain.Customer;

public interface CustomerService {

	List<Customer> findByName(String name);
}
