package com.Spring.Model;

public class Customer extends Person{
private int customerId;
	
	
	/** This constructor is the basic constructor for creting the fields for the customer */
	public Customer(String firstname, String lastname, String address, int phNum) {
		super(firstname, lastname, address, phNum);
		// TODO Auto-generated constructor stub
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

}
