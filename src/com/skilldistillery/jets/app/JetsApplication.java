package com.skilldistillery.jets.app;

import java.util.Scanner;

public class JetsApplication {
	private AirField airField = new AirField();
	private static Scanner scanner;

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
			do {
				displayUserMenu();
				userChoice = scanner.nextLine();
			switch (userChoice) {
			case "0":
			case "List":
			case "list": {
				airField.printJets();
				break;
			}
			case "1": 
			case "fly one":
			case "Fly one":
			case "one":
			case "One":
				flyJet();
				break;
			case "2":
			case "Fly all":
			case "fly all":
			case "All":
			case "all":
				airField.flyAllJets();
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
				removeJet();
				break;
			case "Quit":
			case "quit":
				System.out.println("Have a great day! Stop by any time!");
				keepGoing = false;
				break;
			default: 
					System.out.println(userChoice + " is not a valid choice!");
					break;
				
			}
		} while (keepGoing);
	}

	private void flyJet() {
		for (int i = 0; i < airField.getFleet().size(); i++) {
			System.out.println((i+1) + ". " + airField.getFleet().get(i).getModel());
		}
		System.out.println("Which jet would you like to see fly?");
		int indexChoice = scanner.nextInt();
		scanner.nextLine();
		indexChoice--;
		airField.flyJet(indexChoice);
	}
	private void removeJet() {
		for (int i = 0; i < airField.getFleet().size(); i++) {
			System.out.println((i+1) + ". " + airField.getFleet().get(i).getModel());
		}
		System.out.println("Which jet would you like to remove?");
		int indexChoice = scanner.nextInt();
		scanner.nextLine();
		indexChoice--;
		airField.removeJet(indexChoice);
	}
	private void displayUserMenu() {
		System.out.println();
		System.out.println("0. List our current fleet");
		System.out.println("1. Choose a jet to do a fly-by");
		System.out.println("2. Fly all jets");
		System.out.println("3. View fastest jet");
		System.out.println("4. View jet with longest range");
		System.out.println("5. Load all cargo jets");
		System.out.println("6. Dog Fight!");
		System.out.println("7. Watch sky divers");
		System.out.println("8. Add a jet to fleet");
		System.out.println("9. Remove a jet from fleet");
		System.out.println("Quit");
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
