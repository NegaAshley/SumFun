/*
 * Sum Fun Project
 * Group 7 - Conner Julian, Grace Mavity, Jake Norris, Ashley Xu
 * CS 360 - Software Engineering
 * Professor Sedlmeyer
 */
package edu.ipfw.sumfun;

/**
 * The Controller class holds the main method, and is the controller for the SumFun project.
 * @author Jake
 *
 */
public class Controller {//start SumFunGame class
	
	private static UntimedGame untimedGame;//instance of the main model class, UntimedGame class to run the game logic
	private static SumFunFrame frame;//instance of the main view class, SumFunFrame, to build the GUI
	/**
	 * Instantiate untimedGame and frame to run game logic and GUI.
	 * @param args, the command line arguments
	 */
	public static void main(String[] args) {//start main method
		
		final int FRAME_WIDTH = 1000;
		final int FRAME_LENGTH = 525;
		final boolean FRAME_RESIZABLE = false;
		final boolean FRAME_VISIBLE = true;
		
		//Creates new UntimedGame
		untimedGame = new UntimedGame();
		
		//Creates new SumFunFrame
		 frame = new SumFunFrame();
		
		//Sets size of frame
        frame.setSize(FRAME_WIDTH,FRAME_LENGTH);
        
        //Makes frame unable to be resized
        frame.setResizable(FRAME_RESIZABLE);
        
        //Makes frame visible
        frame.setVisible(FRAME_VISIBLE);
        
        //Uncomment to print the GameBoard to the console for testing purposes
        //TODO delete later
        //untimedGame.getGameBoard().printArray();

	}//end main method
	
	/**
	 * Returns the gameBoard from untimedGame
	 * @return a GameBoard object from untimedGame
	 */
	public static GameBoard getGameBoard(){//start getGameBoard method
		return untimedGame.getGameBoard();
	}//end getGameBoard method
	
	/**
	 * returns the TileModel from the gameBoard at the specified coordinates
	 * @param row the row desired
	 * @param col the column desired
	 * @return the TileModel at the coordinates
	 */
	public static TileModel getTileModel(int row, int col) {//start getTileModel method
		return untimedGame.getGameBoard().getTile(row, col);
	}//end getTileModel method
	
	/**
	 * Gets the points from the back-end for use in front-end
	 * @return 
	 */
	public static int getPoints() {
		return untimedGame.getPoints();
	}//end getPoints
	
	/**
	 * 
	 * @return
	 */
	public static int getMoves() {
		return untimedGame.getMovesRemaining();
	}//end getMoves
	
	/**
	 * Gets the TileModel from the queue at the specified index
	 * @param i the index desired
	 * @return a TileModel object from the queue in untimedGame
	 */
	public static TileModel getQueueTileModel(int i) {//start getQueueTileModel
		return untimedGame.selectQueueTile(i);
	}//end getqueueTileModel
	
	/**
	 * Sets the value of the tile at the specified coordinates to the specified value
	 * @param value the valued desired
	 * @param row the row desired
	 * @param col the column desired
	 */
	public static void setTileValue(int value, int row, int col){//start setTileValue method
		untimedGame.getGameBoard().getTile(row, col).setValue(value);
	}//end setTileValue method
	
	/**
	 * Advances the queue one position
	 */
	public static void pushQueue(){//start pushQueue method
		untimedGame.pushQueue();
	}//end pushQueue method
	
	/**
	 * Repaints the frame
	 */
	public static void repaintFrame(){//start repaintFrame method
		frame.repaint();
	}//end repaintFrame method
	
	/**
	 * Returns the SumFunFrame object
	 * @return frame
	 */
	public static SumFunFrame getFrame(){//start getFrame method
		return frame;
	}//end getFrame method
	
	/**
	 * Calls UntimedGame logic to process a move with the clicked-on coordinates and the top queue value
	 * @param i the row of the tile clicked
	 * @param j the column of the tile clicked
	 * @param value the top queue value
	 */
	public static void processMove(int i, int j, int value) {//start processMove method
		untimedGame.calculateSum(i, j, value);
	}//end processMove method
	
	/**
	 * Prints the values of the gameBoard to the console for testing
	 */
	public static void test() {//start test method
		untimedGame.getGameBoard().printArray();
	}//end test method
	
}//end SumFunGame class
