package edu.ipfw.sumfun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Jake
 *
 */
public class Controller implements ActionListener {
	
	private static final boolean GUI_VISIBLE = true;
	
	private UntimedGame model;
	private SumFunFrame view;
	
	/**
	 * Constructor
	 * @param u, an instance of UntimedGame (the system's model)
	 */
	public Controller(UntimedGame u) {
		model = u;
		view = new SumFunFrame(u);
		view.setVisible(GUI_VISIBLE);
	}

	/**
	 * Process all actions that need to occur due to user input
	 * Uses event.getActionCommand to determine what changes need to occur
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		
		
	}//end actionPerformed

}//end class Controller
