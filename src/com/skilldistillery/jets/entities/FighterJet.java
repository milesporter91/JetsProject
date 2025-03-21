package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady{
	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		System.out.println("The " + getModel() + "is zooming by at " + getSpeed() + " miles per hour!");
	}

	@Override
	public void fight() {
	//TODO 	System.out.println("");
	}

}
