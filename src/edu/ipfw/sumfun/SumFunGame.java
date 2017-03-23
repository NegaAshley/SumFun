/*
 * Sum Fun Project
 * Group 7 - Conner Julian, Grace Mavity, Jake Norris, Ashley Xu
 * CS 360 - Software Engineering
 * Professor Sedlmeyer
 */
package edu.ipfw.sumfun;

public class SumFunGame {//start SumFunGame class

	public static void main(String[] args) {//start main method
		
		//Creates new SumFunFrame
		SumFunFrame frame = new SumFunFrame();
		
		//Sets size of frame -- TODO adjust here to add queue later
        frame.setSize(456,501);
        
        //Makes frame unable to be resized
        frame.setResizable(false);
        
        //Makes frame visible
        frame.setVisible(true);

	}//end main method

}//end SumFunGame class
