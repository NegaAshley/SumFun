/*
 * The Tile class represents the individual tiles on the Sum Fun board.
 */
package edu.ipfw.sumfun;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.sound.sampled.UnsupportedAudioFileException;


class TileView {// start Tile class

	// Reference to the controller
	private Controller controller;
	private ImageNSounds ins;//Reference to images
	private static final int SIZE = 50;// Size of Tile
	private int row;// Row location of Tile
	private int col;// Column location of Tile
	private int xval;// Physical x coordinate of Tile
	private int yval;// Physical y coordinate of Tile
	private Color tileOutlineColor;// Color outline of Tile
	private Color tileBackgroundColor;
	private static int counter = 0;
	
	/*
	 * Constructor method of Tile class
	 * 
	 * @param row - the row of the tile
	 * 
	 * @param col - the column of the tile
	 * 
	 * @param tileOutlineColor - the color of the outline of the tile
	 */
	public TileView(int row, int col, Color tileOutlineColor, Color tileBackgroundColor) throws IOException, URISyntaxException, UnsupportedAudioFileException {// start
																							// Tile
		ins = new ImageNSounds();																				// constructor
		this.tileOutlineColor = tileOutlineColor;
		this.tileBackgroundColor = tileBackgroundColor;
		xval = col * TileView.SIZE;// x corresponds to col instead of row
									// because it is the horizontal value, just
									// like col
		yval = row * TileView.SIZE;// y corresponds to row instead of col
									// because it is the vertical value, just
									// like row
		this.row = row;
		this.col = col;
	}// end Tile constructor

	// Adds controller
	public void addActionListener(Controller controller) {
		this.controller = controller;
	}// end addActionListener

	/**
	 * Processes tile click event
	 */
	public void processEvent() {// start processEvent method

		try {

			int id = ActionEvent.ACTION_FIRST;
			String eventString = row + " " + col;
			controller.actionPerformed(new ActionEvent(this, id, eventString));

		} catch (Exception e) {
			System.out.println("Fatal error. No controller registered for tile.");
			return;
		}

	}// end processEvent method

	/**
	 * Draws the tiles onto the grid.
	 * 
	 * @param g2
	 *            - the brush
	 * @param tile
	 *            - the backend tile
	 * @throws IOException
	 */
	public void draw(Graphics2D g2, TileModel tile) throws IOException {// start
																		// draw
																		// method


		Rectangle2D r = new Rectangle2D.Double(xval, yval, SIZE, SIZE);
		g2.setPaint(tileBackgroundColor);
		g2.fill(r);
		g2.setPaint(tileOutlineColor);
		g2.draw(r);

		Font myFont = new Font(Font.DIALOG, Font.PLAIN, 20);
		g2.setFont(myFont);
		g2.setPaint(Color.BLACK);
		if(tile.getValue() == -2){
			g2.drawImage(ins.getHintBack(), xval, yval, null);
		} else if (tile.getValue() == -1) {
			g2.drawImage(ins.getBackVoid(), xval, yval ,null);
		} else if(tile.getValue() == 0){
			g2.drawImage(ins.getBack0(), xval, yval,null);
		} else if(tile.getValue() == 1){
			g2.drawImage(ins.getBack1(), xval, yval,null);
		} else if(tile.getValue() == 2){
			g2.drawImage(ins.getBack2(), xval, yval,null);
		} else if(tile.getValue() == 3){
			g2.drawImage(ins.getBack3(), xval, yval,null);
		} else if(tile.getValue() == 4){
			g2.drawImage(ins.getBack4(), xval, yval,null);
		} else if(tile.getValue() == 5){
			g2.drawImage(ins.getBack5(), xval, yval,null);
		} else if(tile.getValue() == 6){
			g2.drawImage(ins.getBack6(), xval, yval,null);
		} else if(tile.getValue() == 7){
			g2.drawImage(ins.getBack7(), xval, yval,null);
		} else if(tile.getValue() == 8){
			g2.drawImage(ins.getBack8(), xval, yval,null);
		} else if(tile.getValue() == 9){
			g2.drawImage(ins.getBack9(), xval, yval,null);
		} else{
			g2.drawString(String.valueOf(tile.getValue()), xval + (SIZE / 2) - 4, yval + (SIZE / 2) + 4);
		}

	}// end draw method

	/**
	 * Checks to see if a tile contains given coordinates. Returns true if tile
	 * contains given coordinates and false if not.
	 * 
	 * @param newx
	 *            - the x-coordinate
	 * @param newy
	 *            - the y-coordinate
	 */
	public boolean contains(int newx, int newy) {// start contains method

		if (newx >= xval && newx <= xval + SIZE) {

			if (newy >= yval && newy <= yval + SIZE) {
				return true;
			}
		}
		return false;
	}// end contains method

	/**
	 * Returns row as an int.
	 * 
	 * @return row - the row of the tile
	 */
	public int getRow() {// start getRow method
		return row;
	}// end getRow method

	/**
	 * Returns column as an int.
	 * 
	 * @return col - the column of the tile
	 */
	public int getCol() {// start getCol method
		return col;
	}// end getCol method

	/**
	 * set the outline color of the Tile
	 * 
	 * @param newColor
	 */
	public void setOutlineColor(Color newColor) {
		this.tileOutlineColor = newColor;
	}

	/**
	 * set the background color of the Tile
	 * 
	 * @param newColor
	 */
	public void setBackgroundColor(Color newColor) {
		this.tileBackgroundColor = newColor;
	}

}// end Tile class
