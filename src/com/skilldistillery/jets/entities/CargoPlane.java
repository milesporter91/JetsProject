package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		System.out.printf("The %s is doing a jump run at %.2f miles per hour! With a max range of %d, it can fly at this speed for %.2f hours! It costs $%d\n", getModel(), getSpeed(), getRange(), ( getRange() / getSpeed() ), getPrice());
	}

	@Override
	public void loadCargo() {
		System.out.println(
				"The " + getModel() + " is being loaded with  " + (Math.random() * 4000) + " pounds of cargo!");

	}

}
