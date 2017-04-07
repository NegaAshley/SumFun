/*
 * The TileModel class represents the physical version of the tile.  It keeps track of
 * the value of the TileModel as well as the references to the TileModels surrounding
 * this TileModel.
 */
package edu.ipfw.sumfun;

import java.util.Observable;

/**
 * TileModel is the conceptual model for the tile.
 * @author Jake
 *
 */
public class TileModel extends Observable{//start TileModel class
	
	static final  int MAX_RANDOM_VALUE = 9;//the maximum random value for a tile
	
	//Value of this tile
	private int value;
	//Directional references for the tiles around this TileModel
	private TileModel north;
	private TileModel northEast;
	private TileModel east;
	private TileModel southEast;
	private TileModel south;
	private TileModel southWest;
	private TileModel west;
	private TileModel northWest;
	
	/*
	 * The constructor for the ConceptualTile class.  Sets value to given value.
	 * @param givenValue 
	 */
	public TileModel(int givenValue){//start ConceptualTile constructor
		this.value = givenValue;
	}//end ConceptualTile constructor
	
	/*
	 * Creates a tile with a value between 0 and MAX_RANDOM_VALUE
	 * @returns TileModel - the TileModel created
	 */
	public static TileModel createRandomTile(){//start createRandomTile method
		TileModel randomTile;//random tile created
		int value = (int)(Math.random() * MAX_RANDOM_VALUE);
		randomTile = new TileModel(value);
		return randomTile;
	}//end createRandomTile method
	
	/*
	 * Getter for value
	 * @returns value
	 */
	public int getValue(){//start getValue method
		return this.value;
	}//end getValue method
	
	/*
	 * Setter for value
	 * @param givenValue
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
	 * @returns north
	 */
	public TileModel getNorth(){//start getNorth method
		return this.north;
	}//end getNorth method
	
	/*
	 * Getter for northEast tile reference
	 * @returns northEast
	 */
	public TileModel getNorthEast(){//start getNorthEast method
		return this.northEast;
	}//end getNorthEast method
	
	/*
	 * Getter for east tile reference
	 * @returns east
	 */
	public TileModel getEast(){//start getEast method
		return this.east;
	}//end getEast method
	
	/*
	 * Getter for southEast tile reference
	 * @returns southEast
	 */
	public TileModel getSouthEast(){//start getSouthEast method
		return this.southEast;
	}//end getSouthEast method
	
	/*
	 * Getter for south tile reference
	 * @returns south
	 */
	public TileModel getSouth(){//start getSouth method
		return this.south;
	}//end getSouth method
	
	/*
	 * Getter for southWest tile reference
	 * @returns southWest
	 */
	public TileModel getSouthWest(){//start getSouthWest method
		return this.southWest;
	}//end getSouthWest method
	
	/*
	 * Getter for west tile reference
	 * @returns west
	 */
	public TileModel getWest(){//start getWest method
		return this.west;
	}//end getWest method
	
	/*
	 * Getter for northWest tile reference
	 * @returns northWest
	 */
	public TileModel getNorthWest(){//start getNorthWest method
		return this.northWest;
	}//end getNorthWest method
	
	/*
	 * Setter for north tile reference
	 * @param givenTile
	 */
	public void setNorth(TileModel givenTile){//start setNorth method
		this.north = givenTile;
	}//end setNorth method
	
	/*
	 * Setter for northEast tile reference
	 * @param givenTile
	 */
	public void setNorthEast(TileModel givenTile){//start setNorthEast method
		this.northEast = givenTile;
	}//end setNorthEast method
	
	/*
	 * Setter for east tile reference
	 * @param givenTile
	 */
	public void setEast(TileModel givenTile){//start setEast method
		this.east = givenTile;
	}//end setEast method
	
	/*
	 * Setter for southEast tile reference
	 * @param givenTile
	 */
	public void setSouthEast(TileModel givenTile){//start setSouthEast method
		this.southEast = givenTile;
	}//end setSouthEast method
	
	/*
	 * Setter for south tile reference
	 * @param givenTile
	 */
	public void setSouth(TileModel givenTile){//start setSouth method
		this.south = givenTile;
	}//end setSouth method
	
	/*
	 * Setter for southWest tile reference
	 * @param givenTile
	 */
	public void setSouthWest(TileModel givenTile){//start setSouthWest method
		this.southWest = givenTile;
	}//end setSouthWest method
	
	/*
	 * Setter for west tile reference
	 * @param givenTile
	 */
	public void setWest(TileModel givenTile){//start setWest method
		this.west = givenTile;
	}//end setWest method
	
	/*
	 * Setter for northWest tile reference
	 * @param givenTile
	 */
	public void setNorthWest(TileModel givenTile){//start setNorthWest method
		this.northWest = givenTile;
	}//end setNorthWest method
	
}//end ConceptualTile class
