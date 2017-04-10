/*
 * The SumFunFrame class is the frame of Sum Fun game where panels and menus are
 * located.
 */
package edu.ipfw.sumfun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * The SumFunFrame class is the main View class, and builds the GUI
 * @author Jake
 * 
 */
public class SumFunFrame extends JFrame implements Observer {// start SumFunFrame
	
	//Various constants for use throughout SumFunFrame
	private static final boolean GUI_RESIZABLE = false;
	private static final int GUI_WIDTH = 1000;
	private static final int GUI_HEIGHT = 525;
    private static final int GRID_ROWS = 9;
    private static final int GRID_COLS = 9;
    private static final String INVALID_MOVE_MESSAGE = "Cannot place tile here!";
	private static final String RESET_QUEUE = "Reset Queue";
	
    //The model
	private UntimedGame untimedGame;
	
	//The other model
	private TimedGame timedGame;
	
	//Game type toggle
	//private int gameType;
	
	//The controller
	private Controller controller;
	
    //A two-dimensional array of TileView tiles for easy access
    private TileView[][] tiles = new TileView[GRID_ROWS][GRID_COLS];//2D Array where tiles are located
	private JMenuBar bar;//main menu bar
	private JMenu gameMenu;//menu option holding game options
	private JMenu helpMenu;//menu options holding help options
	private JMenu topMenu;//menu options to view top ten players
	private final JMenuItem newGame;//menu option in gameMenu that will create a new game
	private final JMenuItem resetQueue;//menu option in gameMenu to reset queue once
	private final JMenuItem exit;//menu option in gameMenu that will exit the game
	private final JMenuItem help;//menu option in helpMenu that will bring up help features
	private final JMenuItem mostPoints;
	private final JMenuItem newUntimedGame;
	private final JMenuItem newTimedGame;
	private JPanel initialPanel;//panel to build from
	private JPanel scoreBoardPanel;//panel to hold score and moves left
	private QueuePanel qp;//QueuePanel to hold the queue
	private JLabel scoreLabel;//label for the score
	private JLabel moveLabel;//label for the moves remaining
	private JLabel timeLabel;//label for the time remaining
	
