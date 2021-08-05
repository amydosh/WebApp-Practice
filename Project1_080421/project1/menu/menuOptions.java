package project1.menu;
	
	import java.io.File;
	import java.util.Scanner;
	import java.io.IOException;
		
public class menuOptions {	
	public static int selectSub;
	public static int goHome;
	public static int Select;
	public static boolean correctForm = true;
	public static boolean goBack = true;
	public static boolean checkpoint = true;
	// Define user input variables
	// Select select = new Select();
	public static int option1 = 1;
	public static int option2 = 2;
	public static int option3 = 3;
	// --> Place holders for returning option response
	public static String op1 = "You have selected Option 1";
	public static String op2 = "You have selected Option 2";
	public static String op3 = "You have selected Option 3";
	

		public static void main(String[] args) throws IOException {
			
			// Create "checkpoint" which stays true until a "Y" confirmation is received
			// from the user, this allows the user to automatically return to main menu
			// if they do not confirm their selection
//			sub1 Sub1 = new sub1();
//			sub2 Sub2 = new sub2();
//			MenuOpt menuOpt = new MenuOpt();
//			execute Execute = new execute();

			
			while (goBack) {
				while (checkpoint) {
					
					// clearScreen();
					// Thread.sleep(1);
					correctForm = true;
					MenuOpt();
					
					//menuOptions();
					
					String Confirm;
					
					// If user confirms....
					// Add condition for Y or N confirmation.
					// If user does not confirm redirect to main menu
					//	Scanner userSelect = new Scanner(System.in);
					//	userInput = userSelect.nextInt();
					System.out.println("Please confirm selection by entering Y or N");
					Scanner userConfirm = new Scanner(System.in);
					Confirm = userConfirm.next();
							
					if(Confirm.contains("Y")) {
							System.out.println("                               ");	
							System.out.println("You have confirmed.");
							checkpoint = false;
//							executeSelect();
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
		
		
	// Creating a method to clear the console screen for user when refreshing to main menu
		// the methods below are non-functional
		
//		public static void clearScreen() {
//		        System.out.print("\033[H\033[2J");
//		        System.out.flush();
//		}

//		public static void clearScreen() {  
//		    // System.out.print("\033[H\033[2J");  
//		    System.out.close();
//		    System.out.flush();  
//		} 	
		
		
		
//	class menuopt {
		// Need to add details of the user interface such as options displaying user interaction information
		public static int MenuOpt() {
//			while (correctForm) {
				System.out.println("-------------------------------");	
				// Welcome Screen (needs to contain application name & developer details)
				System.out.println("Hello! Welcome to Company Lockers Pvt. Ltd.!");
				System.out.println("LockedMe.com");
				System.out.println("Developed by Andie Mydosh");
				System.out.println("----------------------------");
				
				
				System.out.println("Please select from one of the following options:");
				System.out.println("1. View the directory list");
				System.out.println("2. Search or modify directory list");
				System.out.println("3. Close the application");
				Scanner userSelect = new Scanner(System.in);
				Select = userSelect.nextInt();
				return Select;
				
				// Verify the user input is one of the listed options, else return to menu
//				if(Select ~= 1 || Select ~=2 || Select ~= 3) {
//					System.out.println("You have not selected a valid option. Please select from the available menu options.");
//					Return = true;
//					checkpoint = true;
//					correctForm = true;
//				} else {
//					correctForm = false;
//				}
//			}
	}


			
			


		
		// -----------------------------------------------------------------------------------------------
		
		// Create the actual function for evaluating user input and committing to 
		// menu options
//	class execute {
		public static void executeSelect(int Select) throws IOException {
			if(Select==1) {
				
				// Option 1 execution
				// First option should return the current file names in ascending order. The root directory can be either
				// or contain a few files or folders in it
				System.out.println("                               ");	
				System.out.println("The directory list is shown below:");
				// Create an array in which the names of the files are stores
				String[] pathnames;
				// Create a new file instance by converting the given pathname string to an 
				// abstract pathname
				File dir = new File("/Users/andrealawrence/Documents/GitHub/Project1_080421");
				// Create an array with names of files and directories
				pathnames = dir.list();
				// For each pathname in the pathnames array, list the name
				for (String pathname : pathnames) {
					System.out.println(pathname);
				}
				System.out.println("-------------------------------");
				// Add option to return to main menu
//				System.out.println("If you would like to return to the main menu, please enter 9");
//				Scanner userReturn = new Scanner(System.in);
//				Return = userReturn.nextInt();
				
				// -->   Need to add conditional code to see if user has selected an option to return

				
			// Option 2 execution
			// Second option should return the details of the user interface such as options
			// displaying the following:
			// Add a file to the existing directory list (You can ignore the case sensitivity of the file names)
			
			// Delete a user specified file from the existing directory list (you can add the case sensitivity
			// on the file name in order to ensure that the right file is deleted from the directory list)
			// Return a message if FNF (file not found)
			
			// Search a user specified file from the main directory (you can add the case sensitivity on the file name 
			// to retrieve the correct file)
			// Display the result upon successful operation
			// Display the result upon unsuccessful operation
			
			// Option to return back to the main context	
			} else if(Select==2) {
				System.out.println("                               ");	
				System.out.println("Please select from the options below:");
				System.out.println("1. Add a file to the existing directory.");
				System.out.println("2. Delete an existing file in the directory.");
				System.out.println("3. Search for a specific file from the main directory.");
				System.out.println("4. Return to main menu.");
				
				Scanner userSelectSub = new Scanner(System.in);
				selectSub = userSelectSub.nextInt();
				
				if(selectSub ==1) {
					selectSub1();
				} else if(selectSub ==2) {
					selectSub2();
				} else {
					selectSub3();		
				}
				
				System.out.println("                               ");	

			}
			
			
//			// Option 3 execution
//			// Third option to close the application
//			else {
//				System.out.println("                               ");	
//				System.out.println("You have selected Option 3");
//				// --> Code below is non-functional, need to fix
//				// System.exit(Select);
//			} 
		}
			
		
		
		
		// -------------------------------------------------------------------------
		
	// SUB MENU METHOD OPTIONS
		// Create methods for each second menu selection
		// Sub one asks user to input name of file they would like to add to directory
		// If there is already a file in the directory by that name, the program states
		// the error and responds that it failed to create file. If a file by the user input
		// name does not exist already, the file is created.
	public static void selectSub1() throws IOException {
		
		// Check to see if the file the user would like to add already exists (or a file by the same name)
		Scanner reader = new Scanner(System.in);
		boolean success = false;
		
		System.out.println("Enter name of the file you would like to create within the directory.");
		String FileName = reader.nextLine();
		
		// --> Having issues as it doesn't actually add a file even though returns true
		// Add file to the directory if it doesn't already exist. Show error if it does.
		File filename = new File(FileName);
		
		try {
		if (filename.exists()) {
			System.out.println("There is already a file in the directory with this name.");
		} else {
			System.out.println("Adding file to the directory.");
			success = filename.createNewFile();
		}
		if (success) {
			System.out.printf("Successfully created new file.");
		}
		} catch (Exception e) {
			System.out.printf("Failed to create new file.");
		}

}

		
	public static void selectSub2() throws IOException {
		boolean canDelete = false;
		// Check to see if the file the user would like to delete is a valid filename
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Enter name of the file you would like to delete.");
		String FileName = reader.nextLine();
		
		// --> Having issues as it doesn't actually add a file even though returns true
		// Add file to the directory if it doesn't already exist. Show error if it does.
		File filename = new File(FileName);
		String absFilename = filename.getAbsolutePath();
		
		try {
		if (filename.delete()) {
			// --> Add code to confirm that user would like to delete the file
			// --> Delete the file and display confirmation
			System.out.println("File successfully deleted.");
			// success = filename.deletefile(??) ();
		}
		} catch (Exception e) {
			// --> Add code to notify user that there is no file in the direcory by that name
			System.out.println("Failed to delete file.");
		}
			// success = filename.createNewFile();
		
	
	}
				
			
	public static void selectSub3() {
		System.exit(0);
		
		}
	}
	

