package com.shop;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_product")

public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productID;
	
	private String name;
	
	private double price;
	
	// Create an array to store the list of images one product has
	@OneToMany(cascade=CascadeType.ALL, mappedBy="product")
	private List<ProductImage> images;
	
//	// Create an array to store the list of image meta data one product has
//	@OneToMany(cascade=CascadeType.ALL, mappedBy="product")
//	private List<ProductImageMeta> imagesMeta;
	public Product() {
		super();
	}

	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
		images = new ArrayList<ProductImage>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getProductID() {
		return productID;
	}

	public List<ProductImage> getImages() {
		return images;
	}

	
	public void addImage(ProductImage image) {
		images.add(image);
	}







	
	
	

}
