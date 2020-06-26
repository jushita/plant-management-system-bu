package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import controller.PlantController;
import exception.IllegalPlantNameException;
/**
 * This class Prints list of plants based on the type given by the user
 * @author Jushita Rahman
 * Date: 06/01/2020
 * Course: CS622
 *
 */
public class Printer {
	public static void main(String[] args) {
		// getting user input
		String givenPlant = userInput();
		// checking to see which plant type to print
	    if(givenPlant.equals("pothos")) {
			Pothos[] arr = { new Pothos(2.0, "2", 5.0), new Pothos(3.0, "1", 6.0) };
	        Item<Pothos> pothos = new Item<Pothos>(arr);
	        System.out.printf("List of Pothos: %s\n", pothos);

	    }
	    if(givenPlant.equals("succulent")) {
	    	Item<Succulent> succulent = new Item<Succulent>();
	        System.out.printf("List of Succulent: %s\n", succulent);
	    }
        
        
    }
	/**
	 * Takes user input
	 * @return givenPlant
	 */
	public static String userInput() {
		// Create a Scanner object
		Scanner myPlant = new Scanner(System.in);
		// Print message to prompt user
	    System.out.println("Enter which plant you want  to print: ");
	    String givenPlant = myPlant.nextLine();
	    // return user input
	    return givenPlant;
	}

}

/**
 * 
 * @author jushita
 * Date: 06/01/2020
 * Course: CS622
 * 
 * @param <Plant>
 * 
 * Generic Class for Items 
 */

class Item<Plant>        
{
    private Plant[] t;
   
    public Item() 
    {
      t = null;
    }

    public Item(Plant[] t) 
    {
      this.t = t;
    }
    
    // converts item to string
    public String toString() 
    { 
      return t == null ? 
             "Has no plants" : 
             Arrays.toString(t);
    }
}
