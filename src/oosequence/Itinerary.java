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
		Date newDeparture = component.getStart();
		Date newArrival = component.getEnd();
		boolean overlapFlag = false;
		
		//checks for overlap
		for (TripComponent existingFlight : tripComponents) {
			//if statement for all cases where there could be overlap
			if (existingFlight.getStart().after(newDeparture) && existingFlight.getStart().before(newArrival) ||
					existingFlight.getEnd().after(newDeparture) && existingFlight.getEnd().before(newArrival) ||
					existingFlight.getStart().equals(newDeparture) || existingFlight.getEnd().equals(newArrival)) {
				overlapFlag = true;
			}
		}
		
		//sorting list and adding new flight
		if (overlapFlag == false) {
			//case for if list is empty of if new departure after last current arrival time
			if ( tripComponents.size() == 0 || newDeparture.after(tripComponents.get(tripComponents.size() - 1).getEnd()) ) {
				tripComponents.add(component);
			} else {
				for (int i = 0; i < tripComponents.size(); i ++) {
					//checks if new arrival is before current flights departure and puts new flight in front of current flight if 
					// 	    thats the case
					if (newArrival.before(tripComponents.get(i).getStart())) {
						tripComponents.add(i, component);
						break;
					}
				}
			}
		}
	}
	/*
	
	/**
	 * finds the total time a person will spend in between flights
	 * @return layover
	 /
	long getTotalLayover() {
		long layover = 0L;
		if (tripComponents.size() > 1) {
			for (int counter = 0; counter < tripComponents.size() - 1; counter ++) {
				//adds the difference between arrival and next departure for every element in list 
				TripComponent nextFlight = tripComponents.get(counter + 1);
				TripComponent currentFlight = tripComponents.get(counter);
				layover += ((nextFlight.getStart().getTime() 
						- currentFlight.getEnd().getTime()) / 60000);
			}	
		}
		return layover;
	}
	*/

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

}
