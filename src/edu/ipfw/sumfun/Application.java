/*
 * Sum Fun Project
 * Group 7 - Connor Julian, Grace Mavity, Jake Norris, Ashley Xu
 * CS 360 - Software Engineering
 * Professor Sedlmeyer
 */
package edu.ipfw.sumfun;
import java.awt.FontFormatException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Application class contains the main method, which initiates the MVC relationship by instantiating
 * a model and the controller
 * @author Jake
 *
 */
public class Application {//start Application class
	private static  String path = "/sumfun.csv";
	private static FileReader reader=new FileReader(path);
	
	//Reference to the model
	private static UntimedGame untimedGame;
	
	//Reference to the other model
	private static TimedGame timedGame;
	
	//Reference to a structure containing the top 10 player records by points earned
	private static TopPointPlayers tpp;
	
	private static TopTimePlayers ttp;
	
	/**
	 * Instantiate untimedGame and frame to run game logic and GUI.
	 * @param args, the command line arguments
	 * @throws IOException 
	 * @throws FontFormatException  
	 * @throws NumberFormatException 
	 * @throws UnsupportedAudioFileException 
	 * @throws URISyntaxException 
	 */
	public static void main(String[] args) throws IOException, FontFormatException, NumberFormatException, URISyntaxException, UnsupportedAudioFileException{//start main method
		
		
	
		//Attempt to load saved data
		deserialize();
		
		ttp.printRecords();
		
		//Get references to both model instances, and instantiate a controller using UntimedGame as the initial model
		untimedGame = UntimedGame.getInstance();
		timedGame = TimedGame.getInstance();

		Controller controller = new Controller(untimedGame, tpp, ttp);

	}//end main method
	
	/**
	 * Save player records to persistent file storage
	 */
    public static void serialize() {//start serialize method

            try (FileOutputStream fos = new FileOutputStream(reader.returnPath())) {
            	System.out.println(reader.returnPath());
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(tpp);
                oos.writeObject(ttp);
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
            try (FileInputStream fis = new FileInputStream(reader.returnPath())) {
            	System.out.println(reader.returnPath());
                ObjectInputStream ois = new ObjectInputStream(fis);
                tpp = (TopPointPlayers) ois.readObject();
                ttp = (TopTimePlayers) ois.readObject();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error reading file! Loading to default settings!");
                tpp = new TopPointPlayers();
                ttp = new TopTimePlayers();
            }
        
    }//end deserialize method
	
}//end Application class
