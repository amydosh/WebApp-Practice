package com.simplilearn.workshop;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.simplilearn.workshop.config.CustomerServiceConfig;
import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.services.CustomerService;
import com.simplilearn.workshop.services.CustomerServiceImpl;

public class CustomerServiceApplication {

	public static void main(String[] args) {
		
		// Spring Container:
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CustomerServiceConfig.class);
		
		
		// Depends upon CustomerService 
//		CustomerService customerService = new CustomerServiceImpl();
		
		CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);
		List<Customer> loadedCustomers = customerService.retrieveAllCustomers();
		
		
		// Using for loop:
//		for( Customer element : loadedCustomers) {
//			System.out.println(element.getName());
//		}
		
		// Using forEach method with lambda expression:
		loadedCustomers.forEach(element -> System.out.println(element.getName()));
		
		// Read the bean 2 times --> Will return that they are identical because the bean is singleton
//		CustomerService customerService1 = applicationContext.getBean("customerService", CustomerService.class);
//		CustomerService customerService2 = applicationContext.getBean("customerService", CustomerService.class);
//			if(customerService1 == customerService2) {
//				System.out.println("Service 1 and Service 2 are identical");
//			} 
//			// If you define in applicationContext that the scope is prototype, the else statement will return instead
//			else {
//				System.out.println("Service 1 and Service 2 are not identical");
//			}

	}

}
