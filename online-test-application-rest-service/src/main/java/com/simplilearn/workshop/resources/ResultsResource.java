package com.simplilearn.workshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.workshop.model.Results;
import com.simplilearn.workshop.model.Welcome;
import com.simplilearn.workshop.repository.ResultsRepository;
import com.simplilearn.workshop.repository.WelcomeRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ResultsResource {

	@Autowired
	private ResultsRepository resultsRepository;
	
	@GetMapping(path="/results")
	public List<Results> getMessage() {
		return resultsRepository.findAll();
	}
	
}
