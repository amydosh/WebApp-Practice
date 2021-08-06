package project1.menu;
	
	import java.io.File;
	import java.util.Scanner;
	import java.io.IOException;
		
public class menuOptions {	
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
	// --> Place holders for returning option response
//	public static String op1 = "You have selected Option 1";
//	public static String op2 = "You have selected Option 2";
//	public static String op3 = "You have selected Option 3";
	

		public static void main(String[] args) throws IOException {
	
			while (goBack) {
				while (checkpoint) {
					correctForm = true;
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
		
		

		
		// --> Need to add details of the user interface such as options displaying user interaction information
		public static int MenuOpt() {
				boolean valSel = true;
				System.out.println("-------------------------------");	
				// Welcome Screen (needs to contain application name & developer details)
				System.out.println("Hello! Welcome to Company Lockers Pvt. Ltd.!");
				System.out.println("LockedMe.com");
				System.out.println("Developed by Andie Mydosh");
				System.out.println("----------------------------");
				
				// Present the menu options and validate that a correct selection is made
				while(valSel) {
				System.out.println("Please select from one of the following options:");
				System.out.println("1. View the directory list");
				System.out.println("2. Search or modify directory list");
				System.out.println("3. Close the application");
				Scanner userSelect = new Scanner(System.in);
				Select = userSelect.nextInt();
				if(Select==1) {
					valSel = false;
				} else if(Select==2) {
					valSel = false;
				} else if(Select==3) {
					valSel = false;
				} else {
					System.out.println("You have not selected a valid option. Please select from the available menu options.");
					System.out.println("----------------------------");
				}
				}
				
				return Select;
	}


			
			


		
// -----------------------------------------------------------------------------------------------
		
		// Create the actual function for evaluating user input and committing to 
		// menu options
		public static void executeSelect(int Select) throws IOException {
			boolean selectValid = true;
			while(selectValid) {
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
				selectValid = false;
				// Add option to return to main menu
//				System.out.println("If you would like to return to the main menu, please enter 9");
//				Scanner userReturn = new Scanner(System.in);
//				Return = userReturn.nextInt();

				
			// Option 2 execution
			// Second option should return the details of the user interface such as options
			// displaying the following:
			// Add a file to the existing directory list (You can ignore the case sensitivity of the file names)
			
			// Delete a user specified file from the existing directory list (you can add the case sensitivity
			// on the file name in order to ensure that the right file is deleted from the directory list)
			// Return a message if FNF (file not found)
			
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
				} else if(selectSub ==3) {
					selectSub3();		
				} else if(selectSub ==4) {
					selectSub4();
				} else {
					System.out.println("You have not selected a valid option. Please select a valid option to continue.");
				}
				
				System.out.println("                               ");	
				selectValid = false;
			}
			
			
			// Option 3 execution
			// Third option to close the application
			else if (Select==3) {
				System.out.println("                               ");	
				System.out.println("You have successfully exited the application.");
				System.out.println("Thank you for stopping by!");
				System.exit(1);
				selectValid = false;
			} else {
				System.out.println("You have not selected a valid option. Please select from the available menu options.");
				System.out.println("----------------------------");
			}
		}
	}
			
		
		
		
// -------------------------------------------------------------------------
		
	// SUB MENU METHOD OPTIONS:
	//---------------------------
		// 1. Sub one asks user to input name of file they would like to add to directory
		// If there is already a file in the directory by that name, the program states
		// the error and responds that it failed to create file. If a file by the user input
		// name does not exist already, the file is created.
	public static void selectSub1() throws IOException {
		
		// Check to see if the file the user would like to add already exists (or a file by the same name)
		Scanner reader = new Scanner(System.in);
		boolean success = false;
		
		System.out.println("Enter name of the file you would like to create within the directory.");
		String FileName = reader.nextLine();
		
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

		
//----------------------------------------------------------------------
	
	// 2. Sub two asks user to input name of file they would like to delete from the directory
	// If there is not a file in the directory by that name, the program states
	// the error and responds that it failed to delete the file. If a file by the user input
	// name does exist, the file is deleted and a message of successful deletion is output.
	public static void selectSub2() throws IOException {
		boolean canDelete = false;
		// Check to see if the file the user would like to delete is a valid filename
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Enter name of the file you would like to delete.");
		String FileName = reader.nextLine();

		File filename = new File(FileName);
		String absFilename = filename.getAbsolutePath();
		boolean checkfile = true;
		while(checkfile) {
			if(filename.exists()) {
			checkfile = false;
		
			try {
				if (filename.delete()) {
					// --> Add code to confirm that user would like to delete the file
					System.out.println("File successfully deleted.");
				}
				} catch (Exception e) {
					System.out.println("Failed to delete file.");
				}
				} else {
					System.out.println("The file you have entered cannot be found. Please verify the filename is correct and try again.");
			}
		}
}			
		
	
	
//----------------------------------------------------------------------
	// 3. Sub three allows user to search a specified file from the main directory (you can add the case 
	// sensitivity on the file name to retrieve the correct file)
	// Display the result upon successful operation
	// Display the result upon unsuccessful operation
	public static void selectSub3() {
		// Check to see if the file the user would like to add already exists (or a file by the same name)
		Scanner reader = new Scanner(System.in);
		boolean success = false;
		
		System.out.println("Enter name of the file you are looking for.");
		String FileName = reader.nextLine();
		
		// Add file to the directory if it doesn't already exist. Show error if it does.
		File filename = new File(FileName);
		
		try {
		if (filename.exists()) {
			System.out.println("The file you are looking for is in the directory.");
		} else {
			System.out.println("The file you are looking for was not found.");
		}
		} catch (Exception e) {
			System.out.printf("Failed to locate file.");
		}
		
		
		}
	
//----------------------------------------------------------------------
	// 4. Sub four allow user to return to the main menu
	public static void selectSub4() {
		System.out.println("                               ");	

		}
	}
