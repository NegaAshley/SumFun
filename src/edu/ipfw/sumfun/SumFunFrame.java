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
 * 
 * @author Jake
 * 
 */
public class SumFunFrame extends JFrame {// start SumFunFrame

	JMenuBar bar;
	JMenu gameMenu;
	JMenu helpMenu;
	final JMenuItem newGame;
	final JMenuItem exit;
	final JMenuItem help;
	JPanel initialPanel;
	JPanel scoreBoardPanel;
	QueuePanel qp;
	JLabel scoreLabel;
	JLabel moveLabel;
	
	public JLabel getScoreLabel() {
		return scoreLabel;
	}

	public void setScoreLabel(JLabel scoreLabel) {
		this.scoreLabel = scoreLabel;
	}

	public JLabel getMoveLabel() {
		return moveLabel;
	}

	public void setMoveLabel(JLabel moveLabel) {
		this.moveLabel = moveLabel;
	}

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

	public JMenuBar getBar() {
		return bar;
	}

	public void setBar(JMenuBar bar) {
		this.bar = bar;
	}

	public JMenu getGameMenu() {
		return gameMenu;
	}

	public void setGameMenu(JMenu gameMenu) {
		this.gameMenu = gameMenu;
	}

	public JMenu getHelpMenu() {
		return helpMenu;
	}

	public void setHelpMenu(JMenu helpMenu) {
		this.helpMenu = helpMenu;
	}

	public JPanel getInitialPanel() {
		return initialPanel;
	}

	public void setInitialPanel(JPanel initialPanel) {
		this.initialPanel = initialPanel;
	}

	public JPanel getScoreBoardPanel() {
		return scoreBoardPanel;
	}

	public void setScoreBoardPanel(JPanel scoreBoardPanel) {
		this.scoreBoardPanel = scoreBoardPanel;
	}

	public QueuePanel getQp() {
		return qp;
	}

	public void setQp(QueuePanel qp) {
		this.qp = qp;
	}

	public JMenuItem getNewGame() {
		return newGame;
	}

	public JMenuItem getExit() {
		return exit;
	}

	public JMenuItem getHelp() {
		return help;
	}
	
// end SumFunFrame constructor
}
// end SumFunFrame
