package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.model.Welcome;

public interface WelcomeRepository extends JpaRepository<Welcome, Integer> {
	
	String message = "the backend Welcome service is working!";

}
 