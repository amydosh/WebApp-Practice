package project1.menu;

public class adminUsers {
	
	public String adminUN;
	public String adminPW;
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
	public adminUsers(String adminUN, String adminPW) {
		super();
		this.adminUN = adminUN;
		this.adminPW = adminPW;
	}
	
	
	public adminUsers() {
		super();
	}
	@Override
	public String toString() {
		return "adminUsers [adminUN=" + adminUN + ", adminPW=" + adminPW + "]";
	}


}
