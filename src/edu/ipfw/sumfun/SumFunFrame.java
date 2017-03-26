/*
 * The SumFunFrame class is the frame of Sum Fun game where panels and menus are
 * located.
 */
package edu.ipfw.sumfun;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
public class SumFunFrame extends JFrame{//start SumFunFrame
	
	public SumFunFrame(){//start SumFunFrame constructor
		
		super("Sum Fun");//sets title of window
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 1));//TODO maybe remove
		//Creates and sets the menu bar
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        
        //Creates menus
        JMenu gameMenu = new JMenu("Game");
        JMenu helpMenu = new JMenu("Help");
        
        //Adds menus to menu bar
        bar.add(gameMenu);
        bar.add(helpMenu);
        
        //Creates menu items for menus
        final JMenuItem newGame = new JMenuItem("New Game");
        final JMenuItem exit = new JMenuItem("Exit");
        final JMenuItem help = new JMenuItem("Help");
        
        //Adds menu items to menus
        gameMenu.add(newGame);
        gameMenu.add(exit);
        helpMenu.add(help);
        
        //Closes game when exit menu option is selected
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
        
        //Initial panel to be added to frame
        //This panel is intermediate, so we can add another panel
        //on the right side of the frame but only in the north space
        JPanel initialPanel = new JPanel();
        initialPanel.setLayout(new BorderLayout());
        
        //Creates and adds SumFunPanel 
        SumFunPanel panel = new SumFunPanel();
        add(panel);
        
        //Creates scoreBoardPanel
        JPanel scoreBoardPanel = new JPanel();
        scoreBoardPanel.setLayout(new GridLayout(2, 2));
        
        JTextField scoreTextField = new JTextField(3);
        JTextField movesRemainingTextField = new JTextField(3);
        
        //Makes text fields uneditable
        scoreTextField.setEnabled(false);
        movesRemainingTextField.setEnabled(false);
        
        //Adds JLabels and text fields for Score and Moves Remaining
        scoreBoardPanel.add(new JLabel("Score:"));
        scoreBoardPanel.add(scoreTextField);
        scoreBoardPanel.add(new JLabel("Moves Remaining: "));
        scoreBoardPanel.add(movesRemainingTextField);
        
        
        //Add scoreboard panel to the north of initialPanel
        initialPanel.add(scoreBoardPanel, BorderLayout.NORTH);
        
        //Queue
        JPanel queuePanel = new JPanel();
        queuePanel.setLayout(new GridLayout(5, 1, 4, 4));
        
        TileView queueTile = new TileView(-1, -1, Color.GRAY);
        TileView queueTile1 = new TileView(-1, -1, Color.GRAY);
        TileView queueTile2 = new TileView(-1, -1, Color.GRAY);
        TileView queueTile3 = new TileView(-1, -1, Color.GRAY);
        TileView queueTile4 = new TileView(-1, -1, Color.GRAY);
        
//        queuePanel.add(queueTile);
//        queuePanel.add(queueTile1);
//        queuePanel.add(queueTile2);
//        queuePanel.add(queueTile3);
//        queuePanel.add(queueTile4);
        
        initialPanel.add(queuePanel, BorderLayout.CENTER);
        
        //Add initial panel 
        add(initialPanel);
        
        //Resets board when new game is selected
        newGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
//                panel.resetBoard(getBackground());
            }
        });
        //test comment
        //changes
	}//end SumFunFrame constructor
}//end SumFunFrame
