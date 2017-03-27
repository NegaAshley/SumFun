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
	
	private boolean processCornerMove(){//not actually implemented, only has a return statement to get rid of the errors
		return true;
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
	
	private boolean calculateSum(TileView tile){//not actually implemented, only has a return statement to get rid of the errors
		// takes input tile and calculates neighboring tiles for scoring
					int row = tile.getRow();
					int column = tile.getCol();

					// check for interior tile
					if ((row >= 1 && row <= 7) && (column >= 1 && column <= 7)) {
						// TODO add logic for scoring interior tile move

					}
					// check for corner move
					if ((row == 0 || row == 8) && (column == 0 || column == 8)) {

						if (row == 0) {
							// check for top left
							if (column == 0) {

								TileModel south = Controller.getGameBoard().getTile(row + 1,column);
								TileModel southeast = Controller.getGameBoard().getTile(row + 1,column + 1);
								TileModel east = Controller.getGameBoard().getTile(row,column + 1);
								int total = (south.getValue() + southeast.getValue() + east
										.getValue());
								if (Controller.getGameBoard().getTile(row, column).getValue() == total % 10) {

									PointBoardView pbv = new PointBoardView();
									pbv.setScore(pbv.getScore() + Controller.getGameBoard().getTile(row, column).getValue());
									
								}
							}
							// check for top right
							if (column == 8) {
								TileModel south = Controller.getGameBoard().getTile(row + 1,column);
								TileModel southwest = Controller.getGameBoard().getTile(row - 1,column - 1);
								TileModel west = Controller.getGameBoard().getTile(row,column - 1);
								int total = (south.getValue() + southwest.getValue() + west
										.getValue());
								if (Controller.getGameBoard().getTile(row, column).getValue() == total % 10) {

									PointBoardView pbv = new PointBoardView();
									pbv.setScore(pbv.getScore() + Controller.getGameBoard().getTile(row, column).getValue());
								}
							}

							if (row == 8) {
								// check for bottom left
								if (column == 0) {
									TileModel north = Controller.getGameBoard().getTile(row - 1,column);
									TileModel northeast = Controller.getGameBoard().getTile(row - 1,column + 1);
									TileModel east = Controller.getGameBoard().getTile(row,column + 1);
									int total = (north.getValue() + northeast.getValue() + east
											.getValue());
									if (Controller.getGameBoard().getTile(row, column).getValue() == total % 10) {

										PointBoardView pbv = new PointBoardView();
										pbv.setScore(pbv.getScore() + Controller.getGameBoard().getTile(row, column).getValue());
									}
								}
								
									// check for bottom right
									if (column == 8) {
										TileModel north = Controller.getGameBoard().getTile(row - 1,column);
										TileModel northwest = Controller.getGameBoard().getTile(row - 1,column - 1);
										TileModel west = Controller.getGameBoard().getTile(row,column - 1);
										int total = (north.getValue()
												+ northwest.getValue() + west.getValue());
										if (Controller.getGameBoard().getTile(row, column).getValue() == total % 10) {

											PointBoardView pbv = new PointBoardView();
											pbv.setScore(pbv.getScore() + Controller.getGameBoard().getTile(row, column).getValue());
											
										}
									}
								}
							}
						}
					}
	
	
	public GameBoard getGameBoard(){
		return gameBoard;
	}
	
}

//end of UntimedGame class
