/*
 * The SumFunFrame class is the frame of Sum Fun game where panels and menus are
 * located.
 */
package edu.ipfw.sumfun;

import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

/**
 * The SumFunFrame class is the main View class, and builds the GUI
 * @author Jake
 * 
 */
public class SumFunFrame extends JFrame {// start SumFunFrame

	JMenuBar bar;//main menu bar
	JMenu gameMenu;//menu option holding game options
	JMenu helpMenu;//menu options holding help options
	final JMenuItem newGame;//menu option in gameMenu that will create a new game
	final JMenuItem exit;//menu option in gameMenu that will exit the game
	final JMenuItem help;//menu option in helpMenu that will bring up help features
	JPanel initialPanel;//panel to build from
	JPanel scoreBoardPanel;//panel to hold score and moves left
	QueuePanel qp;//QueuePanel to hold the queue
	JLabel scoreLabel;//label for the score
	JLabel moveLabel;//label for the moves remaining
	
	/**
	 * Constructor for the SumFunFrame
	 */
	public SumFunFrame() {//start SumFunFrame constructor

		super("Sum Fun");// sets title of window
		setDefaultCloseOperation(EXIT_ON_CLOSE);//exits game on close

		setLayout(new GridLayout(1, 1));//sets the layout of the frame to GridLayout
		
		// Creates and sets the menu bar
		bar = new JMenuBar();
		setJMenuBar(bar);

		//Creates menus
		gameMenu = new JMenu("Game");
		helpMenu = new JMenu("Help");

		//Adds menus to menu bar
		bar.add(gameMenu);
		bar.add(helpMenu);

		//Creates menu items for menus
		newGame = new JMenuItem("New Game");
		exit = new JMenuItem("Exit");
		help = new JMenuItem("Help");

		//Adds menu items to menus
		gameMenu.add(newGame);
		gameMenu.add(exit);
		helpMenu.add(help);

		//Closes game when exit menu option is selected
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//start actionPerformed method
				dispose();
			}//end actionPerformed method
		});

		//Initial panel to be added to frame
		//This panel is intermediate, so we can add another panel
		//on the right side of the frame but only in the north space
		initialPanel = new JPanel();
		initialPanel.setLayout(new BorderLayout());

		//Creates and adds SumFunPanel
		GameBoardPanel panel = new GameBoardPanel();
		add(panel);

		//Add initial panel to right of SumFunPanel
		add(initialPanel);

		//Creates scoreBoardPanel
		scoreBoardPanel = new JPanel();
		scoreBoardPanel.setLayout(new GridLayout(2, 2));

		//Adds JLabels and text fields for Score and Moves Remaining
		scoreLabel = new JLabel("Score: ");
		moveLabel = new JLabel("Moves Remaining: ");
		scoreBoardPanel.add(scoreLabel);
		scoreBoardPanel.add(moveLabel);
		
		//Add score board panel to the north of initialPanel
		initialPanel.add(scoreBoardPanel, BorderLayout.NORTH);

		// Instantiate a new QueuePanel
		qp = new QueuePanel();

		//Ad qp to the panel
		initialPanel.add(qp);

		//Resets board when new game is selected
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//start actionPerformed method
				// panel.resetBoard(getBackground());
			}//end actionPerformed method
		});
	}//end SumFunFrame constructor
	/**
	 * Getter for scoreLabel
	 * @return scoreLabel
	 */
	public JLabel getScoreLabel() {//start getScoreLabel method
		return scoreLabel;
	}//end getScoreLabel method
	
	/**
	 * Setter for scoreLabel
	 * @param scoreLabel
	 */
	public void setScoreLabel(JLabel scoreLabel) {//start setScoreLabel method
		this.scoreLabel = scoreLabel;
	}//end setScoreLabel method
	
	/**
	 * Getter for moveLabel
	 * @return moveLabel
	 */
	public JLabel getMoveLabel() {//start getMoveLabel method
		return moveLabel;
	}//end getMoveLabel method

	/**
	 * Setter for moveLabel
	 * @param moveLabel
	 */
	public void setMoveLabel(JLabel moveLabel) {//start setMoveLabel method
		this.moveLabel = moveLabel;
	}//end setMoveLabel method

	/**
	 * Getter for bar
	 * @return bar
	 */
	public JMenuBar getBar() {//start getBar method
		return bar;
	}//start getBar method

	/**
	 * Setter for bar
	 * @param bar
	 */
	public void setBar(JMenuBar bar) {//start setBar method
		this.bar = bar;
	}//end setBar method

	/**
	 * Getter for gameMenu
	 * @return gameMenu
	 */
	public JMenu getGameMenu() {//start getGameMenu method
		return gameMenu;
	}//end getGameMenu method

	/**
	 * Setter for gameMenu
	 * @param gameMenu
	 */
	public void setGameMenu(JMenu gameMenu) {//start setGameMenu method
		this.gameMenu = gameMenu;
	}//end setGameMenu method

	/**
	 * Getter for helpMenu
	 * @return helpMenu
	 */
	public JMenu getHelpMenu() {//start getHelpMenu method
		return helpMenu;
	}//end getHelpMenu method

	/**
	 * Setter for helpMenu
	 * @param helpMenu
	 */
	public void setHelpMenu(JMenu helpMenu) {//start setHelpMenu method
		this.helpMenu = helpMenu;
	}//end setHelpMenu method

	/**
	 * Getter for initialPanel
	 * @return initialPanel
	 */
	public JPanel getInitialPanel() {//start getInitialPanel method
		return initialPanel;
	}//end getInitialPanel method

	/**
	 * Setter for initialPanel
	 * @param initialPanel
	 */
	public void setInitialPanel(JPanel initialPanel) {//start setInitialPanel method
		this.initialPanel = initialPanel;
	}//end setInitialPanel method

	/**
	 * Getter for scoreBoardPanel
	 * @return scoreBoardPanel
	 */
	public JPanel getScoreBoardPanel() {//start getScoreBoardPanel method
		return scoreBoardPanel;
	}//end getScoreBoardPanel

	/**
	 * Setter for scoreBoardPanel
	 * @param scoreBoardPanel
	 */
	public void setScoreBoardPanel(JPanel scoreBoardPanel) {//start setScoreBoardPanel method
		this.scoreBoardPanel = scoreBoardPanel;
	}//end setScoreBoardPanel method

	/** 
	 * Getter for qp
	 * @return qp
	 */
	public QueuePanel getQp() {//start getQp method
		return qp;
	}//end getQp method

	/**
	 * Setter for qp
	 * @param qp
	 */
	public void setQp(QueuePanel qp) {//start setQp method
		this.qp = qp;
	}//end setQp method

	/**
	 * Getter for newGame
	 * @return newGame
	 */
	public JMenuItem getNewGame() {//start getNewGame method
		return newGame;
	}//end getNewGame method

	/**
	 * Getter for exit
	 * @return exit
	 */
	public JMenuItem getExit() {//start getExit method
		return exit;
	}//end getExit method

	/**
	 * Setter for help
	 * @return help
	 */
	public JMenuItem getHelp() {//start getHelp method
		return help;
	}//end getHelp method

}// end SumFunFrame class
