package com.simplilearn.workshop.services;

import java.util.List;

import com.simplilearn.workshop.model.Admin;

public interface AdminService {
	
	public List<Admin> getAdmins();
	public Admin saveAdmin(Admin theAdmin);
	public Admin getAdmin(Integer theId);
	public void deleteAdmin(Integer theId);

}
