package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.Product;

public interface ProductService {
	
	public List<Product> getProducts();
	public Product saveProduct(Product theProduct);
	public Product getProduct(Integer theId);
	public void deleteProduct(Integer theId);

}
