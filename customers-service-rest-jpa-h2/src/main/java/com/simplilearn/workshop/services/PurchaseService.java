package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.Purchase;

public interface PurchaseService {
	
	public List<Purchase> getPurchases();
	public Purchase savePurchase(Purchase thePurchase);
	public Purchase getPurchase(Integer theId);
	public void deletePurchase(Integer theId);

}
