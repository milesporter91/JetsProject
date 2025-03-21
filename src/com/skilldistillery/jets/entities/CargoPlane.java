package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements CargoCarrier{

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void loadCargo() {
		System.out.println("The " + getModel() + " is being loaded with  " + (Math.random() * 4000) + " pounds of cargo!");
		
	}

}
