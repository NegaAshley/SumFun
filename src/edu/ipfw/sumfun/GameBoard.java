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
	 * constructor that populates the board and sets directional references via helper methods
	 */
	public GameBoard(){
		populateBoard();
		setDirectionalReferences();
	}//end Constructor
	
	/**
	 * populates the board with -1s around the edges and random values in the middle
	 */
	public void populateBoard(){//populate the gameBoard with Tiles
		
		//instantiate 2d array of TileModel objects
		tileGrid = new TileModel[TILE_GRID_WIDTH][TILE_GRID_LENGTH];
		
		
		for(int row = 0; row < TILE_GRID_WIDTH; row++){
			for(int col = 0; col < TILE_GRID_LENGTH; col++){
				
				if(row == 0 || row == (TILE_GRID_WIDTH - 1)|| col == 0 || col == TILE_GRID_WIDTH-1){
					//Then this is the surrounding part of the grid
					//Make the value of the TileModel zero
					tileGrid[row][col] = new TileModel(-1);
					continue;
				}
				tileGrid[row][col] = TileModel.createRandomTile();
			}
		}
	}//end populateBoard
	
	/**
	 * takes coordinates and removes the tile at that place
	 * @param row the row desired
	 * @param col the column desired
	 * @return true, since the method will always wipe the tile at the give place
	 */
	public boolean removeTile(int row, int col){
		tileGrid[row][col] = new TileModel(-1);
		return true;
	}//end removeTile
	
	
	/**
	 * gets the TileModel at the given coordinates 
	 * @param row the row desired
	 * @param col the column desired
	 * @return the TileModel found at the coordinates
	 */
	public TileModel getTile(int row, int col) {
		return tileGrid[row][col];
	}// getTile
	
	/*
	 * Getter for tileGrid
	 */
	public TileModel[][] getTileGrid(){//start getTileGrid method
		return tileGrid;
	}//end getTileGrid method
	
	/**
	 * sets the tile at the given coordinates to the given value
	 * @param row the row desired
	 * @param col the column desired
	 * @param value the new value
	 */
	public void setTile(int row, int col, int value) {
		tileGrid[row][col].setValue(value);
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
	
	/**
	 * prints the gameBoard to the console, for testing
	 */
	public void printArray() {
		
		for(int row = 0; row < tileGrid.length; row++) {
			System.out.println("");
			for(int col = 0; col < tileGrid[row].length; col++) {
				System.out.print(tileGrid[row][col].getValue() + " ");
			}
		}
		
	}
	
	
}//end class GameBoardModel