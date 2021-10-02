package com.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adminId;
	private String adminUN;
	private String adminPW;
	
	
	public String getAdminUN() {
		return adminUN;
	}
	public void setAdminUN(String adminUN) {
		this.adminUN = adminUN;
	}
	public String getAdminPW() {
		return adminPW;
	}
	public void setAdminPW(String adminPW) {
		this.adminPW = adminPW;
	}
	public int getAdminId() {
		return adminId;
	}
	public Admin(String adminUN, String adminPW) {
		super();
		this.adminUN = adminUN;
		this.adminPW = adminPW;
	}
	public Admin() {
		super();
	}
	
	

}
