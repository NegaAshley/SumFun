/*
 * ImageNSounds Class holds all data references to any images and sounds used in the sumfun game.
 */
package edu.ipfw.sumfun;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * 
 * @author Connor
 *
 */

public class Images {//start Images class

	//Empty Tile image
	private Image backVoid;
	
	//Tiles 0-9 backing image
	private Image back9;
	private Image back8;
	private Image back7;
	private Image back6;
	private Image back5;
	private Image back4;
	private Image back3;
	private Image back2;
	private Image back1;
	private Image back0;
	
	//Background for tile grid panel
	private Image gridBack;
	
	//Background for area under score and moves/time
	private Image logoBack;
	
	//Background for a hint tile
	private Image hintBack;

	/*
	 * Images constructor thatnstantiates the data points to files in resource folders.
	 */
	public Images() throws IOException{//start Images constructor

		backVoid = ImageIO.read(new File("images/SumFun Void.jpg"));
		back9 = ImageIO.read(new File("images/SumFun 9.jpg"));
		back8 = ImageIO.read(new File("images/SumFun 8.jpg"));
		back7 = ImageIO.read(new File("images/SumFun 7.jpg"));
		back6 = ImageIO.read(new File("images/SumFun 6.jpg"));
		back5 = ImageIO.read(new File("images/SumFun 5.jpg"));
		back4 = ImageIO.read(new File("images/SumFun 4.jpg"));
		back3 = ImageIO.read(new File("images/SumFun 3.jpg"));
		back2 = ImageIO.read(new File("images/SumFun 2.jpg"));
		back1 = ImageIO.read(new File("images/SumFun 1.jpg"));
		back0 = ImageIO.read(new File("images/SumFun 0.jpg"));
		gridBack = ImageIO.read(new File("images/gridBack.jpg"));
		logoBack = ImageIO.read(new File("images/SumFun Logo.jpg"));
		hintBack = ImageIO.read(new File("images/SumFun Hint.jpg"));

	}//end Images constructor

	/*
	 * Getter for returning hintBack
	 * @return hintBack - background for a hint tile
	 */
	public Image getHintBack() {//start getHintBack method
		return hintBack;
	}//end getHintBack method

	/*
	 * Setter for hintBack
	 * 
	 * @param hintBack - the new hintBack
	 */
	public void setHintBack(Image hintBack) {//start setHintBack method
		this.hintBack = hintBack;
	}//end setHintBack method

	/*
	 * Getter for returning logoBack
	 * 
	 * @return logoBack - background for area under score and moves/time
	 */
	public Image getLogoBack() {//start getLogoBack method
		return logoBack;
	}//end getLogoBack method

	/*
	 * Setter method for setting the logoBack
	 * 
	 * @param logoBack - background for area under score and moves/time
	 */
	public void setLogoBack(Image logoBack) {//start setLogoBack method
		this.logoBack = logoBack;
	}//end setLogoBack method

	/*
	 * Getter method for gridBack
	 * 
	 * @return gridBack - background for tile grid panel
	 */
	public Image getGridBack() {//start getGridBack method
		return gridBack;
	}//end getGridBack method

	/*
	 * Setter method for gridBack
	 * 
	 * @param gridBack - the new background for tile grid panel
	 */
	public void setGridBack(Image gridBack) {//start setGridBack method
		this.gridBack = gridBack;
	}//end setGridBack method

	/*
	 * Getter method for backVoid
	 * 
	 * @return backVoid - empty tile image
	 */
	public Image getBackVoid() {//start getBackVoid method
		return backVoid;
	}//end getBackVoid method

	/*
	 * Setter for backVoid
	 * 
	 * @param backVoid - empty tile image
	 */
	public void setBackVoid(Image backVoid) {//start setBackVoid method
		this.backVoid = backVoid;
	}//end setBackVoid method

	/*
	 * Getter method for returning back9
	 * 
	 * @return back9 - the image representing the 9 tile
	 */
	public Image getBack9() {//start getBack9 method
		return back9;
	}//end getBack9 method

