package edu.ipfw.sumfun;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeRecord implements Serializable {
	
	private final String PLAYER_NAME;
	private final Date DATE;
	private final int TIME;
	private final int START_TIME;
	
	/**
	 * TimeRecord constructor
	 * @param playerName, the name of the player associated with the record
	 * @param time, the game completion time associated with the record
	 */
	public TimeRecord(String playerName, int time, int startTime) {
		this.PLAYER_NAME = playerName;
		this.TIME = time;
		this.START_TIME = startTime;
		DATE = new Date();
	}//end Constructor
	
	/**
	 * Returns a String containing the associated date, in the format
	 * mm/dd/yyyy
	 * @return a String containing the formatted date
	 */
	public String getDateString() {//start getDateString method
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.format(DATE);
	}//end getDateString method
	
	/**
	 * Access method for field date
	 * @return date - the date of the win
	 */
	public Date getDate() {//start getDate method
		return DATE;
	}//end getDate method
	
	/**
	 * Access method for field playerName
	 * @return playerName - the name of the winning player
	 */
	public String getName() {//start getName method
		return PLAYER_NAME;
	}//end getName method
	
	/**
	 * Access method for field time
	 * @return time, the record's completion time
	 */
	public int getTime() {
		return TIME;
	}//end getTime
	
	/**
	 * Returns a String containing the completion time in a formatted string
	 * @return
	 */
	public String getFormattedTime() {
		int tempTime = START_TIME - TIME;
		int minutes = tempTime / (60 * 1000);
		int seconds = (tempTime / 1000) % 60;
		return String.format("%d:%02d", minutes, seconds);
	}//end getFormattedTime
	
	/**
	 * Determines if a TimeRecord object and this object are equal based on relevant 
	 * data fields
	 * @param other - a TimeRecord object
	 * @return true if they are equal, false if not
	 */
	public boolean equals(TimeRecord other) {//start equals method
		return TIME == other.getTime();
	}//end equals method
	
	/**
	 * Compares two TimeRecord objects
	 * @param other - the other UntimedRecord
	 * @return comparison
	 */
	public int compareTo(TimeRecord other) {//start compareTo method
		
		if(this.equals(other)) {
			
			long thisDate = DATE.getTime();
			long otherDate = other.getDate().getTime();
			
			//Scores are equal, so lets see who was first
			if(thisDate < otherDate) {
				return -1;
			} else if (thisDate <= otherDate) {
				return 1;
			} else {
				return 0;
			}
			
		} else if(this.getTime() >= other.getTime()) {
			return -1;
		} else {
			return 1;
		}
		
	}//end compareTo method
	
	public String toString() {
		return PLAYER_NAME + " " + getFormattedTime() + " " + DATE;
	}

}
