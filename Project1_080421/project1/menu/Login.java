package project1.menu;

import java.util.Map;
import java.util.HashMap;
import project1.menu.Users;

public class Login {
	
	static Users user1 = new Users("john.doe","password1");
	static Users user2 = new Users("jane.doe","password2");
	static Users user3 = new Users("mike.smith","password3");
	
	

	public static void main(String[] args) {
		// Login authentication
		
		Map<Integer, Users> userDB = new HashMap<Integer, Users>();
		userDB.put(1001,user1);
		userDB.put(1002,user2);
		userDB.put(1003,user3);

		
		
	}

}
