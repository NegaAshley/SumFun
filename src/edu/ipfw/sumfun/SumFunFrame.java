/*
 * The SumFunFrame class is the frame of Sum Fun game where panels and menus are
 * located.
 */
package edu.ipfw.sumfun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * The SumFunFrame class is the main View class, and builds the GUI
 * 
 * @author Jake
 * 
 */
public class SumFunFrame extends JFrame implements Observer {// start SumFunFrame

	private static final boolean GUI_RESIZABLE = false;// whether or not the
														// frame is resizable
	private static final int GUI_WIDTH = 1250;// the width of the frame
	private static final int GUI_HEIGHT = 525;// the height of the frame
	private static final int GRID_ROWS = 9;// the number of rows
	private static final int GRID_COLS = 9;// the number of columns

	// Error messages
	private static final String INVALID_MOVE_MESSAGE = "Cannot place tile here!";
	private static final String INVALID_REMOVE_NUM_MOVE_MESSAGE = "Cannot remove an "
			+ "empty tile!";
	private static final String EMPTY_TEXT_MESSAGE = "Please enter a name!";

	// Strings to pass to actionPerformed
	private static final String RESET_QUEUE = "Reset Queue";
	private static final String REMOVE_NUMBER = "Remove Number";
	private static final String NEW_UNTIMED = "Untimed";
	private static final String NEW_TIMED = "Timed";
	private static final String GET_USER_NAME = "Get User Name";
	private static final String HINT = "Hint";

	// The model
	// $ private UntimedGame untimedGame;

	// The other model
	// $ private TimedGame timedGame;

	private Game model;// this instance of the game

	// Game type toggle
	// private int gameType;

	private Controller controller;// the controller

	private TopPointPlayers tpp;// the top points players GUI

	private TopTimePlayers ttp;

	// A two-dimensional array of TileView tiles for easy access
	private TileView[][] tiles = new TileView[GRID_ROWS][GRID_COLS];// 2D Array
	//where tiles are located
	private JMenuBar bar;// main menu bar
	private JMenu gameMenu;// menu option holding game options
	private JMenu helpMenu;// menu options holding help options
	private JMenu topMenu;// menu options to view top ten players
	private final JMenuItem resetQueue;// menu option in gameMenu to reset queue
										// once
	private final JMenuItem removeNumber;// menu op;tin in gameMenu to remove
											// all of one number from board
	private final JMenuItem exit;// menu option in gameMenu that will exit the
									// game
	private final JMenuItem hint;// menu option in helpMenu that will bring up
									// hint feature
	private final JMenuItem mostPoints;
	private final JMenuItem fastestTime;
	private final JMenuItem newUntimedGame;
	private final JMenuItem newTimedGame;
	private JPanel initialPanel;// panel to build from
	private JPanel scoreBoardPanel;// panel to hold score and moves left
	private QueuePanel qp;// QueuePanel to hold the queue
	private JLabel scoreLabel;// label for the score
	private JLabel moveLabel;// label for the moves remaining
	private JLabel timeLabel;// label for the time remaining
	private JLabel gridBackLabel;// label for holding grid back
	private GetUserNameDialog gund;// the GetUserNameDialog

