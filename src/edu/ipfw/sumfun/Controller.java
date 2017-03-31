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
	private static SumFunFrame frame;
	//test
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
		 frame = new SumFunFrame();
		
		//Sets size of frame -- TODO adjust here to add queue later
        frame.setSize(FRAME_WIDTH,FRAME_LENGTH);
        
        //Makes frame unable to be resized
        frame.setResizable(FRAME_RESIZABLE);
        
        //Makes frame visible
        frame.setVisible(FRAME_VISIBLE);
        
        untimedGame.getGameBoard().printArray();

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
	public static TileModel getTileModel(int row, int col) {
		return untimedGame.getGameBoard().getTile(row, col);
	}//end getTileModel
	
	public static TileModel getQueueTileModel(int i) {
		return untimedGame.selectQueueTile(i);
	}
	
	public static void setTileValue(int value, int row, int col){
		untimedGame.getGameBoard().getTile(row, col).setValue(value);
	}
	
	public static void pushQueue(){
		untimedGame.pushQueue();
	}
	
	public static void repaintFrame(){
		frame.repaint();
	}
	public static SumFunFrame getFrame(){
		return frame;
	}
	
	public static void processMove(int i, int j, int value) {
		untimedGame.calculateSum(i, j, value);
	}
	
	public static void test() {
		untimedGame.getGameBoard().printArray();
	}

}//end SumFunGame class
