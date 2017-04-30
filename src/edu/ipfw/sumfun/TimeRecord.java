package edu.ipfw.sumfun;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeRecord implements Serializable {//start TimedRecord class
	
	private final String playerName;//the name of the player
	private final Date date;//the date of the record
	private final int time;//the time duration of the game
	private final int startTime;//the start time
	
	/**
	 * TimeRecord constructor
	 * 
	 * @param playerName, the name of the player associated with the record
	 * @param time, the game completion time associated with the record
	 */
	public TimeRecord(String playerName, int time, int startTime) {//start TimeRecord
		//constructor
		this.playerName = playerName;
		this.time = time;
		this.startTime = startTime;
		date = new Date();
	}//end TimeRecord onstructor
	
	/**
	 * Returns a String containing the associated date, in the format
	 * mm/dd/yyyy
	 * 
	 * @return String - containing the formatted date
	 */
	public String getDateString() {//start getDateString method
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.format(date);
	}//end getDateString method
	
	/**
	 * Accessor method for field date
	 * 
	 * @return date - the date of the win
	 */
	public Date getDate() {//start getDate method
		return date;
	}//end getDate method
	
	/**
	 * Accessor method for field playerName
	 * 
	 * @return playerName - the name of the winning player
	 */
	public String getName() {//start getName method
		return playerName;
	}//end getName method
	
	/**
	 * Accessor method for field time
	 * 
	 * @return time - the record's completion time
	 */
	public int getTime() {//start getTime method
		return time;
	}//end getTime method
	
	/**
	 * Returns a String containing the completion time in a formatted string
	 * 
	 * @return String - representing formatted time
	 */
	public String getFormattedTime() {//start getFormattedTime method
		int tempTime = startTime - time;
		int minutes = tempTime / (60 * 1000);
		int seconds = (tempTime / 1000) % 60;
		return String.format("%d:%02d", minutes, seconds);
	}//end getFormattedTime method
	
	/**
	 * Determines if a TimeRecord object and this object are equal based on relevant 
	 * data fields
	 * 
	 * @param other - a TimeRecord object
	 * @return boolean - true if they are equal, false if not
	 */
	public boolean equals(TimeRecord other) {//start equals method
		return time == other.getTime();
	}//end equals method
	
	/**
	 * Compares two TimeRecord objects
	 * 
	 * @param other - the other UntimedRecord
	 * @return comparison
	 */
	public int compareTo(TimeRecord other) {//start compareTo method
		
		if(this.equals(other)) {
			
			long thisDate = date.getTime();
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
	
	/*
	 * The String representation of the TimeRecord
	 * 
	 * @return String - representing the TimeRecord
	 */
	public String toString() {//start toString method
		return playerName + " " + getFormattedTime() + " " + date;
	}//end toString method

}//end TimedRecord class
