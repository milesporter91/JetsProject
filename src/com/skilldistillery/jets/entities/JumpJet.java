package com.skilldistillery.jets.entities;

public class JumpJet extends Jet implements JumpReady{
	private int jumperCapacity;

	JumpJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub

	}

	public int getJumperCapacity() {
		return jumperCapacity;
	}

	public void setJumperCapacity(int jumperCapacity) {
		this.jumperCapacity = jumperCapacity;
	}

	public void jumpRun() {
		System.out.println("The " + getModel() + " is currently dropping " 
				+ ((int) (Math.random() * getJumperCapacity())) + " skydivers!");
		
	}

}
