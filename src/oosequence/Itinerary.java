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
	private ArrayList<Flight> flights;
	private String name;
	
	/**
	 * constructor that defines instance variables
	 * @param nameOfItinerary name of the itinerary
	 */
	Itinerary (String nameOfItinerary) {
		name = nameOfItinerary;
		flights = new ArrayList<Flight>();
		
	}
		
	/**
	 * adds a flight to the itinerary after checking for flight overlap and sorting the itinerary list with first departure first
	 * @param flightToAdd flight you want to add to the itinerary
	 */
	void addFlight(Flight flightToAdd) {
		Date newDeparture = flightToAdd.getStart();
		Date newArrival = flightToAdd.getEnd();
		boolean overlapFlag = false;
		
		//checks for overlap
		for (Flight existingFlight : flights) {
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
			if ( flights.size() == 0 || newDeparture.after(flights.get(flights.size() - 1).getEnd()) ) {
				flights.add(flightToAdd);
			} else {
				for (int i = 0; i < flights.size(); i ++) {
					//checks if new arrival is before current flights departure and puts new flight in front of current flight if 
					// 	    thats the case
					if (newArrival.before(flights.get(i).getStart())) {
						flights.add(i, flightToAdd);
						break;
					}
				}
			}
		}
	}
	
	/**
	 * finds the total time a person will spend in between flights
	 * @return layover
	 */
	long getTotalLayover() {
		long layover = 0L;
		if (flights.size() > 1) {
			for (int counter = 0; counter < flights.size() - 1; counter ++) {
				//adds the difference between arrival and next departure for every element in list 
				Flight nextFlight = flights.get(counter + 1);
				Flight currentFlight = flights.get(counter);
				layover += ((nextFlight.getStart().getTime() 
						- currentFlight.getEnd().getTime()) / 60000);
			}	
		}
		return layover;
	}

	/**
	 * gives the list of flights 
	 * @return flights
	 */
	ArrayList<Flight> getFlights() {
		return flights;
	}
	
	/**
	 * gives the name of the itinerary
	 * @return name
	 */
	String getName() {
		return name;
	}

}
