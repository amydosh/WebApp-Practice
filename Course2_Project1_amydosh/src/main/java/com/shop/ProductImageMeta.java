package com.shop;

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
@Table(name="tbl_product_image_meta")
public class ProductImageMeta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int metaID;
	private String metaKey;
	private String metaValue;
	


	// Need to create a many to one map --> so this is your mapper (or anchor) between the two classes
	@ManyToOne(fetch=FetchType.LAZY)
	private ProductImage productImage;
	
	public ProductImageMeta(String metaKey, String metaValue, ProductImage productImage) {
		super();
		this.metaKey = metaKey;
		this.metaValue = metaValue;
		this.productImage = productImage;
	}
	
	public ProductImageMeta() {
		super();
	}
	
	public String getMetaKey() {
		return metaKey;
	}

	public void setMetaKey(String metaKey) {
		this.metaKey = metaKey;
	}

	public String getMetaValue() {
		return metaValue;
	}

	public void setMetaValue(String metaValue) {
		this.metaValue = metaValue;
	}

	public int getMetaID() {
		return metaID;
	}
	
	public ProductImage getProductImage() {
		return productImage;
	}

	public void setProductImage(ProductImage productImage) {
		this.productImage = productImage;
	}





}