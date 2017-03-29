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
	
	public UntimedGame(){
		//do some stuff 
		start();
	}
	
	public void start(){//initializes the game
		populateQueue();
		gameBoard = new GameBoard();
		//do other things
	}
	
	public TileModel selectQueueTile(int i){//returns the head of the queue
		
		return tileQueue.get(i);
	}
	
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
	
	private boolean calculateSum(int i, int j, int mod){//not actually implemented, only has a return statement to get rid of the errors
		
		TileModel t = Controller.getGameBoard().getTile(i, j);
		
		int total = 0;
		int neighbors = 0;
		
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
		
		
		if((total%10) == mod){
			
			int currentScore = Integer.parseInt(Controller.getFrame().getScoreLabel().getText());
			currentScore += neighbors*10;
			Controller.getFrame().getScoreLabel().setText(Integer.toString(currentScore));
			Controller.getGameBoard().removeTile(i, j);
			
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
