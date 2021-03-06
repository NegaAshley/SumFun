package glassboxtesting;

/**
 * The GameBoard class holds and controls the game board
 * @author Ashley
 *
 */
public class GameBoard {//start GameBoard class
	
	//Various constants for use in GameBoard
	static final int TILE_GRID_WIDTH = 9;//the width of the grid in tiles
	static final int TILE_GRID_LENGTH = 9;//the length of the grid in tiles
	
	private TileModel [][] tileGrid;//the grid of TileModels representing the game board
	
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
		//System.out.println(row);
		//System.out.println(col);
		return tileGrid[row][col];
	}//end getTile method

	/* 
	 * Getter for tileGrid
	 */
	public TileModel[][] getTileGrid(){//start getTileGrid method
		return tileGrid;
	}//end getTileGrid method
	
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
				
				if((col == tileGrid[0].length - 1) || (row == 0)){//then tile is in top row or rightmost column
					tileGrid[row][col].setNorthEast(null);//set northeast reference to null
				}else{
					tileGrid[row][col].setNorthEast(tileGrid[row - 1][col + 1]);
				}
				
				if(col == tileGrid[0].length - 1){//then tile is on right column of grid and east reference is null
					tileGrid[row][col].setEast(null);//set east reference to null
				}else{
					tileGrid[row][col].setEast(tileGrid[row][col+1]);
				}
				
				if((col == tileGrid[0].length - 1) || (row == tileGrid[0].length - 1)){//then tile is on bottom row or rightmost column
					tileGrid[row][col].setSouthEast(null);//set southeast reference to null
				}else{
					tileGrid[row][col].setSouthEast(tileGrid[row + 1][col + 1]);
				}
				
				if(row == tileGrid[0].length - 1){//then tile is on bottom row
					tileGrid[row][col].setSouth(null);//set south reference to null
				}else{
					tileGrid[row][col].setSouth(tileGrid[row + 1][col]);
				}
				
				if((row == tileGrid[0].length - 1) || (col == 0)){//then tile is leftmost column or bottom row
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
	
	/*
	 * Returns true if GameBoard is full of tiles
	 * @returns true if GameBoard is full
	 */
	public boolean isGameBoardFull(){//start isGameBoardFull method
		boolean isFull;
		isFull = true;
		for(int row = 0; row < tileGrid.length; row++){
			for(int col = 0; col < tileGrid[row].length; col++){
				if(tileGrid[row][col].getValue() == -1){
					//then there is an empty tile and the board is not full
					isFull = false;
					return isFull;
				}
			}
		}
		return isFull;
	}//end isGameBoardFull method
	
	/*
	 * Returns true if GameBoard is empty of tiles
	 * @returns true if GameBoard is empty
	 */
	public boolean isGameBoardEmpty(){//start isGameBoardEmpty method
		boolean isEmpty;
		isEmpty = true;
		for(int row = 0; row < tileGrid.length; row++){
			for(int col = 0; col < tileGrid[row].length; col++){
				if(tileGrid[row][col].getValue() != -1){
					//then there is a filled tile and the board is not empty
					isEmpty = false;
					return isEmpty;
				}
			}
		}
		return isEmpty;
	}//end isGameBoardEmpty method
	
	/**
	 * Method for testing, fills board up with tiles
	 */
	public void fillBoard() {
		for(int i = 0; i < tileGrid.length; i++) {
			for(int j = 0; j < tileGrid[i].length; j++) {
				tileGrid[i][j].setValue(7);
			}
			
		}
	}//end fillBoard
	
	/**
	 * Method for testing, put some tiles at random locations on the board
	 */
	public void partiallyFillBoard() {
		tileGrid[4][5].setValue(7);
		tileGrid[0][6].setValue(7);
		tileGrid[1][3].setValue(7);
		tileGrid[5][5].setValue(7);
		tileGrid[7][0].setValue(7);
		tileGrid[4][4].setValue(7);
		tileGrid[8][0].setValue(7);
		tileGrid[0][3].setValue(7);
		tileGrid[6][4].setValue(7);
		tileGrid[6][1].setValue(7);
	}//end partiallyFillBoard
	
	/**
	 * Method for testing, empties board by setting all values to -1
	 */
	public void emptyBoard() {
		for(int i = 0; i < tileGrid.length; i++) {
			for(int j = 0; j < tileGrid.length; j++) {
				tileGrid[i][j].setValue(-1);
			}
			
		}
	}//end emptyBoard
	
	/**
	 * Method for testing, seeds board by emptying it and putting
	 * a tile with seedValue at each tile adjacent to tile at coordinates 0, 0
	 * @param seedValue, the value to put at the tiles adjacent to the tile at 0, 0
	 */
	public void seedBoard(int seedValue) {
		tileGrid[0][0].setValue(-1);
		tileGrid[0][1].setValue(seedValue);
		tileGrid[1][0].setValue(seedValue);
		tileGrid[1][1].setValue(seedValue);
		
	}//end seedBoard
	
	/**
	 * Method for testing, seeds board by emptying it and putting
	 * a tile with seedValue at two of the tiles adjacent to tile at coordinates 0, 0
	 * @param seedValue
	 */
	public void seedBoardNoScore(int seedValue) {
		tileGrid[0][0].setValue(-1);
		tileGrid[0][1].setValue(seedValue);
		tileGrid[1][0].setValue(seedValue);
	}
	
}//end GameBoardModel class