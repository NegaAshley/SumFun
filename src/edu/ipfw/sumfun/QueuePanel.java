package edu.ipfw.sumfun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

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
    
    private Game game;//this instance of Game
    
    //ArrayList of queueTiles to hold references to the physical tiles
    ArrayList<QueueTileView> queueTiles = new ArrayList<>();
    
    /**
     * Constructor for the QueuePanel class
     * @param game - this instance of game
     * @throws IOException 
     * @throws NumberFormatException 
     * @throws UnsupportedAudioFileException 
     * @throws URISyntaxException 
     */
    public QueuePanel(Game game) throws NumberFormatException, IOException, URISyntaxException, UnsupportedAudioFileException {//start QueuePanel constructor
    	
    	this.game = game;

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
     * Setter for game
     * @param game - this instance of the game
     */
    public void setGame(Game game) {//start setGame method
    	this.game = game;
    }//end setGame method
     
    /*
     * Paints components
     * @param g - the Graphics component for the Queue
     */
    public void paintComponent(Graphics g) {//start paintComponent method
    	
    	//Create brush
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        ImageNSounds ins;
		try {
			ins = new ImageNSounds();
			g.drawImage(ins.getLogoBack(), 0, -7, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        //Draw all tiles in ArrayList queueTiles onto panel
    	//g2.setBackground(Color.GRAY);
        for(int i = 0; i < queueTiles.size(); i++) {
        	QueueTileView tile = queueTiles.get(i);
        	try {
				tile.draw(g2, game.selectQueueTile(i));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } 
    }//end paintComponent method
    
}//end QueuePanel class
