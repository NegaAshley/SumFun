package edu.ipfw.sumfun;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;


public class QueuePanel extends JPanel{
	
	final int GRID_ROWS = 5;
	final int GRID_COLS = 1;
	
	final int TILE_HEIGHT = 50;
	final int TILE_WIDTH = 50;
	
	ArrayList<TileView> queueTiles = new ArrayList<>();
	
	/**
	 * Constructor
	 */
	public QueuePanel() {
		
		setLayout(new GridLayout(5, 1, 4, 4));
		
		for (int row = 0; row < GRID_ROWS; row++) {
            for (int col = 0; col < GRID_COLS; col++) {
                TileView newTile = new TileView(-1, -1, Color.GRAY);
                queueTiles.add(newTile);
            }
		}
		
	}// end Constructor
	
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        //Draws tiles onto panel
        for(TileView tile: queueTiles){
            tile.draw(g2, new TileModel(2));
        }
    }

}
