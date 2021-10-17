package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.repository.CustomerRepository;
import com.simplilearn.workshop.repository.InMemoryCustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {
	
	// Depends on:
	private CustomerRepository customerRepository;
	
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("Spring container has called a 'setCustomerRepository' to assemble customerRepository bean");
		this.customerRepository = customerRepository;
	}

	@Override 
	public List<Customer> retrieveAllCustomers(){
		return customerRepository.findAll();
	}

}
