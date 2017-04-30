package edu.ipfw.sumfun;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Jake
 *
 */
public class TopPointPlayers implements Serializable {//start TopPointPlayers class
	
	//The number of records we are maintaining
	private static final int NUM_RECORDS = 10;
	
	//Contains the top 10 records of players with the highest score
	private ArrayList<ScoreRecord> records;
	
	/**
	 * Constructor for the TopPointPlayers class
	 */
	public TopPointPlayers() {//start TopPointPlayers constructor
		records = new ArrayList<ScoreRecord>();
	}//end TopPointsPlayers nstructor
	
	/**
	 * Returns the record found in ArrayList records at index
	 * 
	 * @param index - the index of a desired record
	 * @return ScoreRecord - the record found at index
	 */
	public ScoreRecord getRecord(int index) {//start getRecord method
		return records.get(index);
	}//end getRecord method
	
	/**
	 * Print all records contained in ArrayList records to console
	 */
	public void printRecords() {//start printRecords method
		for(ScoreRecord u : records) {
			System.out.println(u.toString());
		}
		System.out.println();
	}//end printRecords method
	
	/**
	 * Access method for the size of ArrayList records
	 * 
	 * @return int - the size of ArrayList records
	 */
	public int getNumRecords() {//start getNumRecords method
		return records.size();
	}//end getNumRecords method
	
	/**
	 * Attempts to add a record to ArrayList records
	 * 
	 * @param record - a record to attempt to add
	 */
	public void addRecord(ScoreRecord record) {//start addRecord method
		
		//If records is empty, just add and move along
		if(records.isEmpty()) {
			records.add(record);
			return;
		}
		
		for(int i = 0; i < NUM_RECORDS; i++) {
			
			//If there are no more records to compare to
			//And there are less than 10 records so far
			//Stick new record in at the end
			if(i == records.size()) {
				records.add(record);
				break;
			}
			
			//We have found where to put the record in
			if(record.compareTo(records.get(i)) == -1) {
				
				//Create a temporary array of size records.size() - i
				//This is the number of records that need to be shifted
				ScoreRecord[] tempRecords = new ScoreRecord[records.size() - i];
				
				//Pull all of the records out of ArrayList records on and after the insertion point
				for(int j = 0; j < tempRecords.length; j++) {
					tempRecords[j] = records.get(i);
					records.remove(i);
				}
				
				//Add the new record to records
				records.add(i, record);
				
				//Put all of the new records back into place, shifted to the right 
					//by 1
				for(int j = 1; j <= tempRecords.length; j++) {
					records.add(i+j, tempRecords[j-1]);
				}
				
				//remove all records past 10
				for(int j = 10; j < records.size(); j++) {
					records.remove(j);
				}
				
				//We are done processing
				break;
			}
		}
	}//end addRecord method

}//end TopPointPlayer class

