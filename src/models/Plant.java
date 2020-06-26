package models;


/**
 * @author Jushita Rahman
 * Date: 09/06/2020
 * Course: CS622
 * Plant Object 
 */
public abstract class Plant {
	protected double amount;
	protected String whenToWater;
	
	public double getAmount() {
		return amount;
	}
	
	public String getWhenToWater() {
		return whenToWater;
	}

	public abstract String getType();

	@Override
	public String toString() {
		return "Plant [amount=" + amount + ", whenToWater=" + whenToWater + "]";
	}
}


