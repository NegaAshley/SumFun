package edu.ipfw.sumfun;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Abstract class Game contains all shared methods and fields of UntimedGame and
 * TimeGame
 * 
 * @author Jake
 *
 */
public abstract class Game extends Observable {// start Game class

	private ArrayList<TileModel> tileQueue = new ArrayList<>();// holds the
		//queue of tiles
	private GameBoard gameBoard;// handles details of board state
	private int points;// holds the player's score
	private boolean isActive;// boolean to keep track of whether the game is active
	private boolean removeNumAvailable;//boolean to keep track of whether remove 
		//number option was used
	private boolean removeNumActive;//boolean to keep track of whether remove number 
		//action is active currently
	private boolean queueResetAvailable;//boolean to keep track of if the reset queue
		//option is available
	private boolean gameWon;//boolean to keep track of if the game has been won
	public static final int LOW_THRESHOLD = 0;// the lowest number that be randomly 
		//generated
	public static final int HIGH_THRESHOLD = 9;// the highest number that be randomly 
		//generated
	public static final int INITIAL_POINTS = 0;// the number of points the user starts 
		//with
	public static final int QUEUE_LENGTH = 5;// the length of the queue
	public static final int MIN_NUM_TILES_TO_SCORE = 3;// the minimum number of tiles 
		//removed need to score points
	public static final int TILE_SCORE_VALUE = 10;// the value given per tile when 
		//points are scored
	public static final int MOD_VALUE = 10;// the modulus value to calculate with
	public static final int TILE_GRID_WIDTH = 9;//the width of the grid in tiles
	public static final int TILE_GRID_LENGTH = 9;//the length of the grid in tiles

	public Game() {// start Game constructor
		points = INITIAL_POINTS;
		isActive = true;
		removeNumAvailable = true;
		removeNumActive = false;
		queueResetAvailable = true;
		gameWon = false;
		gameBoard = new GameBoard();
		populateQueue();
	}// end Game constructor

	/**
	 * Accessor method for field points
	 * 
	 * @return points - a member field containing the user's score
	 */
	public int getPoints() {// start getPoints method
		return points;
	}// end getPoints method

	/*
	 * Returns the head of the queue
	 * 
	 * @param i - the index of the tile
	 * 
	 * @returns TileModel - the tile selected
	 */
	public TileModel selectQueueTile(int i) {// start selectQueueTile method
		return tileQueue.get(i);
	}// start selectQueueTile method

	/**
	 * Populates the tileQueue with some values
	 */
	public void populateQueue() {// start populateQueue method
		// Initializes tileQueue with random values in the allowed range
		// (inclusive)
		int num;
		for (int i = 0; i < QUEUE_LENGTH; i++) {
			num = LOW_THRESHOLD + (int) (Math.random() * ((HIGH_THRESHOLD - 
					LOW_THRESHOLD) + 1));
			TileModel t = new TileModel(i - 1);
			t.setValue(num);
			tileQueue.add(t);
		}
		setChanged();
		notifyObservers();
	}// end populateQueue method

	/*
	 * Adds a new tile to the queue after one has been removed
	 */
	public void pushQueue() {// start pushQueue method
		TileModel t;// the tile to be added to the queue
		tileQueue.remove(0);
		int num = LOW_THRESHOLD + (int) (Math.random() * ((HIGH_THRESHOLD - 
				LOW_THRESHOLD) + 1));
		t = new TileModel(num);
		tileQueue.add(t);
		setChanged();
		notifyObservers();
	}// end pushQueue method

