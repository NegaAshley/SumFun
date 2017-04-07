package edu.ipfw.sumfun;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * QueueTileView is a version of TileView designed for the queue
 * @author Jake
 *
 */
class QueueTileView {//start QueueTileView class
	
    public static final int SIZE = 50;//Size of Tile
    private int row;//Row location of Tile
    private int col;//Column location of Tile
    private int xval;//Physical x coordinate of Tile
    private int yval;//Physical y coordinate of Tile
    private Color tileOutlineColor;//Color outline of Tile
    
    /*
     * Constructor method of QueueTileView class
     */
    public QueueTileView(int row, int col, Color tileOutlineColor){//start Tile constructor
        this.tileOutlineColor = tileOutlineColor;
        xval = row * SIZE;//since the queue is vertical and 1D, row corresponds to x, unlike in the main TileView class
        yval = col * SIZE;//similarly for y
        this.row = row;
        this.col = col;
    }//end Tile constructor
    
    /**
     * Draw method for QueueTileView
     * @param g2 the Graphics2D object
     * @param tile the TileModel desired
     */
    public void draw(Graphics2D g2, TileModel tile){//start draw method
    	
        g2.setPaint(tileOutlineColor);
        Rectangle2D r = new Rectangle2D.Double(xval, yval, SIZE, SIZE);
        g2.draw(r);
        
        Font myFont = new Font(Font.DIALOG, Font.PLAIN, 20);
        g2.setFont(myFont);
        
        g2.setPaint(Color.BLACK);
        if(tile.getValue() == -1) {
        	g2.drawString("", xval + (SIZE / 2) - 4, yval + (SIZE / 2) + 4);
        } else {
        	g2.drawString(String.valueOf(tile.getValue()), xval + (SIZE / 2) - 4, yval + (SIZE / 2) + 4);
        }
    }//end draw method
    
    /**
     * Checks to see if a tile contains given coordinates.  Returns true if tile 
     * contains given coordinates and false if not.
     */
    public boolean contains(int newx, int newy){//start contains method
    	
        if(newx >= xval && newx <= xval+ SIZE){
        	
            if(newy >= yval && newy <= yval + SIZE){
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
    
}//end QueueTileView class