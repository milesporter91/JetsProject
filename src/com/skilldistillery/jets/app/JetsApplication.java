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
		// TODO Create an Airfield
		// do-while loop
		// * print menu
		// * get user choice
		// * switch on user choice
		// * Call an Airfield method to act on user choice
	}

	private void displayUserMenu() {
		System.out.println("We can store your planes, show you what"
				+ " we've got, or you can stick around for an air show!");
		System.out.println("What would ya like to do?!");
		System.out.println("1. See our current inventory");
		System.out.println("2. Add a plane to our airport");
		System.out.println("3. Remove a plane from our airport");
		System.out.println("4. See an Air Show");
		System.out.println("What would ya like to do?!");
	}
}
