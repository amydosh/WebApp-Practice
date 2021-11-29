package com.simplilearn.workshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.workshop.model.Welcome;
import com.simplilearn.workshop.repository.WelcomeRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class WelcomeResource {
	
	@Autowired
	private WelcomeRepository welcomeRepository;
	
	@GetMapping(path="/welcome")
	public Welcome getMessage() {
		return welcomeRepository.findAll().get(0);
	}

}
