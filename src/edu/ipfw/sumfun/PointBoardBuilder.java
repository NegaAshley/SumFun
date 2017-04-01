package edu.ipfw.sumfun;

import javax.swing.*;
/**
 * @author JulianConnorMitchell
 */
import java.awt.*;
/*
 * PointBoardBuilder is the point board for the game
 */
public class PointBoardBuilder {//start PointBoardBuilder class

	private int score;//represents the score of the user during the game
	private String text;//the text for the score
	private JPanel board;//the JPanel to put the point board in
	private JLabel textLabel;//the label for the score
	private JLabel scoreLabel;//the label that holds the value of the score
	final int STARTING_SCORE = 0;//the starting score for the game
	/*
	 * Constructor for the PointBoardBuilder class
	 */
	public PointBoardBuilder(){//start PointBoardBuilder constructor
		score = STARTING_SCORE;//initialize score to STARTING_SCORE
		text = "Score: ";//set the text to "Score: " to put in the textLabel
		board = new JPanel();//creates the board panel
		board.setLayout(new GridLayout(1,2));//sets the layout of the board to GridLayout
		textLabel = new JLabel(text);//sets the textLabel to have the value of the text
		board.add(textLabel);//add the textLabel to the board
		scoreLabel = new JLabel(Integer.toString(score));//add the score value to the scoreLabel
		board.add(scoreLabel);//add the scoreLabel to the board
	}//end PointBoardBuilder constructor

	/*
	 * Getter method for retrieving the score value
	 * @return score - represents the score of the user during the game
	 */
	public int getScore() {//start getScore method
		return score;
	}//end getScore method

	/*
	 * Setter method for changing the score value
	 */
	public void setScore(int score) {//start setScore method
		this.score = score;
	}//end setScore method

	/*
	 * Getter method for retrieving the String value of the text variable
	 * @return text - the text for the score
	 */
	public String getText() {//start getText method
		return text;
	}//end getText method

	/*
	 * Setter method for changing the value of the text variable
	 */
	public void setText(String text) {//start setText method
		this.text = text;
	}//end setText method

	/*
	 * Getter method for retrieving the score's textLabel
	 * @JLabel textLabel - the label for the score
	 */
	public JLabel getTextLabel() {//start getTextLabel method
		return textLabel;
	}//end getTextLabel method

	/*
	 * Setter method for changing the value of the textLabel variable
	 */
	public void setTextLabel(JLabel textLabel) {//start setTextLabel method
		this.textLabel = textLabel;
	}//end setTextLabel method

	/*
	 * Getter method for retrieving the scoreLabel
	 * @JLabel scoreLabel - the label that holds the value of the score
	 */
	public JLabel getScoreLabel() {//start getScoreLabel method
		return scoreLabel;
	}//end setScoreLabel method

	/*
	 * Setter method for changing the value of the scoreLabel variable
	 */
	public void setScoreLabel(JLabel scoreLabel) {//start setScoreLabel method
		this.scoreLabel = scoreLabel;
	}//end setScoreLabel method
	
}//end PointBoardBuilder class
