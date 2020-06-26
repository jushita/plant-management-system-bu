package controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controller.PlantController;
import exception.IllegalPlantNameException;
import models.*;

public class PlantControllerTest {
	ArrayList<String> plants;
	ArrayList<String[]> listOfPlants;
	ArrayList<String> plantInventory;
    
	protected void setUp() {
		
	}
	
	@Before
	public void before() {
		plants = new ArrayList<>();
		listOfPlants = new ArrayList<>();
	    plantInventory = new ArrayList<>();
	}
	
	@Test
	public void testCheckInventoryForValid() throws IllegalPlantNameException {
		plantInventory.add("Pothos");
		plants.add("Pothos 1.0 1 5");
		for(int i = 0; i< plants.size(); i++) {
			listOfPlants.add(plants.get(i).split(" "));
		}
		PlantController.checkInventory(plantInventory, listOfPlants);
	}
	
	@Test
	public void testCheckInventoryForInvalid() {
		plantInventory.add("Succulent");
		plants.add("Pothos 1.0 1 5");
		for(int i = 0; i< plants.size(); i++) {
			listOfPlants.add(plants.get(i).split(" "));
		}
		Exception exception = assertThrows(IllegalPlantNameException.class, () -> {
			PlantController.checkInventory(plantInventory, listOfPlants);
		});
	}

}
