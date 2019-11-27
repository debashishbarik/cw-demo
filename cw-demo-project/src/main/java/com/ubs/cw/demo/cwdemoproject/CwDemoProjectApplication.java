package com.ubs.cw.demo.cwdemoproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ubs.cw.demo.cwdemoproject.dao.CustomerRepository;
import com.ubs.cw.demo.cwdemoproject.domain.Customer;
import com.ubs.cw.demo.cwdemoproject.service.CustomerService;

@SpringBootApplication
public class CwDemoProjectApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CustomerService customerService;

	public static void main(final String[] args) {
		SpringApplication.run(CwDemoProjectApplication.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {

		customerService.createCustomer(new Customer("Customer11"));
		customerService.createOrUpdateCustomer(new Customer(2L, "Customer22"));
		customerService.createCustomer(new Customer("Customer33"));

		System.out.println("\ngetAllCustomer()");
		customerService.getAllCustomer().forEach(x -> System.out.println(x.getName()));

		System.out.println("\nfindByName()");
		System.out.println(customerService.findByName("Customer1"));
	}

}
