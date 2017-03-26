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
        
        //Text fields for score and moves
        JTextField scoreTextField = new JTextField(3);
        JTextField movesRemainingTextField = new JTextField(3);
        
        scoreBoardPanel.add(new JLabel("Score:"));
        scoreBoardPanel.add(scoreTextField);
        scoreBoardPanel.add(new JLabel("Moves Remaining: "));
        scoreBoardPanel.add(movesRemainingTextField);
        
        initialPanel.add(scoreBoardPanel, BorderLayout.NORTH);
        
        //Queue
        JPanel queuePanel = new JPanel();
        queuePanel.setLayout(new GridLayout(5, 1, 4, 4));
        
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        JPanel qPanel = new JPanel();
        qPanel.setBackground(Color.LIGHT_GRAY);
        qPanel.setBorder(blackBorder);
        
        JPanel qPanel1 = new JPanel();
        qPanel1.setBackground(Color.LIGHT_GRAY);
        qPanel1.setBorder(blackBorder);
        
        JPanel qPanel2 = new JPanel();
        qPanel2.setBackground(Color.LIGHT_GRAY);
        qPanel2.setBorder(blackBorder);
        
        JPanel qPanel3 = new JPanel();
        qPanel3.setBackground(Color.LIGHT_GRAY);
        qPanel3.setBorder(blackBorder);
        
        JPanel qPanel4 = new JPanel();
        qPanel4.setBackground(Color.LIGHT_GRAY);
        qPanel4.setBorder(blackBorder);
        
        queuePanel.add(qPanel);
        queuePanel.add(qPanel1);
        queuePanel.add(qPanel2);
        queuePanel.add(qPanel3);
        queuePanel.add(qPanel4);
        
        initialPanel.add(queuePanel, BorderLayout.CENTER);
        
        //Add initial panel
        add(initialPanel);
        
        //Resets board when new game is selected
        newGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
//                panel.resetBoard(getBackground());
            }
        });
        //test commment
        //changes
	}//end SumFunFrame constructor
}//end SumFunFrame
