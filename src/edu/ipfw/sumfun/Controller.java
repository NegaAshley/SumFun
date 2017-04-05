package edu.ipfw.sumfun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Jake
 *
 */
public class Controller implements ActionListener {
	
	private static final boolean GUI_VISIBLE = true;
	
	private UntimedGame model;
	private SumFunFrame view;
	
	/**
	 * Constructor
	 * @param u, an instance of UntimedGame (the system's model)
	 */
	public Controller(UntimedGame u) {
		model = u;
		view = new SumFunFrame(model, this);
		view.setVisible(GUI_VISIBLE);
	}

	/**
	 * Process all actions that need to occur due to user input
	 * Uses event.getActionCommand to determine what changes need to occur
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		
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
		
	}//end actionPerformed
	
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
	
	/**
	 * 
	 * @param c, any single character
	 * @return whether or not that character is a digit
	 */
	private boolean isNumeric(char c) {
		
		boolean answer = ((c == '0') || (c == '1') || (c == '2') || (c == '3') || (c == '4')
				|| (c == '5') || (c == '6') || (c == '7') || (c == '8') || (c == '9'));
		return answer;
		
	}//end isNumeric

}//end class Controller
