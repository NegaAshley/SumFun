/*
 * The Tile class represents the individual tiles on the Sum Fun board.
 */
package edu.ipfw.sumfun;
import java.awt.*;
import java.awt.geom.*;

class TileView{//start Tile class
	
    public static final int SIZE = 50;//Size of Tile
    private int row, col;//Row and column location of Tile
    private int x, y;//Physical coordinates of Tile
    private Color tileOutlineColor;//Color outline of Tile
    /*
     * Constructor method of Tile class
     */
    public TileView(int row, int col, Color tileOutlineColor){//start Tile constructor
        this.tileOutlineColor = tileOutlineColor;
        x = row * TileView.SIZE;
        y = col * TileView.SIZE;
        this.row = row;
        this.col = col;
    }//end Tile constructor
    
    /*
     * Draws the tile
     */
    public void draw(Graphics2D g2){//start draw method
        g2.setPaint(tileOutlineColor);
        Rectangle2D r = new Rectangle2D.Double(x, y, SIZE, SIZE);
        g2.draw(r);  
        //TODO figure out how to get TileModel value here
        //g2.drawString(String.valueOf(TileModel.getValue()), x, y);
        
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
}//end Tile class