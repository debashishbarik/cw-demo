package com.ubs.cw.demo.rest.cwrestdemoproject.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ubs.cw.demo.rest.cwrestdemoproject.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByName(String name);
}
