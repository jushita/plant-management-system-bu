package models;


/**
 * @author Jushita Rahman
 * Date: 09/06/2020
 * Course: CS622
 * Succulent Object extends Plant Object 
 */
public class Succulent extends Plant {
	public Succulent(double amount, String whenToWater) {
		this.amount = amount;
		this.whenToWater = whenToWater;
	}
	
	public String getWhenToWater() {
		return whenToWater;
	}
 
	@Override
	public String getType() {
		return "Succulent";
	}
}
