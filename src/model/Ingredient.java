package model;

import exception.NegativeNumberException;

public class Ingredient {
	private String name;
	private double weight;
	
	public Ingredient(String n, double w) {
		name = n;
		weight = w;	
	}
	
	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void addWeight(double additionalW) throws NegativeNumberException {
		if(additionalW >= 0) {
			weight = weight + additionalW;
		}else {
			throw new NegativeNumberException(additionalW);
		}
	}
	
	public void removeWeight(double toRemoveW) throws NegativeNumberException {
		if(toRemoveW >= 0) {
			weight = weight - toRemoveW;
		}else {
			throw new NegativeNumberException(toRemoveW);
		}
	}
	
	
}
