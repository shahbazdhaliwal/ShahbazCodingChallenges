package oosequence;

/**
 * Stores flight info such as airport names and returns duration of flight and airport names
 * @author Shahbaz
 *
 */
public class Flight extends TripComponent {
	
	//initializing encapsulated instance variables
	private String departureAirport;
	private String arrivalAirport;
	
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
	void setDepartureAirport(String departureAirport) {
		//checks string is not empty/null and makes sure characters are alphabetic and string is of size 3
		if (departureAirport != null && !departureAirport.isEmpty()) {
			char[] charList = departureAirport.toCharArray();
			boolean alphabetic = true;
			
			for (char i : charList) {
				if (!Character.isAlphabetic(i)) {
					alphabetic = false;
				}
			}
			if (departureAirport.length() == 3 && alphabetic) {
				this.departureAirport = departureAirport;
			} else {
				this.departureAirport = "";
			}	
		} else {
			this.departureAirport = "";
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
	void setArrivalAirport(String arrivalAirport) {
		//checks string is not empty/null and makes sure characters are alphabetic and string is of size 3
		if (arrivalAirport != null && !arrivalAirport.isEmpty()) {
			char[] charList = arrivalAirport.toCharArray();
			boolean alphabetic = true;
			
			for (char i : charList) {
				if (!Character.isAlphabetic(i)) {
					alphabetic = false;
				}
			}
			if (arrivalAirport.length() == 3 && alphabetic) {
				this.arrivalAirport = arrivalAirport;
			} else {
				this.arrivalAirport = "";
			}	
		} else {
			this.arrivalAirport = "";
		}
	}
	
	/**
	 * gets the length of flight in minutes
	 * @return minutes
	 */
	String getDuration() {
		float duration = lengthInSeconds() / 60.0f;
		return String.format("%.0f minutes", duration);
	}
	
	
}



