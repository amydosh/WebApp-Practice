package com.simplilearn.workshop.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.model.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer>{

	List<Admin> findByAdminun(String adminun);
	
}
