package edu.ipfw.sumfun;
import java.awt.*;
import java.awt.event.*;//Save this for action listener
import java.util.*;
import javax.swing.*;

/**
 * GameBoardPanel is the panel which holds the game grid
 * @author Ashley
 *
 */
public class GameBoardPanel extends JPanel{//start GameBoardPanel class
	
	//Number of rows and columns in the grid
    public static final int GRID_ROWS = 9;
    public static final int GRID_COLS = 9;
   
    //A two-dimensional array of TileView tiles for easy access
    private TileView[][] tiles = new TileView[GRID_ROWS][GRID_COLS];//2D Array where tiles are located
    
    /**
     * GameBoardPanel constructor
     */
    public GameBoardPanel() {//start GameBoardPanel constructor
    	
        //Creates grid of size GRID_ROWS by GRID_COLS
        setLayout(new GridLayout(GRID_ROWS, GRID_COLS));
        
        //Iterates through the tileView 2D array
        for (int row = 0; row < GRID_ROWS; row++) {
            for (int col = 0; col < GRID_COLS; col++) {
            	
            	//Create a new tile and add it to the 2D array
                TileView tile = new TileView(row, col, Color.GRAY);
                tiles[row][col] = tile;

                //Adds MouseListener to SumFunPanel
                addMouseListener(new MouseAdapter() {

                    //Event occurs when mouse is clicked on panel
                    public void mouseClicked(MouseEvent e){//start mouseClicked method
                    	
                        /**
                         * Checks to see left mouse button was clicked and tile 
                         * contains the x,y coordinates
                         */
                        if(e.getButton() == 1 && tile.contains(e.getX(), e.getY())){
                        	
                        	//Print contents of back-end array of TileModel objects
                        	//Used to match with GUI representation
                        	Controller.test();
                				
                        	//Query back-end here to get the value of the selected tile
                        	int placementRow = tile.getRow();
                        	int placementCol = tile.getCol();
                        	TileModel t = Controller.getTileModel(placementRow, placementCol);
                        	int placementValue = t.getValue();
                        	
                        	//TODO remove later
                        	//Uncomment this to see the coordinates of the tile
                        	//Used for testing
                        	//JOptionPane.showMessageDialog(null, tile.getRow() + " " + tile.getCol());
                        	
                        	//If the tile is empty (value is -1), then the placement is valid
                        	if(placementValue == -1 ) {
                        		
                        		//Get the value of the first item in the queue
                        		int queueValue = Controller.getQueueTileModel(0).getValue();
                        		
                        		//Set the value of the corresponding tile in the back-end to the new value
                        		Controller.setTileValue(queueValue, tile.getRow(), tile.getCol());
                        		
                        		//Process the move, update the queue, and refresh the GUI
                        		Controller.processMove(tile.getRow(), tile.getCol(), queueValue);
                        		Controller.pushQueue();
                        		Controller.repaintFrame();
                        		
                        		//Uncomment to see the value of the tile placed in a popup window
                        		//TODO remove later
                        		//JOptionPane.showMessageDialog(null, queueValue);
                        		
                        	} else {
                        		//Lets the user know that they are unable to place a tile in a particular location
                        		JOptionPane.showMessageDialog(null, "Cannot place tile here!");
                        		return;
                        	}
                        }
                    }//end mouseClicked method
                });//end addMouseListner
            }//end nested for
        }//end for 
    }//end SumFunPanel constructor
     
    /*
     * Paints components
     */
    public void paintComponent(Graphics g){//start paintComponent method
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        //Iterates through tiles and draws tiles onto panel
        for(int row = 0; row < GRID_ROWS; row++) {
        	for(int col = 0; col < GRID_COLS; col++) {
        		tiles[row][col].draw(g2, Controller.getGameBoard().getTileGrid()[row][col]);
        	}
        }
    }//end paintComponent method
}//end SumFunPanel class
