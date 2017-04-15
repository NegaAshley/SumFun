package edu.ipfw.sumfun;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A record of a completed UntimedGame match
 * @author Jake
 *
 */
public class UntimedRecord implements Serializable {//start UntimedRecord method
	
	private final String playerName;//the name of the player
	private final Date date;//the date of the win
	private final int moves;//the moves remaining
	private final int points;//the total points
	
	/**
	 * Constructor
	 * @param playerName - the name of the player associated with this record
	 * @param moves - the number of moves the untimed game was completed in
	 */
	public UntimedRecord(String playerName, int moves, int points) {//start UntimedGame 
		//constructor
		date = new Date();
		this.moves = moves;
		this.points = points;
		this.playerName = playerName;
	}//end UntimedGame constructor
	
	/**
	 * Returns a String containing the associated date, in the format
	 * mm/dd/yyyy
	 * @return a String containing the formatted date
	 */
	public String getDateString() {//start getDateString method
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.format(date);
	}//end getDateString method
	
	/**
	 * Access method for field date
	 * @return date - the date of the win
	 */
	public Date getDate() {//start getDate method
		return date;
	}//end getDate method
	
	/**
	 * Access method for field moves
	 * @return moves - the moves remaining
	 */
	public int getMoves() {//start getMoves method
		return moves;
	}//end getMoves method
	
	/**
	 * Access method for field points
	 * @return points - the total number of points
	 */
	public int getPoints() {//start getPoints method
		return points;
	}//end getPoints method
	
	/**
	 * Accessor method for field playerName
	 * @return playerName - the name of the winning player
	 */
	public String getName() {//start getName method
		return playerName;
	}//end getName method
	
	/**
	 * Determines if an UntimedRecord object and this object are equal based on relevant 
	 * data fields
	 * @param other - an UntimedRecord object
	 * @return true - if they are equal, false if not
	 */
	public boolean equals(UntimedRecord other) {//start equals method
		return points == other.getPoints();
	}//end equals method
	
	/**
	 * Compares two UntimedRecord objects
	 * @param other - the other UntimedRecord
	 * @return comparison
	 */
	public int compareTo(UntimedRecord other) {//start compareTo method
		
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
			
		} else if(this.getPoints() >= other.getPoints()) {
			return -1;
		} else {
			return 1;
		}
		
	}//end compareTo method
	
	/**
	 * String representation of UntimedRecord
	 * @return string representation of UntimedRecord
	 */
	public String toString() {//start toString method
		return playerName + " " + points + " " + date;
	}//end toString method

}//end UntimedRecord class
