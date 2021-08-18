package project1.menu;

import java.util.Scanner;

public class Authentication {
	
	// Define public properties
	public static int selectSub;
	public static int goHome;
	public static int Select;
	public static boolean correctForm = true;
	public static boolean goBack = true;
	public static boolean checkpoint = true;
	public static int option1 = 1;
	public static int option2 = 2;
	public static int option3 = 3;
	
	while (goBack) {
		while (checkpoint) {
			correctForm = true;
			mainMenu();
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
		}

		executeSelect(Select);
		
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
	}
}

public 

}
