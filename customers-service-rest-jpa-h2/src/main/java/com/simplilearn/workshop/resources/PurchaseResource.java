package com.simplilearn.workshop.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.simplilearn.workshop.errors.PurchaseNotFoundException;
import com.simplilearn.workshop.model.Purchase;
import com.simplilearn.workshop.services.PurchaseService;

@RestController
public class PurchaseResource {
	
	@Autowired
	private PurchaseService purchaseService;
	
	@GetMapping(path = "/purchases")
	public List<Purchase> retrievePurchases() {
		return purchaseService.getPurchases();
	}
	
	@GetMapping(path = "/purchases/{theId}")
	public Purchase retrievePurchase(@PathVariable Integer theId) {
		Purchase thePurchase = purchaseService.getPurchase(theId);
		
		if(thePurchase==null) {
			throw new PurchaseNotFoundException("id: "+theId+" not found!");
		}
		
		return thePurchase;
	}
	
	@PostMapping(path="/purchases") 
	public ResponseEntity<Purchase> createPurchase(@Valid @RequestBody Purchase thePurchase) {
		Purchase savedPurchase = purchaseService.savePurchase(thePurchase);
		
		// Location header: http://localhost:8080/customers/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{theId}").buildAndExpand(savedPurchase.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(path="/purchases/{theId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updatePurchase(@PathVariable Integer theId, @RequestBody Purchase thePurchase) {
		// Find whether the customer is present
		Purchase savedPurchase = purchaseService.getPurchase(theId);
		savedPurchase.setId(theId);
		savedPurchase.setProductid(thePurchase.getProductid());
		savedPurchase.setCustomerid(thePurchase.getCustomerid());
		savedPurchase.setPurchasedate(thePurchase.getPurchasedate());
	}
	
	@DeleteMapping(path="/purchases/{theId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deletePurchase(@PathVariable Integer theId) {
		Purchase thePurchase = purchaseService.getPurchase(theId);
		if(thePurchase==null) {
			throw new PurchaseNotFoundException("id: "+theId+" not found!");
		}
		purchaseService.deletePurchase(theId);
	}

}
