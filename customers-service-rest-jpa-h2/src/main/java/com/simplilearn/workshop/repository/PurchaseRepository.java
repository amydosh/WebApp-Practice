package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase,Integer>{

	List<Purchase> findByPurchasedate(String purchasedate);
}
