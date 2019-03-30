package com.Spring.Model;

import java.util.Date;

public class Flight {
	private Date departureDate;
	private Date arrivalTime;
	private long duration;
	private String flightNum;
	private String destination;
	private int capacity;
	
	/** Constructor for the flight class for setting the fields to a particular flight */
	public Flight(Date departureDate, Date arrivalTime, long duration, String flightNum, String destination, int capacity) {
		
		this.departureDate = departureDate;
		this.arrivalTime = arrivalTime;
		this.duration = duration;
		this.flightNum = flightNum;
		this.destination = destination;
		this.capacity = capacity;
	}
	
	
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public String getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
