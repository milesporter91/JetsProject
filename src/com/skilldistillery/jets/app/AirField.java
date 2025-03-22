package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.JumpJet;
//import com.skilldistillery.jets.entities.Pilot;

public class AirField {

//	private List<Pilot> pilots;
	
	private List<Jet> fleet;

	public AirField() {
		loadJetsFromFile("jetData.txt");
//		loadPilotsFromFile("pilots.txt");
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
	
//	public void hirePilot(String name) {
//		Pilot pilot = new Pilot(name);
//		pilots.add(pilot);
//	}

//	public void loadPilotsFromFile(String fileName) {
//		try (BufferedReader bufIn = new BufferedReader(new FileReader("pilots.txt"))) {
//			pilots = new ArrayList<>();
//			String line;
//			while ((line = bufIn.readLine()) != null) {
//				Pilot j;
//				j = new Pilot(line);
//				pilots.add(j);
//			}
//			System.out.println(pilots);
//			for (int i = 0; i < pilots.size(); i++) {
//					if (fleet.get(i).getPilot() == null) {
//						fleet.get(i).setPilot(pilots.get(i)); 
//					}
//				}
//		} catch (IOException e) {
//			System.err.println(e);
//		}
//	}
	
 	public void findFastestJet() {
		if (fleet.size() != 0) {
			Jet fastestJet = fleet.get(0);
		for (int i = 0; i < fleet.size(); i++) {
			if (fleet.get(i).getSpeed() > fastestJet.getSpeed()) {
				fastestJet = fleet.get(i);
			}
			
		}
		System.out.println(fastestJet.getModel() + " is the fastest jet in our fleet, with a top speed of "
						+ fastestJet.getSpeed() + " miles per hour! It has a range of " + fastestJet.getRange() 
						+ " miles and costs $" + fastestJet.getPrice() + ".");
		}
	}

	public void findLongestRange() {
		if (fleet.size() != 0) {
			Jet longestRangeJet = fleet.get(0);
		for (int i = 0; i < fleet.size(); i++) {
			if (fleet.get(i).getRange() > longestRangeJet.getRange()) {
				longestRangeJet = fleet.get(i);
			}
		}
		System.out.println("The jet with the longest range in our fleet is the " 
							+ longestRangeJet.getModel() + " with a max range of " 
							+ longestRangeJet.getRange() + " miles! It has a top speed of " 
							+ longestRangeJet.getSpeed() + " miles per hour, and costs $" + longestRangeJet.getPrice());
		}
	}
	
	public void flyJet(int indexChoice) {
	 if (fleet != null && indexChoice >= 0 && indexChoice < fleet.size()) {
		 fleet.get(indexChoice).fly();
	 } else {
		 System.out.println("That is not a valid choice.");
	 }
		 
	}
	
	public void flyAllJets() {
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
	
	public void removeJet(int indexChoice) {
		 if (fleet != null && indexChoice >= 0 && indexChoice < fleet.size()) {
			 fleet.remove(indexChoice);
		 } else {
			 System.out.println("There is no jet there!");
		 }
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

	
//	public List<Pilot> getPilots() {
//		return pilots;
//	}

//	public void setPilots(List<Pilot> pilots) {
//		this.pilots = pilots;
//	}
//	
}
