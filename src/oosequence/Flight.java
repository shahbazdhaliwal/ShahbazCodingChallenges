package oosequence;

import java.util.Date;

public class Flight {
	
	Date departure;
	Date arrival;
	
	Flight (Date departureDate, Date arrivalDate) {
		if ((departureDate != null && arrivalDate != null) && 
				departureDate.before(arrivalDate)) {
			departure = departureDate;
			arrival = arrivalDate;
		}
	}
	
	Flight(Flight toCopy){
		departure = toCopy.departure;
		arrival = toCopy.arrival;
	}
	
	long length() {
		if ((departure != null && arrival != null) && 
				departure.before(arrival)) {
			long time = (arrival.getTime() - departure.getTime()) / 60000;  
			return time;
		} else {
			return (long) 0.0;
		}
	}
	

}