	/*
	 * Setter method for setting back9
	 * 
	 * @param back9 - the image representing the 9 tile
	 */
	public void setBack9(Image back9) {//start setBack9 method
		this.back9 = back9;
	}//end setBack9 method

	/*
	 * Getter method for back8
	 * 
	 * return back8 - the image representing the 8 tile
	 */
	public Image getBack8() {//start getBack8 method
		return back8;
	}//end getBack8 method

	/*
	 * Setter method for setting back8
	 * 
	 * @param back8 - the image representing the 8 tile
	 */
	public void setBack8(Image back8) {//start setBack8 method
		this.back8 = back8;
	}//end setBack8 method

	/*
	 * Getter method for returning back7
	 * 
	 * @return back7 - the image representing the 7 tile
	 */
	public Image getBack7() {//start getBack7 method
		return back7;
	}//end getBack7 method

	/*
	 * Setter method for back7
	 * 
	 * @param back7 - the image representing the 7 tile
	 */
	public void setBack7(Image back7) {//start setBack7 method
		this.back7 = back7;
	}//end setBack7 method

	/*
	 * Getter method for returning back6
	 * 
	 * @return back6 - the image representing the 6 tile
	 */
	public Image getBack6() {//start getBack6 method
		return back6;
	}//end getBack6 method

	/*
	 * Setter method for setting back6
	 * 
	 * @param back6 - the image representing the 6 tile
	 */
	public void setBack6(Image back6) {//start setBack6 method
		this.back6 = back6;
	}//end setBack6 method

	/*
	 * Getter method for back5
	 * 
	 * @return back5 - the image representing the 5 tile
	 */
	public Image getBack5() {//start getBack5 method
		return back5;
	}//end getBack5 method

	/*
	 * Setter method for back5
	 * 
	 * @param back5 - the image representing the 5 tile
	 */
	public void setBack5(Image back5) {//start setBack5 method
		this.back5 = back5;
	}//end setBack5 method

	/*
	 * Getter method for back4
	 * 
	 * @return back4 - the image representing the 4 tile
	 */
	public Image getBack4() {//start getBack4 method
		return back4;
	}//end getBack4 method

	/*
	 * Setter method for back4
	 * 
	 * @param back4 - the image representing the 4 tile
	 */
	public void setBack4(Image back4) {//start setBack4 method
		this.back4 = back4;
	}//end setBack4 method

	/*
	 * Getter method for back3
	 * 
	 * @return back3 - the image representing the 3 tile
	 */
	public Image getBack3() {//start getBack3 method
		return back3;
	}//end getBack3 method

	/*
	 * Setter method for setting back3
	 * 
	 * @param back3 - the image representing the 3 tile
	 */
	public void setBack3(Image back3) {//start setBack3 method
		this.back3 = back3;
	}//end setBack3 method

	/*
	 * Getter method for back2
	 * 
	 * @return back2 - the image representing the 2 tile
	 */
	public Image getBack2() {//start getBack2 method
		return back2;
	}//end getBack2 method

	/*
	 * Setter method for back2
	 * 
	 * @param back2 - the image representing the 2 tile
	 */
	public void setBack2(Image back2) {//start setBack2 method
		this.back2 = back2;
	}//end setBack2 method

	/*
	 * Getter method for back1
	 * 
	 * @return back1 - the image representing the 1 tile
	 */
	public Image getBack1() {//start getBack1 method
		return back1;
	}//end getBack1 method

	/*
	 * Setter method for back1
	 * 
	 * @param back1 - the image representing the 1 tile
	 */
	public void setBack1(Image back1) {//start setBack1 method
		this.back1 = back1;
	}//end setBack1 method

	/*
	 * Getter method for back0
	 * 
	 * @return back0 - the image representing the 0 tile
	 */
	public Image getBack0() {//start getBack0 method
		return back0;
	}//end getBack0 method

	/*
	 * Setter method for back0
	 * 
	 * @param back0 - the image representing the 0 tile
	 */
	public void setBack0(Image back0) {//start setBack0 method
		this.back0 = back0;
	}//end setBack0 method
	
}//end Images class

