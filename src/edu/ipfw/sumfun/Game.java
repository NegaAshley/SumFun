package edu.ipfw.sumfun;

import java.util.ArrayList;

/**
 * Abstract class Game contains all shared methods and fields of UntimedGame and TimeGame
 * @author Jake
 *
 */
public abstract class Game {//start Game class
	
	private ArrayList<TileModel> tileQueue = new ArrayList<>();//holds the queue of tiles
	private GameBoard gameBoard;//handles details of board state
	private int points;//holds the player's score
	private static final int LOW_THRESHOLD = 0;//the lowest number that be randomly generated
	private static final int HIGH_THRESHOLD = 9;//the highest number that be randomly generated
	private static final int INITIAL_POINTS = 0;//the number of points the user starts with
	private static final int QUEUE_LENGTH = 5;//the length of the queue
	private static final int MIN_NUM_TILES_TO_SCORE = 3;//the minimum number of tiles removed need to score points
	private static final int TILE_SCORE_VALUE = 10;//the value given per tile when points are scored
	private static final int MOD_VALUE = 10;//the modulus value to calculate with
	private static final int REMOVE_THIS = 0;//TODO remove this
}//end Game class
