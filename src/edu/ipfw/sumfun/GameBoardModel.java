/*
 * The GameBoard class holds and controls the game board
 */

package edu.ipfw.sumfun;

import java.util.*;

public class GameBoardModel {
	private TileModel [][] tileGrid;//2D array of TileModels
	final int TILE_GRID_WIDTH = 9;
	final int TILE_GRID_LENGTH = 9;
	
	public GameBoardModel(){
		populateBoard();
	}
	
	public void populateBoard(){//populate the gameBoard with Tiles
		for(int i = 0; i < TILE_GRID_WIDTH; i++){
			for(int j = 0; j < TILE_GRID_LENGTH; j++){
				if(i == 0 || i == 8 || j == 1 || j == 8){
					//Then this is the surrounding part of the grid
					//Make the value of the TileModel zero
					tileGrid[i][j] = new TileModel(0);
					continue;
				}
				tileGrid[i][j] = TileModel.createRandomTile();
			}
		}
	}
	
	public boolean addTile(int i, int j, TileModel t){//takes coordinates and a tile, and attempts to place the tile at that place
		return true;
	}
	
	public boolean removeTile( int i, int j){//takes coordinates and attempts to remove the tile at that place if one exists
		return true;
	}
	
	public void resetBoard(){//clears gameBoard to all NULL references (or zeros?)
		
	}
	
	private boolean isValid(int i, int j){//determines if a move at given coordinates is valid
		return true;
	}
	/*
	 * Getter for tileGrid
	 */
	public TileModel [][] getTileGrid(){//start getTileGrid method
		return tileGrid;
	}//end getTileGrid method
}

//end of GameBoard class