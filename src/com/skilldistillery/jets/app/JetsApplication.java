package com.skilldistillery.jets.app;

import java.util.Scanner;

public class JetsApplication {
	private AirField airField = new AirField();
	private static Scanner scanner;

	// NO Jet collection in app class
	// only an Airfield
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println("Welcome to The Skill Distillery Airport!");
		JetsApplication app = new JetsApplication();
		app.launch();

		scanner.close();
	}

	private void launch() {
		boolean keepGoing = true;
		String userChoice;
		airField = new AirField();
			displayUserMenu();
			userChoice = scanner.nextLine();
			do {
			switch (userChoice) {
			case "1":
			case "List":
			case "list": {
				airField.printJets();
				break;
			}
			case "2":
			case "Fly":
			case "fly":
				airField.flyJets();
				break;
			case "3":
			case "Fastest":
			case "fastest":
				airField.findFastestJet();
				break;
			case "4":
			case "Longest":
			case "longest":
				airField.findLongestRange();
				break;
			case "5":
			case "Load":
			case "load":
				airField.loadCargoPlanes();
				break;
			case "6":
			case "Dogfight":
			case "dogfight":
				airField.dogFight();
				break;
			case "7":
			case "Skydive":
			case "skydive":
				airField.jumpRun();
				break;
			case "8":
			case "Add":
			case "add":
				addJet();
				break;
			case "9":
			case "Remove":
			case "remove":
				airField.removeJet();
				break;
			case "0":
			case "Quit":
			case "quit":
				System.out.println("Have a great day! Stop by any time!");
				keepGoing = false;
				break;
			default: {
					System.out.println(userChoice + " is not a valid choice!");
					break;
				} 
			}
		} while (keepGoing);
	}

	private void displayUserMenu() {
		System.out.println();
		System.out.println("1. List our current fleet");
		System.out.println("2. Fly all jets");
		System.out.println("3. View fastest jet");
		System.out.println("4. View jet with longest range");
		System.out.println("5. Load all cargo jets");
		System.out.println("6. Dog Fight!");
		System.out.println("7. Watch sky divers");
		System.out.println("8. Add a jet to fleet");
		System.out.println("9. Remove a jet from fleet");
		System.out.println("0. Quit");
		System.out.println("What would ya like to do?!");
	}

	private void addJet() {
		System.out.println("What model of jet will you be storing here?");
		String model = scanner.nextLine();
		System.out.println("What is the speed of your " + model + "?");
		double speed = scanner.nextDouble();
		System.out.println("What is the range of your " + model + "?");
		int range = scanner.nextInt();
		System.out.println("What is the value of your " + model + "?");
		long price = scanner.nextLong();
		scanner.nextLine();
		System.out.println("What is the function of the jet you will be storing here?");
		System.out.println("1. Fighter \t2. Cargo \t3.Jump");
		String jetType = scanner.nextLine();
		switch (jetType) {
		case "1":
		case "F":
		case "f":
			airField.addFighterJet(model, speed, range, price);
			break;
		case "2":
		case "C":
		case "c":
			airField.addCargoPlane(model, speed, range, price);
			break;
		case "3":
		case "J":
		case "j":
			airField.addJumpJet(model, speed, range, price);
			break;
		default: {
			System.out.println(jetType + " is not a jet type we recognize!");
			break;
		}

		}
	}

}