	/**
	 * Constructor for the SumFunFrame
	 */
	//Add TimedGame here
	//$ public SumFunFrame(TimedGame timedGame, final Controller controller) {
	public SumFunFrame(UntimedGame untimedGame, final Controller controller) {//start SumFunFrame constructor

		super("Sum Fun");// sets title of window
		setDefaultCloseOperation(EXIT_ON_CLOSE);//exits game on close
		setSize(GUI_WIDTH, GUI_HEIGHT);
		setResizable(GUI_RESIZABLE);
		setLayout(new GridLayout(1, 1));//sets the layout of the frame to GridLayout
		
		//Register view as observer of model
		//change to timedgame constructor
		//$ this.timedGame = timedGame;
		this.untimedGame = untimedGame;
		//change to timedgame
		//$ timedGame.addObserver(this);
		untimedGame.addObserver(this);
		
		this.controller = controller;
		
		// Creates and sets the menu bar
		bar = new JMenuBar();
		setJMenuBar(bar);

		//Creates menus
		gameMenu = new JMenu("Game");
		helpMenu = new JMenu("Help");
		topMenu = new JMenu("Top Players");

		//Adds menus to menu bar
		bar.add(gameMenu);
		bar.add(topMenu);
		bar.add(helpMenu);

		//Creates menu items for menus
		newGame = new JMenuItem("New Game");
		newUntimedGame = new JMenuItem("New Untimed Game");
		newTimedGame = new JMenuItem("New Timed Game");
		resetQueue = new JMenuItem("Reset Queue");
		exit = new JMenuItem("Exit");
		help = new JMenuItem("Help");
		mostPoints = new JMenuItem("Most Points");

		//Adds menu items to menus
		gameMenu.add(newGame);
		gameMenu.add(newUntimedGame);
		gameMenu.add(newTimedGame);
		gameMenu.addSeparator();
		gameMenu.add(resetQueue);
		gameMenu.add(exit);
		helpMenu.add(help);
		topMenu.add(mostPoints);

		//Creates and adds SumFunPanel
		GameBoardPanel panel = new GameBoardPanel();
		add(panel);
		
		//Initial panel to be added to frame
		//This panel is intermediate, so we can add another panel
		//on the right side of the frame but only in the north space
		initialPanel = new JPanel();
		initialPanel.setLayout(new BorderLayout());

		//Add initial panel to right of SumFunPanel
		add(initialPanel);

		//Creates scoreBoardPanel
		scoreBoardPanel = new JPanel();
		scoreBoardPanel.setLayout(new GridLayout(2, 2));

		//Adds JLabels and text fields for Score and Moves Remaining
		int score = Application.getPoints();
		String scoreString = "Score: " + score;
		int moves = Application.getMoves();
		//$ String timeString = "Time Remaining: " + time;
		//$ String time = Application.getTime();
		String moveString = "Moves Remaining: " + moves;
		//$ String timeString = "Time Remaining: " + time;
		scoreLabel = new JLabel(scoreString);
		moveLabel = new JLabel(moveString);
		//$ timeLabel = new JLabel(timeString);
		scoreBoardPanel.add(scoreLabel);
		scoreBoardPanel.add(moveLabel);
		//$ scoreBoardPanel.add(timeLabel);
		
		//Add score board panel to the north of initialPanel
		initialPanel.add(scoreBoardPanel, BorderLayout.NORTH);

		// Instantiate a new QueuePanel and add to initialPanel
		qp = new QueuePanel();
		initialPanel.add(qp);

		//Resets board when new game is selected
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//start actionPerformed method

			}//end actionPerformed method
		});
		
		mostPoints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TopPointsDialog tpd = new TopPointsDialog();
				tpd.setVisible(true);
			}
		});
		
		//Closes game when exit menu option is selected
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//start actionPerformed method
				dispose();
			}//end actionPerformed method
		});
		
		//Resets the queue once and then disables the option
		resetQueue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				resetQueue.setActionCommand(RESET_QUEUE);
				controller.actionPerformed(e);
				
			}
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
	 * Getter for resetQueue
	 * @return resetQueue
	 */
	public JMenuItem getResetQueue() {//start getResetQueue method
		return resetQueue;
	}//end getResetQueue method
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
	
	/**
	 * Updates each GUI component with corresponding model element
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		
		//Update score
		String score = "Score: " + untimedGame.getPoints();
		scoreLabel.setText(score);
		
		//Update moves remaining
		
		String move = "Moves Remaining: " + untimedGame.getMovesRemaining();
		moveLabel.setText(move);
		
		//These strings handle timer update
		//$ String time = "Time Remaining: " + timedGame.getTime();
		//$ timeLabel.setText(time);
		
		//Repaint the frame
		repaint();
		
	}//end update
	
	/**
	 * Display an alert that an invalid move was attempted by the player
	 */
	public void invalidMoveEvent() {
		JOptionPane.showMessageDialog(this, INVALID_MOVE_MESSAGE);
	}//end invalidMoveEvent
	
	/**
	 * GameBoardPanel is the panel which holds the game grid
	 * GameBoardPanel is an inner class of SumFunFrame
	 * @author Ashley
	 *
	 */
	public class GameBoardPanel extends JPanel{//start GameBoardPanel class
	    
	    /**
	     * GameBoardPanel constructor
	     */
	    public GameBoardPanel() {//start GameBoardPanel constructor
	    	
	        //Creates grid of size GRID_ROWS by GRID_COLS
	        setLayout(new GridLayout(GRID_ROWS, GRID_COLS));
	        
	        //Iterates through the tileView 2D array
	        for (int row = 0; row < GRID_ROWS; row++) {
	            for (int col = 0; col < GRID_COLS; col++) {
	            	
	            	//Create a new tile and add it to the 2D array
	                final TileView tile = new TileView(row, col, Color.GRAY);
	                tile.addActionListener(controller);
	                tiles[row][col] = tile;

	                //Adds MouseListener to SumFunPanel
	                addMouseListener(new MouseAdapter() {

	                    /**
	                     * Process MouseEvent when tile is clicked
	                     */
	                    public void mouseClicked(MouseEvent e){//start mouseClicked method
	                    	
	                        /**
	                         * Checks to see left mouse button was clicked and tile 
	                         * contains the x,y coordinates
	                         */
	                        if(e.getButton() == 1 && tile.contains(e.getX(), e.getY())){
		                        	tile.processEvent();
	                        }
	                    }//end mouseClicked method
	                    
	                });//end addMouseListner
	            }//end nested for
	        }//end for 
	        
	    }//end SumFunPanel constructor
	     
	    /*
	     * Paints components
	     */
	    public void paintComponent(Graphics g){//start paintComponent method
	        super.paintComponent(g);
	        Graphics2D g2 = (Graphics2D) g;
	        
	        //Iterates through tiles and draws tiles onto panel
	        for(int row = 0; row < GRID_ROWS; row++) {
	        	for(int col = 0; col < GRID_COLS; col++) {
	        		tiles[row][col].draw(g2, Application.getGameBoard().getTileGrid()[row][col]);
	        	}
	        }
	    }//end paintComponent method
	    
	}//end SumFunPanel class
	
	/**
	 * 
	 * @author Jake
	 *
	 */
	class TopPointsDialog extends JDialog {
		
		private final int TOP_POINTS_WIDTH = 400;
		private final int TOP_POINTS_LENGTH = 400;
		private final int GRID_ROWS = 10;
		private final int GRID_COLS = 3;
		private final boolean RESIZABLE = false;
		
        private ArrayList<JLabel> nameList = new ArrayList<>();
        private ArrayList<JLabel> scoreList = new ArrayList<>();
        private ArrayList<JLabel> dateList = new ArrayList<>();
		
		public TopPointsDialog() {
			
			//Set some properties of the dialog box
			setSize(TOP_POINTS_WIDTH, TOP_POINTS_LENGTH);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setTitle("Top 10 Players - Most Points");
			setResizable(RESIZABLE);
			
			JPanel listPanel = new JPanel();
			listPanel.setLayout(new GridLayout(GRID_ROWS, GRID_COLS));
			
			for(int i = 0; i < GRID_ROWS; i++) {
				
				nameList.add(i, new JLabel());
				scoreList.add(i, new JLabel());
				dateList.add(i, new JLabel());
				
				nameList.get(i).setText("Name test " + i);
				scoreList.get(i).setText("Score test " + i);
				dateList.get(i).setText("Date test " + i);
				
				listPanel.add(nameList.get(i));
				listPanel.add(scoreList.get(i));
				listPanel.add(dateList.get(i));
				
			}
			
			add(listPanel);
			
		}

		
	}//end class TopPointsDialog

}// end SumFunFrame class
