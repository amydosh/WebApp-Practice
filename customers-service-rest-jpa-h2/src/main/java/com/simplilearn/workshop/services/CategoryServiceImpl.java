package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.Category;
import com.simplilearn.workshop.repository.CategoryRepository;

@Service(value="categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category saveCategory(Category theCategory) {
		return categoryRepository.save(theCategory);
	}

	@Override
	public Category getCategory(Integer theId) {
		return categoryRepository.getById(theId);
	}

	@Override
	public void deleteCategory(Integer theId) {
		categoryRepository.deleteById(theId);
		
	}
}
