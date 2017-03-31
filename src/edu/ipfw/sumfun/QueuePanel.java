package edu.ipfw.sumfun;

import java.awt.*;
import java.awt.event.*;//Save this for action listener
import java.util.*;
import javax.swing.*;

/**
 * QueuePanel is a JPanel extension designed to show the visual queue
 * @author Jake
 *
 */
public class QueuePanel extends JPanel {//start the QueuePanel class
	
	//Number of rows and columns in the grid
	//Queue grid is simply one column of squares
    public static final int GRID_ROWS = 1;
    public static final int GRID_COLS = 5;
    public static final String GREEN_HEX_VALUE="0x00cc00";

    //ArrayList of queueTiles to hold references to the physical tiles
    ArrayList<QueueTileView> queueTiles = new ArrayList<>();
    
    /**
     * Constructor for the QueuePanel class
     */
    public QueuePanel() {//start QueuePanel constructor

        //Set QueuePanel layout to a grid layout of GRID_ROWS by GRID_COLS
        setLayout(new GridLayout(GRID_ROWS, GRID_COLS));
        
        //Create a sufficient number of tiles to fill ArrayList queueTiles
        QueueTileView newTile ;
        newTile= new QueueTileView(0, 0, Color.decode(GREEN_HEX_VALUE));
        queueTiles.add(newTile);
        for (int row = 0; row < GRID_ROWS; row++) {
            for (int col = 1; col < GRID_COLS; col++) {
                 newTile = new QueueTileView(row, col, Color.GRAY);
                queueTiles.add(newTile);  
            }
        } 
    }//end QueuePanel constructor
     
    /*
     * Paints components
     */
    public void paintComponent(Graphics g) {
    	
    	//Create brush
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        //Draw all tiles in ArrayList queueTiles onto panel
    	//g2.setBackground(Color.GRAY);
        for(int i = 0; i < queueTiles.size(); i++) {
        	QueueTileView tile = queueTiles.get(i);
        	tile.draw(g2, Controller.getQueueTileModel(i));
        } 
    }//end paintComponent
    
}//end QueuePanel class