/*
 * Sum Fun Project
 * Group 7 - Conner Julian, Grace Mavity, Jake Norris, Ashley Xu
 * CS 360 - Software Engineering
 * Professor Sedlmeyer
 */
package edu.ipfw.sumfun;

/**
 * 
 * @author Jake
 *
 */
public class Controller {//start SumFunGame class
	
	private static UntimedGame untimedGame;
	
	/**
	 * 
	 * @param args, the command line arguments
	 */
	public static void main(String[] args) {//start main method
		
		final int FRAME_WIDTH = 1000;
		final int FRAME_LENGTH = 525;
		final boolean FRAME_RESIZABLE = false;
		final boolean FRAME_VISIBLE = true;
		untimedGame = new UntimedGame();
		
		//Creates new SumFunFrame
		SumFunFrame frame = new SumFunFrame();
		
		//Sets size of frame -- TODO adjust here to add queue later
        frame.setSize(FRAME_WIDTH,FRAME_LENGTH);
        
        //Makes frame unable to be resized
        frame.setResizable(FRAME_RESIZABLE);
        
        //Makes frame visible
        frame.setVisible(FRAME_VISIBLE);

	}//end main method
	
	/**
	 * 
	 * @return
	 */
	public static GameBoard getGameBoard(){
		return untimedGame.getGameBoard();
	}//end getGameBoard
	
	/**
	 * 
	 * @return
	 */
	public static TileModel getTileModel(int i, int j) {
		return untimedGame.getGameBoard().getTile(i, j);
	}//end getTileModel
	
	public static TileModel getQueueTileModel(int i) {
		return untimedGame.selectQueueTile(i);
	}

}//end SumFunGame class
