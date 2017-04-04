package edu.ipfw.sumfun;

import java.awt.event.*;
import java.text.SimpleDateFormat;

import javax.swing.Timer;
/**
 * 
 * @author Connor
 *
 */
public class TimerModel {

	// Time Left in milliseconds (5 minutes = 300,000 millis)
	private long duration = 300000;
	//Instationation of timer object
	private Timer timer;
	//Starting at -1 so Timer can run full five minutes
	private long startTime = -1;

	public TimerModel() {

		//Timer takes delay between actions and an actionlistener
		timer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//References current system time for starting point
				if (startTime < 0) {
					startTime = System.currentTimeMillis();
				}
				//sets now to current system time
				long now = System.currentTimeMillis();
				//Consistently updates clockTime to the difference between now and when timer began
				long clockTime = now - startTime;
				//Checks if timer has run its course
				if (clockTime >= duration) {
					//Resets timer to duration specified
					clockTime = duration;
					timer.stop();
				}
				//Formats long for display on timer label
				SimpleDateFormat df = new SimpleDateFormat("mm:ss:");
				// Controller.getFrame().getScoreBoardPanel().getTimeLabel().setText(df.format(duration
				// - clockTime));
			}
		});
		timer.setInitialDelay(0);
	}
}
