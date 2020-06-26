/**
 * 
 */
package controller;

/**
 * @author Jushita Rahman
 * Read given file 
 *
 */
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {
  public ArrayList read(String myFile) {
    ArrayList<String[]> listOfPlants = new ArrayList<>();
    try {
      File myObj = new File(myFile);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        listOfPlants.add(data.split(" "));
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
	return listOfPlants;
  }
  
  public ArrayList readInventory(String myFile) {
	    ArrayList<String> listOfPlants = new ArrayList<>();
	    try {
	      File myObj = new File(myFile);
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        listOfPlants.add(data);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		return listOfPlants;
	  }
}