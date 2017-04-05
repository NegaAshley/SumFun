/*
 * The Tile class represents the individual tiles on the Sum Fun board.
 */
package edu.ipfw.sumfun;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.*;

class TileView{//start Tile class
	
	private Controller controller;
	
    private static final int SIZE = 50;//Size of Tile
    private int row, col;//Row and column location of Tile
    private int x, y;//Physical coordinates of Tile
    private Color tileOutlineColor;//Color outline of Tile
    private static int counter = 0;
    /*
     * Constructor method of Tile class
     */
    public TileView(int row, int col, Color tileOutlineColor){//start Tile constructor
        this.tileOutlineColor = tileOutlineColor;
        x = col * TileView.SIZE;//x corresponds to col instead of row because it is the horizontal value, just like col
        y = row * TileView.SIZE;//y corresponds to row instead of col because it is the vertical value, just like row
        this.row = row;
        this.col = col;
    }//end Tile constructor
    
    public void addActionListener(Controller controller) {
    	this.controller = controller;
    }
    
    public void processEvent() {
    	
    	try {
    		
    		int id = ActionEvent.ACTION_FIRST;
    		String eventString = row + " " + col;
    		controller.actionPerformed(new ActionEvent(this, id, eventString));
    		
    	} catch(Exception e){
    		System.out.println("Fatal error. No controller registered for tile.");
    		System.exit(1);
    	}
    	
    }
    
    /**
     * Draws the tiles onto the grid.
     * @param g2, the brush
     * @param tile, the backend tile
     */
    public void draw(Graphics2D g2, TileModel tile){//start draw method
    	
        g2.setPaint(Color.GRAY);
        Rectangle2D r = new Rectangle2D.Double(x, y, SIZE, SIZE);
        g2.draw(r);
        
        g2.setPaint(Color.BLACK);
        
        //Test code to see in what order the tiles are drawn onto the panel
//        g2.drawString(String.valueOf(counter), x + (SIZE / 2) - 4, y + (SIZE / 2) + 4);
//        counter++;
        
        if(tile.getValue() == -1) {
        	g2.drawString("", x + (SIZE / 2) - 4, y + (SIZE / 2) + 4);
        } else {
        	g2.drawString(String.valueOf(tile.getValue()), x + (SIZE / 2) - 4, y + (SIZE / 2) + 4);
        }
        
    }//end draw method
    
    /**
     * Checks to see if a tile contains given coordinates.  Returns true if tile 
     * contains given coordinates and false if not.
     * @param newx, the x-coordinate
     * @param newy, the y-coordinate
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