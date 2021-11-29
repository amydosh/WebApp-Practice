package com.simplilearn.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.model.Welcome;

public interface WelcomeRepository extends JpaRepository<Welcome, Integer> {
	
	

}