	/**
	 * Calculates the sum of the tiles around the one at the given coordinates,
	 * and compares it to the given queue value, mod
	 * 
	 * @param i - the row of the clicked tile
	 * @param j - the column of the clicked tile
	 * @param mod - the queue value placed
	 */
	public void processMove(int i, int j, int mod) {// start processMove method
		// Retrieval of tile referenced by i and j
		TileModel t = gameBoard.getTile(i, j);
		gameBoard.getTile(i, j).setValue(mod);
		
		// Array holding the values for total and score, returned from
		// sumAdjacentTiles with total at index 0 and score at index 0
		int[] totalAndScore;

		// Running total of neighboring tile values
		int total;

		// Running count of neighboring tiles for point value (x10)
		int score;

		// Check neighbors and store values received
		totalAndScore = sumAdjacentTiles(t);
		total = totalAndScore[0];
		score = totalAndScore[1];

		// If the MIN_NUM_TILES_TO_SCORE or more tiles have been removed,
		// calculate score
		// Otherwise, no score awarded
		if (score >= MIN_NUM_TILES_TO_SCORE) {
			score = score * TILE_SCORE_VALUE;
		} else {
			score = 0;
		}

		// Check if value of placed tile = total neighboring tile values modulo
		// MOD_VALUE
		if ((total % MOD_VALUE) == mod) {

			// Update points with new score
			this.points += score;

			// Update tile and adjacent tiles
			removeAdjacentTiles(t);

		}
		
		if(gameBoard.isGameBoardEmpty()) {
			isActive = false;
			gameWon = true;
			Sounds.BGM1.stopLoop();
		} else if (gameBoard.isGameBoardFull()) {
			isActive = false;
			gameWon = false;
			Sounds.BGM1.stopLoop();
		}
		
		setChanged();
		notifyObservers();

	}//end processMove method

	/**
	 * Sums the neighboring tiles of the given tile and returns and array
	 * containing that total sum at index 0 and the number of neighbors that
	 * would be removed if the move is valid at index 1
	 * 
	 * @param t - the selected tile
	 * @return totalAndScore - an array representing the total and score
	 */
	private int[] sumAdjacentTiles(TileModel t) {//start sumAdjacentTiles method
		int totalIndex = 0;
		int scoreIndex = 1;
		int[] totalAndScore = { 0, 0 };

		// Checking all potential neighbors (omitting with value -1 so they
		// don't mess up the total)
		if (t.getEast() != null && t.getEast().getValue() != -1) {
			totalAndScore[totalIndex] += t.getEast().getValue();
			totalAndScore[scoreIndex]++;
		}
		if (t.getWest() != null && t.getWest().getValue() != -1) {
			totalAndScore[totalIndex] += t.getWest().getValue();
			totalAndScore[scoreIndex]++;
		}
		if (t.getNorth() != null && t.getNorth().getValue() != -1) {
			totalAndScore[totalIndex] += t.getNorth().getValue();
			totalAndScore[scoreIndex]++;
		}
		if (t.getSouth() != null && t.getSouth().getValue() != -1) {
			totalAndScore[totalIndex] += t.getSouth().getValue();
			totalAndScore[scoreIndex]++;
		}
		if (t.getNorthEast() != null && t.getNorthEast().getValue() != -1) {
			totalAndScore[totalIndex] += t.getNorthEast().getValue();
			totalAndScore[scoreIndex]++;
		}
		if (t.getSouthEast() != null && t.getSouthEast().getValue() != -1) {
			totalAndScore[totalIndex] += t.getSouthEast().getValue();
			totalAndScore[scoreIndex]++;
		}
		if (t.getNorthWest() != null && t.getNorthWest().getValue() != -1) {
			totalAndScore[totalIndex] += t.getNorthWest().getValue();
			totalAndScore[scoreIndex]++;
		}
		if (t.getSouthWest() != null && t.getSouthWest().getValue() != -1) {
			totalAndScore[totalIndex] += t.getSouthWest().getValue();
			totalAndScore[scoreIndex]++;
		}

		return totalAndScore;
	}//end sumAdjacentTiles method

	/**
	 * Set value of current tile and all adjacent tiles to -1
	 * 
	 * @param t - the tile that has been placed
	 */
	private void removeAdjacentTiles(TileModel t) {// start removeAdjacentTiles
		//method
		// Set value of placed tile to -1
		t.setValue(-1);

		// Set all adjacent tiles to -1, if they exist
		// checking all potential neighbors
		if (t.getEast() != null) {
			t.getEast().setValue(-1);
		}
		if (t.getWest() != null) {
			t.getWest().setValue(-1);
		}
		if (t.getNorth() != null) {
			t.getNorth().setValue(-1);
		}
		if (t.getSouth() != null) {
			t.getSouth().setValue(-1);
		}
		if (t.getNorthEast() != null) {
			t.getNorthEast().setValue(-1);
		}
		if (t.getSouthEast() != null) {
			t.getSouthEast().setValue(-1);
		}
		if (t.getNorthWest() != null) {
			t.getNorthWest().setValue(-1);
		}
		if (t.getSouthWest() != null) {
			t.getSouthWest().setValue(-1);
		}
	}// end removeAdjacentTiles method

