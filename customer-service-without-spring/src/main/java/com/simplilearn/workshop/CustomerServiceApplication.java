package com.simplilearn.workshop;

import java.util.List;

import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.services.CustomerService;
import com.simplilearn.workshop.services.CustomerServiceImpl;

public class CustomerServiceApplication {

	public static void main(String[] args) {
		// Depends upon CustomerService 
		CustomerService customerService = new CustomerServiceImpl();
		
		List<Customer> loadedCustomers = customerService.retrieveAllCustomers();
		
		
		// Using for loop:
		for( Customer element : loadedCustomers) {
			System.out.println(element.getName());
		}
		
		// Using forEach method with lambda expression:
		loadedCustomers.forEach(element -> System.out.println(element.getName()));
		
		

	}

}
