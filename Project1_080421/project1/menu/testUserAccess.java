package project1.menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



	



public class testUserAccess {
	public static int selectSub;
	public static int goHome;
	public static int Select;
	public static int accountType;
	public static boolean correctForm = true;
	public static boolean goBack = true;
	public static boolean checkpoint = true;
	public static int option1 = 1;
	public static int option2 = 2;
	public static int option3 = 3;
	public static String adminValidationStatus = "failed";
	public static String userValidationStatus = "failed";
	public static String userun;
	public static boolean userValSel = true;

	
	public static void main(String[] args) throws IOException {
		userAccess();
	}

	public static void userAccess() {
		boolean findUN = true;
//		Object[][] userInfo = new Object[1][2];
		while(findUN) {
			Scanner userUN = new Scanner(System.in);
			System.out.println("Welcome to the user login.");
			System.out.println("Please enter your username.");
			String username = userUN.nextLine();
			boolean pwValidate = true;
			
			// Search the directory for a filename that matches the user entered username
			File userFile = new File(username);
			
			
			
			try {
				FileInputStream fileInputStream = new FileInputStream(userFile);
				// If a file with the given username is found, ask for password
				if (userFile.exists()) {
					System.out.println("Your username has been found.");
					findUN = false;
//				while(pwValidate) {
					System.out.println("Please enter your password.");
					Scanner userPW = new Scanner(System.in);
					String userpw = userPW.nextLine();
					System.out.println(userpw);
					
					String usernameFull = username.concat(".txt");
					BufferedReader in = new BufferedReader(new FileReader(usernameFull));
					String unLine = in.readLine();

					
					unLine = in.readLine();
					System.out.println("file reads :"+unLine);
					System.out.println("user input is :"+userpw);
					if(unLine.equals(userpw)) {
						System.out.println("Password is correct!");
					} else {
						System.out.println("Password is incorrect!");
					}
//					System.out.println(unLine);
					
					in.close();
//					
//					int firstLine = fileInputStream.read();
//					System.out.print((char)firstLine);
//					int secondLine = fileInputStream.read();
//					System.out.print((char)secondLine);
				}
//					int count = 0;
//					// =-1 means until it reaches the end of the file
//					while((count=fileInputStream.read()) !=-1) {
//						System.out.print((char)count);
//					}
				
				// Read the file in an ASCII value
//				try {
//					int i = fileInputStream.read();
//					System.out.println(i);
//					System.out.println((char)i);
//				}
				
			} catch (FileNotFoundException e) {
				System.out.println("File not found exception!");
			} catch (IOException e) {
				System.out.println("File Read Exception");
			}
			}
}
}
	
			
//			try {
//				// If a file with the given username is found, ask for password
//				if (userFile.exists()) {
//					System.out.println("Your username has been found.");
//					findUN = false;
//				while(pwValidate) {
//					System.out.println("Please enter your password.");
//					Scanner userPW = new Scanner(System.in);
//					String userpw = userPW.nextLine();
//					System.out.println(userpw);
//					// --> Trying to debug...
//					FileReader userFR = new FileReader(userFile);
//					BufferedReader userBR = new BufferedReader(userFR);
////					String pwline;
//					
//					String pwline = userBR.readLine();
//					while(pwline != null) {
//						pwline = userBR.readLine();
//						System.out.println(pwline);
//					}
//	
//					
//
////					userPW.close();
////					// Write logic to read the second line of the file and determine if the password matches
////					userfr = new FileReader(userFile);
////					BufferedReader userbr = new BufferedReader(userfr);
//////					String pwline;
////					String firstline = userbr.readLine(); 				// consume first line and ignore
////					System.out.println(firstline);
////					String pwline = userbr.readLine();
////					System.out.println(pwline);
//					
//					
//					if(pwline.equals(userpw)) {
//						System.out.println("Your password has been validated.");
//						System.out.println("You are being redirected to the main menu.");
//						System.out.println("---------------------------------------------");
//						pwValidate = false;
//						userValidationStatus = "validated";
////						userInfo[0][0] = userValidationStatus;
////						userInfo[0][1] = filename;
//					} else {
//						// If password does not match the second line of the file, the user will remain in the while loop and 
//						// be prompted to enter their password again
//						System.out.println("Your password has not been validated.");
//						pwValidate = true;
//						userValidationStatus = "failed";
//					}
//				}	
//				} else {
//					System.out.println("Your username has not been found");
//					findUN = true;
//					userValidationStatus = "failed";
//				}
////				userFR.close();
////				userbr.close();
//			} catch (IOException e1) {
//				System.out.printf("Failed to locate username.");
//				userValidationStatus = "failed";
//			}
//			userUN.close();
//			userun = username;
//			System.out.println(userun);
//			userValidationStatus = "validated";
//			return userValidationStatus;
//			
//		}
//	return userValidationStatus;
//}