	/*
	 * Method to return the location represented in rows and columns of the place
	 * where placing a tile will generate the most points.
	 * 
	 * @return rowAndCol - the row and column representation of where the hint is 
	 * located
	 */
	public int[] getHint() {//start getHint method
		//Array holding the values for total and score, returned from 
		//sumAdjacentTiles with total at index 0 and score at index 0
		int[] totalAndScore;
		int[] rowAndCol={0, 0};

		//Running total of neighboring tile values
		int total;

		//Running count of neighboring tiles for point value (x10)
		int currentScore;
		
		//Keep track of the best score, corresponding with the best tile to make a move at
		int bestScore=0;
		
		//If -1, -1 is returned, the Controller knows there is no good move and handles the results accordingly
		int bestRow=-1;
		int bestCol=-1;

		//Create the tile to be referenced here so there is not a new one created for every single tile on the board
		TileModel currentTile;
		
		//The tile at which the best move could be made
		TileModel bestTile;

		//Iterate through the board, storing the current best move
		for (int row = 0; row < TILE_GRID_WIDTH; row++) {
			for (int col = 0; col < TILE_GRID_LENGTH; col++) {
				// Retrieval of tile referenced by row and col
				currentTile= gameBoard.getTile(row, col);
				
				if(currentTile.getValue() == -1){//only check empty tiles
					// check neighbors and store values received
					totalAndScore = sumAdjacentTiles(currentTile);
					total = totalAndScore[0];
					currentScore = totalAndScore[1];

					// If the MIN_NUM_TILES_TO_SCORE or more tiles have been removed, calculate score. Otherwise, no score awarded
					if (currentScore >= MIN_NUM_TILES_TO_SCORE) {
						currentScore = currentScore * TILE_SCORE_VALUE;
					} else {
						currentScore = 0;
					}

					// Check if value of placed tile = total neighboring tile values modulo MOD_VALUE
					if ((total % MOD_VALUE) == selectQueueTile(0).getValue()) {
						if(currentScore>bestScore){
							bestScore = currentScore;
							bestTile = currentTile;
							bestRow = row;
							bestCol = col;
						}
					}
				}

			}
		}
		rowAndCol[0] = bestRow;
		rowAndCol[1] = bestCol;
		return rowAndCol;
	}//end getHint method
	
	/**
	 * Finds the tile marked as a hint to reset
	 * @return rowAndCol - position of hint tile
	 */
	public int[] getKnownHint() {//start getHint method
		//Row and col of known hint
		int[] rowAndCol = {0, 0};

	
		
		//If -1, -1 is returned, the Controller knows there is no hint displayed
		int defaultRow = -1;
		int defaultCol = -1;

		//Create the tile to be referenced here so there is not a new one created for every single tile on the board
		TileModel currentTile;
		
		//The tile at which the best move could be made
		TileModel markedTile;

		//Iterate through the board, storing the current best move
		for (int row = 0; row < TILE_GRID_WIDTH; row++) {
			for (int col = 0; col < TILE_GRID_LENGTH; col++) {
				// Retrieval of tile referenced by row and col
				currentTile= gameBoard.getTile(row, col);
				
				if(currentTile.getValue()==-2){//only check marked tiles
					
					rowAndCol[0] = row;
					rowAndCol[1] = col;
					return rowAndCol;
				}

			}
		}
		rowAndCol[0] = defaultRow;
		rowAndCol[1] = defaultCol;
		return rowAndCol;
	}//end getKnownHint method

