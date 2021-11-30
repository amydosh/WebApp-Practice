package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.Purchase;
import com.simplilearn.workshop.repository.PurchaseRepository;

@Service(value="purchaseService")
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Override
	public List<Purchase> getPurchases() {
		return purchaseRepository.findAll();
	}

	@Override
	public Purchase savePurchase(Purchase thePurchase) {
		return purchaseRepository.save(thePurchase);
	}

	@Override
	public Purchase getPurchase(Integer theId) {
		return purchaseRepository.getById(theId);
	}

	@Override
	public void deletePurchase(Integer theId) {
		purchaseRepository.deleteById(theId);
		
	}
	
}
