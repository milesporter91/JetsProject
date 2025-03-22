package com.skilldistillery.jets.entities;

public class JumpJet extends Jet implements JumpReady{

	public JumpJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		System.out.println("The " + getModel() + " is doing a jump run at " 
						+ getSpeed() + " miles per hour! With a max range of " + getRange() 
						+ ", it can fly at this speed for " + ( getRange() / getSpeed() ) + " miles! "
								+ "It costs $" + getPrice() + "." );

	}


	public void jumpRun() {
		System.out.println("The " + getModel() + " is currently dropping " 
				+ ( (int) ( (Math.random() * 20) + 3 ) ) + " skydivers!");
		
	}

}
