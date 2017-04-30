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

public class Images {//start ImageNSounds class

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
	
	//background for tile grid panel
	private Image gridBack;
	
	//background for area under score and moves/time
	private Image logoBack;
	
	//Background for a hint tile
	private Image hintBack;

	//
	//Start Constructor - Instantiates data points to files in resource folders.
	public Images() throws IOException{

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
		
		
	}

	//Getters and Setters
	public Image getHintBack() {
		return hintBack;
	}

	public void setHintBack(Image hintBack) {
		this.hintBack = hintBack;
	}

	public Image getLogoBack() {
		return logoBack;
	}

	public void setLogoBack(Image logoBack) {
		this.logoBack = logoBack;
	}

	public Image getGridBack() {
		return gridBack;
	}

	public void setGridBack(Image gridBack) {
		this.gridBack = gridBack;
	}

	public Image getBackVoid() {
		return backVoid;
	}

	public void setBackVoid(Image backVoid) {
		this.backVoid = backVoid;
	}

	public Image getBack9() {
		return back9;
	}

	public void setBack9(Image back9) {
		this.back9 = back9;
	}

	public Image getBack8() {
		return back8;
	}

	public void setBack8(Image back8) {
		this.back8 = back8;
	}

	public Image getBack7() {
		return back7;
	}

	public void setBack7(Image back7) {
		this.back7 = back7;
	}

	public Image getBack6() {
		return back6;
	}

	public void setBack6(Image back6) {
		this.back6 = back6;
	}

	public Image getBack5() {
		return back5;
	}

	public void setBack5(Image back5) {
		this.back5 = back5;
	}

	public Image getBack4() {
		return back4;
	}

	public void setBack4(Image back4) {
		this.back4 = back4;
	}

	public Image getBack3() {
		return back3;
	}

	public void setBack3(Image back3) {
		this.back3 = back3;
	}

	public Image getBack2() {
		return back2;
	}

	public void setBack2(Image back2) {
		this.back2 = back2;
	}

	public Image getBack1() {
		return back1;
	}

	public void setBack1(Image back1) {
		this.back1 = back1;
	}

	public Image getBack0() {
		return back0;
	}

	public void setBack0(Image back0) {
		this.back0 = back0;
	}
	
}

