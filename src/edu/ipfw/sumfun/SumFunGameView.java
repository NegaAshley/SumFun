/*
 * Sum Fun Project
 * Group 7 - Conner Julian, Grace Mavity, Jake Norris, Ashley Xu
 * CS 360 - Software Engineering
 * Professor Sedlmeyer
 */
package edu.ipfw.sumfun;

public class SumFunGameView {//start SumFunGame class

	public static void main(String[] args) {//start main method
		final int FRAME_WIDTH = 1000;
		final int FRAME_LENGTH = 500;
		final boolean FRAME_RESIZABLE = false;
		final boolean FRAME_VISIBLE = true;
		
		//Creates new SumFunFrame
		SumFunFrame frame = new SumFunFrame();
		
		//Sets size of frame -- TODO adjust here to add queue later
        frame.setSize(FRAME_WIDTH,FRAME_LENGTH);
        
        //Makes frame unable to be resized
        frame.setResizable(FRAME_RESIZABLE);
        
        //Makes frame visible
        frame.setVisible(FRAME_VISIBLE);

	}//end main method

}//end SumFunGame class
