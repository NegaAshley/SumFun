/*
 * The SumFunPanel class is the panel where the grid is located.
 */
package edu.ipfw.sumfun;
import java.awt.*;
import java.awt.event.*;//Save this for action listener
import java.util.*;
import javax.swing.*;

/**
 * 
 * @author Ashley
 *
 */
public class SumFunPanel extends JPanel{//start SumFunPanel class
	
	//Number of rows and columns in the grid
    public static final int GRID_ROWS = 9;
    public static final int GRID_COLS = 9;
   
    //A two-dimensional array of TileView tiles for easy access
    private TileView[][] tiles = new TileView[GRID_ROWS][GRID_COLS];//2D Array where tiles are located
    
    /**
     * SumFunPanel constructor
     */
    public SumFunPanel() {//start SumFunPanel constructor
    	
        //Creates grid of size GRID_ROWS by GRID_COLS
        setLayout(new GridLayout(GRID_ROWS, GRID_COLS));
        
        for (int row = 0; row < GRID_ROWS; row++) {
            for (int col = 0; col < GRID_COLS; col++) {
            	
            	//Create a new tile and add it to the 2D array
                TileView newTile = new TileView(row, col, Color.GRAY);
                tiles[row][col] = newTile;

                //Adds MouseListener to SumFunPanel
                //TODO Put code here when tiles are interacted with
                addMouseListener(new MouseAdapter() {

                    //Event occurs when mouse is clicked on panel
                    public void mouseClicked(MouseEvent e){
                        /**
                         * Checks to see left mouse button was clicked and tile 
                         * contains the x,y coordinates
                         */
                        if(e.getButton() == 1 && newTile.contains(e.getX(), e.getY())){
                				//code here for action
                        }
                    }
                    
                });//end addMouseListner
            }//end nested for
        }//end for 
        
    }//end SumFunPanel constructor
     
    /*
     * Paints components
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        //Draws tiles onto panel
        for(int i = 0; i < GRID_ROWS; i++) {
        	for(int j = 0; j < GRID_COLS; j++) {
        		tiles[i][j].draw(g2, Controller.getGameBoard().getTileGrid()[i][j]);
        	}
        }
       
    }//end paintComponent
    
}//end SumFunPanel class
