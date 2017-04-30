package edu.ipfw.sumfun;

import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * 
 * @author Jake
 *
 */
public class Controller implements ActionListener {// start Controller class

	// Various constants for use throughout Controller
	private static final boolean GUI_VISIBLE = true;
	private static final String RESET_QUEUE = "Reset Queue";
	private static final String REMOVE_NUMBER = "Remove Number";
	private static final String NEW_GAME = "New Game";
	private static final String GET_USER_NAME = "Get User Name";
	private static final String HINT = "Hint";
	public static final String GREEN_HEX_VALUE = "0x00cc00";// the color green
															// used for hint
															// tiles
	public static final int TILE_GRID_WIDTH = 9;// the width of the grid in
												// tiles
	public static final int TILE_GRID_LENGTH = 9;// the length of the grid in
													// tiles
	public static final int MAX_HINTS = 3;// the number of hints available
	private int hintsUsed = 0;// the number of hints currently used

	// References to model, view, and TopPointPlayers objects
	private Game model;
	private SumFunFrame view;
	private TopPointPlayers tpp;
	private TopTimePlayers ttp;
	
	/**
	 * Constructor for the Controller class
	 * 
	 * @param u,
	 *            an instance of UntimedGame (the system's model)
	 * @throws IOException
	 * @throws FontFormatException
	 * @throws UnsupportedAudioFileException 
	 * @throws URISyntaxException 
	 * @throws NumberFormatException 
	 */
	public Controller(Game game, TopPointPlayers tpp, TopTimePlayers ttp) throws 
	IOException, FontFormatException, NumberFormatException, URISyntaxException, 
	UnsupportedAudioFileException {// start
		// Controller constructor
		Sounds.init(); // Initialize and preload sounds
		model = game;
		this.tpp = tpp;
		this.ttp = ttp;
		view = new SumFunFrame(model, this, tpp, ttp);
		int[] rowAndCol = model.getHint();
		if (rowAndCol[0] == -1 || rowAndCol[1] == -1) {
			view.getHint().setEnabled(false);
		} else {
			view.getHint().setEnabled(true);
		}
		view.setVisible(GUI_VISIBLE);
	}// end Constructor method

	/**
	 * Process all actions that need to occur due to user input Uses
	 * event.getActionCommand to determine what changes need to occur
	 * 
	 * @param event
	 *            - the event occuring
	 */
	@Override
	public void actionPerformed(ActionEvent event) {// start actionPerformed method

		// Starts a new UntimedGame
		if (event.getActionCommand().equals("Untimed")) {
			startNewUntimedGame();
			int[] rowAndCol = model.getHint();
			if (rowAndCol[0] == -1 || rowAndCol[1] == -1) {
				view.getHint().setEnabled(false);
			} else {
				view.getHint().setEnabled(true);
			}
			return;
		}

		// Starts a new TimedGame
		if (event.getActionCommand().equals("Timed")) {
			startNewTimedGame();
			int[] rowAndCol = model.getHint();
			if (rowAndCol[0] == -1 || rowAndCol[1] == -1) {
				view.getHint().setEnabled(false);
			} else {
				view.getHint().setEnabled(true);
			}
			return;
		}

		// Check for an event that needs to reset the queue
		if (event.getActionCommand().equals(RESET_QUEUE)) {
			if (model.getQueueResetAvailable()) {
				model.setQueueResetAvailable(false);
				resetQueue();
				Sounds.SHUFFLE.play();
			}

			return;
		}

		// Check for an event that needs to remove all of one number from the
		// board
		if (event.getActionCommand().equals(REMOVE_NUMBER)) {
			model.setRemoveNumActive(true);
			return;
		}

		// Check for an event that needs to give a hint
		if (event.getActionCommand().equals(HINT)) {
			int[] rowAndCol = model.getHint();
		
			TileModel hintTile = model.getGameBoard().getTile(rowAndCol[0], 
					rowAndCol[1]);
			hintTile.setValue(-2);
			hintsUsed++;
			view.getHint().setEnabled(false);
			view.repaint();
			return;
		}

		if (event.getActionCommand().equals("Game Over")) {

			if (model instanceof UntimedGame) {
				startNewUntimedGame();
			} else if (model instanceof TimedGame) {
				startNewTimedGame();
			}

			return;

		}

		// Checks for an event that needs to grab user name and closes popup
		if (event.getActionCommand().equals(GET_USER_NAME)) {
			String userName;// the name of the user
			int moves = 0;// the number of moves left
			int points = 0;// the number of points
			int time = 0;

			// Assigns the username to a variable from the text box
			view.getUserNameDialog().assignUserName();

			// Sets the local variable username
			userName = view.getUserNameDialog().getUserName();

			// Sets the local variable points
			points = model.getPoints();

			// Sets the local variable moves
			if (model instanceof UntimedGame) {
				UntimedGame temp = (UntimedGame) model;
				moves = temp.getMovesRemaining();
				// Creates the record with given variables
				ScoreRecord record = new ScoreRecord(userName, moves, points);

				// Adds a record to the top point players
				tpp.addRecord(record);
			} else if (model instanceof TimedGame) {
				TimedGame temp = (TimedGame) model;
				time = temp.getDuration();
				TimeRecord record = new TimeRecord(userName, time, 
						TimedGame.getInitialTime());
				ttp.addRecord(record);
			}

			// Disposes the dialog box
			view.getUserNameDialog().dispose();

			// Starts a new game of chosen type
			if (model instanceof UntimedGame) {
				startNewUntimedGame();
			} else if (model instanceof TimedGame) {
				startNewTimedGame();
			}
			view.setVisible(true);
			return;
		}

		// If the Remove Number menu option is active, process that event
		if (model.getRemoveNumActive() == true) {
			model.setRemoveNumAvailable(false);
			removeNumber(event);
			model.setRemoveNumActive(false);
			return;
		}
		// Process a move
	
			placeTile(event);
	

	}// end actionPerformed

