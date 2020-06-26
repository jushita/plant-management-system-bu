package services;

import java.util.ArrayList;

import controller.PlantController;
import controller.ReadFile;
import exception.IllegalPlantNameException;
import models.Plant;
import models.Pothos;
import models.Succulent;


/**
 * @author Jushita Rahman
 * Date: 06/06/2020
 * Course: CS622
 *
 * Calculate Maximum vine Length of the plants in the inventory
 */
public class VineLength {
	public static ArrayList<Double> vines = new ArrayList<>();
	public static void main(String[] args) {
        ArrayList<Plant> plants = new ArrayList<>();
		try {
			plants = getPlants();
		} catch (IllegalPlantNameException e) {
			System.out.println("Given plant was not found in Plant Inventory");
		}
        PlantController controller = new PlantController();
        // Helper function to display all plants and their vine lengths
        controller.showVineLengths(plants);
        
        // Lambda function to print Longest Vine Length
        Printer printer = vine ->
        System.out.println("Plant with longest vine: " + vine);
        printer.vineLength(getLongestPlant());
        
    }
	
	// Function to get Plants from the given plant file and extract the vine lengths
	static ArrayList<Plant> getPlants() throws IllegalPlantNameException {
        ArrayList<Plant> plants = new ArrayList<>(10);
        ReadFile rf = new ReadFile();
        ArrayList<String[]> listOfPlants = rf.read("plants.txt");
        
        for (int i = 0; i < listOfPlants.size(); i++) {
        	if(listOfPlants.get(i)[0].equals("Pothos")) {
        		double amount = new Double( listOfPlants.get(i)[1]);
        		double vineLength = new Double (listOfPlants.get(i)[3]);
        		vines.add(vineLength);
        		String whenToWater = listOfPlants.get(i)[2];
        		Plant plant = new Pothos(amount, whenToWater, vineLength);
        		plants.add(plant);
        	}
                        
        }

        return plants;
    }
	
	
	// Using stream() to calculate the maximum vine length among all the plants
	static double getLongestPlant() {
		return vines.stream().max(Double::compare).get();
	}
	
	
}

// Helper interface to print the vine length
interface Printer {
    void vineLength(double d);
 }