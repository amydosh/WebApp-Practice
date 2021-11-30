package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.model.Quiz;

public interface QuizRepository extends JpaRepository <Quiz,Integer>{

	List<Quiz> findByQuestionnum(String name);
	
}
