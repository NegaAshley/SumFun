/*
 * The UntimeGame class controls the untimed version of the game
 */

package edu.ipfw.sumfun;
import java.util.*;

/**
 * 
 * @author Jake
 *
 */
public class UntimedGame {
	
	private int movesRemaining;//counter of number of moves remaining, decrements with each successful move
	private ArrayList<TileModel> tileQueue = new ArrayList<>();//holds the queue of tiles
	private GameBoard gameBoard;//handles details of board state
	private int points;//holds the player's score
	private int low = 0;//the lowest number that be randomly generated
	private int high = 9;//the highest number that be randomly generated
	
	/**
	 * Constructor
	 */
	public UntimedGame(){
		gameBoard = new GameBoard();
		populateQueue();
	}//end Constructor
	
	/*
	 * Returns the head of the queue
	 */
	public TileModel selectQueueTile(int i){//start selectQueueTile method
		return tileQueue.get(i);
	}//start selectQueueTile method
	
	/**
	 * Places a tile at the given location by simply replacing the value
	 * of the current tile with the value of the selected tile
	 * @return true if tile successfully removed adjacent tiles
	 */
	public void placeTile(int i, int j){	
		gameBoard.setTile(i, j, tileQueue.get(0).getValue());
		calculateSum(i, j, tileQueue.get(0).getValue());
	}//end placeTile
	
	/**
	 * populates the tileQueue with some values
	 */
	private void populateQueue(){//initializes tileQueue with random values in the allowed range (inclusive)
		int num;
		for(int i=1; i<=5; i++){
			num=low + (int)(Math.random() * ((high - low) + 1));
			TileModel t=new TileModel(i-1);
			t.setValue(num);
			tileQueue.add(t);
		}
	}//end populateQueue
	
	public void pushQueue(){//adds a new tile to the queue after one has been removed
		tileQueue.remove(0);
		int num=low + (int)(Math.random() * ((high - low) + 1));
		TileModel t=new TileModel(4);
		t.setValue(num);
		tileQueue.add(t);
		//this method is assuming that the GUI will automatically update itself with the queue methods. If it doesn't, this method will have to adjust. It has been tested with printouts, and does work, however.
	}
	
	public void calculateSum(int i, int j, int mod){
		
		System.out.println("calculate sum reached");
		
		//Retrieval of tile referenced by i and j
		
		TileModel t = gameBoard.getTile(i, j);
		
		//running total of neighboring tile values
		int total = 0;
		//running count of neighboring tiles for point value (x10)
		int score = 0;
		
		//checking all potential neighbors (omitting with value -1 so they don't mess up the total)
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
		
		//Update score (10 points per tile)
		score = score * 10;
		
		//Check if value of placed tile = total neighboring tile values modulo 10
		if((total % 10) == mod){
			
			//Update points with new score
			this.points += score;
			
			//Update tile and adjacent tiles
			removeAdjacentTiles(t);
			
			System.out.println("move successful");
			
			//Make calls to notifyObservers, etc

		}
		
	}//end calculateSum
	
	/**
	 * set value of current tile and all adjacent tiles to -1
	 * @param t, the tile that has been placed
	 */
	private void removeAdjacentTiles(TileModel t) {
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
	}//end updateTiles
	
	/**
	 * Access method for gameBoard
	 * @return gameBoard
	 */
	public GameBoard getGameBoard(){
		return gameBoard;
	}//end getGameBoard
	
}//end of UntimedGame class