package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {
	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		System.out.printf(
				"The %s is zooming by at %.2f miles per hour! With a max range of %d, it can fly at this speed for %.2f hours! It costs $%d\n",
				getModel(), getSpeed(), getRange(), (getRange() / getSpeed()), getPrice());
	}

	@Override
	public void fight() {
		System.out.println(getModel() + " is firing its weapons!");
		System.out.println("Brrrrrrrrr");
	}

}
