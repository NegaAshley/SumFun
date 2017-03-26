/*
 * The UntimeGame class controls the untimed version of the game
 */

package edu.ipfw.sumfun;
import java.awt.Color;
import java.util.*;

public class UntimedGame {
	private int movesRemaining;//counter of number of moves remaining, decrements with each successful move
	private ArrayList<Tile> tileQueue=new ArrayList<>();//holds the queue of tiles
	private GameBoard gameBoard;//handles details of board state
	private int points;//holds the player's score
	private int low=0;//the lowest number that be randomly generated
	private int high=9;//the highest number that be randomly generated
	
	public UntimedGame(){
		//do some stuff 
		start();
	}
	
	public void start(){//initializes the game
		populateQueue();
		//do other things
	}
	
	public Tile selectQueueTile(){//returns the head of the queue
		return tileQueue.get(0);
	}
	
	public boolean placeTile(){//not actually implemented, only has a return statement to get rid of the errors
		return true;
	}
	
	private boolean processCornerMove(){//not actually implemented, only has a return statement to get rid of the errors
		return true;
	}
	
	private void populateQueue(){//initializes tileQueue with random values in the allowed range (inclusive)
		int num;
		for(int i=1; i<=5; i++){
			num=low + (int)(Math.random() * ((high - low) + 1));
			Tile t=new Tile(i-1, 0, Color.gray);
			t.setValue(num);
			tileQueue.add(t);
		}
	}
	
	private void pushQueue(){//adds a new tile to the queue after one has been removed
		tileQueue.remove(0);
		int num=low + (int)(Math.random() * ((high - low) + 1));
		Tile t=new Tile(4, 0, Color.gray);
		t.setValue(num);
		tileQueue.add(t);
		//this method is assuming that the GUI will automatically update itself with the queue methods. If it doesn't, this method will have to adjust. It has been tested with printouts, and does work, however.
	}
	
	private boolean calculateSum(int mod){//not actually implemented, only has a return statement to get rid of the errors
		return true;
	}
	
}

//end of UntimedGame class
