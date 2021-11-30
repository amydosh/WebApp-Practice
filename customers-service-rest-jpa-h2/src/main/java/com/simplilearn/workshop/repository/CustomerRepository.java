package com.simplilearn.workshop.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.model.Customer;

public interface CustomerRepository extends JpaRepository <Customer,Integer> {

//	public Customer findByEmail(String email);
	List<Customer> findByName(String name);

}
