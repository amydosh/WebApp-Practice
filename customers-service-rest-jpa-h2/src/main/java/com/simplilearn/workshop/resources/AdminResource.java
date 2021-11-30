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

import com.simplilearn.workshop.errors.AdminNotFoundException;
import com.simplilearn.workshop.errors.CustomerNotFoundException;
import com.simplilearn.workshop.model.Admin;
import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.services.AdminService;
import com.simplilearn.workshop.services.CustomerService;

@RestController
public class AdminResource {

	
	@Autowired
	private AdminService adminService;
	
	@GetMapping(path = "/admins")
	public List<Admin> retrieveAdmins() {
		return adminService.getAdmins();
	}
	
	@GetMapping(path = "/admins/{theId}")
	public Admin retrieveAdmin(@PathVariable Integer theId) {
		Admin theAdmin = adminService.getAdmin(theId);
		
		if(theAdmin==null) {
			throw new AdminNotFoundException("id: "+theId+" not found!");
		}
		
		return theAdmin;
	}
	
	@PostMapping(path="/admins") 
	public ResponseEntity<Admin> createAdmin(@Valid @RequestBody Admin theAdmin) {
		Admin savedAdmin = adminService.saveAdmin(theAdmin);
		
		// Location header: http://localhost:8080/customers/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{theId}").buildAndExpand(savedAdmin.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(path="/admins/{theId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateAdmin(@PathVariable Integer theId, @RequestBody Admin theAdmin) {
		// Find whether the customer is present
		Admin savedAdmin = adminService.getAdmin(theId);
		savedAdmin.setId(theId);
		savedAdmin.setAdminun(theAdmin.getAdminun());
		savedAdmin.setAdminpw(theAdmin.getAdminpw());
	}
	
	@DeleteMapping(path="/admins/{theId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteAdmin(@PathVariable Integer theId) {
		Admin theAdmin = adminService.getAdmin(theId);
		if(theAdmin==null) {
			throw new AdminNotFoundException("id: "+theId+" not found!");
		}
		adminService.deleteAdmin(theId);
	}
}
