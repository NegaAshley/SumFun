package edu.ipfw.sumfun;

import java.io.Serializable;
import java.util.ArrayList;


public class TopTimePlayers implements Serializable {//start TopTimePlayers method
	
	private static final int NUM_RECORDS = 10;//the number of records held
	
	//Contains the top 10 records of players with the most time remaining
	private ArrayList<TimeRecord> records;
	
	/*
	 * The constructor of TopTimePlayers
	 */
	public TopTimePlayers() {//start TopTimePlayers constructor
		records = new ArrayList<TimeRecord>();
	}//end TopTimePlayers constructor
	
	/**
	 * Returns the record found in ArrayList records at index
	 * 
	 * @param index - the index of a desired record
	 * @return TimeRecord - the record found at index
	 */
	public TimeRecord getRecord(int index) {//start getRecord method
		return records.get(index);
	}//end getRecord method
	
	/**
	 * Print all records contained in ArrayList records to console
	 */
	public void printRecords() {//start printRecords method
		for(TimeRecord u : records) {
			System.out.println(u.toString());
		}
		System.out.println();
	}//end printRecords method
	
	/**
	 * Accessor method for the size of ArrayList records
	 * 
	 * @return int - the size of ArrayList records
	 */
	public int getNumRecords() {//start getNumRecords method
		return records.size();
	}//end getNumRecords method
	
	/**
	 * Attempts to add a record to ArrayList records
	 * @param record - a record to attempt to add
	 */
	public void addRecord(TimeRecord record) {//start addRecord method
		
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
				TimeRecord[] tempRecords = new TimeRecord[records.size() - i];
				
				//Pull all of the records out of ArrayList records on and after the insertion point
				for(int j = 0; j < tempRecords.length; j++) {
					tempRecords[j] = records.get(i);
					records.remove(i);
				}
				
				//Add the new record to records
				records.add(i, record);
				
				//Put all of the new records back into place, shifted to the right by 1
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

}//end TopTimePlayers method
