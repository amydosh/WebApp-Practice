package com.simplilearn.workshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer","fieldHandler"})
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String adminun;
	private String adminpw;
	
	public Admin(Integer id, String adminun, String adminpw) {
		super();
		this.id = id;
		this.adminun = adminun;
		this.adminpw = adminpw;
	}

	public Admin() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdminun() {
		return adminun;
	}

	public void setAdminun(String adminun) {
		this.adminun = adminun;
	}

	public String getAdminpw() {
		return adminpw;
	}

	public void setAdminpw(String adminpw) {
		this.adminpw = adminpw;
	}

	@Override
	public String toString() {
		return String.format("Admin [id=%s, adminun=%s, adminpw=%s]", id, adminun, adminpw);
	}
	
	
	
	

}
