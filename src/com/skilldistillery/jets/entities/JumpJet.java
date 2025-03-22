package com.skilldistillery.jets.entities;

public class JumpJet extends Jet implements JumpReady{

	public JumpJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		System.out.printf("The %s is doing a jump run at %.2f miles per hour! With a max range of %d, it can fly at this speed for %.2f hours! It costs $%d\n", getModel(), getSpeed(), getRange(), ( getRange() / getSpeed() ), getPrice());

	}


	public void jumpRun() {
		System.out.println("The " + getModel() + " is currently dropping " 
				+ ( (int) ( (Math.random() * 20) + 3 ) ) + " skydivers!");
		
	}

}
