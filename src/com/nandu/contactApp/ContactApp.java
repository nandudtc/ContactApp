package com.nandu.contactApp;

import java.io.File;
import java.util.Scanner;

public class ContactApp {

	Scanner sc1; //used to input values like int , float,double etc,.
	Scanner sc2; //used to input more than one character
	File f;
	String basePath;

	{
		sc1 = new Scanner(System.in);
		sc2 = new Scanner(System.in);
		basePath = "D:\\other\\javaProject\\";
	}

	public void start() {

		int mainMenuOption = 0;

		try {

			mainMenuOption = showContactAppMainMenu();
			processMainMenuSelectedOption(mainMenuOption);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	private void processMainMenuSelectedOption(int selectedOption) {

		switch (selectedOption) {

		case 1: {
			createContactsBook();
		}
		break;

		case 2: {
			//load contact book
			loadContactBook();
		}
		break;

		case 3: {
			System.out.println("Option 3 selected. Logic yet to be implemented!!");
		}
		break;

		case 4: {
			System.out.println("Option 4 selected. Logic yet to be implemented!!");
		}
		break;

		case 5: {
			System.out.println("Option 5 selected. Logic yet to be implemented!!");
		}
		break;

		case 6: {
			printEmptyLines(2);
			System.out.println("Bye bye :-)");
			System.exit(0);
		}
		break;

		default:{
			System.out.println("Enter valid option!!");
			printEmptyLines(1);
			start();
		}	
		break;

		}

		printEmptyLines(1);
		start();

	}

	private void loadContactBook() {

		String contactBooKName;
		boolean isValidcontactBooKName = false;
		int temp ;
		f = new File(basePath); 

		try {
			
			File[] ff = f.listFiles();

			if(ff.length == 0) {

				System.out.println("No contact book is present, please create a contact book before proceeding.");

			} else {

				System.out.println("contacts list");

				for(File fi : ff) {

					System.out.println(fi.getName());
				}
				printEmptyLines(1);

				System.out.println("Enter contact book which already exists");
				contactBooKName = sc2.nextLine();

				printEmptyLines(1);

				for(File f : ff) {

					if(f.getName().contains(contactBooKName)) {

						isValidcontactBooKName = true;
						break;

					}
				}

				if(isValidcontactBooKName == true) {

					startToLoadContactBook();

				}else {

					System.out.println("invalid contact book name. Press 1 to enter an valid contact book name or else press 0 to back to previous menu");
					temp = sc1.nextInt();

					if(temp == 1) {

						loadContactBook();
					}else {

						start();
					}
				}


			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}

	private void startToLoadContactBook() {
		
		int loadContactBookOption;
		
		try {
			
			loadContactBookOption = loadContactBookMenu();
			processLoadContactBookInnerMenuSelecetedOption(loadContactBookOption);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	private void processLoadContactBookInnerMenuSelecetedOption(int innerMenuOption) {
		
		try {
			
			switch (innerMenuOption) {
			case 1: {
				System.out.println("option 1 selected , logic yet to be implemented");
			}
			break;

			case 2: {
				System.out.println("option 2 selected , logic yet to be implemented");
			}
			break;

			case 3:{
				System.out.println("option 3 selected , logic yet to be implemented");
			}
			break;

			case 4: {
				System.out.println("option 4 selected , logic yet to be implemented");
			}
			break;

			case 5:{
				System.out.println("option 5 selected , logic yet to be implemented");
			}	
			break;

			case 6: {
				System.out.println("going back to main menu");
				start();
				printEmptyLines(1);
			}	
			break;

			default:{

				System.out.println("invalid option!!");
				printEmptyLines(2);
				startToCreateContactBook();
			}
			break;

			}
			printEmptyLines(1);
			startToCreateContactBook();

			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

	private int loadContactBookMenu() {

		int choice = 0;
		
		try {

			System.out.println("Press 1 to Add a Contact");
			System.out.println("Press 2 to Edit a Contact");
			System.out.println("Press 3 to Remove a Contact");
			System.out.println("Press 4 to List the Contact");
			System.out.println("Press 5 to Search Contact");
			System.out.println("Press 6 to Go back to previous menu");
			
			System.out.println("Enter choice : ");
			
			choice = sc1.nextInt();
			
		} catch (Exception e) {

			e.printStackTrace();

		}
		return choice;
		

	}

	private int showContactAppMainMenu(){

		int choice = 0;

		try {

			System.out.println("Press 1 to Create Contacts Book");
			System.out.println("Press 2 to Load Contacts Book");
			System.out.println("Press 3 to Search contacts");
			System.out.println("Press 4 to List contacts");
			System.out.println("Press 5 for Birthday reminders");
			System.out.println("Press 6 to Exit");
			printEmptyLines(1);
			System.out.println("Enter choice : ");

			choice = sc1.nextInt();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return choice;
	}

	public static void printEmptyLines(int num) {

		for(int i = 1 ; i <= num; i++) {
			System.out.println("");
		}

	}

	private void createContactsBook() {

		String contactBookName;
		int temp;

		try {

			System.out.println("Enter contact book name");
			contactBookName = sc2.nextLine();
			printEmptyLines(1);

			if(checkIfFileExists(basePath , contactBookName + ".txt")) {

				System.out.println(contactBookName + " already exists. Enter 1 to enter new name else enter 0 for previous menu.");

				temp = sc1.nextInt();
				printEmptyLines(1);

				if(temp == 1) {
					createContactsBook();
					printEmptyLines(1);
				}

				if(temp == 0) {
					start();
					printEmptyLines(1);
				}

			} else {

				f.createNewFile();
				startToCreateContactBook();
				printEmptyLines(1);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	private int createContactsBookMenu() {

		int choice = 0;
		try {

			System.out.println("Press 1 to Add a Contact");
			System.out.println("Press 2 to Edit a Contact");
			System.out.println("Press 3 to Remove a Contact");
			System.out.println("Press 4 to List the Contact");
			System.out.println("Press 5 to Search Contact");
			System.out.println("Press 6 to Go back");
			printEmptyLines(1);

			System.out.println("Enter choice : ");
			choice = sc1.nextInt();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return choice;
	}

	private void processCreateContactsBookMenuSelectedOption(int selectedOption) {

		switch (selectedOption) {

		case 1: {
			System.out.println("option 1 selected , logic yet to be implemented");
		}
		break;

		case 2: {
			System.out.println("option 2 selected , logic yet to be implemented");
		}
		break;

		case 3:{
			System.out.println("option 3 selected , logic yet to be implemented");
		}
		break;

		case 4: {
			System.out.println("option 4 selected , logic yet to be implemented");
		}
		break;

		case 5:{
			System.out.println("option 5 selected , logic yet to be implemented");
		}	
		break;

		case 6: {
			System.out.println("going back to main menu");
			start();
			printEmptyLines(1);
		}	
		break;

		default:{

			System.out.println("invalid option!!");
			printEmptyLines(2);
			startToCreateContactBook();
		}
		break;

		}
		printEmptyLines(1);
		startToCreateContactBook();

	}

	private void startToCreateContactBook() {
		int createContactMenuOption;
		try {

			createContactMenuOption = createContactsBookMenu();

			processCreateContactsBookMenuSelectedOption(createContactMenuOption);


		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	private boolean checkIfFileExists(String basePath, String fileName) {

		String filePath = basePath + fileName;

		f = new File(filePath);

		if(f.exists() & f.isFile() & f.getName().equals(fileName)){

			return true;

		}else {

			return false;

		}
	}

}

