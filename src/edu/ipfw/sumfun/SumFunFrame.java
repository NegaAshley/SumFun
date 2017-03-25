/*
 * The SumFunFrame class is the frame of Sum Fun game where panels and menus are
 * located.
 */
package edu.ipfw.sumfun;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SpringLayout;
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
        
        //Creates and adds SumFunPanel 
        SumFunPanel panel = new SumFunPanel();
        add(panel);
        JPanel scoreBoardPanel = new JPanel();
        scoreBoardPanel.setLayout(new GridLayout());
        
        JLabel scoreBoardLabel = new JLabel("Score");
        JTextField scoreTextField = new JTextField(3);
        scoreBoardPanel.add(scoreBoardLabel);
        scoreBoardPanel.add(scoreTextField);
        add(scoreBoardPanel);
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
