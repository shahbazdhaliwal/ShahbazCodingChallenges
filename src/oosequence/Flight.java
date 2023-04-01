package oosequence;

import java.util.Date;

/**
 * Stores flight info such as airport names and returns duration of flight and airport names
 * @author Shahbaz
 *
 */
public class Flight extends TripComponent {
	
	//initializing encapsulated instance variables
	private String departureAirport = "";
	private String arrivalAirport = "";
		
	/**
	 * copy constructor
	 * @param toCopy Flight instance to be copied
	 */
	Flight (Flight toCopy) {
		super(toCopy);
		departureAirport = toCopy.getDepartureAirport();
		arrivalAirport = toCopy.getArrivalAirport();
	}
	
	/**
	 * default constructor
	 * @param departureTime start time of flight
	 * @param arrivalTime end time of flight
	 * @param departureAirportName departure airport name
	 * @param arrivalAirportName arrival airport name
	 */
	Flight (Date departureTime, Date arrivalTime, String departureAirportName, String arrivalAirportName) {
		super(departureTime, arrivalTime);
		//sets name of each airport if valid
		if (departureAirportName != null) {
			setDepartureAirport(departureAirportName);
		} else {
			setDepartureAirport("");
		}
		if (arrivalAirportName != null) {
			setArrivalAirport(arrivalAirportName);
		} else {
			setArrivalAirport("");
		}
	}
	
	/**
	 * returns the name of the airport one is departing from
	 * @return airport name
	 */
	String getDepartureAirport() {
		return departureAirport;
	}
	
	/**
	 * sets the name of airport to depart from and makes sure its valid
	 * @param departureAirport airport to depart from
	 */
	void setDepartureAirport(String airportName) {
		//checks string is not empty/null and makes sure characters are alphabetic and string is of size 3
		if (airportName != null && !airportName.isEmpty()) {
			char[] charList = airportName.toCharArray();
			boolean alphabetic = true;
			
			for (char i : charList) {
				if (!Character.isAlphabetic(i)) {
					alphabetic = false;
				}
			}
			if (airportName.length() == 3 && alphabetic) {
				departureAirport = airportName;
			} else {
				departureAirport = "";
			}	
		} else {
			departureAirport = "";
		}
		
	}
	
	/**
	 * returns name of arrival airport
	 * @return arrival airport name
	 */
	String getArrivalAirport() {
		return arrivalAirport;
	}
	
	/**
	 * sets the name of an arrival airport and makes sure its valid
	 * @param arrivalAirport airport name
	 */
	void setArrivalAirport(String airportName) {
		//checks string is not empty/null and makes sure characters are alphabetic and string is of size 3
		if (airportName != null && !airportName.isEmpty()) {
			char[] charList = airportName.toCharArray();
			boolean alphabetic = true;
			
			for (char i : charList) {
				if (!Character.isAlphabetic(i)) {
					alphabetic = false;
				}
			}
			if (airportName.length() == 3 && alphabetic) {
				this.arrivalAirport = airportName;
			} else {
				this.arrivalAirport = "";
			}	
		} else {
			this.arrivalAirport = "";
		}
	}
	
	/**
	 * method to get the name of airport and time of departure as string
	 */
	String getStart() {
		return getDepartureAirport() + " " + super.getStart();
	}
	
	/**
	 * method to get name of airport and time of arrival as string
	 */
	String getEnd() {
		return getArrivalAirport() + " " + super.getEnd();
	}
	
	
}



