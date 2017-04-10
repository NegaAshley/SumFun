package edu.ipfw.sumfun;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Jake
 *
 */
public class TopPointPlayers implements Serializable {
	
	private static final int NUM_RECORDS = 10;
	
	//Contains the top 10 records of players with the highest score
	private ArrayList<UntimedRecord> records;
	
	/**
	 * Constructor
	 */
	public TopPointPlayers() {
		records = new ArrayList<UntimedRecord>();
	}//end Constructor
	
	/**
	 * Returns the record found in ArrayList records at index
	 * @param index, the index of a desired record
	 * @return the record found at index
	 */
	public UntimedRecord getRecord(int index) {
		return records.get(index);
	}//end getRecord
	
	/**
	 * Print all records contained in ArrayList records to console
	 */
	public void printRecords() {
		for(UntimedRecord u : records) {
			System.out.println(u.toString());
		}
		System.out.println();
	}//end printRecords
	
	/**
	 * Access method for the size of ArrayList records
	 * @return the size of ArrayList records
	 */
	public int getNumRecords() {
		return records.size();
	}//end getNumRecords
	
	/**
	 * Attempts to add a record to ArrayList records
	 * @param record, a record to attempt to add
	 */
	public void addRecord(UntimedRecord record) {
		
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
				UntimedRecord[] tempRecords = new UntimedRecord[records.size() - i];
				
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
		
	}//end addRecord

}//end class TopPlayers

