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
public class UntimedRecord implements Serializable {
	
	private final String playerName;
	private final Date date;
	private final int moves;
	private final int points;
	
	/**
	 * Constructor
	 * @param playerName, the name of the player associated with this record
	 * @param moves, the number of moves the untimed game was completed in
	 */
	public UntimedRecord(String playerName, int moves, int points) {
		date = new Date();
		this.moves = moves;
		this.points = points;
		this.playerName = playerName;
	}//end Constructor
	
	/**
	 * Returns a String containing the associated date, in the format
	 * mm/dd/yyyy
	 * @return, a String containing the formatted date
	 */
	public String getDateString() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.format(date);
	}//end getDate
	
	/**
	 * Access method for field date
	 * @return
	 */
	public Date getDate() {
		return date;
	}//end getDate
	
	/**
	 * Access method for field moves
	 * @return moves
	 */
	public int getMoves() {
		return moves;
	}//end getMoves
	
	/**
	 * Access method for field points
	 * @return points
	 */
	public int getPoints() {
		return points;
	}//end getPoints
	
	/**
	 * Access method for field playerName
	 * @return playerName
	 */
	public String getName() {
		return playerName;
	}//end getName
	
	public boolean equals(UntimedRecord other) {
		return points == other.getPoints();
	}
	
	/**
	 * Compares two UntimedRecord objects
	 * @param other
	 * @return
	 */
	public int compareTo(UntimedRecord other) {
		
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
		
	}//end compareTo
	
	public String toString() {
		return playerName + " " + points + " " + date;
	}

}//end class Record
