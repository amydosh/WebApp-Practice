package com.simplilearn.workshop.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.simplilearn.workshop.errors.CategoryNotFoundException;
import com.simplilearn.workshop.model.Category;
import com.simplilearn.workshop.services.CategoryService;

@RestController
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(path = "/categories")
	public List<Category> retrieveCategories() {
		return categoryService.getCategories();
	}
	
	@GetMapping(path = "/categories/{theId}")
	public Category retrieveCategory(@PathVariable Integer theId) {
		Category theCategory = categoryService.getCategory(theId);
		
		if(theCategory==null) {
			throw new CategoryNotFoundException("id: "+theId+" not found!");
		}
		
		return theCategory;
	}
	
	@PostMapping(path="/categories") 
	public ResponseEntity<Category> createCategory(@Valid @RequestBody Category theCategory) {
		Category savedCategory = categoryService.saveCategory(theCategory);
		
		// Location header: http://localhost:8080/customers/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{theId}").buildAndExpand(savedCategory.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(path="/categories/{theId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCategory(@PathVariable Integer theId, @RequestBody Category theCategory) {
		// Find whether the customer is present
		Category savedCategory = categoryService.getCategory(theId);
		savedCategory.setId(theId);
		savedCategory.setCategoryname(theCategory.getCategoryname());
	}
	
	@DeleteMapping(path="/categories/{theId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteCategory(@PathVariable Integer theId) {
		Category theCategory = categoryService.getCategory(theId);
		if(theCategory==null) {
			throw new CategoryNotFoundException("id: "+theId+" not found!");
		}
		categoryService.deleteCategory(theId);
	}

}
