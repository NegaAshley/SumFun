package edu.ipfw.sumfun;

/**
 * The UntimedGame class controls the untimed version of the game
 * @author Jake
 */
public class UntimedGame extends Game {//start UntimedGame class
	
	private static UntimedGame untimedInstance = new UntimedGame();
	
	private int movesRemaining;//counter of number of moves remaining, decrements with each successful move
	private static final int MAX_MOVES = 50;//the max moves allowed for a game
	
	
	/**
	 * Constructor method for UntimedGame class
	 */
	private UntimedGame() {//start UntimedGame constructor method
		super();
		movesRemaining = MAX_MOVES;
		setIsActive(true);
	}//end UntimedGame constructor method
	
	/**
	 * Calculates the sum of the tiles around the one at the given coordinates, and compares it to the given queue value, mod
	 * Just decrements the moves remaining, then calls the method from the super class
	 * @param i - the row of the clicked tile
	 * @param j - the column of the clicked tile
	 * @param mod - the queue value placed
	 */
	public void processMove(int i, int j, int mod){//start calculateSum method
		//decrement movesRemaining
		decrementMoves();
		super.processMove(i, j, mod);
	}//end calculateSum method
	
	/**
	 * Access method for field movesRemaining
	 * @return movesRemaining - a member field 
	 */
	public int getMovesRemaining() {//start get movesRemaining method
		return movesRemaining;
	}//end getMovesRemaining method
	
	
	/**
	 * Decrement movesRemaining by 1
	 */
	public void decrementMoves() {//start decrementMoves method
		movesRemaining--;
		if(isZeroMovesRemaining()){
			setIsActive(false);
		}
		setChanged();
		notifyObservers();
	}//end decrementMoves method
	
	/*
	 * Creates a new GameBoard
	 * just sets the moves remaining then calls the method from the super class
	 */
	public void createNewGameBoard(){//start createNewGameBoard method
		movesRemaining = MAX_MOVES;
		super.createNewGameBoard();
	}//end createNewGameBoard method
	
	/**
	 * Returns the singleton instance of UntimedGame
	 * @return untimedInstance - this instance of the UntimedGame
	 */
	public static UntimedGame getInstance() {//start getInstance method
		return untimedInstance;
	}//end getInstance method
	
	/*
	 * Checks to see if moves remaining is less than or equal to zero.  
	 * @returns true if movesRemaining is less than or equal to zero
	 */
	public boolean isZeroMovesRemaining(){//start isZeroMovesRemaining method
		return (movesRemaining <= 0);
	}//end isZeroMovesRemaining method
}//end UntimedGame class