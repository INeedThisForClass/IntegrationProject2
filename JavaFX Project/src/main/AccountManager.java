package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AccountManager {

	// creates a single text file that keeps track of users account.
	private static File database = new File("res/database.txt");

	public static void saveAccount(String text) {
		try {
			// Permits writing to file, second paremeter appends to file.
			FileWriter writer = new FileWriter(database, true);
			writer.write(text + "\n");
			System.out.println("Account saved to database.");
			writer.close();
		} catch (IOException e) {

		}
	}

	public static String getDatabase() {
		String accounts = "";
		try {
			// Permits reading the file.
			Scanner reader = new Scanner(database);
			while (reader.hasNext()) {
				accounts += reader.nextLine() + "\n";
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	public static boolean containsAccount(String username, String password) {
		String databaseFormat = username + ":" + password;
		// Checks for matches in database 
		if (getDatabase().contains(databaseFormat)) return true;
		return false;
	}

}
