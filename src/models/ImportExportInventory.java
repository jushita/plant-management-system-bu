package models;
import java.io.*;



/**
 * @author jushita
 * Date: 06/06/2020
 * Course: CS622
 * Import and Export plants to and from inventory file
 */
public class ImportExportInventory {
	public static void main(String[] args) {
		try {
			try (ObjectOutputStream outfile = new ObjectOutputStream 
					(new FileOutputStream("inventoryplant.dat"));) {
				// save given plants to file; for now hard coding the 
				//values we can also take this as user input
				System.out.println("Importing given plants to file: inventoryplant.dat");
				outfile.writeObject(new InvPlant(1, "Pothos"));
				outfile.writeObject(new InvPlant(2, "Succulent"));
			} 
			try (ObjectInputStream infile = new ObjectInputStream
										(new FileInputStream("inventoryplant.dat"));) {
				// exporting all the plants in the file
				System.out.println("Exporting plants from file: inventoryplant.dat");
				while (true) {
					System.out.printf("%s%n", (InvPlant) (infile.readObject()));
				}
			}
			
		} catch (EOFException ex) {
	         System.out.println("EOF reached in inventoryplant.dat");    
		}
		catch (FileNotFoundException ex)
	     {
	         System.out.println("FileNotFoundException"); 
	         ex.printStackTrace();   
	     }
		catch (IOException ex)
	     {
	         System.out.println("IOException");
	         ex.printStackTrace();    
	     }

	     catch (ClassNotFoundException ex)
	     {
	         System.out.println("ClassNotFoundException");
	         ex.printStackTrace();    
	     }
	}

}

/**
 * 
 * @author jushita
 *
 * Inventory Plant Object 
 */
class InvPlant implements Serializable {
	static final long serialVersionUID = -4325001773598432534L;
	private int id;
	private String name;
	

	public InvPlant (int pid, String pname) {
		id = pid;
		name = pname;
	}
	
	public String toString() {
		return "id = " + id + " name " + name;
	}
}