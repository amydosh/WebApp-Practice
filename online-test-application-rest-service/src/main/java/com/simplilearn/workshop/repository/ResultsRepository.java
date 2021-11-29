package com.simplilearn.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.model.Results;

public interface ResultsRepository extends JpaRepository <Results,Integer>{

}
