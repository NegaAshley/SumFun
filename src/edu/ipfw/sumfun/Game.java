package edu.ipfw.sumfun;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Abstract class Game contains all shared methods and fields of UntimedGame and TimeGame
 * @author Jake
 *
 */
public abstract class Game extends Observable{//start Game class
	
	private ArrayList<TileModel> tileQueue = new ArrayList<>();//holds the queue of tiles
	private GameBoard gameBoard;//handles details of board state
	private int points;//holds the player's score
	private boolean isActive;//boolean to keep track of whether the game is active
	public static final int LOW_THRESHOLD = 0;//the lowest number that be randomly generated
	public static final int HIGH_THRESHOLD = 9;//the highest number that be randomly generated
	public static final int INITIAL_POINTS = 0;//the number of points the user starts with
	public static final int QUEUE_LENGTH = 5;//the length of the queue
	public static final int MIN_NUM_TILES_TO_SCORE = 3;//the minimum number of tiles removed need to score points
	public static final int TILE_SCORE_VALUE = 10;//the value given per tile when points are scored
	public static final int MOD_VALUE = 10;//the modulus value to calculate with
	
	public Game(){//start Game constructor
		points = INITIAL_POINTS;
		isActive = true;
		gameBoard = new GameBoard();
		populateQueue();
	}//end Game constructor
	
	/**
	 * Access method for field points
	 * @return points, a member field containing the user's score
	 */
	public int getPoints() {//start getPoints method
		return points;
	}//end getPoints method
	
	/*
	 * Returns the head of the queue
	 * @param i - the index of the tile
	 * @returns TileModel - the tile selected
	 */
	public TileModel selectQueueTile(int i){//start selectQueueTile method
		return tileQueue.get(i);
	}//start selectQueueTile method
	
	/**
	 * Populates the tileQueue with some values
	 */
	public void populateQueue(){//initializes tileQueue with random values in the allowed range (inclusive)
		int num;
		for(int i = 0; i < QUEUE_LENGTH ; i++){
			num = LOW_THRESHOLD + (int) (Math.random() * ((HIGH_THRESHOLD - LOW_THRESHOLD) + 1));
			TileModel t = new TileModel(i - 1);
			t.setValue(num);
			tileQueue.add(t);
		}
		setChanged();
		notifyObservers();
	}//end populateQueue
	
	/*
	 * Adds a new tile to the queue after one has been removed
	 */
	public void pushQueue(){//start pushQueue start
		TileModel t;//the tile to be added to the queue
		tileQueue.remove(0);
		int num = LOW_THRESHOLD + (int) (Math.random() * ((HIGH_THRESHOLD - LOW_THRESHOLD) + 1));
		t = new TileModel(num);
		tileQueue.add(t);
		setChanged();
		notifyObservers();
		//this method is assuming that the GUI will automatically update itself with the queue methods. If it doesn't, this method will have to adjust. It has been tested with printouts, and does work, however.
	}//end pushQueue method
	
	/**
	 * Calculates the sum of the tiles around the one at the given coordinates, and compares it to the given queue value, mod
	 * @param i the row of the clicked tile
	 * @param j the column of the clicked tile
	 * @param mod the queue value placed
	 */
	public void calculateSum(int i, int j, int mod){//start calculateSum method
		//Retrieval of tile referenced by i and j
		TileModel t = gameBoard.getTile(i, j);
		
		//Running total of neighboring tile values
		int total = 0;
		
		//Running count of neighboring tiles for point value (x10)
		int score = 0;
		
		//Checking all potential neighbors (omitting with value -1 so they don't mess up the total)
		if(t.getEast() != null && t.getEast().getValue()!=-1){
			total += t.getEast().getValue();
			score++;
		}
		if(t.getWest() != null && t.getWest().getValue()!=-1){
			total += t.getWest().getValue();
			score++;
		}
		if(t.getNorth() != null && t.getNorth().getValue()!=-1){
			total += t.getNorth().getValue();
			score++;
		}
		if(t.getSouth() != null && t.getSouth().getValue()!=-1){
			total += t.getSouth().getValue();
			score++;
		}
		if(t.getNorthEast() != null && t.getNorthEast().getValue()!=-1){
			total += t.getNorthEast().getValue();
			score++;
		}
		if(t.getSouthEast() != null && t.getSouthEast().getValue()!=-1){
			total += t.getSouthEast().getValue();
			score++;
		}
		if(t.getNorthWest() != null && t.getNorthWest().getValue()!=-1){
			total += t.getNorthWest().getValue();
			score++;
		}
		if(t.getSouthWest() != null && t.getSouthWest().getValue()!=-1){
			total += t.getSouthWest().getValue();
			score++;
		}
		
		//If the MIN_NUM_TILES_TO_SCORE or more tiles have been removed, calculate score
		//Otherwise, no score awarded
		if(score >= MIN_NUM_TILES_TO_SCORE) {
			score = score * TILE_SCORE_VALUE;
		} else {
			score = 0;
		}
		
		//Check if value of placed tile = total neighboring tile values modulo MOD_VALUE
		if((total % MOD_VALUE) == mod){
			
			//Update points with new score
			this.points += score;
			
			//Update tile and adjacent tiles
			removeAdjacentTiles(t);
			
			//Test print statement
			//System.out.println("Move successful");
			
			//Make calls to notifyObservers, etc
		}	
		
		if(gameBoard.isGameBoardEmpty() || gameBoard.isGameBoardFull()){
			isActive = false;
		}
		
		setChanged();
		notifyObservers();
		
	}//end calculateSum method
	
	/**
	 * set value of current tile and all adjacent tiles to -1
	 * @param t, the tile that has been placed
	 */
	private void removeAdjacentTiles(TileModel t) {//start removeAdjacentTiles method
		//Set value of placed tile to -1
		t.setValue(-1);
		
		//Set all adjacent tiles to -1, if they exist
		//checking all potential neighbors
		if(t.getEast() != null){
			t.getEast().setValue(-1);
		}
		if(t.getWest() != null){
			t.getWest().setValue(-1);
		}
		if(t.getNorth() != null){
			t.getNorth().setValue(-1);
		}
		if(t.getSouth() != null){
			t.getSouth().setValue(-1);
		}
		if(t.getNorthEast() != null){
			t.getNorthEast().setValue(-1);
		}
		if(t.getSouthEast() != null){
			t.getSouthEast().setValue(-1);
		}
		if(t.getNorthWest() != null){
			t.getNorthWest().setValue(-1);
		}
		if(t.getSouthWest() != null){
			t.getSouthWest().setValue(-1);
		}
	}//end removeAdjacentTiles method
	
	/**
	 * Accessor method for gameBoard
	 * @return gameBoard
	 */
	public GameBoard getGameBoard(){//start getGameBoard method
		return gameBoard;
	}//end getGameBoard method
	
	/*
	 * Accessor method for isActive
	 * @return isActive - boolean to keep track of whether the game is active
	 */
	public boolean getIsActive(){//start getIsActive method
		return isActive;
	}//end getIsActive method
	/*
	 * Setter for isActive
	 * @param newIsActive - the new value for isActive
	 */
	public void setIsActive(boolean newIsActive){//start setIsActive method
		isActive = newIsActive;
	}//end setIsActive method
	/*
	 * Creates a new GameBoard
	 */
	public void createNewGameBoard(){//start createNewGameBoard method
		gameBoard = new GameBoard();
		points = INITIAL_POINTS;
		isActive = true;
		setChanged();
		notifyObservers();
	}//end createNewGameBoard method
	
	
}//end Game class
