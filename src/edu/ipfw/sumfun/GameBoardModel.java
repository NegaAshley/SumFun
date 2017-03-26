/*
 * The GameBoard class holds and controls the game board
 */

package edu.ipfw.sumfun;

import java.util.*;

public class GameBoardModel {
	private ArrayList<ArrayList<TileModel>> tileGrid;//2D ArrayList of Tiles representing the game board. 
	final int TILE_GRID_WIDTH = 9;
	final int TILE_GRID_LENGTH = 9;
	
	public GameBoardModel(){
		
	}
	
	public void populateBoard(){//populate the gameBoard with Tiles
		
	}
	
	public boolean addTile(int i, int j, TileModel t){//takes coordinates and a tile, and attempts to place the tile at that place
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