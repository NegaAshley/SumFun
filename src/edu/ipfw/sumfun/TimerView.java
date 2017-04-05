package edu.ipfw.sumfun;

import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author Connor
 *
 */
public class TimerView {

	//Simple container panel and two labels
	private JPanel container = new JPanel(new GridLayout(2,1));
	private JLabel titleLabel = new JLabel("Time Remaining:");
	private JLabel timeLabel = new JLabel();
	
	//constructor
	public TimerView(){
		
		container.add(titleLabel);
		container.add(timeLabel);
	}

	//generic getters and setters
	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}

	public JLabel getTimeLabel() {
		return timeLabel;
	}

	public void setTimeLabel(JLabel timeLabel) {
		this.timeLabel = timeLabel;
	}
}
