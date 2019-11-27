package com.ubs.cw.demo.cwdemoproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ubs.cw.demo.cwdemoproject.dao.CustomerRepository;
import com.ubs.cw.demo.cwdemoproject.domain.Customer;

@SpringBootApplication
public class CwDemoProjectApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;

	public static void main(final String[] args) {
		SpringApplication.run(CwDemoProjectApplication.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {

		customerRepository.save(new Customer("Customer1"));
		customerRepository.save(new Customer("Customer2"));
		customerRepository.save(new Customer("Customer3"));

		System.out.println("\nfindAll()");
		customerRepository.findAll().forEach(x -> System.out.println(x.getName()));

		System.out.println("\nfindAll()");
		System.out.println(customerRepository.findByName("Customer1"));
	}

}
