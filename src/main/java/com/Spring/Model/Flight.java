package com.Spring.Model;
public class Flight {
	
	
	private String departureDate;
	private String arrivalTime;
	private long duration;
	private String flightNum;
	private String destination;
	private int capacity;
	private double price;
	private String arrivalDate;
	
	/** Constructor for the flight class for setting the fields to a particular flight */
	public Flight(String departureDate, String arrivalTime, long duration, String flightNum, String destination, int capacity, double price) {
		
		this.departureDate = departureDate;
		this.arrivalTime = arrivalTime;
		this.duration = duration;
		this.flightNum = flightNum;
		this.destination = destination;
		this.capacity = capacity;
		this.price = price;
	}
	
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	/**
	 * Getter of arrivalDate
	 */
	public String getArrivalDate() {
	 	 return arrivalDate; 
	}
	/**
	 * Setter of arrivalDate
	 */
	public void setArrivalDate(String arrivalDate) { 
		 this.arrivalDate = arrivalDate; 
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
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
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return this.price;
	}
	public String toString() {
		return "The flight Number is " + this.flightNum + " the destination " + this.destination +" and the duration is "+ this.duration + " Hours" + " Its departure date " + this.departureDate + " " + "$" + this.price + "\n";
	}
}
