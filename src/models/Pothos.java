package models;


/**
 * @author Jushita Rahman
 * Date: 09/06/2020
 * Course: CS622
 * Pothos Object that extends Plant Object 
 */
public class Pothos extends Plant {
	private double vineLength;

	public Pothos(double string, String whenToWater, double string2) {
		this.amount = string;
		this.whenToWater = whenToWater;
		this.vineLength = string2;
	}
	
	public String getWhenToWater() {
		return whenToWater;
	}
	
	public double getVineLength() {
		return vineLength;
	}
	
	public void setVineLength(double vineLength) {
		this.vineLength = vineLength;
	}

	@Override
	public String getType() {
		return "Pothos";
	}

}
