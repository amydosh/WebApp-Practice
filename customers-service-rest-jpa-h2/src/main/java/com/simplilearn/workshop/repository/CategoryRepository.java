package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{

	List<Category> findByCategoryname(String categoryname);
}
