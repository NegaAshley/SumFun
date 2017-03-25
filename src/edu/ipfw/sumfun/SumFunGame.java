/*
 * Sum Fun Project
 * Group 7 - Conner Julian, Grace Mavity, Jake Norris, Ashley Xu
 * CS 360 - Software Engineering
 * Professor Sedlmeyer
 */
package edu.ipfw.sumfun;

public class SumFunGame {//start SumFunGame class

	public static void main(String[] args) {//start main method
		
		final int WIDTH = 1000;
		final int HEIGHT = 500;
		final boolean RESIZABLE = false;
		final boolean VISIBLE = false;
		
		//Creates new SumFunFrame
		SumFunFrame frame = new SumFunFrame();
		
		//Sets size of frame -- TODO adjust here to add queue later
        frame.setSize(WIDTH, HEIGHT);
        
        //Makes frame unable to be resized
        frame.setResizable(RESIZABLE);
        
        //Makes frame visible
        frame.setVisible(VISIBLE);

	}//end main method

}//end SumFunGame class
