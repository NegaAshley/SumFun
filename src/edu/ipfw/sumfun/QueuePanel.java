package edu.ipfw.sumfun;

import java.awt.*;
import java.awt.event.*;//Save this for action listener
import java.util.*;
import javax.swing.*;

public class QueuePanel extends JPanel{//start SumFunPanel class
	//Number of rows and columns in the grid
    public static final int GRID_ROWS = 1;
    public static final int GRID_COLS = 5;
    
    //Height and width of tiles
    public static final int HEIGHT = 50;
    public static final int WIDTH = 50;
    
    ArrayList <TileView> queueTiles = new ArrayList<>();//ArrayList where tiles are located
    
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
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        //Draws tiles onto panel
        for(TileView tile: queueTiles){
            tile.draw(g2, new TileModel(2));
        }
    }
    
}//end SumFunPanel class
