package edu.ipfw.sumfun;

import java.util.Timer;
import java.util.TimerTask;

/**
 * The TimedGame class handles the timed version
 * 
 * @author Connor
 */
public class TimedGame extends Game {
	
	private static TimedGame timedInstance = new TimedGame();

	private static int DURATION = 300000;// Duration of timed game in millis
	private static final int TICK = 1000; // Number of milliseconds per tick (1
											// second)
	private static Timer t;// Timer for timed game

	/**
	 * Constructor for TimedGame class
	 */
	private TimedGame() {

		super();
		t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				DURATION = DURATION - TICK;
				if (DURATION <= 0) {
					DURATION = 300000;
				}
				setChanged();
				notifyObservers();
			}
		}, 0, 1000);
	}// end TimedGame constructor
	
	public void setTimer() {
		DURATION = 300000;
	}
	
	public void stopTimer() {
		t.cancel();
	}
	
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
		int minutes = DURATION / (60 * 1000);
		int seconds = (DURATION / 1000) % 60;
		String str = String.format("%d:%02d", minutes, seconds);
		System.out.println(str);
		return str;
	}// end getStartTime
	
	/**
	 * 
	 * Setter method fo duration, to restart timed game
	 * 
	 * @return n/a 
	 */
	public void resetTimer(int newTime){
		
		DURATION = newTime;
		t.cancel();
		t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				DURATION = DURATION - TICK;
				setChanged();
				notifyObservers();
				if (DURATION <= 0) {
					t.cancel();
				}
			}
		}, 0, 1000);
		
	}
	
	
	/**
	 * Accessor method for set increment of time
	 * 
	 * @return DURATION
	 */
	public int getTick() {// start getTick
		return TICK;
	}// end getTick

}// end TimedGame class