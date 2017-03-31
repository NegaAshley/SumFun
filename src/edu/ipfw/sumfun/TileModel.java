/*
 * The TileModel class represents the physical version of the tile.  It keeps track of
 * the value of the TileModel as well as the references to the TileModels surrounding
 * this TileModel.
 */
package edu.ipfw.sumfun;

/**
 * 
 * @author Jake
 *
 */
public class TileModel {
	
	private int value;//the value of the Tile
	private TileModel north, northEast, east, southEast, south, southWest, west, northWest;
	
	/*
	 * The constructor for the ConceptualTile class.  Sets value to given value.
	 */
	public TileModel(int givenValue){//start ConceptualTile constructor
		this.value = givenValue;
	}//end ConceptualTile constructor
	
	/*
	 * Creates a tile with a value between 0 and 9
	 */
	public static TileModel createRandomTile(){//start createRandomTile method
		TileModel randomTile;//random tile created
		randomTile = new TileModel( (int)(Math.random() * 9));
		return randomTile;
	}//end createRandomTile method
	
	/*
	 * Getter for value
	 */
	public int getValue(){//start getValue method
		return this.value;
	}//end getValue method
	
	/*
	 * Setter for value
	 */
	public void setValue(int givenValue){//start setValue method
		this.value = givenValue;
	}//end setValue method
	
	/*
	 * Sets value of tile to zero.
	 */
	public void setZero(){//start setZero method
		this.value = 0;
	}//end setZero method
	
	/*
	 * Getter for north tile reference
	 */
	public TileModel getNorth(){//start getNorth method
		return this.north;
	}//end getNorth method
	
	/*
	 * Getter for northEast tile reference
	 */
	public TileModel getNorthEast(){//start getNorthEast method
		return this.northEast;
	}//end getNorthEast method
	
	/*
	 * Getter for east tile reference
	 */
	public TileModel getEast(){//start getEast method
		return this.east;
	}//end getEast method
	
	/*
	 * Getter for southEast tile reference
	 */
	public TileModel getSouthEast(){//start getSouthEast method
		return this.southEast;
	}//end getSouthEast method
	
	/*
	 * Getter for south tile reference
	 */
	public TileModel getSouth(){//start getSouth method
		return this.south;
	}//end getSouth method
	
	/*
	 * Getter for southWest tile reference
	 */
	public TileModel getSouthWest(){//start getSouthWest method
		return this.southWest;
	}//end getSouthWest method
	
	/*
	 * Getter for west tile reference
	 */
	public TileModel getWest(){//start getWest method
		return this.west;
	}//end getWest method
	
	/*
	 * Getter for northWest tile reference
	 */
	public TileModel getNorthWest(){//start getNorthWest method
		return this.northWest;
	}//end getNorthWest method
	
	/*
	 * Setter for north tile reference
	 */
	public void setNorth(TileModel givenTile){//start setNorth method
		this.north = givenTile;
	}//end setNorth method
	
	/*
	 * Setter for northEast tile reference
	 */
	public void setNorthEast(TileModel givenTile){//start setNorthEast method
		this.northEast = givenTile;
	}//end setNorthEast method
	
	/*
	 * Setter for east tile reference
	 */
	public void setEast(TileModel givenTile){//start setEast method
		this.east = givenTile;
	}//end setEast method
	
	/*
	 * Setter for southEast tile reference
	 */
	public void setSouthEast(TileModel givenTile){//start setSouthEast method
		this.southEast = givenTile;
	}//end setSouthEast method
	
	/*
	 * Setter for south tile reference
	 */
	public void setSouth(TileModel givenTile){//start setSouth method
		this.south = givenTile;
	}//end setSouth method
	
	/*
	 * Setter for southWest tile reference
	 */
	public void setSouthWest(TileModel givenTile){//start setSouthWest method
		this.southWest = givenTile;
	}//end setSouthWest method
	
	/*
	 * Setter for west tile reference
	 */
	public void setWest(TileModel givenTile){//start setWest method
		this.west = givenTile;
	}//end setWest method
	
	/*
	 * Setter for northWest tile reference
	 */
	public void setNorthWest(TileModel givenTile){//start setNorthWest method
		this.northWest = givenTile;
	}//end setNorthWest method
	
}//end ConceptualTile class
