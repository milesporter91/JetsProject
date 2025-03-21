package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements CargoCarrier{
	private int cargoCapacityInPounds;

	CargoPlane(String model, double speed, int range, long price, int cargoCapacityInPounds) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}

	public int getCargoCapacityInPounds() {
		return cargoCapacityInPounds;
	}

	public void setCargoCapacityInPounds(int cargoCapacityInPounds) {
		this.cargoCapacityInPounds = cargoCapacityInPounds;
	}

	@Override
	public void loadCargo() {
		System.out.println("The " + getModel() + " can carry up to " + cargoCapacityInPounds + " pounds of cargo!");
		
	}

}
