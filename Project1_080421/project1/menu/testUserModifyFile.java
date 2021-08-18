package project1.menu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class testUserModifyFile {
	
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
	static File filename = null;
	public static String userun = "amydosh";
	public static boolean userValSel = true;
	

	public static void main(String[] args) {
		// THIS IS FULLY FUNCTIONAL

		try {
			userSub2("amydosh.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File modification failed.");
		}
	}
	
	public static void userSub2(String userun) throws IOException {
		Scanner sc = new Scanner(new File(userun));
		StringBuffer buffer = new StringBuffer();
		while(sc.hasNextLine()) {
			buffer.append(sc.nextLine()+System.lineSeparator());
		}
		
		String fileContents = buffer.toString();
		System.out.println("Contents of the file: ");
		System.out.println(fileContents);
		sc.close();
		Scanner oldLine = new Scanner(System.in);
		System.out.println("Please enter the password you would like to change");
		String oldline = oldLine.nextLine();
		Scanner newLine = new Scanner(System.in);
		System.out.println("Please enter your new password");
		String newline = newLine.nextLine();
		oldLine.close();
		newLine.close();
		
		fileContents = fileContents.replaceAll(oldline, newline);
		FileWriter writer = new FileWriter(userun);
		System.out.println("");
		System.out.println("new data: "+fileContents);
		writer.append(fileContents);
		writer.flush();
	}
		
		
//		FileInputStream oldData = null;
//		FileOutputStream newData = null;
//		String tempuserun = "tempuserun.txt";
		
//		// --> Need to modify the code below to allow user to change the text instead of just copy
//		try {
//			// Logic to copy a file
//			oldData = new FileInputStream(userun);
//			newData = new FileOutputStream(tempuserun);
//			FileWriter fw = new FileWriter(userun);
//			BufferedWriter bw = new BufferedWriter(fw);
//			
//			FileReader fr = new FileReader(userun);
//			BufferedReader br = new BufferedReader(fr);
//			
//			
//			String verify;
//			
//			// Read one file and write another
//			// --> Should have multiple options to allow user to select whether to add, delete, or modify??
//			// --> Would need to be able to search for the application by name, without case sensitivity...
//			// --> and then maybe delete the second line after that (for pw modification) and replace with 
//			// --> new?
//			while((verify=br.readLine()) != null) {
//				if(verify != null) {
//					System.out.println("");
//					System.out.println("Please enter the new credentials you would like to store.");
//					Scanner addNewCred = new Scanner(System.in);
//					String addnewcred = addNewCred.next();
//					bw.write(addnewcred);
//				}
//			}
//			br.close();
//			bw.close();
//			
//			// --> Update this to success message 
//			System.out.println("File copy is complete");
//			
//		} catch (Exception e) {
//			System.out.println("Exception: "+e.getMessage());
//		
//		}
	}

