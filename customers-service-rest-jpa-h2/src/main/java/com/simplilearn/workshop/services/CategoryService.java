package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.Category;

public interface CategoryService {
	
	public List<Category> getCategories();
	public Category saveCategory(Category theCategory);
	public Category getCategory(Integer theId);
	public void deleteCategory(Integer theId);

}
