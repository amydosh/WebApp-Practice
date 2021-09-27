package com.shop;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_product_image")
public class ProductImage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int imageId;
	
	private String imageUrl;
	
	// Need to create a many to one map --> so this is your mapper (or anchor) between the two classes
	@ManyToOne(fetch=FetchType.LAZY)
	private Product product;
	
	// Create an array to store the list of image meta data each image product has
	@OneToMany(cascade=CascadeType.ALL, mappedBy="productImage")
	private List<ProductImageMeta> imagesMeta;
	
	public ProductImage(String imageUrl) {
		super();
	}
	
	public ProductImage(String imageUrl, Product product) {
		super();
		this.imageUrl = imageUrl;
		this.product = product;
		// Initialize metas within this constructor
		imagesMeta = new ArrayList<>();
	}
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public int getImageId() {
		return imageId;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<ProductImageMeta> getImagesMeta() {
		return imagesMeta;
	}
	
	// Create a method to add image data (part of streamlining!)
	public void addImageMeta(ProductImageMeta meta) {
		imagesMeta.add(meta);
	}
	
	
}
