package com.ubs.cw.demo.cwdemoproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubs.cw.demo.cwdemoproject.dao.CustomerRepository;
import com.ubs.cw.demo.cwdemoproject.domain.Customer;
import com.ubs.cw.demo.cwdemoproject.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> findByName(final String name) {
		return customerRepository.findByName(name);
	}

}