	/*
	 * Removes all tiles with value givenNum from the gameBoard.  A precondition is that 
	 * input is within bounds of tiles in game.
	 * @param givenNum - the value of the tiles that we want to remove from the board
	 */
	public void removeNumFromGame(int givenNum){//start removeNumFromGame
		//Create the tile to be referenced here so there is not a new one created for every single tile on the board
		TileModel currentTile;
		
		for(int row = 0; row < TILE_GRID_WIDTH; row++){
			for(int col = 0; col < TILE_GRID_LENGTH; col++){
				// Retrieval of tile referenced by row and col
				currentTile= gameBoard.getTile(row, col);
				if(currentTile.getValue() == givenNum){
					//sets the tile to an empty tile
					currentTile.setValue(-1);
				}
			}
		}
		if(gameBoard.isGameBoardEmpty()) {
			isActive = false;
			gameWon = true;
		} else if (gameBoard.isGameBoardFull()) {
			isActive = false;
			gameWon = false;
		}
		setChanged();
		notifyObservers();
	}//end removeNumFromGame
	
	/**
	 * Accessor method for gameBoard
	 * 
	 * @return gameBoard - the representation of the GameBoard
	 */
	public GameBoard getGameBoard() {// start getGameBoard method
		return gameBoard;
	}// end getGameBoard method

	/*
	 * Accessor method for isActive
	 * 
	 * @return isActive - boolean to keep track of whether the game is active
	 */
	public boolean getIsActive() {// start getIsActive method
		return isActive;
	}// end getIsActive method
	
	/**
	 * Access method for getGameWon
	 * @return gameWon, a boolean that keeps track of whether or not the game has been won
	 */
	public boolean getGameWon() {//start getGameWon method
		return gameWon;
	}//end getGameWon
	
	/*
	 * Setter for isActive
	 * 
	 * @param newIsActive - the new value for isActive
	 */

	public void setIsActive(boolean newIsActive) {//start setIsActive method
		isActive = newIsActive;
	}// end setIsActive method
	
	public void setGameWon(boolean gameWon) {
		this.gameWon = gameWon;
		}
	
	/*
	 * Acessor method for removeNumAvailable
	 * 
	 * @return removeNumAvailable - boolean to keep track of whether remove number 
	 * option was used
	 */
	public boolean getRemoveNumAvailable(){//start getRemoveNumAvailable method
		return removeNumAvailable;
	}//end getRemoveNumAvailable method

	/*
	 * Setter for removeNumAvailable
	 * 
	 * @param newRemoveNumAvailable
	 */
	public void setRemoveNumAvailable(boolean newRemoveNumAvailable){//start 
		//setRemoveNumAvailable method
		removeNumAvailable = newRemoveNumAvailable;
	}//end setRemoveNumAvailable method
	
	/*
	 * Acessor method for removeNumActive
	 * 
	 * @return removeNumActive - boolean to keep track of whether remove number option 
	 * was used
	 */
	public boolean getRemoveNumActive(){//start getRemoveNumActive method
		return removeNumActive;
	}//end getRemoveNumActivemethod
	
	/*
	 * Getter for removeNumActive
	 * 
	 * @return queueResetAvailable - the boolean representation of whether or not the
	 * queue reset is available
	 */
	public boolean getQueueResetAvailable(){//start getRemoveNumActive method
		return queueResetAvailable;
	}//end getRemoveNumActive method

	/*
	 * Setter for removeNumActive
	 * 
	 * @param newRemoveNumActive
	 */
	public void setRemoveNumActive(boolean newRemoveNumActive){//start 
		//setRemoveNumActive method
		removeNumActive = newRemoveNumActive;
	}//end setRemoveNumActive method
	
	/*
	 * Setter for removeNumActive
	 * 
	 * @param queueResetAvailable - the boolean representation of whether or not the
	 * queue reset is available
	 */
	public void setQueueResetAvailable(boolean queueResetAvailable){//start 
		//setRemoveNumActive method
		this.queueResetAvailable = queueResetAvailable;
	}//end setRemoveNumActive method
	
	/*
	 * Creates a new GameBoard
	 */
	public void createNewGameBoard() {//start createNewGameBoard method
		gameBoard = new GameBoard();
		points = INITIAL_POINTS;
		isActive = true;
		queueResetAvailable = true;
		removeNumAvailable = true;
		removeNumActive = false;
		setChanged();
		notifyObservers();
	}//end createNewGameBoard method

}//end Game class
