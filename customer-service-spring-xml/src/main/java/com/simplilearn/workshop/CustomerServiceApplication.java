package com.simplilearn.workshop;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.services.CustomerService;
import com.simplilearn.workshop.services.CustomerServiceImpl;

public class CustomerServiceApplication {

	public static void main(String[] args) {
		
		// Spring Container:
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Depends upon CustomerService 
//		CustomerService customerService = new CustomerServiceImpl();
		
		CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);
		List<Customer> loadedCustomers = customerService.retrieveAllCustomers();
		
		
		// Using for loop:
		for( Customer element : loadedCustomers) {
			System.out.println(element.getName());
		}
		
		// Using forEach method with lambda expression:
		loadedCustomers.forEach(element -> System.out.println(element.getName()));
		
		

	}

}
