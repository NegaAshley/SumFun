package edu.ipfw.sumfun;

import java.util.*;

import javax.swing.JPanel;

/**
 * The GameBoard class holds and controls the game board
 * @author Ashley
 *
 */
public class GameBoard {//start GameBoard class
	
	private TileModel [][] tileGrid;//the grid of TileModels representing the game board
	final int TILE_GRID_WIDTH = 9;//the width of the grid in tiles
	final int TILE_GRID_LENGTH = 9;//the length of the grid in tiles
	
	/**
	 * Constructor that populates the board and sets directional references via helper methods
	 */
	public GameBoard(){//start GameBoard constructor
		populateBoard();
		setDirectionalReferences();
	}//end GameBoard constructor
	
	/**
	 * Populates the board with -1s around the edges and random values in the middle
	 */
	public void populateBoard(){//start populateBoard method
		
		//Instantiate 2d array of TileModel objects
		tileGrid = new TileModel[TILE_GRID_WIDTH][TILE_GRID_LENGTH];
		
		//Iterate through rows and columns and set tiles
		for(int row = 0; row < TILE_GRID_WIDTH; row++){
			for(int col = 0; col < TILE_GRID_LENGTH; col++){
				
				if(row == 0 || row == (TILE_GRID_WIDTH - 1)|| col == 0 || col == TILE_GRID_WIDTH-1){
					//Then this is the surrounding part of the grid
					//Make the value of the TileModel -1
					tileGrid[row][col] = new TileModel(-1);
					continue;
				}
				//Create a tile in this place with a random value
				tileGrid[row][col] = TileModel.createRandomTile();
			}
		}
	}//end populateBoard method
	
	/**
	 * Takes coordinates and removes the tile at that place
	 * @param row the row desired
	 * @param col the column desired
	 * @return true, since the method will always wipe the tile at the give place
	 */
	public boolean removeTile(int row, int col){//start removeTile method
		tileGrid[row][col] = new TileModel(-1);
		return true;
	}//end removeTile method

	/**
	 * Gets the TileModel at the given coordinates 
	 * @param row the row desired
	 * @param col the column desired
	 * @return the TileModel found at the coordinates
	 */
	public TileModel getTile(int row, int col) {//start getTile method
		return tileGrid[row][col];
	}//end getTile method

	/*
	 * Getter for tileGrid
	 */
	public TileModel[][] getTileGrid(){//start getTileGrid method
		return tileGrid;
	}//end getTileGrid method
	
	/**
	 * Sets the tile at the given coordinates to the given value
	 * @param row the row desired
	 * @param col the column desired
	 * @param value the new value
	 */
	public void setTile(int row, int col, int value) {//start setTile method
		tileGrid[row][col].setValue(value);
	}//end setTile method
	/*
	 * Sets the directional references of the tileGrid
	 */
	public void setDirectionalReferences(){//start setDirectionalReferences method
		//Iterates through the rows and columns of the tile grid
		for(int row = 0; row < TILE_GRID_WIDTH; row++){
			for(int col = 0; col < TILE_GRID_LENGTH; col++){
				
				if(row == 0){//then tile is on top row of grid
					tileGrid[row][col].setNorth(null);//set north reference to null
				}else{
					tileGrid[row][col].setNorth(tileGrid[row - 1][col]);
				}
				
				if((col == 8) || (row == 0)){//then tile is in top row or rightmost column
					tileGrid[row][col].setNorthEast(null);//set northeast reference to null
				}else{
					tileGrid[row][col].setNorthEast(tileGrid[row - 1][col + 1]);
				}
				
				if(col == 8){//then tile is on right column of grid and east reference is null
					tileGrid[row][col].setEast(null);//set east reference to null
				}else{
					tileGrid[row][col].setEast(tileGrid[row][col+1]);
				}
				
				if((col == 8) || (row == 8)){//then tile is on bottom row or rightmost column
					tileGrid[row][col].setSouthEast(null);//set southeast reference to null
				}else{
					tileGrid[row][col].setSouthEast(tileGrid[row + 1][col + 1]);
				}
				
				if(row == 8){//then tile is on bottom row
					tileGrid[row][col].setSouth(null);//set south reference to null
				}else{
					tileGrid[row][col].setSouth(tileGrid[row + 1][col]);
				}
				
				if((row == 8) || (col == 0)){//then tile is leftmost column or bottom row
					tileGrid[row][col].setSouthWest(null);//set southwest reference to null
				}else{
					tileGrid[row][col].setSouthWest(tileGrid[row + 1][col - 1]);
				}
				
				if(col == 0){//then tile is on leftmost column
					tileGrid[row][col].setWest(null);//set west reference to null
				}else{
					tileGrid[row][col].setWest(tileGrid[row][col - 1]);
				}
				
				if((row == 0) || (col == 0)){//then tile is on top row or leftmost column
					tileGrid[row][col].setNorthWest(null);//set northwest reference to null
				}else{
					tileGrid[row][col].setNorthWest(tileGrid[row - 1][col - 1]);
				}
			}
		}
	}//end setDirectionalReferences method
	
	/**
	 * Prints the gameBoard to the console, for testing
	 */
	public void printArray() {//start printArray method
		
		for(int row = 0; row < tileGrid.length; row++) {
			System.out.println("");
			for(int col = 0; col < tileGrid[row].length; col++) {
				System.out.print(tileGrid[row][col].getValue() + " ");
			}
		}
		
		System.out.println("");
		
	}//end printArray method
	
}//end class GameBoardModel