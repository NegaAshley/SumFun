/*
 * Sum Fun Project
 * Group 7 - Conner Julian, Grace Mavity, Jake Norris, Ashley Xu
 * CS 360 - Software Engineering
 * Professor Sedlmeyer
 */
package edu.ipfw.sumfun;

public class SumFunGame {//start SumFunGame class

	public static void main(String[] args) {//start main method
		
		final int FRAME_WIDTH = 650;
		final int FRAME_HEIGHT = 650;
		final int FRAME_LOCATION_X = 450;
		final int FRAME_LOCATION_Y = 100;
		final boolean RESIZABLE = false;
		final boolean VISIBLE = true;
		
		//Creates new SumFunFrame
		SumFunFrame frame = new SumFunFrame();
		
		//Sets size of frame -- TODO adjust here to add queue later

        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        
        //Sets location of frame on screen
        frame.setLocation(FRAME_LOCATION_X, FRAME_LOCATION_Y);

        
        //Makes frame unable to be resized
        frame.setResizable(RESIZABLE);
        
        //Makes frame visible
        frame.setVisible(VISIBLE);

	}//end main method

}//end SumFunGame class
