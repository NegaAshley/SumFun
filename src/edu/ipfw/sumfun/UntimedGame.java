package edu.ipfw.sumfun;

/**
 * The UntimedGame class controls the untimed version of the game
 * @author Jake
 */
public class UntimedGame extends Game {//start UntimedGame class
	
	private int movesRemaining;//counter of number of moves remaining, decrements with each successful move
	private static final int MAX_MOVES = 50;//the max moves allowed for a game
	
	/**
	 * Constructor method for UntimedGame class
	 */
	public UntimedGame() {
		super();
		movesRemaining = MAX_MOVES;
	}//end UntimedGame constructor method
	
	/**
	 * Calculates the sum of the tiles around the one at the given coordinates, and compares it to the given queue value, mod
	 * Just decrements the moves remaining, then calls the method from the super class
	 * @param i the row of the clicked tile
	 * @param j the column of the clicked tile
	 * @param mod the queue value placed
	 */
	public void calculateSum(int i, int j, int mod){//start calculateSum method
		//decrement movesRemaining
		decrementMoves();
		super.calculateSum(i, j, mod);
}
	
	/**
	 * Access method for field movesRemaining
	 * @return movesRemaining, a member field 
	 */
	public int getMovesRemaining() {
		return movesRemaining;
	}//end getMovesRemaining
	
	
	/**
	 * Decrement movesRemaining by 1
	 */
	public void decrementMoves() {
		movesRemaining--;
		setChanged();
		notifyObservers();
	}//end decrementMoves
	
	/*
	 * Creates a new GameBoard
	 * just sets the moves remaining then calls the method from the super class
	 */
	public void createNewGameBoard(){//start createNewGameBoard method
		movesRemaining = MAX_MOVES;
		super.createNewGameBoard();
	}//end createNewGameBoard method
	
}//end UntimedGame class