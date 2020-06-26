package services;

import models.Plant;



/**
 * @author Jushita Rahman
 * Date: 09/15/2020
 * Course: CS622
 * Creates a new thread to water a plant
 */
public class Waterer extends Thread {
	private Plant plant;
	private double waterRate; // Liters/minute
	
	public Waterer(Plant plant) {
		this.plant = plant;
		this.waterRate = 1.25;
	}
	
	public void run() {
		double minutesToWater = plant.getAmount() / waterRate;
		int actualWaterTimeInMillis = (int) (minutesToWater * 60 * 1000);
		
		System.out.println("Beginning watering of " 
				+ plant.toString() + " for " 
				+ actualWaterTimeInMillis + "ms.");
		
		// Simulate watering of plant
		try {
			Thread.sleep(actualWaterTimeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Water of " + plant.toString() + " complete!");
	}
}
