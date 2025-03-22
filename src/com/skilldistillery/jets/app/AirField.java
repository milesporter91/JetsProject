package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.JumpJet;

public class AirField {

	private List<Jet> fleet;

	public AirField() {
		loadJetsFromFile("jetData.txt");
	}

	public List<Jet> getFleet() {
		return fleet;
	}

	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}

	@Override
	public String toString() {
		return "" + fleet;
	}
	
	public void findFastestJet() {
		Jet fastestJet = fleet.get(0);
		for (int i = 0; i < fleet.size(); i++) {
			if (fleet.get(i).getSpeed() > fastestJet.getSpeed()) {
				fastestJet = fleet.get(i);
			}
			
		}
		System.out.println(fastestJet.getModel() + " is the fastest jet in our fleet, with a top speed of "
						+ fastestJet.getSpeed() + " miles per hour!");
	}

	public void findLongestRange() {
		Jet longestRangeJet = fleet.get(0);
		for (int i = 0; i < fleet.size(); i++) {
			if (fleet.get(i).getRange() > longestRangeJet.getRange()) {
				longestRangeJet = fleet.get(i);
			}
		}
		System.out.println("The jet with the longest range in our fleet is " 
							+ longestRangeJet.getModel() + " with a max range of " 
							+ longestRangeJet.getRange() + " miles!");
	}
	
	public void flyJets() {
		for (int i = 0; i < fleet.size(); i++) {
			fleet.get(i).fly();
		}
	}

	public void printJets() {
		for (int i = 0; i < fleet.size(); i++) {
			System.out.println("Model: " + fleet.get(i).getModel() + "\t Speed: " 
							+ fleet.get(i).getSpeed() + "mph\t Range: " + fleet.get(i).getRange() 
								+ " miles\t Price: " + fleet.get(i).getPrice());
		}
	}
	
	public void loadJetsFromFile(String fileName) {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jetdata.txt"))) {
			fleet = new ArrayList<>();
			String line;
			while ((line = bufIn.readLine()) != null) {
				Jet j;
				String[] fields = line.split("[|]");
				String model = fields[1];
				double speed = Double.parseDouble(fields[2]);
				int range = Integer.parseInt(fields[3]);
				long price = Long.parseLong(fields[4]);
				switch (fields[0]) {
				case "J":
					j = new JumpJet(model, speed, range, price);
					fleet.add(j);
					break;
				case "F":
					j = new FighterJet(model, speed, range, price);
					fleet.add(j);
					break;
				case "C":
					j = new CargoPlane(model, speed, range, price);
					fleet.add(j);
					break;
				}

			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public void loadCargoPlanes() {
		for (int i = 0; i < fleet.size(); i++) {
			if (fleet.get(i) instanceof CargoPlane) {
				( (CargoPlane)fleet.get(i) ).loadCargo();
			}
		}
	}

	public void dogFight() {
		for (int i = 0; i < fleet.size(); i++) {
			if (fleet.get(i) instanceof FighterJet) {
				( (FighterJet)fleet.get(i) ).fight();
			}
		}
	}
	
	
	public void jumpRun() {
		for (int i = 0; i < fleet.size(); i++) {
			if (fleet.get(i) instanceof JumpJet) {
				( (JumpJet)fleet.get(i) ).jumpRun();
			}
		}
	}
	
	public void removeJet() {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < fleet.size(); i++) {
			System.out.println((i+1) + ". " + fleet.get(i).getModel());
		}
		System.out.println("Which jet would you like to remove?");
		int indexChoice = scanner.nextInt();
		fleet.remove(indexChoice - 1);
		
	}
	
	public void addFighterJet(String model, double speed, int range, long price) {
		Jet j = new FighterJet(model, speed, range, price);
		fleet.add(j);
	}
		
	public void addCargoPlane(String model, double speed, int range, long price) {
		Jet j = new CargoPlane(model, speed, range, price);
		fleet.add(j);
	}
		
	public void addJumpJet(String model, double speed, int range, long price) {
		Jet j = new JumpJet(model, speed, range, price);
		fleet.add(j);
	}
	
}
