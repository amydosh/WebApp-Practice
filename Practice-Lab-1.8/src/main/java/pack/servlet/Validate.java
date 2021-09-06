package pack.servlet;

import pack.Users;

public class Validate {
	public static boolean checkUser(String userId, String pw) {
		boolean check = false;
		Users[] uArray = new Users[3];
		uArray[0] = new Users("jdoe","pw123");
		uArray[1] = new Users("ksmith","pw123");
		uArray[2] = new Users("tjohnson","pw123");
		
		System.out.println(userId);
		System.out.println(pw);
		for(int i=0; i<uArray.length; i++) {
			
			if(uArray[i].getUsername().equals(userId)) {
				System.out.println("Username found!");
				if(uArray[i].getPassword().equals(pw)){
					check = true;
					System.out.println("Password Authenticated!");
					break;
				} else {
					System.out.println("Password Incorrect!");
				}
			
			} else {
				System.out.println("Username Not Found!");

				}
			}
		System.out.println(check);
		return check;
	}
}
