package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.Product;
import com.simplilearn.workshop.repository.ProductRepository;

@Service(value="productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product saveProduct(Product theProduct) {
		return productRepository.save(theProduct);
	}

	@Override
	public Product getProduct(Integer theId) {
		return productRepository.getById(theId);
	}

	@Override
	public void deleteProduct(Integer theId) {
		productRepository.deleteById(theId);
		
	}

}