	/**
	 * Constructor for the SumFunFrame
	 * 
	 * @param game
	 *            - this instance of the game
	 * @param controller
	 *            - the controller for the game
	 * @param tpp
	 *            - the TopPointsPlayers GUI
	 * @throws IOException
	 * @throws FontFormatException
	 * @throws UnsupportedAudioFileException 
	 * @throws URISyntaxException 
	 * @throws NumberFormatException 
	 */
	// Add TimedGame here
	// $ public SumFunFrame(TimedGame timedGame, final Controller controller) {
	public SumFunFrame(Game game, final Controller controller, TopPointPlayers tpp, 
			TopTimePlayers ttp)
			throws IOException, FontFormatException, NumberFormatException, 
			URISyntaxException, UnsupportedAudioFileException {
		// start SumFunFrame constructor

		super("Sum Fun");// sets title of window

		// Creates and regiters font from .tff file
		Font fontA = Font.createFont(Font.TRUETYPE_FONT, new File("font/lunchds.ttf"));
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(fontA);

		// Sets aspects of the frame
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(GUI_WIDTH, GUI_HEIGHT);
		setResizable(GUI_RESIZABLE);
		setLayout(new GridLayout(1, 1));// sets the layout of the frame to
										// GridLayout

		// Set reference to TopPointPlayers object
		this.tpp = tpp;

		this.ttp = ttp;

		// Set the model to whatever game was passed to the frame's constructor
		this.model = game;

		// Add this frame as an observer to both game types
		UntimedGame.getInstance().addObserver(this);
		TimedGame.getInstance().addObserver(this);

		// Sets reference to controller
		this.controller = controller;

		// Creates and sets the menu bar
		bar = new JMenuBar();
		setJMenuBar(bar);

		// Creates menus
		gameMenu = new JMenu("<html><font size = 6><b> Game</b></font></html>");
		gameMenu.setFont(fontA);
		helpMenu = new JMenu("<html><font size = 6><b> Help</b></font></html>");
		helpMenu.setFont(fontA);
		topMenu = new JMenu("<html><font size = 6><b> Top Players</b></font></html>");
		topMenu.setFont(fontA);

		// Adds menus to menu bar
		bar.add(gameMenu);
		bar.add(topMenu);
		bar.add(helpMenu);

		// Creates menu items for menus
		newUntimedGame = new JMenuItem("New Untimed Game");
		//newUntimedGame.setFont(fontA);
		newTimedGame = new JMenuItem("New Timed Game");
		//newTimedGame.setFont(fontA);
		resetQueue = new JMenuItem("Reset Queue");
		//resetQueue.setFont(fontA);
		removeNumber = new JMenuItem("Remove Number");
		//removeNumber.setFont(fontA);
		exit = new JMenuItem("Exit");
		//exit.setFont(fontA);
		hint = new JMenuItem("Hint");
		//hint.setFont(fontA);
		mostPoints = new JMenuItem("Most Points");
		//mostPoints.setFont(fontA);
		fastestTime = new JMenuItem("Fastest Time");
		//fastestTime.setFont(fontA);

		// Adds menu items to menus
		gameMenu.add(newUntimedGame);
		gameMenu.add(newTimedGame);
		gameMenu.addSeparator();
		gameMenu.add(resetQueue);
		gameMenu.add(removeNumber);
		gameMenu.add(exit);
		helpMenu.add(hint);
		topMenu.add(mostPoints);
		topMenu.add(fastestTime);

		// Creates and adds SumFunPanel
		GameBoardPanel panel = new GameBoardPanel();

		add(panel);

		// Initial panel to be added to frame
		// This panel is intermediate, so we can add another panel
		// on the right side of the frame but only in the north space
		initialPanel = new JPanel();

		initialPanel.setLayout(new BorderLayout());

		// Add initial panel to right of SumFunPanel
		add(initialPanel);

		// Creates scoreBoardPanel
		scoreBoardPanel = new JPanel();
		scoreBoardPanel.setLayout(new GridLayout(1, 2));

		// Adds JLabels and text fields for Score and Moves Remaining
		int moves = 0;
		String moveString = "";
		if (model instanceof UntimedGame) {
			UntimedGame temp = (UntimedGame) model;
			moves = temp.getMovesRemaining();
			moveString = "<html><font size = +1>Moves Remaining: " + moves + 
					" </font></html>";
		} else {
			moveString = "";
		}

		int score = model.getPoints();
		String scoreString = "<html><font size = +1>Score: " + score + 
				"</font></html>";

		String time;

		String timeString = "";
		if (model instanceof TimedGame) {
			TimedGame temp = (TimedGame) model;
			time = temp.getTime();
			timeString += "<html><font size =0.5>Time Remaining: " + time + 
					"</font></html>";
		} else {
			timeString = "";
		}

		scoreLabel = new JLabel(scoreString, SwingConstants.CENTER);
		scoreLabel.setFont(fontA);
		moveLabel = new JLabel(moveString);
		moveLabel.setFont(fontA);
		timeLabel = new JLabel(timeString);
		timeLabel.setFont(fontA);
		scoreBoardPanel.add(scoreLabel);
		scoreBoardPanel.add(moveLabel);
		scoreBoardPanel.add(timeLabel);

		// Add score board panel to the north of initialPanel
		initialPanel.add(scoreBoardPanel, BorderLayout.NORTH);

		// Instantiate a new QueuePanel and add to initialPanel
		qp = new QueuePanel(model);
		initialPanel.add(qp);

		newUntimedGame.setActionCommand(NEW_UNTIMED);
		newUntimedGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//start actionPerformed
			//method
				controller.actionPerformed(e);
			}// end actionPerformed method
		});

		newTimedGame.setActionCommand(NEW_TIMED);
		newTimedGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// start actionPerformed
			//method
				controller.actionPerformed(e);
			}// end actionPerformed method
		});

		mostPoints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TopPointsDialog tpd = new TopPointsDialog();
				tpd.setVisible(true);
			}
		});

		fastestTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FastestTimeDialog ftd = new FastestTimeDialog();
				ftd.setVisible(true);
			}
		});

		// Closes game when exit menu option is selected
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//start actionPerformed
			//method
				TimedGame.getInstance().stopTimer();
				Sounds.BGM1.stopLoop();
				Application.serialize();
				dispose();
			}// end actionPerformed method
		});

		// Resets the queue once and then disables the option
		resetQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetQueue.setActionCommand(RESET_QUEUE);
				controller.actionPerformed(e);

			}
		});

		// Removes all of one number on the game board
		removeNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetQueue.setActionCommand(REMOVE_NUMBER);
				controller.actionPerformed(e);

			}
		});

		// gets a hint
		hint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hint.setActionCommand(HINT);
				controller.actionPerformed(e);

			}
		});

	}// end SumFunFrame constructor

	/**
	 * Set the model to specified Game
	 * 
	 * @param game - the instance of Game to use as model
	 */
	public void setModel(Game game) {// start setModel method
		model = game;
		qp.setGame(game);
	}// end setModel method

	/**
	 * Getter for scoreLabel
	 * 
	 * @return scoreLabel - the label for the score
	 */
	public JLabel getScoreLabel() {// start getScoreLabel method
		return scoreLabel;
	}// end getScoreLabel method

	/**
	 * Setter for scoreLabel
	 * 
	 * @param scoreLabel
	 *            - the label for the score
	 */
	public void setScoreLabel(JLabel scoreLabel) {// start setScoreLabel method
		this.scoreLabel = scoreLabel;
	}// end setScoreLabel method

	/**
	 * Getter for moveLabel
	 * 
	 * @return moveLabel - the label for the moves remaining
	 */
	public JLabel getMoveLabel() {// start getMoveLabel method
		return moveLabel;
	}// end getMoveLabel method

	/**
	 * Setter for moveLabel
	 * 
	 * @param moveLabel
	 *            - the label for the moves remaining
	 */
	public void setMoveLabel(JLabel moveLabel) {// start setMoveLabel method
		this.moveLabel = moveLabel;
	}// end setMoveLabel method

	/**
	 * Getter for bar
	 * 
	 * @return bar - the menu bar
	 */
	public JMenuBar getBar() {// start getBar method
		return bar;
	}// start getBar method

	/*
	 * Setter for bar
	 * 
	 * @param bar - the menu bar
	 */
	public void setBar(JMenuBar bar) {//start  setBar method 
		this.bar = bar; 
	}//end setBar method

	/* 
	 * Getter for gameMenu
	 * 
	 * @return gameMenu - the menu for Game
	 */
	public JMenu getGameMenu() {// start getGameMenu method
		return gameMenu;
	}//end getGameMenu method

	/**
	 * Setter for gameMenu
	 * 
	 * @param gameMenu - the menu for game
	 */
	public void setGameMenu(JMenu gameMenu) {// start setGameMenu method
		this.gameMenu = gameMenu;
	}// end setGameMenu method

	/**
	 * Getter for helpMenu
	 * 
	 * @return helpMenu - the menu for help
	 */
	public JMenu getHelpMenu() {// start getHelpMenu method
		return helpMenu;
	}// end getHelpMenu method

	/**
	 * Setter for helpMenu
	 * 
	 * @param helpMenu - the menu for help
	 */
	public void setHelpMenu(JMenu helpMenu) {// start setHelpMenu method
		this.helpMenu = helpMenu;
	}// end setHelpMenu method

	/**
	 * Getter for initialPanel
	 * 
	 * @return initialPanel - the first panel
	 */
	public JPanel getInitialPanel() {// start getInitialPanel method
		return initialPanel;
	}// end getInitialPanel method

	/**
	 * Setter for initialPanel
	 * 
	 * @param initialPanel - the first panel
	 */
	public void setInitialPanel(JPanel initialPanel) {// start setInitialPanel
	//method
		this.initialPanel = initialPanel;
	}// end setInitialPanel method

	/**
	 * Getter for scoreBoardPanel
	 * 
	 * @return scoreBoardPanel - the panel for the scoreboard
	 */
	public JPanel getScoreBoardPanel() {// start getScoreBoardPanel method
		return scoreBoardPanel;
	}// end getScoreBoardPanel

	/**
	 * Setter for scoreBoardPanel
	 * 
	 * @param scoreBoardPanel - the panel for the scoreboard
	 */
	public void setScoreBoardPanel(JPanel scoreBoardPanel) {// start
	//setScoreBoardPanel method
		this.scoreBoardPanel = scoreBoardPanel;
	}// end setScoreBoardPanel method

	/**
	 * Getter for qp
	 * 
	 * @return qp - the queue panel
	 */
	public QueuePanel getQp() {//start getQp method
		return qp;
	}//end getQp method

	/**
	 * Setter for qp
	 * 
	 * @param qp - the queue panel
	 */
	public void setQp(QueuePanel qp) {//start setQp method
		this.qp = qp;
	}//end setQp method

	/**
	 * Getter for resetQueue
	 * 
	 * @return resetQueue - the reset queue menu item
	 */
	public JMenuItem getResetQueue() {//start getResetQueue method
		return resetQueue;
	}//end getResetQueue method

	/**
	 * Getter for exit
	 * 
	 * @return exit - the exit menu item
	 */
	public JMenuItem getExit() {//start getExit method
		return exit;
	}//end getExit method

	/**
	 * Getter for help
	 * 
	 * @return help - the help menu item
	 */
	public JMenuItem getHint() {//start getHint method
		return hint;
	}//end getHelp method

	/*
	 * Getter for removeNumber menu
	 * 
	 * @return removeNumber - the menu to remove numbers
	 */
	public JMenuItem getRemoveNumber() {//start getRemoveNumber method
		return removeNumber;
	}//end getRemoveNumber method
	
	/*
	 * Getter for this SumFunFrame
	 * 
	 * @returns this.SumFunFrame
	 */
	public SumFunFrame getSumFunFrame() {//start getSumFunFrame method
		return this;
	}//end getSumFunFrame method

	/*
	 * Getter for GetUserNameDialog
	 * 
	 * @returns this.GetUserNameDialog
	 */
	public GetUserNameDialog getUserNameDialog() {//start getUserNameDialog
		//method
		return gund;
	}//end getUserNameDialog method

	/*
	 * Getter for the tiles.
	 * 
	 * @returns tiles
	 */
	public TileView[][] getTileGrid() {//start getTileGrid method
		return tiles;
	}//end getTileGrid method

	/*
	 * Makes moveLabel visible if true is given ore invisible if false is given.
	 * 
	 * @param visible - true if visibility desired
	 */
	public void setMoveLabelVisible(boolean visible) {//start setMoveLabelVisible 
		//method
		moveLabel.setVisible(visible);
	}//end setMoveLabelVisibile method

	/*
	 * Makes timeLabel visible if true is given ore invisible if false is given.
	 * 
	 * @param visible - true if visibility desired
	 */
	public void setTimeLabelVisible(boolean visible) {//start setTimeLabelVisible 
		//method
		timeLabel.setVisible(visible);
	}//end setTimeLabelVisible method

	/**
	 * Updates each GUI component with corresponding model element
	 * 
	 * @param arg0 - the first argument
	 * @param arg1 - the second arguement
	 */
	@Override
	public void update(Observable arg0, Object arg1) {//start update method

		repaint();

		// Disable the removeNumber option from the menu
		// if it has been used already
		if (!model.getRemoveNumAvailable()) {
			removeNumber.setEnabled(false);
		}

		// Disable queue refresh option from menu
		// if it has been used already
		if (!model.getQueueResetAvailable()) {
			resetQueue.setEnabled(false);
		}

		// Update score
		String score = "<html><font size = +1>Score: " + model.getPoints() + 
				"</font></html>";
		scoreLabel.setText(score);

		// Update moves remaining
		// if the model is an UntimedGame
		if (model instanceof UntimedGame) {
			UntimedGame temp = (UntimedGame) model;
			String move = "<html><font size = +1>Moves Remaining: " + 
			temp.getMovesRemaining() + " </font></html>";
			moveLabel.setText(move);
		} else {
			String move = "Moves Remaining: N/A";
			moveLabel.setText(move);
			moveLabel.setVisible(false);
		}

		// Update time remaining
		// if the model is a TimedGame
		if (model instanceof TimedGame) {
			TimedGame temp = (TimedGame) model;
			String time = "<html><font size = +1>Time Remaining: " + temp.getTime() 
			+ "</font></html>";
			timeLabel.setText(time);
		} else {
			String time = "Time Remaining: N/A";
			timeLabel.setText(time);
			timeLabel.setVisible(false);
		}

		// Here we are checking if the game is active or not
		// If it isn't, we have reached the game's end and should
		// Process things accordingly
		if (!model.getIsActive() && model.getGameWon()) {

			model.setIsActive(true);
			if (model instanceof TimedGame) {
				TimedGame temp = (TimedGame) model;
				temp.stopTimer();
			}

			gund = new GetUserNameDialog();
			gund.setVisible(true);
			getSumFunFrame().setVisible(false);

		} else if (model.getIsActive() == false && !model.getGameWon()) {
			model.setIsActive(true);

			if (model instanceof TimedGame) {
				TimedGame temp = (TimedGame) model;
				temp.stopTimer();
			}

			JOptionPane.showMessageDialog(this, "Game Over!");
			int id = ActionEvent.ACTION_FIRST;
			String eventString = "Game Over";
			controller.actionPerformed(new ActionEvent(this, id, eventString));

		}

		// Repaint the frame
		repaint();

	}// end update method

	/**
	 * Display an alert that an invalid move was attempted by the player
	 */
	public void invalidMoveEvent() {//start invalidMoveEvent method
		JOptionPane.showMessageDialog(this, INVALID_MOVE_MESSAGE);
	}//end invalidMoveEvent method

	/**
	 * Display an alert that an the player cannot remove an empty tile
	 */
	public void invalidRemoveNumMoveEvent() {//start invalidRemoveNumMoveEvent
		//method
		JOptionPane.showMessageDialog(this, INVALID_REMOVE_NUM_MOVE_MESSAGE);
	}//end invalidRemoveNumMoveEvent method

	/**
	 * GameBoardPanel is the panel which holds the game grid GameBoardPanel is
	 * an inner class of SumFunFrame
	 * 
	 * @author Ashley
	 *
	 */
	public class GameBoardPanel extends JPanel {//start GameBoardPanel class

		/**
		 * GameBoardPanel constructor
		 * 
		 * @throws IOException
		 * @throws UnsupportedAudioFileException 
		 * @throws URISyntaxException 
		 */
		public GameBoardPanel() throws IOException, URISyntaxException, 
		UnsupportedAudioFileException {//start GameBoardPanel constructor

		
			// Creates grid of size GRID_ROWS by GRID_COLS
			setLayout(new GridLayout(GRID_ROWS, GRID_COLS));

			// Iterates through the tileView 2D array
			for (int row = 0; row < GRID_ROWS; row++) {
				for (int col = 0; col < GRID_COLS; col++) {

					// Create a new tile and add it to the 2D array
					final TileView tile = new TileView(row, col, Color.GRAY, 
							Color.WHITE);
					tile.addActionListener(controller);
					tiles[row][col] = tile;

					// Adds MouseListener to SumFunPanel
					addMouseListener(new MouseAdapter() {

						/**
						 * Process MouseEvent when tile is clicked
						 */
						public void mouseClicked(MouseEvent e) {// start
																// mouseClicked
																// method

							/**
							 * Checks to see left mouse button was clicked and
							 * tile contains the x,y coordinates
							 */
							if (e.getButton() == 1 && tile.contains(e.getX(), 
									e.getY())) {
								tile.processEvent();
							}
						}// end mouseClicked method

					});// end addMouseListner
				} // end nested for
			} // end for

			Sounds.BGM1.loop();
		}// end SumFunPanel constructor

		/*
		 * Paints components
		 * 
		 * @param g - the graphics component
		 */
		public void paintComponent(Graphics g) {//start paintComponent method
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			//Reference to image
			Images ins;
			try {
				ins = new Images();
				g.drawImage(ins.getGridBack(), 0, -5,null);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			// Iterates through tiles and draws tiles onto panel
			for (int row = 0; row < GRID_ROWS; row++) {
				for (int col = 0; col < GRID_COLS; col++) {
					try {
						tiles[row][col].draw(g2, 
								model.getGameBoard().getTileGrid()[row][col]);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}//end paintComponent method

	}//end SumFunPanel class

	/**
	 * Dialog box to display the top 10 players by points earned
	 * 
	 * @author Jake
	 *
	 */
	class TopPointsDialog extends JDialog {//start TopPointsDialog class

		private static final int TOP_POINTS_WIDTH = 600;//the width of the top 
			//points
		private static final int TOP_POINTS_LENGTH = 400;//the length of the
			//top points
		private static final int GRID_ROWS = 10;//the number of rows in the
			//table
		private static final int GRID_COLS = 3;//the number of columns in the
			//table
		private static final boolean RESIZABLE = false;//whether or not the
			//JDialog is resizeable

		private ArrayList<JLabel> nameList = new ArrayList<>();// keeps the list
			//of winner names
		private ArrayList<JLabel> scoreList = new ArrayList<>();// keeps the
			//list of winner scores
		private ArrayList<JLabel> dateList = new ArrayList<>();// keeps the list
			//of winner dates

		/**
		 * Constructor for TopPoints Dialog
		 */
		public TopPointsDialog() {//start TopPointsDialog constructor

			//Set some properties of the dialog box
			setSize(TOP_POINTS_WIDTH, TOP_POINTS_LENGTH);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setTitle("Top 10 Players - Most Points");
			setResizable(RESIZABLE);

			JPanel listPanel = new JPanel();
			listPanel.setLayout(new GridLayout(GRID_ROWS, GRID_COLS));
			String name = "";
			String score = "";
			String date = "";

			for (int i = 0; i < GRID_ROWS; i++) {

				// Add new JLabels to each of the arraylists
				nameList.add(i, new JLabel());
				scoreList.add(i, new JLabel());
				dateList.add(i, new JLabel());

				// Populate labels with appropriate records as long as they
				// exist
				// If exception is thrown, there is an insufficient number of
				// records
				// And we must display empty records
				try {
					ScoreRecord currentRecord = tpp.getRecord(i);
					name = currentRecord.getName();
					score = "" + currentRecord.getPoints();
					date = currentRecord.getDateString();
				} catch (IndexOutOfBoundsException e) {
					name = "";
					score = "";
					date = "";

				} finally {

					if (i < 9) {
						nameList.get(i).setText(" " + (i + 1) + ".    " + "Name: " 
					+ name);
						scoreList.get(i).setText("Score: " + score);
						dateList.get(i).setText("Date: " + date);
					} else {
						nameList.get(i).setText(" " + (i + 1) + ".  " + "Name: " 
					+ name);
						scoreList.get(i).setText("Score: " + score);
						dateList.get(i).setText("Date: " + date);
					}

					listPanel.add(nameList.get(i));
					listPanel.add(scoreList.get(i));
					listPanel.add(dateList.get(i));
				}

			}

			add(listPanel);

		}//end TopPoints dialog constructor

	}//end class TopPointsDialog

	/**
	 * Dialog box to display the top 10 players by lowest completion time
	 * 
	 * @author Jake
	 *
	 */
	class FastestTimeDialog extends JDialog {//start FastestTimeDialog class

		private static final int TOP_POINTS_WIDTH = 600;// the width of the top
														// points
		private static final int TOP_POINTS_LENGTH = 400;// the length of the
															// top points
		private static final int GRID_ROWS = 10;// the number of rows in the
												// table
		private static final int GRID_COLS = 3;// the number of columns in the
												// table
		private static final boolean RESIZABLE = false;// whether or not the
														// JDialog is

		private ArrayList<JLabel> nameList = new ArrayList<>();// keeps the list
																// of winner
		// names
		private ArrayList<JLabel> timeList = new ArrayList<>();// keeps the list
																// of
		// winner times
		private ArrayList<JLabel> dateList = new ArrayList<>();// keeps the list
																// of winner
		// dates

		/**
		 * Constructor for FastestTimeDialog
		 */
		public FastestTimeDialog() {//start FastestTimeDialog constructor

			// Set some properties of the dialog box
			setSize(TOP_POINTS_WIDTH, TOP_POINTS_LENGTH);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setTitle("Top 10 Players - Fastest Completion Time");
			setResizable(RESIZABLE);

			JPanel listPanel = new JPanel();
			listPanel.setLayout(new GridLayout(GRID_ROWS, GRID_COLS));
			String name = "";
			String time = "";
			String date = "";

			for (int i = 0; i < GRID_ROWS; i++) {

				// Add new JLabels to each of the arraylists
				nameList.add(i, new JLabel());
				timeList.add(i, new JLabel());
				dateList.add(i, new JLabel());

				// Populate labels with appropriate records as long as they
				// exist
				// If exception is thrown, there is an insufficient number of
				// records
				// And we must display empty records
				try {
					TimeRecord currentRecord = ttp.getRecord(i);
					name = currentRecord.getName();
					time = "" + currentRecord.getFormattedTime();
					date = currentRecord.getDateString();
				} catch (IndexOutOfBoundsException e) {
					name = "";
					time = "";
					date = "";

				} finally {

					if (i < 9) {
						nameList.get(i).setText(" " + (i + 1) + ".    " + "Name: " 
					+ name);
						timeList.get(i).setText("Time: " + time);
						dateList.get(i).setText("Date: " + date);
					} else {
						nameList.get(i).setText(" " + (i + 1) + ".  " + "Name: " 
					+ name);
						timeList.get(i).setText("Time: " + time);
						dateList.get(i).setText("Date: " + date);
					}

					listPanel.add(nameList.get(i));
					listPanel.add(timeList.get(i));
					listPanel.add(dateList.get(i));
				}

			}

			add(listPanel);

		}//end FastestTimeDialog constructor

	}//end FastestTimeDialog class

	/*
	 * This class is a dialog box used to get the name of the user at the end of
	 * the game.
	 */
	class GetUserNameDialog extends JDialog {// start getUserNameDialog class
		private static final int GET_USER_WIDTH = 400;// the width of the dialog
			//box
		private static final int GET_USER_LENGTH = 100;// the length of the
			//dialog box
		private static final boolean RESIZABLE = false;// whether or not box is
			//resizeable
		// The text for the JLabel preceding the text box
		private static final String GET_USER_DIALOG = "Game over!  Enter name:";
		private JLabel userDialogLabel;// the label before the text box
		private JTextField userNameTextField;// the text field where user enters
			//name
		private JButton okButton;// the button to confirm
		private String userName;// the entered name of the user
		
		/*
		 * The constructor for the getUserNameDialog class.
		 */
		public GetUserNameDialog() {//start getUserNameDialog constructor
			// Set some properties of the dialog box
			setSize(GET_USER_WIDTH, GET_USER_LENGTH);
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			setTitle("Game Over - Enter Name");
			setResizable(RESIZABLE);
			setLayout(new FlowLayout());

			// Creates label and adds it to dialog box
			userDialogLabel = new JLabel(GET_USER_DIALOG);
			add(userDialogLabel);

			// Creates text field and adds it to dialog box
			userNameTextField = new JTextField(10);
			add(userNameTextField);

			// Creates ok button and adds it to dialog box
			okButton = new JButton("Ok");
			add(okButton);
			okButton.setActionCommand(GET_USER_NAME);

			// Grabs the text from the text box and creates
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// If textbox is empty, show a dialog and return to
					// GetUserNameDialog
					if (isTextBoxEmpty() == true) {
						JOptionPane.showMessageDialog(getGetUserNameDialog(), 
								EMPTY_TEXT_MESSAGE);
						return;
					}
					controller.actionPerformed(e);
				}
			});
		}//end getUserNameDialog constructor

		/*
		 * Assigns username from text box
		 */
		public void assignUserName() {//start assignUserName method
			userName = userNameTextField.getText();
			// System.out.println(userName);
		}//end assignUserName method

		/*
		 * Returns the username
		 * 
		 * @returns userName - the name of the user
		 */
		public String getUserName() {//start getUserName method
			// System.out.println(userName);
			return userName;
		}//end getUserName method

		/*
		 * Returns true if the textbox is empty.
		 * 
		 * @returns true if textbox is empty
		 */
		public boolean isTextBoxEmpty() {//start isTextBoxEmpty method
			return userNameTextField.getText().equals("");
		}//end isTextBoxEmpty method

		/*
		 * Returns this dialog
		 * 
		 * @returns this.GetUserNameDialog
		 */
		public GetUserNameDialog getGetUserNameDialog() {//start
			//getGetUserNameDialog method
			return this;
		}//end getGetUserNameDialog method

	}//end getUserNameDialog class

}//end SumFunFrame class
