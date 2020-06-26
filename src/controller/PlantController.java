package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import exception.*;
import models.Plant;
import models.Pothos;
import models.Succulent;
import services.Waterer;


/**
 * @author Jushita Rahman
 * Date: 09/06/2020
 * Course: CS622
 * Get plants and Check inventory and print plants
 */
public class PlantController {
	public static void main(String[] args) {
        ArrayList<Plant> plants = new ArrayList<>();
		try {
			plants = getPlants();
		} catch (IllegalPlantNameException e) {
			System.out.println("Given plant was not found in Plant Inventory");
		}
        PlantController controller = new PlantController();

        controller.showAllPlants(plants);
        controller.water(plants);
        System.out.println("Watering of plants has begun! See you next time!");
    }

    static ArrayList<Plant> getPlants() throws IllegalPlantNameException {
        ArrayList<Plant> plants = new ArrayList<>(10);
        ReadFile rf = new ReadFile();
        ArrayList<String[]> listOfPlants = rf.read("plants.txt");
        ArrayList<String> plantInventory = rf.readInventory("plantInventory.txt");
        
        checkInventory(plantInventory, listOfPlants);
        for (int i = 0; i < listOfPlants.size(); i++) {
        	if(listOfPlants.get(i)[0].equals("Pothos")) {
        		double amount = new Double( listOfPlants.get(i)[1]);
        		double vineLength = new Double (listOfPlants.get(i)[3]);
        		String whenToWater = listOfPlants.get(i)[2];
        		Plant plant = new Pothos(amount, whenToWater, vineLength);
        		plants.add(plant);
        	}
        	
        	if(listOfPlants.get(i)[0].equals("Succulent")) {
        		double amount = new Double(listOfPlants.get(i)[1]);
        		String whenToWater = listOfPlants.get(i)[2];
        		Plant plant = new Succulent(amount, whenToWater);
        		plants.add(plant);
        	}
                        
        }

        return plants;
    }
    
    static void checkInventory(ArrayList<String> plantInventory, ArrayList<String[]> listOfPlants) 
    		throws IllegalPlantNameException {
    	for (int i = 0; i < listOfPlants.size(); i++) {
        	if(!plantInventory.contains(listOfPlants.get(i)[0])) {
        		 throw new IllegalPlantNameException(listOfPlants.get(i)[0], "Name not found in Inventory");
        	} 
    	}
    }

    public void showAllPlants(ArrayList<Plant> plants) {
        System.out.println("--------------------------------");
        for (Plant plant: plants) {
            System.out.println("Plant Type: " + plant.getType());
            if (plant instanceof Pothos) {
            	Pothos p = (Pothos) plant;
            	System.out.println("Water every " + p.getWhenToWater() + " week");
            } else {
            	Succulent s = (Succulent) plant;
            	System.out.println("Water every " + s.getWhenToWater() + " week");
            }
            System.out.println("--------------------------------");
        }
    }
    
    
    public void showVineLengths(ArrayList<Plant> plants) {
        System.out.println("--------------------------------");
        for (Plant plant: plants) {
            System.out.println("Plant Type: " + plant.getType());
            if (plant instanceof Pothos) {
            	Pothos p = (Pothos) plant;
            	System.out.println(p.getVineLength() + " vines");
            }
            System.out.println("--------------------------------");
        }
    }
    
    public void water(ArrayList<Plant> plants) {
    	for (Plant plant : plants) {
    		Waterer w = new Waterer(plant);
    		w.start();
    	}
    }
}