package oosequence;

import java.util.ArrayList;
import java.util.Date;

/**
 * Stores a persons flight itinerary with departure and arrival times
 * @author Shahbaz
 *
 */
public class Itinerary {
	
	
	
	//Initializing instance variables
	private ArrayList<TripComponent> tripComponents;
	private String name;
	
	/**
	 * constructor that defines instance variables
	 * @param nameOfItinerary name of the itinerary
	 */
	Itinerary (String nameOfItinerary) {
		name = nameOfItinerary;
		tripComponents = new ArrayList<TripComponent>();
		
	}
		
	/**
	 * adds a flight to the itinerary after checking for flight overlap and sorting the itinerary list with first departure first
	 * @param component flight you want to add to the itinerary
	 */
	void addTripComponent(TripComponent component) {
		boolean flag = false;
		//checks for any overlap with existing trips. 
		//if overlap flag raised
		for (TripComponent i : tripComponents) {
			if (i.overlapsWith(component)) {
				flag = true;
			} 
		}
		//case for no overlap
		if (!flag) {
			//case for if list is empty of if new departure after last current arrival time
			if ( tripComponents.size() == 0 || tripComponents.get(tripComponents.size() - 1).isBefore(component)) {
				tripComponents.add(component);
			} else {
				for (int i = 0; i < tripComponents.size(); i ++) {
					//checks if new arrival is before current flights departure and puts new flight in front of current flight if 
					// 	    thats the case
					if (component.isBefore(tripComponents.get(i))) {
						tripComponents.add(i, component);
						break;
					}
				}
			}
	
		}
				
	}
	
	/**
	 * gives the list of flights 
	 * @return flights
	 */
	ArrayList<TripComponent> getTripComponents() {
		return tripComponents;
	}
	
	/**
	 * gives the name of the itinerary
	 * @return name
	 */
	String getName() {
		return name;
	}
	
	/**
	 * organizes itinerary into a readable string with name of itinerary and ordered trips
	 */
	public String toString() {
		// learned how to add new line to a string from: https://stackoverflow.com/questions/7833689/how-can-i-print-a-string-adding-newlines-in-java
		String itinerary = getName() + "\n";
		for (int counter = 0; counter < tripComponents.size(); counter ++) {
			itinerary += counter + "\t" + tripComponents.get(counter).getStart() + "\t" +
					tripComponents.get(counter).getEnd() + "\n";
		}
		
		return itinerary;
	}

}
