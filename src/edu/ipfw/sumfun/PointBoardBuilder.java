package edu.ipfw.sumfun;

import javax.swing.*;
/**
 * @author JulianConnorMitchell
 */
import java.awt.*;

public class PointBoardBuilder {

	private int score;
	private String text;
	private JPanel board;
	private JLabel textLabel;
	private JLabel scoreLabel;
	
	public PointBoardBuilder(){
		
		score = 0;
		text = "Score: ";
		board = new JPanel();
		board.setLayout(new GridLayout(1,2));
		textLabel = new JLabel(text);
		board.add(textLabel);
		scoreLabel = new JLabel(Integer.toString(score));
		board.add(scoreLabel);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public JLabel getTextLabel() {
		return textLabel;
	}

	public void setTextLabel(JLabel textLabel) {
		this.textLabel = textLabel;
	}

	public JLabel getScoreLabel() {
		return scoreLabel;
	}

	public void setScoreLabel(JLabel scoreLabel) {
		this.scoreLabel = scoreLabel;
	}
	
}
