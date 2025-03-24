package com.skilldistillery.jets.entities;

public abstract class Jet {
	private String model;
	private double speed;
	private int range;
	private long price;

	public  void fly() {
		System.out.printf(
				"The %s is flying by at %.2f miles per hour! With a max range of %d miles, it can fly at this speed for %.2f hours before running out of fuel! It costs $%d\n",
				getModel(), getSpeed(), getRange(), (getRange() / getSpeed()), getPrice());
	}

	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	@Override
	public String toString() {
		return model + ": Speed: " + speed + ", Range: " + range + ", Price: " + price;
	}

	public String getModel() {
		return model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

}
