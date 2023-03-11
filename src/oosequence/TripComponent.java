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
	/*
	/**
	 * sets start to current date and end to an hour later
	 /
	TripComponent() {
		long millisInHour = 3600000;
		Date currentTime = new Date();
		long hourAdded = currentTime.getTime() + millisInHour;
		Date endTime = new Date(hourAdded);
		
		setStart(currentTime);
		setEnd(endTime);
		
	}
	*/
	/**
	 * constructor that defines instance variables
	 * @param startDate start date
	 * @param endDate end date
	 */
	TripComponent (Date startDate, Date endDate) {
		super(null);
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
		super(null);
		setStart(toCopy.getStart());
		setEnd(toCopy.getEnd());
	}
	
	/**
	 * returns the length of the trip
	 * @return length
	 */
	protected long lengthInSeconds() {
		if ((getStart() != null && getEnd() != null) && 
				getStart().before(getEnd())) {
			//find the difference between end and start
			long millisToSecs = 1000;
			long time = (getEnd().getTime() - getStart().getTime()) / millisToSecs;  
			return time;
		} else {
			return (long) 0.0;
		}
	}
	
	/**
	 * returns start time
	 * @return start time
	 */
	String getStart() {
		return "";
	}
	
	/**
	 * sets the start of the trip granted the time of start is valid
	 * @param startDate start
	 */
	void setStart(Date startDate) {
		if (this.end != null && startDate.before(this.end)) {
			this.start = startDate;
		} else if (this.end == null) {
			this.start = startDate;
		}
	}
	
	/**
	 * returns the end time
	 * @return end time
	 */
	String getEnd() {
		return "";
	}

	/**
	 * sets the end time of a trip given its a valid time
	 * @param endDate end time
	 */
	void setEnd(Date endDate) {
		if (this.start != null && endDate.after(this.start)) {
			this.end = endDate;
		} else if (this.start == null) {
			this.end = endDate;
		}
	}
	
	public boolean isBefore(TripComponent otherComponent) {
		return true;
	}
	
	public boolean overlapsWith(TripComponent otherComponent) {
		return true;
	}
	

}
