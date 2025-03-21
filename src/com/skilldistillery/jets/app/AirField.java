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
