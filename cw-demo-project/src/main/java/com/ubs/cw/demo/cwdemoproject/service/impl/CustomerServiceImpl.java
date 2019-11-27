package com.ubs.cw.demo.cwdemoproject.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubs.cw.demo.cwdemoproject.dao.CustomerRepository;
import com.ubs.cw.demo.cwdemoproject.domain.Customer;
import com.ubs.cw.demo.cwdemoproject.exceptions.CustomerNotFoundException;
import com.ubs.cw.demo.cwdemoproject.service.CustomerService;

/**
 * The Class CustomerServiceImpl.
 *
 * @author debashish.barik
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the list
	 */
	@Override
	public List<Customer> findByName(final String name) {
		return customerRepository.findByName(name);
	}

	/**
	 * Gets the all customer.
	 *
	 * @return the all customer
	 */
	@Override
	public List<Customer> getAllCustomer() {
		final Iterable<Customer> customerIter = customerRepository.findAll();
		final List<Customer> customerList = new ArrayList<Customer>();
		for (final Customer eachCustomer : customerIter) {
			customerList.add(eachCustomer);
		}
		return customerList;
	}

	/**
	 * Gets the customer by id.
	 *
	 * @param id the id
	 * @return the customer by id
	 * @throws CustomerNotFoundException the customer not found exception
	 */
	@Override
	public Customer getCustomerById(final Long id) throws CustomerNotFoundException {
		final Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isPresent()) {
			return customer.get();
		} else {
			throw new CustomerNotFoundException("Customer record not found with this id");
		}
	}

	/**
	 * Creates customer.
	 *
	 * @param customerEntity the customer entity
	 * @return the customer
	 */
	@Override
	public Customer createCustomer(final Customer customerEntity) {

		return customerRepository.save(customerEntity);
	}

	/**
	 * Creates or update customer.
	 *
	 * @param CustomerEntity the customer entity
	 * @return the customer
	 */
	@Override
	public Customer createOrUpdateCustomer(Customer customerEntity) {

		final Optional<Customer> customerOpt = customerRepository.findById(customerEntity.getId());

		if (customerOpt.isPresent()) {
			final Customer newCustomer = customerOpt.get();
			newCustomer.setName(customerEntity.getName());
			return customerRepository.save(newCustomer);
		} else {
			customerEntity = customerRepository.save(customerEntity);
		}

		return customerEntity;
	}

	/**
	 * Delete customer by id.
	 *
	 * @param id the id
	 * @throws CustomerNotFoundException
	 */
	@Override
	public void deleteCustomerById(final Long id) throws CustomerNotFoundException {
		final Optional<Customer> customerOpt = customerRepository.findById(id);
		if (customerOpt.isPresent()) {
			customerRepository.deleteById(id);
		} else {
			throw new CustomerNotFoundException("Customer record not found with this id");
		}
	}

}
