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

import com.simplilearn.workshop.errors.ProductNotFoundException;
import com.simplilearn.workshop.model.Product;
import com.simplilearn.workshop.services.ProductService;

@RestController
public class ProductResource {

	@Autowired
	private ProductService productService;
	
	@GetMapping(path = "/products")
	public List<Product> retrieveProducts() {
		return productService.getProducts();
	}
	
	@GetMapping(path = "/products/{theId}")
	public Product retrieveProduct(@PathVariable Integer theId) {
		Product theProduct = productService.getProduct(theId);
		
		if(theProduct==null) {
			throw new ProductNotFoundException("id: "+theId+" not found!");
		}
		
		return theProduct;
	}
	
	@PostMapping(path="/products") 
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product theProduct) {
		Product savedProduct = productService.saveProduct(theProduct);
		
		// Location header: http://localhost:8080/customers/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{theId}").buildAndExpand(savedProduct.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(path="/products/{theId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateProduct(@PathVariable Integer theId, @RequestBody Product theProduct) {
		// Find whether the customer is present
		Product savedProduct = productService.getProduct(theId);
		savedProduct.setId(theId);
		savedProduct.setColor(theProduct.getColor());
		savedProduct.setSize(theProduct.getSize());
		savedProduct.setStyle(theProduct.getStyle());
	}
	
	@DeleteMapping(path="/products/{theId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable Integer theId) {
		Product theProduct = productService.getProduct(theId);
		if(theProduct==null) {
			throw new ProductNotFoundException("id: "+theId+" not found!");
		}
		productService.deleteProduct(theId);
	}

	
}
