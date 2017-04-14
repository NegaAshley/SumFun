/*
 * Sum Fun Project
 * Group 7 - Conner Julian, Grace Mavity, Jake Norris, Ashley Xu
 * CS 360 - Software Engineering
 * Professor Sedlmeyer
 */
package edu.ipfw.sumfun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Application class contains the main method, which initiates the MVC relationship by instantiating
 * a model and the controller
 * @author Jake
 *
 */
public class Application {//start Application class
	
	private static final String path = "sumfun.csv";
	
	//Reference to the model
	private static UntimedGame untimedGame;
	
	//Reference to the other model
	private static TimedGame timedGame;
	
	//Reference to a structure containing the top 10 player records by points earned
	private static TopPointPlayers tpp;
	
	/**
	 * Instantiate untimedGame and frame to run game logic and GUI.
	 * @param args, the command line arguments
	 */
	public static void main(String[] args) {//start main method
		
		//Attempt to load saved data
		deserialize();
		
	// adds some sample UntimedRecords to TopPointsPlayers	
	// tpp.addRecord(new UntimedRecord("Rhiannon", 0, 66));
	// tpp.addRecord(new UntimedRecord("Freya", 0, 77);
		
		//Instantiate a model and a controller, passing the model reference to the controller
		//$ timedGame = TimedGame.getInstance();
		untimedGame = UntimedGame.getInstance();
		timedGame = TimedGame.getInstance();
		//$ Controller controller = new Controller(timedGame);
		Controller controller = new Controller(untimedGame, tpp);

	}//end main method
	
	/**
	 * Save player records to persistent file storage
	 */
    public static void serialize() {//start serialize method

            try (FileOutputStream fos = new FileOutputStream(path)) {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(tpp);
            } catch (Exception ex0111111111) {
                JOptionPane.showMessageDialog(null, "Error writing to file! Work not saved!");
            }
            
    }//end serialize method
    
    /**
     * Load player records from persistent file storage, or instantiate new
     * TopPlayers objects if they fail to load
     */
    public static void deserialize() {//start deserialize method
        JFileChooser fc = new JFileChooser();
            try (FileInputStream fis = new FileInputStream(path)) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                tpp = (TopPointPlayers) ois.readObject();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error reading file! Loading to default settings!");
                tpp = new TopPointPlayers();
            }
        
    }//end deserialize method
	
}//end Application class
