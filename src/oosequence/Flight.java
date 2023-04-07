package oosequence;

import java.util.Date;

/**
 * Represents a flight
 * @author Shahbaz
 *
 */
public class Flight {
	
	//initializing instance variables
	private Date departure;
	private Date arrival;
	
	/**
	 * constructor that defines instance variables
	 * @param departureDate departure date
	 * @param arrivalDate arrival date
	 */
	Flight (Date startDate, Date endDate) {
		if (startDate != null && endDate == null) {
			setDeparture(startDate);
			
		} else if (endDate != null && startDate == null) {
			setArrival(endDate);
			
		} else if (startDate == null && endDate == null) {
			setDeparture(startDate);
			setArrival(endDate);
			
		} else if (startDate.before(endDate)) {
			setDeparture(startDate);
			setArrival(endDate);	
			
		} else if (startDate.equals(endDate) || startDate.after(endDate)) {
			//setDeparture(startDate);
			
		}
	}
	
	/**
	 * constructor for making copy of some give flight
	 * @param toCopy flight you want to copy
	 */
	Flight(Flight toCopy){
		setDeparture(toCopy.getDeparture());
		setArrival(toCopy.getArrival());
	}
	
	/**
	 * returns the length of the flight
	 * @return length
	 */
	long length() {
		if ((getDeparture() != null && getArrival() != null) && 
				getDeparture().before(getArrival())) {
			//find the difference between arrival and departure
			long time = (getArrival().getTime() - getDeparture().getTime()) / 60000;  
			return time;
		} else {
			return (long) 0.0;
		}
	}
	
	/**
	 * returns departure time
	 * @return departure time
	 */
	Date getDeparture() {
		Date departureCopy = null;
		if (departure != null) {
			departureCopy = (Date) departure.clone();
		}
		return departureCopy;
	}
	
	/**
	 * sets the departure of the flight granted the time of departure is valid
	 * @param departureDate departure
	 */
	void setDeparture(Date departureDate) {
		if (departureDate != null) {
			if (arrival != null && departureDate.before(arrival)) {
				departure = (Date) departureDate.clone();
			} else if (arrival == null) {
				departure = (Date) departureDate.clone();
			}
		}
	}
	
	/**
	 * returns the arrival time
	 * @return arrival time
	 */
	Date getArrival() {
		Date arrivalCopy = null;
		if (arrival != null) {
			arrivalCopy = (Date) arrival.clone();
		}
		return arrivalCopy;
	}

	/**
	 * sets the arrival time of a flight given its a valid time
	 * @param arrivalDate arrival time
	 */
	void setArrival(Date arrivalDate) {
		if (arrivalDate != null) {
			if (departure != null && arrivalDate.after(departure)) {
				arrival = (Date) arrivalDate.clone();
			} else if (departure == null) {
				arrival = (Date) arrivalDate.clone();
			}	
		}
	}
	

}
