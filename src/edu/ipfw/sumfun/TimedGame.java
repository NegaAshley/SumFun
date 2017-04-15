package edu.ipfw.sumfun;

import java.util.Timer;
import java.util.TimerTask;

/**
 * The TimedGame class handles the timed version
 * 
 * @author Connor
 */
public class TimedGame extends Game {
	
	//Singleton instance of TimedGame
	private static TimedGame timedInstance = new TimedGame();

	//The initial time that the timer will start out, in milliseconds
	private static final int INITIAL_TIME = 300000;
	
	//The tick of the timer, in milliseconds 
	private static final int TICK = 1000;
	
	//The current state of the timer
	private static int duration;
	
	//Timer object to handle timer countdown
	private static Timer t;

	/**
	 * Constructor for TimedGame class
	 */
	private TimedGame() {
		super();
	}// end TimedGame constructor
	
	/**
	 * Resets the timer by instantiating a new one to default values
	 */
	public void setNewTimer() {
		
		stopTimer();
		t = null;
		setTimer();
		startTimer();
		t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				duration = duration - TICK;
				setChanged();
				notifyObservers();
				if (duration == 0) {
					setIsActive(false);
					t.cancel();
					setChanged();
					notifyObservers();
				} 
			}
		}, 0, 1000);
	
	}//end setNewTimer
	
	/**
	 * 
	 */
	public void setTimer() {
		duration = INITIAL_TIME;
	}
	//end setTimer
	
	/**
	 * Attempts to stop 
	 */
	public void stopTimer() {
		try {
			t.cancel();
		} catch (Exception e) {
			
		}
	}//end stopTimer
	
	/**
	 * Return singleton instance of TimedGame
	 * @return timedInstance
	 */
	public static TimedGame getInstance() {
		return timedInstance;
	}//end getInstance

	/**
	 * Access method for current time remaining
	 * 
	 * @return a string format of time remaining
	 */
	public String getTime() {
		int minutes = duration / (60 * 1000);
		int seconds = (duration / 1000) % 60;
		String str = String.format("%d:%02d", minutes, seconds);
		System.out.println(str);
		return str;
	}// end getStartTime
	
	/**
	 * Accessor method for set increment of time
	 * 
	 * @return DURATION
	 */
	public int getTick() {// start getTick
		return TICK;
	}// end getTick

	/*
	 * Accessor method to get the timer
	 * @return t - the timer
	 */
	public Timer getTimer(){//start getTimer method
		return t;
	}//end getTimer method
	
	/*
	 * Starts the timer
	 */
	public void startTimer(){//start startTimer method
		t = new Timer();
	}//end startTimer method
	
}// end TimedGame class