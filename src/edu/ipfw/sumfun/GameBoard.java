/*
 * The GameBoard class holds and controls the game board
 */

package edu.ipfw.sumfun;

import java.util.*;

import javax.swing.JPanel;

/**
 * 
 * @author Ashley
 *
 */
public class GameBoard {
	
	private TileModel [][] tileGrid;//2D array of TileModels
	final int TILE_GRID_WIDTH = 9;
	final int TILE_GRID_LENGTH = 9;
	
	/**
	 * 
	 */
	public GameBoard(){
		populateBoard();
	}//end Constructor
	
	/**
	 * 
	 */
	public void populateBoard(){//populate the gameBoard with Tiles
		tileGrid=new TileModel[TILE_GRID_WIDTH][TILE_GRID_LENGTH];
		for(int i = 0; i < TILE_GRID_WIDTH; i++){
			for(int j = 0; j < TILE_GRID_LENGTH; j++){
				if(i == 0 || i == TILE_GRID_WIDTH-1 || j == 0 || j == TILE_GRID_WIDTH-1){
					//Then this is the surrounding part of the grid
					//Make the value of the TileModel zero
					tileGrid[i][j] = new TileModel(-1);
					continue;
				}
				tileGrid[i][j] = TileModel.createRandomTile();
			}
		}
	}//end populateBoard
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @param t
	 * @return
	 */
	public boolean addTile(int i, int j, TileModel t){//takes coordinates and a tile, and attempts to place the tile at that place
		return true;
	}//addTile
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean removeTile( int i, int j){//takes coordinates and attempts to remove the tile at that place if one exists
		return true;
	}//end removeTile
	
	/**
	 * 
	 */
	public void resetBoard(){//clears gameBoard to all NULL references (or zeros?)
		
	}//end resetBoard
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	private boolean isValid(int i, int j){//determines if a move at given coordinates is valid
		return true;
	}//end isValid
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public TileModel getTile(int i, int j) {
		return tileGrid[i][j];
	}// getTile
	
	/*
	 * Getter for tileGrid
	 */
	public TileModel[][] getTileGrid(){//start getTileGrid method
		return tileGrid;
	}//end getTileGrid method
	
	
}//end class GameBoardModel