package com.skilldistillery.jets.app;

import java.util.List;

import com.skilldistillery.jets.entities.Jet;

public class AirField {

	private List<Jet> fleet;

	public AirField() {
		super();
	}

	public List<Jet> getFleet() {
		return fleet;
	}

	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}

}
