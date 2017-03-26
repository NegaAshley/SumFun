package edu.ipfw.sumfun;

import java.awt.*;
import java.awt.event.*;//Save this for action listener
import java.util.*;
import javax.swing.*;

/**
 * QueuePanel is a JPanel designed to show the visual queue
 * @author Jake
 *
 */
public class QueuePanel extends JPanel{
	
	//Number of rows and columns in the grid
	//Queue grid is simply one column of squares
    public static final int GRID_ROWS = 1;
    public static final int GRID_COLS = 5;

    //
    ArrayList<TileView> queueTiles = new ArrayList<>();//ArrayList where tiles are located
    
    /**
     * SumFunPanel constructor
     */
    public QueuePanel() {//start SumFunPanel constructor

        //Create 5 queue tiles
        setLayout(new GridLayout(GRID_ROWS, GRID_COLS));
        
        TileView tile = new TileView(0, 0, Color.GRAY);
        queueTiles.add(tile);
        
        for (int row = 0; row < GRID_ROWS; row++) {
            for (int col = 1; col < GRID_COLS; col++) {
                TileView newTile = new TileView(row, col, Color.GRAY);
                queueTiles.add(newTile);
                
            }
        } 
        
    }//end SumFunPanel constructor
     
    /*
     * Paints components
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        //Draws tiles onto panel
        for(TileView tile: queueTiles){
            tile.draw(g2, TileModel.createRandomTile());
        }
    }
    
}//end SumFunPanel class
