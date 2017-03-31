/*
 * The UntimeGame class controls the untimed version of the game
 * Blarghhh
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
	
	public UntimedGame(){
		//do some stuff 
		start();
	}
	
	public void start(){//initializes the game
		populateQueue();
		gameBoard = new GameBoard();
		//do other things
	}
	/*
	 * Returns the head of the queue
	 */
	public TileModel selectQueueTile(int i){//start selectQueueTile method
		
		return tileQueue.get(i);
	}//start selectQueueTile method
	
	public boolean placeTile(){//not actually implemented, only has a return statement to get rid of the errors
		return true;
	}
	
	private boolean processCornerMove(int i, int j){//not actually implemented, only has a return statement to get rid of the errors

		// check for interior tile
		if ((i >= 1 && i <= 7) && (j >= 1 && j <= 7)) {
			
			return false;
		}
		// check for corner move
		else if ((i == 0 || i == 8) && (j == 0 || j == 8)) {
			
			return true;
		}
		
	}
	
	private void populateQueue(){//initializes tileQueue with random values in the allowed range (inclusive)
		int num;
		for(int i=1; i<=5; i++){
			num=low + (int)(Math.random() * ((high - low) + 1));
			TileModel t=new TileModel(i-1);
			t.setValue(num);
			tileQueue.add(t);
		}
	}
	
	public void pushQueue(){//adds a new tile to the queue after one has been removed
		tileQueue.remove(0);
		int num=low + (int)(Math.random() * ((high - low) + 1));
		TileModel t=new TileModel(4);
		t.setValue(num);
		tileQueue.add(t);
		//this method is assuming that the GUI will automatically update itself with the queue methods. If it doesn't, this method will have to adjust. It has been tested with printouts, and does work, however.
	}
	
	private boolean calculateSum(int i, int j, int mod){
		
		//Retrieval of tile refenced by i and j
		TileModel t = Controller.getGameBoard().getTile(i, j);
		
		//running total of neighboring tile values
		int total = 0;
		//running count of neighboring tiles for poitn value (x10)
		int neighbors = 0;
		
		//checking all potential neighbors
		if(t.getEast()!=null){
			total += t.getEast().getValue();
			neighbors++;
		}
		if(t.getWest()!=null){
			total += t.getWest().getValue();
			neighbors++;
		}
		if(t.getNorth()!=null){
			total += t.getNorth().getValue();
			neighbors++;
		}
		if(t.getSouth()!=null){
			total += t.getSouth().getValue();
			neighbors++;
		}
		if(t.getNorthEast()!=null){
			total += t.getNorthEast().getValue();
			neighbors++;
		}
		if(t.getSouthEast()!=null){
			total += t.getSouthEast().getValue();
			neighbors++;
		}
		if(t.getNorthWest()!=null){
			total += t.getNorthWest().getValue();
			neighbors++;
		}
		if(t.getSouthWest()!=null){
			total += t.getSouthWest().getValue();
			neighbors++;
		}
		
		//Check if value of placed tile = total neighboring tile values modulo 10
		if((total%10) == mod){
			
			//Retrieves current score from scor label
			int currentScore = Integer.parseInt(Controller.getFrame().getScoreLabel().getText());
			
			//Sets value to previous + (number of neighbors * 10)
			currentScore += neighbors*10;
			
			//Retrieves score label and updates text to new score value
			Controller.getFrame().getScoreLabel().setText(Integer.toString(currentScore));
			
			//Removes placed tile
			Controller.getGameBoard().removeTile(i, j);
			
			//Running check to remove all neighboring tiles if used to score
			if(t.getEast()!=null){
				Controller.getGameBoard().removeTile(i+1, j);
			}
			if(t.getWest()!=null){
				Controller.getGameBoard().removeTile(i-1, j);
			}
			if(t.getNorth()!=null){
				Controller.getGameBoard().removeTile(i, j+1);
			}
			if(t.getSouth()!=null){
				Controller.getGameBoard().removeTile(i, j-1);
			}
			if(t.getNorthEast()!=null){
				Controller.getGameBoard().removeTile(i+1, j+1);
			}
			if(t.getSouthEast()!=null){
				Controller.getGameBoard().removeTile(i+1, j-1);
			}
			if(t.getNorthWest()!=null){
				Controller.getGameBoard().removeTile(i-1, j+1);
			}
			if(t.getSouthWest()!=null){
				Controller.getGameBoard().removeTile(i-1, j-1);
			}
		}
		
	}
	
					
	
	
	public GameBoard getGameBoard(){
		return gameBoard;
	}
	
}

//end of UntimedGame class
