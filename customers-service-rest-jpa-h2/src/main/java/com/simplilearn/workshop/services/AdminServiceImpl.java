package com.simplilearn.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.Admin;
import com.simplilearn.workshop.repository.AdminRepository;

@Service(value="adminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public List<Admin> getAdmins() {
		return adminRepository.findAll();
	}

	@Override
	public Admin saveAdmin(Admin theAdmin) {
		return adminRepository.save(theAdmin);
	}

	@Override
	public Admin getAdmin(Integer theId) {
		return adminRepository.getById(theId);
	}

	@Override
	public void deleteAdmin(Integer theId) {
		adminRepository.deleteById(theId);
		
	}

}
