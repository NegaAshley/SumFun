package edu.ipfw.sumfun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Jake
 *
 */
public class Controller implements ActionListener {
	
	//Various constants for use throughout Controller
	private static final boolean GUI_VISIBLE = true;
	private static final String RESET_QUEUE = "Reset Queue";
	private static final String NEW_GAME = "New Game";
	
	//References to model and view
	//Change model type
	//$ private TimedGame model;
	private UntimedGame model; 
	private SumFunFrame view;
	
	/**
	 * Constructor
	 * @param u, an instance of UntimedGame (the system's model)
	 */
	//$ public Controller(TimedGame t) {
		//$ model = t;
	public Controller(UntimedGame u){
		model =u;
		view = new SumFunFrame(model, this);
		view.setVisible(GUI_VISIBLE);
	}//end Constructor

	/**
	 * Process all actions that need to occur due to user input
	 * Uses event.getActionCommand to determine what changes need to occur
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		
		//Check for an even that needs to start a new game
		if(event.getActionCommand().equals(NEW_GAME)){
			startNewGame();
			return;
		}
		
		//Check for an event that needs to reset the queue
		if(event.getActionCommand().equals(RESET_QUEUE)){
			resetQueue();
			return;
		}
		
		//Process a move
		placeTile(event);
		
	}//end actionPerformed
	
	/**
	 * Resets the value of each tile in the queue
	 */
	private void resetQueue() {
		//Refreshes the queue the size of the queue panel
		for(int i = 0; i < QueuePanel.GRID_COLS; i++){
			model.pushQueue();
		}
		//Makes the resetQueue menu item disabled
		view.getResetQueue().setEnabled(false);
	}//end resetQueue
	
	/*
	 * Resets the variables of the game and creates a new board
	 */
	private void startNewGame(){//start startNewGame method
		//Resets queue
		resetQueue();
		//Enables queue reset option
		view.getResetQueue().setEnabled(true);
		//Repopulate board
		model.createNewGameBoard();	
	}//end startNewGame method
	
	/**
	 * Parses the coordinates of a tile that was clicked, and updates model accordingly
	 */
	private void placeTile(ActionEvent event) {
		
		//Parse the coordinates of the tile and sparked the ActionEvent
		int[] coordinates = parseActionCommand(event);
		int row = coordinates[0];
		int col = coordinates[1];
		
		//Now that we have the coordinates, process move if it is valid
		int value = model.getGameBoard().getTile(row, col).getValue();
		
		//If value equals -1, then the move is valid
		if(value == -1) {
			int mod = model.selectQueueTile(0).getValue();
			model.getGameBoard().getTile(row, col).setValue(mod);
			model.calculateSum(row, col, mod);
			model.pushQueue();
		} else {
			//Alert user that move is invalid
			view.invalidMoveEvent();
		}
	}//end placeTile
	
	/**
	 * Parse int coordinates from ActionEvent
	 * @param event, an ActionEvent
	 * @return coordinates[], an array of 2 elements containing row and col in index 0 and 1, respectively
	 */
	private int[] parseActionCommand(ActionEvent event) {
		
		int row = 0;
		int col = 0;
		char rowC;
		char colC;
		char[] token = event.getActionCommand().toCharArray();
		
		//Grab the char containing row and col, which are separated by a space in token
		rowC = token[0];
		colC = token[2];
		
		//Try to parse each of the coordinates to int
		try{
			row = Character.getNumericValue(rowC);
			col = Character.getNumericValue(colC);
		} catch (Exception e) {
			System.out.println("Fatal error parsing coordinates for tile event.");
			System.exit(1);
		}
		
		//Now that we have two int coordinates, load array and return
		int[] coordinates = new int[2];
		coordinates[0] = row;
		coordinates[1] = col;
		
		return coordinates;
		
	}//end parseActionCommand

}//end class Controller
