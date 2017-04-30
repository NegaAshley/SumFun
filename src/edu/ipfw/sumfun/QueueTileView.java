package edu.ipfw.sumfun;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.sound.sampled.UnsupportedAudioFileException;

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
    private Images ins; //Reference to images
    /*
     * Constructor method of QueueTileView class
     * @param row - the row the tile is in
     * @param col - the column the tile is in
     * @param tileOutlineColor - the outline color of the tile
     */
    public QueueTileView(int row, int col, Color tileOutlineColor) throws IOException, 
    URISyntaxException, UnsupportedAudioFileException{//start QueueTileView 
    	//constructor
        this.tileOutlineColor = tileOutlineColor;
        //since the queue is vertical and 1D, row corresponds to x, unlike in the main 
        //TileView class
        xval = row * SIZE;
        yval = col * SIZE;//similarly for y
        this.row = row;
        this.col = col;
        ins = new Images();
    }//end QueueTileView constructor
    
    /**
     * Draw method for QueueTileView
     * @param g2 - the Graphics2D object
     * @param tile - the TileModel desired
     * @throws IOException 
     */
    public void draw(Graphics2D g2, TileModel tile) throws IOException{//start draw 
    	//method
    	
        g2.setPaint(tileOutlineColor);
        Rectangle2D r = new Rectangle2D.Double(xval, yval, SIZE, SIZE);
        g2.draw(r);
        
        Font myFont = new Font(Font.DIALOG, Font.PLAIN, 20);
        g2.setFont(myFont);
        
        g2.setPaint(Color.BLACK);
  

        if (tile.getValue() == -1) {
			g2.drawImage(ins.getBackVoid(), xval, yval ,null);
		} else if(tile.getValue() == 0){
			g2.drawImage(ins.getBack0(), xval, yval,null);
		} else if(tile.getValue() == 1){
			g2.drawImage(ins.getBack1(), xval, yval,null);
		} else if(tile.getValue() == 2){
			g2.drawImage(ins.getBack2(), xval, yval,null);
		} else if(tile.getValue() == 3){
			g2.drawImage(ins.getBack3(), xval, yval,null);
		} else if(tile.getValue() == 4){
			g2.drawImage(ins.getBack4(), xval, yval,null);
		} else if(tile.getValue() == 5){
			g2.drawImage(ins.getBack5(), xval, yval,null);
		} else if(tile.getValue() == 6){
			g2.drawImage(ins.getBack6(), xval, yval,null);
		} else if(tile.getValue() == 7){
			g2.drawImage(ins.getBack7(), xval, yval,null);
		} else if(tile.getValue() == 8){
			g2.drawImage(ins.getBack8(), xval, yval,null);
		} else if(tile.getValue() == 9){
			g2.drawImage(ins.getBack9(), xval, yval,null);
		} else{
			g2.drawString(String.valueOf(tile.getValue()), xval + (SIZE / 2) - 4, yval 
					+ (SIZE / 2) + 4);
		}
    }//end draw method
    
    /**
     * Checks to see if a tile contains given coordinates.  Returns true if tile 
     * contains given coordinates and false if not.
     * @param newx - the new x value
     * @param newy - the new y value
     * @returns true if tile contains given coordinates
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
     * @return row - the row the tile is in
     */
    public int getRow(){//start getRow method
        return row;
    }//end getRow method
    
    /**
     * Returns column as an int.
     * @return col - the column the tile is in
     */
    public int getCol(){//start getCol method
        return col;
    }//end getCol method
    
}//end QueueTileView class
