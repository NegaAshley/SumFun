/*
 * The SumFunPanel class is the panel where the grid is located.
 */
package edu.ipfw.sumfun;
import java.awt.*;
import java.awt.event.*;//Save this for action listener
import java.util.*;
import javax.swing.*;

public class SumFunPanel extends JPanel{//start SumFunPanel class
	//Number of rows and columns in the grid
    public static final int GRID_ROWS = 9;
    public static final int GRID_COLS = 9;
    
    //Height and width of tiles
    public static final int HEIGHT = 50;
    public static final int WIDTH = 50;
    
    ArrayList <TileView> tiles = new ArrayList<>();//ArrayList where tiles are located
    
    /**
     * SumFunPanel constructor
     */
    public SumFunPanel() {//start SumFunPanel constructor
    	//Makes panel interactable
        setFocusable(true);
        
        //Creates grid.
        setLayout(new GridLayout(GRID_ROWS, GRID_COLS));
        for (int row = 0; row < GRID_ROWS; row++) {
            for (int col = 0; col < GRID_COLS; col++) {
                TileView newTile = new TileView(row, col, Color.GRAY);
                tiles.add(newTile);
                
                
                //Adds MouseListener to SumFunPanel
                //TODO Put code here when tiles are interacted with
//                addMouseListener(new MouseAdapter() {
//
//                    //Event occurs when mouse is clicked on panel
//                    public void mouseClicked(MouseEvent e){
//                        /**
//                         * Checks to see left mouse button was clicked and tile 
//                         * contains the x,y coordinates
//                         */
//                        if(e.getButton() == 1 && newTile.contains(e.getX(), e.getY())){
                				//code here for action
//                       }
//                    }
//                });
            }
        } 
    }//end SumFunPanel constructor
     
    /*
     * Paints components
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //TODO figure out how to show value of actual tile
//        for(int i = 0; i < GRID_ROWS; i++){
//        	for(int j = 0; j < GRID_COLS; j++){
//        		tile.draw()
//        	}
//        }
        //Draws tiles onto panel
        //Temporarily drew random tiles, but these are not the actual TileModels
        for(TileView tile: tiles){
            tile.draw(g2, TileModel.createRandomTile());
        }
    }
    
}//end SumFunPanel class