	/**
	 * Resets the value of each tile in the queue
	 */
	private void resetQueue() {// start resetQueue method

		// Refreshes the queue the size of the queue panel
		// clear out any hint tile that is present
		int[] rowAndCol = model.getKnownHint();
		if (rowAndCol[0] == -1 || rowAndCol[1] == -1) {
			view.getHint().setEnabled(false);
		} else {
			TileModel hintTile = model.getGameBoard().getTile(rowAndCol[0], 
					rowAndCol[1]);
			hintTile.setValue(-1);
			view.repaint();
		}
		for (int i = 0; i < QueuePanel.GRID_COLS; i++) {
			model.pushQueue();
		}

	}// end resetQueue

	/*
	 * Removes selected number from the board
	 * 
	 * @param - event - the mouse click
	 */
	private void removeNumber(ActionEvent event) {// start removeNumber method
		// Doesn't allow action to happen is board is inactive
		if (model.getIsActive() == false) {
			return;
		}

		// Parse the coordinates of the tile and sparked the ActionEvent
		int[] coordinates = parseActionCommand(event);
		int row = coordinates[0];
		int col = coordinates[1];

		// Get value of tile
		int value = model.getGameBoard().getTile(row, col).getValue();

		// Clear out hint coloring every time a move is placed, no matter
		// whether they chose to listen to the hint or not
		int[] rowAndCol = model.getKnownHint();
		if (rowAndCol[0] == -1 || rowAndCol[1] == -1) {
			view.getHint().setEnabled(false);
		} else {
			TileModel hintTile = model.getGameBoard().getTile(rowAndCol[0], 
					rowAndCol[1]);
			hintTile.setValue(-1);
			view.repaint();
		}

		if (value != -1) {
			model.removeNumFromGame(value);
		} else {
			// Alert user that move is invalid
			view.invalidRemoveNumMoveEvent();
		}
		Sounds.REMOVE.play();
	}// end removeNumber method

