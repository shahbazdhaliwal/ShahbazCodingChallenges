package oosequence;

import java.util.Date;

/**
 * Handles trips, takes start and end times and also returns durations of trip
 * @author Shahbaz
 *
 */
public class TripComponent extends Itinerary{
	
	//initializing instance variables
	private Date start;
	private Date end;
	
	/**
	 * constructor that defines instance variables
	 * @param startDate start date
	 * @param endDate end date
	 */
	TripComponent (Date startDate, Date endDate) {
		super("");
		if (startDate != null && endDate == null) {
			setStart(startDate);
			
		} else if (endDate != null && startDate == null) {
			setEnd(endDate);
			
		} else if (startDate == null && endDate == null) {
			setStart(startDate);
			setEnd(endDate);
			
		} else if (startDate.before(endDate)) {
			setStart(startDate);
			setEnd(endDate);	
			
		} else if (startDate.equals(endDate) || startDate.after(endDate)) {
			setStart(startDate);
			
		}
	}
	
	/**
	 * constructor for making copy of some given trip
	 * @param toCopy trip you want to copy
	 */
	TripComponent(TripComponent toCopy){
		super("");
		setStart(toCopy.start);
		setEnd(toCopy.end);
	}
	
	/**
	 * returns the length of the trip
	 * @return length
	 */
	protected long lengthInSeconds() {
		if ((start != null && end != null) && 
				start.before(end)) {
			//find the difference between end and start
			long millisToSecs = 1000;
			long time = (end.getTime() - start.getTime()) / millisToSecs;  
			return time;
		} else {
			return (long) 0.0;
		}
	}
	
	/**
	 * returns start time, if start time is null it returns empty string
	 * @return start time
	 */
	String getStart() {
		if (start != null) {
			return start.toString();
		} else {
			return "";
		}
	}
	
	/**
	 * sets the start of the trip granted the time of start is valid
	 * @param startDate start
	 */
	void setStart(Date startDate) {
		if (end != null && startDate.before(end)) {
			start = startDate;
		} else if (end == null) {
			start = startDate;
		}
	}
	
	/**
	 * returns the end time, if end is null then empty string returned
	 * @return end time
	 */
	String getEnd() {
		if (end != null) {
			return end.toString();
		} else {
			return "";
		}
	}

	/**
	 * sets the end time of a trip given its a valid time
	 * @param endDate end time
	 */
	void setEnd(Date endDate) {
		if (start != null && endDate.after(start)) {
			end = endDate;
		} else if (start == null) {
			end = endDate;
		}
	}
	
	/**
	 * Checks to see if the end time of one trip is before the start time of another trip
	 * @param otherComponent other trip to compare to
	 * @return true if end before another trip start
	 */
	public boolean isBefore(TripComponent otherComponent) {
		if (end.before(otherComponent.start)) {
			return true;
		} else {
			return false;
		}

	}
	
	/**
	 * checks for overlap between two trips
	 * @param otherComponent other trip
	 * @return true if there is overlap
	 */
	public boolean overlapsWith(TripComponent otherComponent) { 
		//case for when overlap check isn't necessary
		if (start == null || end == null || otherComponent.start == null || otherComponent.end == null ) {
			return false;
		//checking cases of possible overlap
		} else if (start.after(otherComponent.start) && start.before(otherComponent.end)) {
			return true;
		} else if (otherComponent.start.after(start) && otherComponent.start.before(end)) {
			return true;
		} else {
			return false;
		}

	}
	

}
