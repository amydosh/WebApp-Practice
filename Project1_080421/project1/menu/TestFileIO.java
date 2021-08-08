package project1.menu;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class TestFileIO {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		boolean success = false;
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter name of the file you would like to create within the directory.");
		String FileName = reader.nextLine();
		
		// --> Having issues as it doesn't actually add a file even though returns true
		// Add file to the directory if it doesn't already exist. Show error if it does.
		File filename = new File(FileName);
		if (filename.exists()) {
			System.out.println("There is already a file in the directory with this name.");
		} else {
			System.out.println("Adding file to the directory.");
			success = filename.createNewFile();
		}
		if (success) {
			System.out.printf("Successfully created new file.");
		} else {
			System.out.printf("Failed to create new file.");
		}

		
	}

}
