package com.ubs.cw.demo.cwdemoproject.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ubs.cw.demo.cwdemoproject.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByName(String name);
}
