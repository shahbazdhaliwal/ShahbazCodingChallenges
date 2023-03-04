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
	Flight (Date departureDate, Date arrivalDate) {
		if ((departureDate != null && arrivalDate != null) && 
				departureDate.before(arrivalDate)) {
			setDeparture(departureDate);
			setArrival(arrivalDate);
		} else if (departureDate != null && arrivalDate == null) {
			setDeparture(departureDate);
		} else if (arrivalDate != null && departureDate == null) {
			setArrival(arrivalDate);
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
		return departure;
	}
	
	/**
	 * sets the departure of the flight granted the time of departure is valid
	 * @param departure departure
	 */
	void setDeparture(Date departure) {
		if (this.arrival != null && departure.before(this.arrival)) {
			this.departure = departure;
		} else if (this.arrival == null) {
			this.departure = departure;
		}
	}
	
	/**
	 * returns the arrival time
	 * @return arrival time
	 */
	Date getArrival() {
		return arrival;
	}

	/**
	 * sets the arrival time of a flight given its a valid time
	 * @param arrival arrival time
	 */
	void setArrival(Date arrival) {
		if (this.departure != null && arrival.after(this.departure)) {
			this.arrival = arrival;
		} else if (this.departure == null) {
			this.arrival = arrival;
		}
	}
	

}
