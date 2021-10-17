package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.repository.CustomerRepository;
import com.simplilearn.workshop.repository.InMemoryCustomerRepositoryImpl;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {
	
	// Depends on:
	@Autowired
	private CustomerRepository customerRepository;
	

	public CustomerServiceImpl() {
		super();
	}
	
//	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("spring called constructor method to inject a bean 'customerReposiory'");
		this.customerRepository = customerRepository;
	}

//	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("Spring container has called a 'setCustomerRepository' to assemble customerRepository bean");
		this.customerRepository = customerRepository;
	}

	@Override 
	public List<Customer> retrieveAllCustomers(){
		return customerRepository.findAll();
	}

}
