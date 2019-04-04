package com.Spring.Model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person{
private int customerId;	
static  List<Booking> bookedReservation;
	static double price;
Payment payment = new Payment();
	/** This constructor is the basic constructor for creating the fields for the customer */
	public Customer(String firstname, String lastname, String address, String phNum) {
		super(firstname, lastname, address, phNum);
		// TODO Auto-generated constructor stub
		bookedReservation = new ArrayList<Booking>();

	}
	
	public Customer() {
		bookedReservation = new ArrayList<Booking>();
	}
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public boolean checkAvailability() {
		// TODO have to write some code for checking the flight status
		
		return false;
	}

	public List<Booking> getBookings() {
		return bookedReservation;
	}
	public void addBooking(Booking b) {
		bookedReservation.add(b);
	}
	public void removeBooking(Booking b) {
	
				bookedReservation.remove(b);
		
	}
	
}
