package com.simplilearn.workshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.workshop.model.Quiz;
import com.simplilearn.workshop.model.Results;
import com.simplilearn.workshop.repository.QuizRepository;
import com.simplilearn.workshop.repository.ResultsRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class QuizResource {
	
	@Autowired
	private QuizRepository quizRepository;
	
	@GetMapping(path="/quiz")
	public List<Quiz> getMessage() {
		return quizRepository.findAll();
	}

}
