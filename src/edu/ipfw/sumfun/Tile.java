/*
 * The Tile class represents the individual tiles on the Sum Fun board.
 */
package edu.ipfw.sumfun;
import java.awt.*;
import java.awt.geom.*;

class Tile{//start Tile class
	
    public static final int SIZE = 50;//Size of Tile
    private int row, col;//Row and column location of Tile
    private int x, y;//Physical coordinates of Tile
    private Color tileOutlineColor;//Color outline of Tile
    private int value;//Int value of Tile
    private boolean isEmpty;//Indicates whether the Tile is empty
    
    /*
     * Constructor method of Tile class
     */
    public Tile(int row, int col, Color tileOutlineColor){//start Tile constructor
        this.tileOutlineColor = tileOutlineColor;
        x = row * Tile.SIZE;
        y = col * Tile.SIZE;
        this.row = row;
        this.col = col;
        value = -1;//value set to -1 to start with.
        isEmpty = true;
    }//end Tile constructor
    
    /*
     * Draws the tile
     */
    public void draw(Graphics2D g2){//start draw method
        g2.setPaint(tileOutlineColor);
        Rectangle2D r = new Rectangle2D.Double(x, y, SIZE, SIZE);
        g2.draw(r);  
        //If tile is not empty, draw the String value of value into Tile.
        if(!isEmpty){
        	g2.drawString(String.valueOf(value), x, y);
        }
    }//end draw method
    
    /**
     * Checks to see if a tile contains given coordinates.  Returns true if tile 
     * contains given coordinates and false if not.
     */
    public boolean contains(int newx, int newy){//start contains method
        if(newx >= x && newx <= x+ SIZE){
            if(newy >= y && newy <= y + SIZE){
                return true;
            }
        }
        return false;
    }//end contains method
    
    /**
     * Returns row as an int.
     */
    public int getRow(){//start getRow method
        return row;
    }//end getRow method
    
    /**
     * Returns column as an int.
     */
    public int getCol(){//start getCol method
        return col;
    }//end getCol method
    
    /*
     * Gets value.
     */
    public int getValue(){//start getValue method
    	return value;
    }//end getValue method
    
    /*
     * Returns whether or not the tile is empty.
     */
    public boolean getIsEmpty(){//start getIsEmpty method
    	return isEmpty;
    }//end getIsEmpty method
    
    /*
     * Sets value.
     */
    public void setValue(int newValue){//start setValue method
    	this.value = newValue;
    }//end setValue method
    
    /*
     * Sets isEmpty
     */
    public void setIsEmpty(boolean newIsEmpty){//start setIsEmpty method
    	this.isEmpty = newIsEmpty;
    }//end setIsEmpty method
    
}//end Tile class