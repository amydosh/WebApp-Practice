package project1.menu;
	
	import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.FileReader;
	import java.io.FileWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
	import java.util.Map;
	import java.util.Scanner;
	import javax.security.auth.login.AccountException;
	import java.io.IOException;
		
public class menuOptions {	
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
		
		while (goBack) {
			while (checkpoint) {
				correctForm = true;
				
				userLogin();
				executeLoginAuthentication(accountType);
				
				if(adminValidationStatus.equals("validated")) {
					MenuOpt();

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
				

// ------------------------------------------------------------------------------------------------------------------		
	// Details of the admin user interface such as options displaying user interaction information
	public static int MenuOpt() {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("-------------------------------");	
			
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
	// Regular user UI with options such as displaying user credentials and modifying user credentials
	public static int userMenuOpt(String userun) {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("-------------------------------");	
			
			// Present the menu options and validate that a correct selection is made
			// Create menu options for normal users wishing to access their user file
			while(userValSel) {
			System.out.println("Please select from one of the following options:");
			System.out.println("1. View your credentials");
			System.out.println("2. Modify your existing credentials");
			System.out.println("3. Add new credentials");
			System.out.println("4. Delete existing credentials");
			System.out.println("5. Close the application");
			Scanner userSelect = new Scanner(System.in);
			Select = userSelect.nextInt();
			if(Select==1) {
				userValSel = false;
				userSub1(userun);
			} else if(Select==2) {
				userValSel = false;
				try{
					userSub2(userun);
				} catch (IOException e) {
					System.out.println("Failed to modify data.");
				}
				adminValidationStatus = "failed";
			} else if(Select==3) {
				try {
					userSub3(userun);
				} catch (IOException e) {
					System.out.println("Failed to add data.");
				}
			} else if (Select==4) {
				userValSel = false;
				try {
					userSub4(userun);
				} catch (IOException e) {
					System.out.println("Failed to delete credentials.");
				}
			}
			else if (Select==5){
				userValSel = false;
				System.out.println("                               ");	
				System.out.println("You have successfully exited the application.");
				System.out.println("Thank you for stopping by!");
				System.exit(1);

			} else {
				System.out.println("You have not selected a valid option. Please select from the available menu options.");
				System.out.println("----------------------------");
			}
			}
			return Select;
}

// -----------------------------------------------------------------------------------------------
	// User sub option 1 - display credentials on the screen
	public static void userSub1(String userun) {
		try {
			String fullUserFile = "UserFiles/".concat(userun);
			BufferedReader in = new BufferedReader(new FileReader(fullUserFile));
			String line = in.readLine();
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("Your credential information is shown below.");
			System.out.println("");
			while(line != null)
			{
			  System.out.println(line);
			  line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found exception!");
		} catch (IOException e) {
			System.out.println("File Read Exception!");
		} finally {
			userValSel = true;
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("You are being redirected back to the main user menu.");
			System.out.println("----------------------------");
			System.out.println("");
			System.out.println("");
			System.out.println("");
		}
		}

		
// -----------------------------------------------------------------------------------------------
	// User sub option 2 - modify credentials
	public static void userSub2(String userun) throws IOException {
		
		String fullUserFileMod = "UserFiles/".concat(userun);
		Scanner sc = new Scanner(new File(fullUserFileMod));
		StringBuffer buffer = new StringBuffer();
		while(sc.hasNextLine()) {
			buffer.append(sc.nextLine()+System.lineSeparator());
		}
		
		// Display the user's current credentials:
		String fileContents = buffer.toString();
		System.out.println("Your current credentials are shown below.");
		System.out.println(fileContents);
		Scanner oldLine = new Scanner(System.in);
		
		// Prompt user to select the data they would like to modify:
		System.out.println("Please copy the data you would like to change.");
		String oldline = oldLine.nextLine();
		Scanner newLine = new Scanner(System.in);
		
		// Prompt user to enter the new data they would like to replace:
		System.out.println("Please enter the new data to replace the existing data selected.");
		String newline = newLine.nextLine();
		
		// Replace the data as specified by user:
		fileContents = fileContents.replaceAll(oldline, newline);
		FileWriter writer = new FileWriter(fullUserFileMod);
		System.out.println("");
		
		// Display confirmation that credentials have been updated and print new credentials
		System.out.println("Your updated credentials are shown below.");
		System.out.println(fileContents);
		writer.append(fileContents);
		writer.flush();
	}
		
			
// ------------------------------------------------------------------------------------------------
	// User sub option 3 - add credentials
	public static void userSub3(String userun) throws IOException {
		
		String fullUserFileMod = "UserFiles/".concat(userun);;
		Scanner newforum = new Scanner(System.in);
		System.out.println("Please enter the name of the application for which you would like to store new credentials.");
		String newForum = newforum.nextLine();
		System.out.println("Please enter the username you would like to store.");
		Scanner newun = new Scanner(System.in);
		String newUN = newun.nextLine();
		System.out.println("Please enter the password you would like to store.");
		Scanner newpw = new Scanner(System.in);
		String newPW = newpw.nextLine();
		String newForumbk = newForum.concat("\n");
		String newUNbk = newUN.concat("\n");
		String newPWbk = newPW.concat("\n");
		String newInput = "\n".concat(newForumbk).concat(newUNbk).concat(newPWbk);
		System.out.println("The new credentials being added to your file are:");
		System.out.println(newInput);
		
		// Open the file in writing mode:
		Scanner addCred = new Scanner(new File(fullUserFileMod));
		StringBuffer buffer = new StringBuffer();
		while(addCred.hasNextLine()) {
			buffer.append(addCred.nextLine()+System.lineSeparator());
		}
		
		// Add the new credentials:
		String fileContents = buffer.toString();
		fileContents = fileContents.concat(newInput);

		FileWriter writerAdd = new FileWriter(fullUserFileMod);
		writerAdd.append(fileContents);
		writerAdd.flush();

	}
	
		
// ------------------------------------------------------------------------------------------------
	// User sub option 4 - delete credentials
	public static void userSub4(String userun) throws IOException {
		String fullUserFileDel = "UserFiles/".concat(userun);
		Scanner deleteSC = new Scanner(new File(fullUserFileDel));
		StringBuffer bufferDelete = new StringBuffer();
		while(deleteSC.hasNextLine()) {
			bufferDelete.append(deleteSC.nextLine()+System.lineSeparator());
		}
		
		// Display the user's current credentials:
		String deletedfileContents = bufferDelete.toString();
		System.out.println("Your current credentials are shown below.");
		System.out.println(deletedfileContents);
		Scanner deleteLineForum = new Scanner(System.in);
		Scanner deleteLineUN = new Scanner(System.in);
		Scanner deleteLinePW = new Scanner(System.in);
		
		// Prompt user to select the data they would like to delete:
		System.out.println("Please enter the forum for the credentials you would like to delete.");
		String deletelineForum = deleteLineForum.nextLine();
		deletedfileContents = deletedfileContents.replaceAll(deletelineForum,"");
		System.out.println("Please enter the username for the credentials you would like to delete.");
		String deletelineUN = deleteLineUN.nextLine();
		deletedfileContents = deletedfileContents.replaceAll(deletelineUN, "");
		System.out.println("Please enter the password for the credentials you would like to delete.");
		String deletelinePW = deleteLinePW.nextLine();
		deletedfileContents = deletedfileContents.replaceAll(deletelinePW,"");
		
		FileWriter writer = new FileWriter(fullUserFileDel);
		System.out.println("");
		
		// Display confirmation that credentials have been updated and print new credentials
		System.out.println("Your updated credentials are shown below.");
		System.out.println(deletedfileContents);
		writer.append(deletedfileContents);
		writer.flush();
		userValSel = true;
	}
				
				
		
		
// -----------------------------------------------------------------------------------------------
	public static int userLogin() {
		System.out.println("-------------------------------");	
		// Initial menu should allow user to select whether they are a normal user or an admin
		// Present the menu options and validate that a correct selection is made
		while(selected) {
		// Welcome Screen (needs to contain application name & developer details)
		System.out.println("Hello! Welcome to Company Lockers Pvt. Ltd.!");
		System.out.println("LockedMe.com");
		System.out.println("Developed by Andie Mydosh");
		System.out.println("----------------------------");
		System.out.println("Please select from one of the following options:");
		System.out.println("1. User Login");
		System.out.println("2. Admin Login");
		System.out.println("3. Create new user account");
		System.out.println("4. Close the application");
		Scanner userSelectLogin = new Scanner(System.in);
		accountType = userSelectLogin.nextInt();
		if(accountType==1) {
			selected = false;
		} else if(accountType==2) {
			selected = false;
		} else if(accountType==3) {
			selected = false;
		} else if(accountType==4) {
			selected = false;
		} else {
			System.out.println("You have not selected a valid option. Please select from the available menu options.");
			System.out.println("----------------------------");
		}
		}
		return accountType;
		
		
	}
			
			

// -----------------------------------------------------------------------------------------------
	// Method to execute login authentication depending upon the type of user account selected
	public static void executeLoginAuthentication(int accountType) {
		boolean loginAuthenticating = true;
		System.out.println("-------------------------------");	
		
		// If account type normal user selected
		// Authenticate user credentials and then...
		// Route user to a user menu where they can view the contents of their user LockedMe file
		if(accountType==1) {
			loginAuthenticating = false;
			
			userAccess();
			selected = true;
			valSel = true;
			
		// If account type is admin user
		// Authenticate user credentials and then...
		// Route the admin user to the menuOpt where they can view user files, open, add, remove, delete, sort, etc. 
		} else if(accountType==2) {
			loginAuthenticating = false;
			
			adminAccess();
			valSel = true;
			
		// If user would like to create an account:	
		} else if(accountType==3) {
			boolean accountReg = true;
			while(accountReg) {
				Scanner newuserUN = new Scanner(System.in);
				System.out.println("Welcome to the user registration.");
				System.out.println("Please enter your desired username.");
				String newUsername = newuserUN.nextLine();
				
				// Search the directory for a filename that matches the user entered username
				String newFullUserFile = "UserFiles/".concat(newUsername.concat(".txt"));

				File newUserFile = new File(newFullUserFile);
				try {
					
					// If a file with the given username is found, ask for password
					if (newUserFile.createNewFile()) {
						System.out.println("Your desired username is available.");
						System.out.println("Please enter your desired password.");
						Scanner newuserPW = new Scanner(System.in);
						String newUserPW = newuserPW.nextLine();
						// Write content to file -> FileWriter -> Character Stream
						FileWriter fileWriter = new FileWriter(newUserFile);
						fileWriter.write(newUsername.concat("\n").concat(newUserPW).concat("\n"));
						fileWriter.close();
						System.out.println("User registration successful.");

					} else {
						System.out.println("Your desired username already exists, please try another username.");
						accountReg = true;
					}			
				} catch (IOException e) {
					System.out.println("File creation failed.");
				}
						accountReg = false;
						loginAuthenticating = false;
						selected = true;
						userAccess();
					}
			valSel = true;
			
		// If user chooses to close the application
		} else if(accountType==4) {
			System.out.println("                               ");	
			System.out.println("You have successfully exited the application.");
			System.out.println("Thank you for stopping by!");
			System.exit(1);
			loginAuthenticating = false;
			
		// If user does not select a valid option
		} else {
			System.out.println("You have not selected a valid option. Please select from the available menu options.");
			System.out.println("----------------------------");
			valSel = true;
		}
		}
	
	
// -----------------------------------------------------------------------------------------------

	// Authentication of normal user account
	public static String userAccess() {
		boolean findUN = true;
		while(findUN) {
			Scanner userUN = new Scanner(System.in);
			System.out.println("Welcome to the user login.");
			System.out.println("Please enter your username.");
			String username = userUN.nextLine();
			boolean pwValidate = true;
			
			// Search the directory for a filename that matches the user entered username
			String fullUserFile = "UserFiles/".concat(username.concat(".txt"));

			File userFile = new File(fullUserFile);
			
			
			try {
				
				// If a file with the given username is found, ask for password
				if (userFile.exists()) {
					System.out.println("Your username has been found.");
					findUN = false;
				while(pwValidate) {
					System.out.println("Please enter your password.");
					Scanner userPW = new Scanner(System.in);
					String userpw = userPW.nextLine();
					BufferedReader in = new BufferedReader(new FileReader(userFile));
					String unLine = in.readLine();
			
					unLine = in.readLine();

					if(unLine.equals(userpw)) {
						System.out.println("Your password has been validated.");
						System.out.println("You are being redirected to the main menu.");
						System.out.println("---------------------------------------------");
						pwValidate = false;
						userValidationStatus = "validated";
					} else {
						// If password does not match the second line of the file, the user will remain in the while loop and 
						// be prompted to enter their password again
						System.out.println("Your password has not been validated.");
						pwValidate = true;
						userValidationStatus = "failed";
					}
				}	
				} else {
					System.out.println("Your username has not been found");
					findUN = true;
					userValidationStatus = "failed";
					adminValidationStatus = "failed";
					}
			} catch (IOException e1) {
				System.out.printf("Failed to locate username.");
				userValidationStatus = "failed";
				adminValidationStatus = "failed";
				}
			userun = username;
			return userValidationStatus;	
			}
		return userun;
	}
			
		
		
// -----------------------------------------------------------------------------------------------

	// Authentication of admin user
	public static String adminAccess() {
		Scanner adminUN = new Scanner(System.in);
		System.out.println("Welcome to the admin login.");
		System.out.println("Please enter your username.");
		String adminun = adminUN.next();
		boolean pwValidate = true;
		
		// Create hashmap for admin users
		Map<String, String> adminUsers = new HashMap<String, String>();
		adminUsers.put("admin1", "password1");
		adminUsers.put("admin2", "password2");
		adminUsers.put("admin3", "password3");
		
		// Logic to search for admin credentials
		for(int i=0; i<adminUsers.size(); i++) {
			while(pwValidate) {
			try {
				if(adminUsers.containsKey(adminun)) {
					// If username is found within the map, declare that the username was found and ask for the password
				System.out.println("Admin username has been found.");
				System.out.println("Please enter your password.");
				Scanner adminPW = new Scanner(System.in);
				String adminpw = adminPW.next();
				if(adminUsers.get(adminun).equals(adminpw)) {
					System.out.println("Your password has been validated.");
					System.out.println("You are going to be redirected to the main admin menu.");
					pwValidate = false;
					adminValidationStatus = "validated";
					return adminValidationStatus;
				} else {
					System.out.println("You have not entered the correct password.");
					System.out.println("Please try entering your password again.");
					adminValidationStatus = "failed";
					pwValidate = true;
				}
				
			} else {
				// If incorrect credentials, return a not found statement
				System.out.println("Your username has not been found.");
				adminValidationStatus = "failed";
				return adminValidationStatus;
			}
		} catch (Exception e){
			System.out.println("Your password has not been validated.");
			adminValidationStatus = "failed";
			return adminValidationStatus;
		}
		}
	} return adminValidationStatus;
	}
		
	
		
// -----------------------------------------------------------------------------------------------
		
// Create the actual function for evaluating user input and committing to menu options
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
			File dir = new File("UserFiles/");
			
			// Create an array with names of files and directories
			pathnames = dir.list();
			Arrays.sort(pathnames);
			
			// For each pathname in the pathnames array, list the name
			for (String pathname : pathnames) {
				System.out.println(pathname);
			}
			System.out.println("-------------------------------");
			// --> Trying to get the menu to auto re-direct to admin value after execution instead of auto re-directing to the main menu
			selectValid = false;
		
			
	

			
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
			System.out.println("");
		}
	}
}
		
		
		
		
// -------------------------------------------------------------------------
		
// ADMIN SUB MENU METHOD OPTIONS:
//---------------------------
	// 1. Sub one asks user to input name of file they would like to add to directory
	// If there is already a file in the directory by that name, the program states
	// the error and responds that it failed to create file. If a file by the user input
	// name does not exist already, the file is created.
	public static void selectSub1() throws IOException {
		
		// Check to see if the file the user would like to add already exists (or a file by the same name)
		Scanner reader = new Scanner(System.in);
		boolean success = false;
		
		System.out.println("Enter name of the file you would like to create within the directory (please do not add suffix).");
		String FileName = reader.nextLine();
		String folder = "UserFiles/";
		String filePath = folder.concat(FileName.concat(".txt"));
		
		// Add file to the directory if it doesn't already exist. Show error if it does.
		File addFilename = new File(filePath);
		
		try {
		if (addFilename.exists()) {
			System.out.println("There is already a file in the directory with this name.");
		} else {
			System.out.println("Adding file to the directory.");
			success = addFilename.createNewFile();
		}
		if (success) {
			System.out.printf("Successfully created new file.");
		}
		} catch (Exception e) {
			System.out.printf("Failed to create new file.");
		} finally {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			}
	
	}

		
//----------------------------------------------------------------------
	
	// 2. Sub two asks user to input name of file they would like to delete from the directory
	// If there is not a file in the directory by that name, the program states
	// the error and responds that it failed to delete the file. If a file by the user input
	// name does exist, the file is deleted and a message of successful deletion is output.
	public static void selectSub2() throws IOException {
	
		boolean tryAgain = true;
				
		while(tryAgain) {
			boolean checkfile = true;
			// Check to see if the file the user would like to delete is a valid filename
			Scanner reader = new Scanner(System.in);
			
			System.out.println("Enter name of the file you would like to delete (please do not add suffix).");
			String deleteFileName = reader.nextLine();
			String folder = "UserFiles/";
			String filePath = folder.concat(deleteFileName.concat(".txt"));
	
			File deleteFile = new File(filePath);
	
	
			while(checkfile) {
				if(deleteFile.exists()) {
				checkfile = false;
				tryAgain = false;
			
				try {
					if (deleteFile.delete()) {
						System.out.println("File successfully deleted.");
						checkfile = false;
						tryAgain = false;
					}
					} catch (Exception e) {
						System.out.println("Failed to delete file.");
					} finally {
						System.out.println("");
						System.out.println("");
					}
					} else {
						System.out.println("The file you have entered cannot be found. Please verify the filename is correct and try again.");
							tryAgain = true;
							checkfile = false;
					}
					tryAgain = false;
					checkfile = false;
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
		
		System.out.println("Enter name of the file you are looking for (please do not add suffix).");
		String FileName = reader.nextLine();
		String folder = "UserFiles/";
		String searchFilePath = folder.concat(FileName.concat(".txt"));
		
		// Add file to the directory if it doesn't already exist. Show error if it does.
		File searchfilepath = new File(searchFilePath);
		
		try {
		if (searchfilepath.exists()) {
			System.out.println("The file you are looking for is in the directory.");
		} else {
			System.out.println("The file you are looking for was not found.");
		}
		} catch (Exception e) {
			System.out.printf("Failed to locate file.");
		} finally {
			System.out.println("");
			System.out.println("");
		}
		
		
		}
	
//----------------------------------------------------------------------
	// 4. Sub four allow user to return to the main menu
	public static void selectSub4() {
		System.out.println("                               ");	
	
		}
	}
