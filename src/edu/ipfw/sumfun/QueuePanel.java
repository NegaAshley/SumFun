package edu.ipfw.sumfun;
import javax.swing.*;
import java.awt.GridLayout;
import java.util.ArrayList;

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
		
	}// end Constructor

}
