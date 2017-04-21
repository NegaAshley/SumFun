package edu.ipfw.sumfun;

import java.util.Timer;
import java.util.TimerTask;

/**
 * The TimedGame class handles the timed version
 * 
 * @author Connor
 */
public class TimedGame extends Game {//start TimedGame class
	
	//Singleton instance of TimedGame
	private static TimedGame timedInstance = new TimedGame();

	//The initial time that the timer will start out, in milliseconds
	private static final int INITIAL_TIME = 300_000;
	
	//The tick of the timer, in milliseconds 
	private static final int TICK = 1000;
	
	//The current state of the timer
	private static int duration;
	
	//Timer object to handle timer countdown
	private static Timer t;

	/**
	 * Constructor for TimedGame class
	 */
	private TimedGame() {//start TimedGame constructor
		super();
	}// end TimedGame constructor
	
	/**
	 * Resets the timer by instantiating a new one to default values
	 */
	public void setNewTimer() {//start setNewTimer method
		
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
					setGameWon(false);
					t.cancel();
					setChanged();
					notifyObservers();
				} 
			}
		}, 0, 1000);
	
	}//end setNewTimer method
	
	/**
	 * 
	 */
	public void setTimer() {//start setTimer method
		duration = INITIAL_TIME;
	}//end setTimer method
	
	/**
	 * Attempts to stop 
	 */
	public void stopTimer() {//start stopTimer method
		try {
			t.cancel();
		} catch (Exception e) {
			
		}
	}//end stopTimer method
	
	/**
	 * Return singleton instance of TimedGame
	 * @return timedInstance - this instance of the timed game
	 */
	public static TimedGame getInstance() {//start getInstance method
		return timedInstance;
	}//end getInstance method

	/**
	 * Access method for current time remaining
	 * @return a string format of time remaining
	 */
	public String getTime() {//start getTime method
		int minutes = duration / (60 * 1000);
		int seconds = (duration / 1000) % 60;
		String str = String.format("%d:%02d", minutes, seconds);
		System.out.println(duration);
		return str;
	}// end getStartTime method
	
	/**
	 * Accessor method for set increment of time
	 * @return TICK - the amount of time decremented in the timer
	 */
	public int getTick() {// start getTick method
		return TICK;
	}// end getTick method

	/*
	 * Access method to get the timer
	 * @return t - the timer
	 */
	public Timer getTimer(){//start getTimer method
		return t;
	}//end getTimer method
	
	/**
	 * Access method for duration
	 * @return
	 */
	public int getDuration() {
		return duration;
	}//end getDuration
	
	public static int getInitialTime() {
		return INITIAL_TIME;
	}
	
	/*
	 * Starts the timer
	 */
	public void startTimer(){//start startTimer method
		t = new Timer();
	}//end startTimer method
	
}// end TimedGame class