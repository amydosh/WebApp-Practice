package com.simplilearn.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.model.Quiz;

public interface QuizRepository extends JpaRepository <Quiz,Integer>{

	
}