	/**
	 * Initiates a new UntimedGame
	 */
	private void startNewUntimedGame() {// start startNewUntimedGame method
		model = UntimedGame.getInstance();
		view.setModel(UntimedGame.getInstance());
		resetQueue();
		view.getResetQueue().setEnabled(true);
		view.getRemoveNumber().setEnabled(true);
		view.setMoveLabelVisible(true);
		view.setTimeLabelVisible(false);
		model.createNewGameBoard();
		hintsUsed = 0;
		int[] rowAndCol = model.getHint();
		if (rowAndCol[0] == -1 || rowAndCol[1] == -1) {
			view.getHint().setEnabled(false);
		}
	}// end startNewUntimedGame method

	/**
	 * Initiates a new TimedGame
	 */
	private void startNewTimedGame() {// start startNewTimedGame method
		model = TimedGame.getInstance();
		TimedGame temp = (TimedGame) model;
		temp.setNewTimer();
		view.setModel(model);
		resetQueue();
		view.getResetQueue().setEnabled(true);
		view.getRemoveNumber().setEnabled(true);
		view.setMoveLabelVisible(false);
		view.setTimeLabelVisible(true);
		model.createNewGameBoard();
		hintsUsed = 0;
		int[] rowAndCol = model.getHint();
		if (rowAndCol[0] == -1 || rowAndCol[1] == -1) {
			view.getHint().setEnabled(false);
		}
	}// end startNewTimedGame method

	/**
	 * Parses the coordinates of a tile that was clicked, and updates model
	 * accordingly
	 * @param event - the ActionEvent of the click
	 * @throws IOException 
	 */
	private void placeTile(ActionEvent event) {// start placeTile method
		// Doesn't allow tiles to be placed if board is inactive
		
		if (model.getIsActive() == false) {
			return;
		}

		// Parse the coordinates of the tile and sparked the ActionEvent
		int[] coordinates = parseActionCommand(event);
		int row = coordinates[0];
		int col = coordinates[1];

		// Now that we have the coordinates, process move if it is valid
		int value = model.getGameBoard().getTile(row, col).getValue();

		// If value equals -1, then the move is valid
		if (value == -1 || value == -2) {
			// Clear out hint coloring every time a move is placed, no matter
			// whether they chose
			// to listen to the hint or not and make sure button is disabled as
			// needed
			int[] rowAndCol = model.getKnownHint();
			if (rowAndCol[0] == -1 || rowAndCol[1] == -1) {
				view.getHint().setEnabled(false);
			} else {
				TileModel hintTile = model.getGameBoard().getTile(rowAndCol[0], 
						rowAndCol[1]);
				hintTile.setValue(-1);
				view.repaint();
				
			}

			int mod = model.selectQueueTile(0).getValue();
			model.processMove(row, col, mod);
			model.pushQueue();

			// check the move for the next turn, and turn off or on the hint
			// button accordingly
			rowAndCol = model.getHint();
			if (rowAndCol[0] == -1 || rowAndCol[1] == -1) {
				view.getHint().setEnabled(false);
			} else if (hintsUsed < MAX_HINTS) {
				view.getHint().setEnabled(true);
			}
			Sounds.BOOP.play();
		} else {
			// Alert user that move is invalid
			view.invalidMoveEvent();
		}

	}// end placeTile method

	/**
	 * Parse int coordinates from ActionEvent
	 * 
	 * @param event,
	 *            an ActionEvent
	 * @return coordinates[], an array of 2 elements containing row and col in
	 *         index 0 and 1, respectively
	 */
	private int[] parseActionCommand(ActionEvent event) {// start
															// parseActionCommand
															// method

		int row = 0;
		int col = 0;
		char rowC;
		char colC;
		char[] token = event.getActionCommand().toCharArray();

		// Grab the char containing row and col, which are separated by a space
		// in token
		rowC = token[0];
		colC = token[2];

		// Try to parse each of the coordinates to int
		try {
			row = Character.getNumericValue(rowC);
			col = Character.getNumericValue(colC);
		} catch (Exception e) {
			System.out.println("Fatal error parsing coordinates for tile event.");
			System.exit(1);
		}

		// Now that we have two int coordinates, load array and return
		int[] coordinates = new int[2];
		coordinates[0] = row;
		coordinates[1] = col;

		return coordinates;

	}// end parseActionCommand method

}// end Controller class
