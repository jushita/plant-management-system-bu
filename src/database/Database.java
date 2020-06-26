package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jushita Rahman
 * Date: 22/06/2020
 * Course: CS622
 *
 * Class to implement database
 */
public class Database {
	private static Database instance;
     /**
     * Connect to a sample database
     * @return 
     */
	// creating singleton for database connection
	public static Database getInstance() {
		if(Database.instance == null) {
			Database.instance = new Database();
		}
		return Database.instance;
	}
	
	private Connection connection;
	private Database() {}
	
	// connecting to database
    public void connect() {
    	if(connection != null) {
    		return;
    	}
        try {
            // db parameters
            String url = "jdbc:sqlite:plant.db";
            // create a connection to the database
            connection = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    // create new db table
    public void createNewDatabase(String fileName) {
    	String url ="jdbc:sqlite:/" + fileName;
    	
    	try {
            if (connection != null) {
                DatabaseMetaData meta = connection.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    // creating table to store plants
    public void createPlantTable() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS plants (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	amount double\n"
                + ");";
        
        try {
        	Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // creating table to store vine length of plants 
    public void createVineTable() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS vines (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	size integer\n"
                + ");";
        
        try {
        	Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // selecting all plants from table 
    public void selectAllPlants() {
    	String sql ="SELECT id, name, amount FROM plants";
    	
    	try {
    		Statement stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
    		// loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getDouble("amount"));
            }
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
 // selecting all vines from table 
    public void selectAllVines() {
    	String sql ="SELECT id, name, size FROM vines";
    	
    	try {
    		Statement stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
    		// loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getDouble("size"));
            }
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    // inserting data into plants table 
    public void insertIntoPlants(String name, double amount) {
        String sql = "INSERT INTO plants(name,amount) VALUES(?,?)";
        try {
        		PreparedStatement pstmt = connection.prepareStatement(sql);
        		pstmt.setString(1, name);
                pstmt.setDouble(2, amount);
                pstmt.executeUpdate();
        	} catch (SQLException e) {
                System.out.println(e.getMessage());
            }
    }
    // inserting data into plants table 
    public void insertIntoVine(String name, double size) {
        String sql = "INSERT INTO vines(name,size) VALUES(?,?)";
        try {
        		PreparedStatement pstmt = connection.prepareStatement(sql);
        		pstmt.setString(1, name);
                pstmt.setDouble(2, size);
                pstmt.executeUpdate();
        	} catch (SQLException e) {
                System.out.println(e.getMessage());
            }
    }
    
 // selecting all plants from table 
    public void selectAndOrderBy() {
    	String sql ="SELECT * FROM plants order by name";
    	
    	try {
    		Statement stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
    		// loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getDouble("amount"));
            }
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // selecting all data from plants and vines table using join
    public void selectPlantsAndVine() {
    	String sql = "SELECT * FROM plants, vines where plants.id = vines.id";
    	try {
    		Statement stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
    		// loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getDouble("amount") + "\t" +
                                   rs.getDouble("size"));
            }
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
    
    
    // function to show total vine length using aggregation of data
    public void getTotalVineLength() {
    	String sql = "SELECT sum(size) as totalVine from vines";
    	
    	try {
    		Statement stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
    		// loop through the result set
            while (rs.next()) {
                System.out.println("Total Vine length is" + rs.getDouble("totalVine"));
            }
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // delete plant by id from plants table
    public void deletePlant(double id) {
    	String sql = "DELETE FROM plants where id = " + id; 
    	try {
    		Statement stmt = connection.createStatement();
    		stmt.executeQuery(sql);
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // delete vines by id from vines table 
    public void deleteVines(double id) {
    	String sql = "DELETE FROM vines where id = " + id; 
    	try {
    		Statement stmt = connection.createStatement();
    		stmt.executeQuery(sql);
    	} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    

  
    
    
    public static void main(String[] args) throws SQLException {
    	Database db = Database.getInstance();
    	db.connect();
        db.createNewDatabase("plant.db");
        db.createPlantTable();
        db.createVineTable();
        db.insertIntoPlants("succulent", 0.5);
        db.insertIntoPlants("pothos", 2.0);
        db.insertIntoVine("pothos", 5);
        db.insertIntoVine("succulent", 3);
        db.deletePlant(3);
        db.selectAllPlants();
        db.selectAllVines();
        db.selectAndOrderBy();
        db.selectPlantsAndVine();
        db.getTotalVineLength();

    } 
    
    
}