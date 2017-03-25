/*
 * The GameBoard class holds and controls the game board
 */

package edu.ipfw.sumfun;

import java.util.*;

public class GameBoard {
	private ArrayList<ArrayList<Tile>> gameBoard;//2D ArrayList of Tiles representing the game board. 
	
	
	public GameBoard(){
		
	}
	
	public void populateBoard(){//populate the gameBoard with Tiles
		
	}
	
	public boolean addTile(int i, int j, Tile t){//takes coordinates and a tile, and attempts to place the tile at that place
		return true;
	}
	
	public boolean removeTile( int i, int j){//takes coordinates and attempts to remove the tile at that place if one exists
		return true;
	}
	
	public void resetBoard(){//clears gameBoard to all NULL references
		
	}
	
	private boolean isValid(int i, int j){//determines if a move at given coordinates is valid
		return true;
	}
}

//end of GameBoard class