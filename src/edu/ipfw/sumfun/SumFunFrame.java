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
	 * getter for scoreLabel
	 * @return scoreLabel
	 */
	public JLabel getScoreLabel() {
		return scoreLabel;
	}
	
	/**
	 * setter for scoreLabel
	 * @param scoreLabel
	 */
	public void setScoreLabel(JLabel scoreLabel) {
		this.scoreLabel = scoreLabel;
	}
	
	/**
	 * getter for moveLabel
	 * @return moveLabel
	 */
	public JLabel getMoveLabel() {
		return moveLabel;
	}

	/**
	 * setter for moveLabel
	 * @param moveLabel
	 */
	public void setMoveLabel(JLabel moveLabel) {
		this.moveLabel = moveLabel;
	}

	/**
	 * builds the frame
	 */
	public SumFunFrame() {// start SumFunFrame constructor

		super("Sum Fun");// sets title of window
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new GridLayout(1, 1));// TODO maybe remove
		// Creates and sets the menu bar
		bar = new JMenuBar();
		setJMenuBar(bar);

		// Creates menus
		gameMenu = new JMenu("Game");
		helpMenu = new JMenu("Help");

		// Adds menus to menu bar
		bar.add(gameMenu);
		bar.add(helpMenu);

		// Creates menu items for menus
		newGame = new JMenuItem("New Game");
		exit = new JMenuItem("Exit");
		help = new JMenuItem("Help");

		// Adds menu items to menus
		gameMenu.add(newGame);
		gameMenu.add(exit);
		helpMenu.add(help);

		// Closes game when exit menu option is selected
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// Initial panel to be added to frame
		// This panel is intermediate, so we can add another panel
		// on the right side of the frame but only in the north space
		initialPanel = new JPanel();
		initialPanel.setLayout(new BorderLayout());

		// Creates and adds SumFunPanel
		GameBoardPanel panel = new GameBoardPanel();
		add(panel);

		// Add initial panel to right of SumFunPanel
		add(initialPanel);

		// Creates scoreBoardPanel
		scoreBoardPanel = new JPanel();
		scoreBoardPanel.setLayout(new GridLayout(2, 2));

		// Adds JLabels and text fields for Score and Moves Remaining
		scoreLabel = new JLabel("Score: ");
		moveLabel = new JLabel("Moves Remaining: ");
		scoreBoardPanel.add(scoreLabel);
		scoreBoardPanel.add(moveLabel);
		
		// Add scoreboard panel to the north of initialPanel
		initialPanel.add(scoreBoardPanel, BorderLayout.NORTH);

		// Instantiate a new QueuePanel
		qp = new QueuePanel();

		initialPanel.add(qp);

		// Resets board when new game is selected
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// panel.resetBoard(getBackground());
			}
		});
		
		// test comment
		// changes
	}

	/**
	 * getter for bar
	 * @return bar
	 */
	public JMenuBar getBar() {
		return bar;
	}

	/**
	 * setter for bar
	 * @param bar
	 */
	public void setBar(JMenuBar bar) {
		this.bar = bar;
	}

	/**
	 * getter for gameMenu
	 * @return gameMenu
	 */
	public JMenu getGameMenu() {
		return gameMenu;
	}

	/**
	 * setter for gameMenu
	 * @param gameMenu
	 */
	public void setGameMenu(JMenu gameMenu) {
		this.gameMenu = gameMenu;
	}

	/**
	 * getter for helpMenu
	 * @return helpMenu
	 */
	public JMenu getHelpMenu() {
		return helpMenu;
	}

	/**
	 * setter for helpMenu
	 * @param helpMenu
	 */
	public void setHelpMenu(JMenu helpMenu) {
		this.helpMenu = helpMenu;
	}

	/**
	 * getter for initialPanel
	 * @return initialPanel
	 */
	public JPanel getInitialPanel() {
		return initialPanel;
	}

	/**
	 * setter for initialPanel
	 * @param initialPanel
	 */
	public void setInitialPanel(JPanel initialPanel) {
		this.initialPanel = initialPanel;
	}

	/**
	 * getter for scoreBoardPanel
	 * @return scoreBoardPanel
	 */
	public JPanel getScoreBoardPanel() {
		return scoreBoardPanel;
	}

	/**
	 * setter for scoreBoardPanel
	 * @param scoreBoardPanel
	 */
	public void setScoreBoardPanel(JPanel scoreBoardPanel) {
		this.scoreBoardPanel = scoreBoardPanel;
	}

	/** 
	 * getter for qp
	 * @return qp
	 */
	public QueuePanel getQp() {
		return qp;
	}

	/**
	 * setter for qp
	 * @param qp
	 */
	public void setQp(QueuePanel qp) {
		this.qp = qp;
	}

	/**
	 * getter for newGame
	 * @return newGame
	 */
	public JMenuItem getNewGame() {
		return newGame;
	}

	/**
	 * getter for exit
	 * @return exit
	 */
	public JMenuItem getExit() {
		return exit;
	}

	/**
	 * getter for help
	 * @return help
	 */
	public JMenuItem getHelp() {
		return help;
	}
	
// end SumFunFrame constructor
}
// end SumFunFrame
