package project1.menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserLogin extends MainMenu{

	// -----------------------------------------------------------------------------------------------	
			// Regular user UI with options such as displaying user credentials and modifying user credentials
			public static int userMenuOpt(String userun) {
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("-------------------------------");	
					// Welcome Screen (needs to contain application name & developer details)
					System.out.println("Hello! Welcome to Company Lockers Pvt. Ltd.!");
					System.out.println("LockedMe.com");
					System.out.println("Developed by Andie Mydosh");
					System.out.println("----------------------------");
					
					// Present the menu options and validate that a correct selection is made
					// Create menu options for normal users wishing to access their user file
					while(userValSel) {
					System.out.println("Please select from one of the following options:");
					System.out.println("1. View your credentials");
					System.out.println("2. Modify your credentials");
					System.out.println("3. Close the application");
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
					adminValidationStatus = "failed";
					return Select;
	
			}
			
			// -----------------------------------------------------------------------------------------------	
			// Regular user UI with options such as displaying user credentials and modifying user credentials
			public static int userMenuOpt(String userun) {
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("-------------------------------");	
					// Welcome Screen (needs to contain application name & developer details)
					System.out.println("Hello! Welcome to Company Lockers Pvt. Ltd.!");
					System.out.println("LockedMe.com");
					System.out.println("Developed by Andie Mydosh");
					System.out.println("----------------------------");
					
					// Present the menu options and validate that a correct selection is made
					// Create menu options for normal users wishing to access their user file
					while(userValSel) {
					System.out.println("Please select from one of the following options:");
					System.out.println("1. View your credentials");
					System.out.println("2. Modify your credentials");
					System.out.println("3. Close the application");
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
					adminValidationStatus = "failed";
					return Select;
		}
			
			// -----------------------------------------------------------------------------------------------
			// User sub option 1 - display credentials on the screen
			public static void userSub1(String userun) {
				try {
					System.out.println(userun);
					BufferedReader in = new BufferedReader(new FileReader(userun));
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
					adminValidationStatus = "failed";
				}
				}

			
	// -----------------------------------------------------------------------------------------------
			// User sub option 2 - modify credentials
			public static void userSub2(String userun) throws IOException {
				Scanner sc = new Scanner(new File(userun));
				StringBuffer buffer = new StringBuffer();
				while(sc.hasNextLine()) {
					buffer.append(sc.nextLine()+System.lineSeparator());
				}
				
				// Display the user's current credentials:
				String fileContents = buffer.toString();
				System.out.println("Your current credentials are shown below.");
				System.out.println("Contents of the file: ");
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
				FileWriter writer = new FileWriter(userun);
				System.out.println("");
				
				// Display confirmation that credentials have been updated and print new credentials
				System.out.println("Your updated credentials are shown below.");
				System.out.println(fileContents);
				writer.append(fileContents);
				writer.flush();
				adminValidationStatus = "failed";
				userValSel = true;
			}
				
				
			
			
			
	// -----------------------------------------------------------------------------------------------
			public static int userLogin() {
				System.out.println("-------------------------------");	
				// Initial menu should allow user to select whether they are a normal user or an admin
				// Present the menu options and validate that a correct selection is made
				while(selected) {
				System.out.println("Please select from one of the following options:");
				System.out.println("1. User Login");
				System.out.println("2. Admin Login");
				System.out.println("3. Close the application");
				Scanner userSelectLogin = new Scanner(System.in);
				accountType = userSelectLogin.nextInt();
				if(accountType==1) {
					selected = false;
				} else if(accountType==2) {
					selected = false;
				} else if(accountType==3) {
					selected = false;
				} else {
					System.out.println("You have not selected a valid option. Please select from the available menu options.");
					System.out.println("----------------------------");
				}
				}
				return accountType;
				
				
			}
			
}
