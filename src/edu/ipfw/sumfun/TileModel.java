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
	
	public static final int LOW_THRESHOLD = 0;// the lowest number that be randomly 
	//generated
	public static final int HIGH_THRESHOLD = 9;// the highest number that be randomly 
	//generated
	
	private int value;//the value of this tile
	
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
	 * @param givenValue - the new value for the TileModel
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
		int value;//the value of the tile
		value = LOW_THRESHOLD + (int) (Math.random() * ((HIGH_THRESHOLD - 
				LOW_THRESHOLD) + 1));
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
	 * @returns north - the north directional reference
	 */
	public TileModel getNorth(){//start getNorth method
		return this.north;
	}//end getNorth method
	
	/*
	 * Getter for northEast tile reference
	 * @returns northEast - the northeast directional reference
	 */
	public TileModel getNorthEast(){//start getNorthEast method
		return this.northEast;
	}//end getNorthEast method
	
	/*
	 * Getter for east tile reference
	 * @returns east - the east directional reference
	 */
	public TileModel getEast(){//start getEast method
		return this.east;
	}//end getEast method
	
	/*
	 * Getter for southEast tile reference
	 * @returns southEast - the southeast directional reference
	 */
	public TileModel getSouthEast(){//start getSouthEast method
		return this.southEast;
	}//end getSouthEast method
	
	/*
	 * Getter for south tile reference
	 * @returns south - the south directional reference
	 */
	public TileModel getSouth(){//start getSouth method
		return this.south;
	}//end getSouth method
	
	/*
	 * Getter for southWest tile reference
	 * @returns southWest - the southwest directional reference
	 */
	public TileModel getSouthWest(){//start getSouthWest method
		return this.southWest;
	}//end getSouthWest method
	
	/*
	 * Getter for west tile reference
	 * @returns west - the west directional reference
	 */
	public TileModel getWest(){//start getWest method
		return this.west;
	}//end getWest method
	
	/*
	 * Getter for northWest tile reference
	 * @returns northWest - the northwest directional reference
	 */
	public TileModel getNorthWest(){//start getNorthWest method
		return this.northWest;
	}//end getNorthWest method
	
	/*
	 * Setter for north tile reference
	 * @param givenTile - the tile that north will be set to
	 */
	public void setNorth(TileModel givenTile){//start setNorth method
		this.north = givenTile;
	}//end setNorth method
	
	/*
	 * Setter for northEast tile reference
	 * @param givenTile - the tile that northeast will be set to
	 */
	public void setNorthEast(TileModel givenTile){//start setNorthEast method
		this.northEast = givenTile;
	}//end setNorthEast method
	
	/*
	 * Setter for east tile reference
	 * @param givenTile - the tile that east will be set to
	 */
	public void setEast(TileModel givenTile){//start setEast method
		this.east = givenTile;
	}//end setEast method
	
	/*
	 * Setter for southEast tile reference
	 * @param givenTile - the tile that southeast will be set to
	 */
	public void setSouthEast(TileModel givenTile){//start setSouthEast method
		this.southEast = givenTile;
	}//end setSouthEast method
	
	/*
	 * Setter for south tile reference
	 * @param givenTile - the tile that south will be set to
	 */
	public void setSouth(TileModel givenTile){//start setSouth method
		this.south = givenTile;
	}//end setSouth method
	
	/*
	 * Setter for southWest tile reference
	 * @param givenTile - the tile that southwest will be set to
	 */
	public void setSouthWest(TileModel givenTile){//start setSouthWest method
		this.southWest = givenTile;
	}//end setSouthWest method
	
	/*
	 * Setter for west tile reference
	 * @param givenTile - the tile that west will be set to
	 */
	public void setWest(TileModel givenTile){//start setWest method
		this.west = givenTile;
	}//end setWest method
	
	/*
	 * Setter for northWest tile reference
	 * @param givenTile - the tile that northwest will be set to
	 */
	public void setNorthWest(TileModel givenTile){//start setNorthWest method
		this.northWest = givenTile;
	}//end setNorthWest method
	
}//end TileModel
