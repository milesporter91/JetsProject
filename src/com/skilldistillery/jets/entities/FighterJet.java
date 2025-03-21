package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady{
	private int roundsPerMinute;
	FighterJet(String model, double speed, int range, long price, int roundsPerMinute) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		System.out.println("The " + getModel() + "is zooming by at " + getSpeed() + " miles per hour!");
	}

	@Override
	public void fight() {
		System.out.println("The " + getModel() + " can fire its weapons at up to " + roundsPerMinute + "rounds per minute!");
	}

}
