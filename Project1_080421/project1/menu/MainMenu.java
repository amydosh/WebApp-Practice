package project1.menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import project1.menu.UserLogin;

public class MainMenu {

		// Define public properties
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
		static FileReader fr = null;
		static FileReader userfr = null;
		static BufferedReader userbr = null;
		static File filename = null;
		public static String userun;
		public static boolean userValSel = true;
		public static boolean valSel = true;
		public static boolean selected = true;
		

			public static void main(String[] args) throws IOException {
				// --> Update so that code doesn't circle you back to main menu after operation, rather to the admin or user menu
				// --> Update the modify credentials code so that it doesn't modify anything that partially matches
				
				while (goBack) {
					while (checkpoint) {
						correctForm = true;
					
						UserLogin();
						executeLoginAuthentication(accountType);
						
						if(adminValidationStatus.equals("validated")) {
							MenuOpt();
							String Confirm;
							System.out.println("Please confirm selection by entering Y or N");
							Scanner userConfirm = new Scanner(System.in);
							Confirm = userConfirm.next();
									
							if(Confirm.contains("Y")) {
									System.out.println("                               ");	
									System.out.println("You have confirmed.");
									checkpoint = false;
							} else { 
								System.out.println("                               ");	
								System.out.println("You have not confirmed and are being redirected to the main menu.");
								System.out.println("Please hit ENTER to continue.");
								System.out.println("-------------------------------");	
								Scanner userreturn = new Scanner(System.in);
								String goback = userreturn.nextLine();
								checkpoint = true;
								}
		
							executeSelect(Select);
							valSel = true;
							
							System.out.println("-------------------------------");	
							System.out.println("Enter to return to main menu");
							Scanner userreturn = new Scanner(System.in);
							String goback = userreturn.nextLine();
							checkpoint = true;
							goBack = true;
							System.out.println("-------------------------------");	
							System.out.println("                               ");	
							System.out.println("                               ");	
							System.out.println("                               ");	
							System.out.println("                               ");	
							System.out.println("                               ");	
						
						} else if (userValidationStatus.equals("validated")) {
							String userFile = userun.concat(".txt");
							userMenuOpt(userFile);
						} else {
							System.out.println("User account validation failed.");
						}
					}
				}
			}

}
