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
		setDirectionalReferences();
	}//end Constructor
	
	/**
	 * 
	 */
	public void populateBoard(){//populate the gameBoard with Tiles
		tileGrid = new TileModel[TILE_GRID_WIDTH][TILE_GRID_LENGTH];
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
		
		if(tileGrid[i][j].getValue() == -1){
			tileGrid[i][j] = t;
			return true;
		}else{
			return false;
		}
	}//addTile
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean removeTile( int i, int j){//takes coordinates and attempts to remove the tile at that place if one exists
		tileGrid[i][j] = new TileModel(-1);
		return true;
	}//end removeTile
	
	/**
	 * 
	 */
	public void resetBoard(){//clears gameBoard to all NULL references (or zeros?)
		//TODO maybe get rid of
	}//end resetBoard
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	private boolean isValid(int i, int j){//determines if a move at given coordinates is valid
		return true;
		//TODO maybe get rid of
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
	
	public void setTile(int i, int j, int value) {
		tileGrid[i][j].setValue(value);
	}
	/*
	 * Sets the directional references of the tileGrid
	 */
	public void setDirectionalReferences(){//start setDirectionalReferences method
		for(int row = 0; row < TILE_GRID_WIDTH; row++){
			for(int col = 0; col < TILE_GRID_LENGTH; col++){
				
				if(row == 0){//then tile is on top row of grid and north reference is null
					tileGrid[row][col].setNorth(null);
				}else{
					tileGrid[row][col].setNorth(tileGrid[row - 1][col]);
				}
				
				if((col == 8) || (row == 0)){//then tile is northeastern corner tile and northeast reference is null
					tileGrid[row][col].setNorthEast(null);
				}else{
					tileGrid[row][col].setNorthEast(tileGrid[row - 1][col + 1]);
				}
				
				if(col == 8){//then tile is on right column of grid and east reference is null
					tileGrid[row][col].setEast(null);
				}else{
					tileGrid[row][col].setEast(tileGrid[row][col+1]);
				}
				
				if((col == 8) || (row == 8)){//then tile is southeastern corner tile and southeast reference is null
					tileGrid[row][col].setSouthEast(null);
				}else{
					tileGrid[row][col].setSouthEast(tileGrid[row + 1][col + 1]);
				}
				
				if(row == 8){//then tile is on bottom row of grid and south reference is null
					tileGrid[row][col].setSouth(null);
				}else{
					tileGrid[row][col].setSouth(tileGrid[row + 1][col]);
				}
				
				if((row == 8) || (col == 0)){//then tile is southwestern corner tile and southwest reference is null
					tileGrid[row][col].setSouthWest(null);
				}else{
					tileGrid[row][col].setSouthWest(tileGrid[row + 1][col - 1]);
				}
				
				if(col == 0){//then tile is on left column of grid and west reference is null
					tileGrid[row][col].setWest(null);
				}else{
					tileGrid[row][col].setWest(tileGrid[row][col - 1]);
				}
				
				if((row == 0) || (col == 0)){//then tile is northwestern corner tile and northwest reference is null
					tileGrid[row][col].setNorthWest(null);
				}else{
					tileGrid[row][col].setNorthWest(tileGrid[row - 1][col - 1]);
				}
			}
		}
	}//end setDirectionalReferences method
	
	public void printArray() {
		
		for(int i = 0; i < tileGrid.length; i++) {
			System.out.println("");
			for(int j = 0; j < tileGrid[0].length; j++) {
				System.out.print(tileGrid[i][j].getValue() + " ");
			}
		}
		
	}
	
	
}//end class GameBoardModel