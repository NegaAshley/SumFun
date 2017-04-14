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
	
	/**
	 * Returns the gameBoard from untimedGame
	 * @return a GameBoard object from untimedGame
	 */
	public static GameBoard getGameBoard(){//start getGameBoard method
		//$ return timedGame.getGameBoard();
		return untimedGame.getGameBoard();
	}//end getGameBoard method
	
	/**
	 * returns the TileModel from the gameBoard at the specified coordinates
	 * @param row the row desired
	 * @param col the column desired
	 * @return the TileModel at the coordinates
	 */
	public static TileModel getTileModel(int row, int col) {//start getTileModel method
		//game type change
		//$ return timedGame.getGameBoard().getTile(row, col);
		return untimedGame.getGameBoard().getTile(row, col);
	}//end getTileModel method
	
	/**
	 * Gets the points from the back-end for use in front-end
	 * @return points
	 */
	public static int getPoints() {
		//change game type
		//$ return timedGame.getPoints();
		return untimedGame.getPoints();
	}//end getPoints
	
	/**
	 * Gets the moves from the back-end for use in front-end
	 * @return movesRemaining
	 */
	public static int getMoves() {
		return untimedGame.getMovesRemaining();
	}//end getMoves
	
	/**
	 * Gets the time remaining for use in front end
	 * @return time - as a string
	 */
	public static String getTime(){//start getTime method
		if(timedGame == null) {
			return null;
		} else {
			return timedGame.getTime();
		}
	}//end getTime method
	
	/**
	 * Gets the TileModel from the queue at the specified index
	 * @param i the index desired
	 * @return a TileModel object from the queue in untimedGame
	 */
	public static TileModel getQueueTileModel(int i) {//start getQueueTileModel
		//change game type
		//$ return timedGame.selectQueueTile(i);
		return untimedGame.selectQueueTile(i);
	}//end getqueueTileModel
	
	/**
	 * Sets the value of the tile at the specified coordinates to the specified value
	 * @param value the valued desired
	 * @param row the row desired
	 * @param col the column desired
	 */
	public static void setTileValue(int value, int row, int col){//start setTileValue method
		//change game type
		//$ timedGame.getGameBoard().getTile(row, col).setValue(value);
		untimedGame.getGameBoard().getTile(row, col).setValue(value);
	}//end setTileValue method
	
	/**
	 * Advances the queue one position
	 */
	public static void pushQueue(){//start pushQueue method
		//change game type
		//$ timedGame.pushQueue();
		untimedGame.pushQueue();
	}//end pushQueue method
	
	/**
	 * Prints the values of the gameBoard to the console for testing
	 */
	public static void test() {//start test method
		//change game type
		//$ timedGame.getGameBoard().printArray();
		untimedGame.getGameBoard().printArray();
	}//end test method
	
}//end Application class
