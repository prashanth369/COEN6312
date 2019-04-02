package com.Spring.Model;

public class Admin extends Person {
	
private int adminId;


/**
 * use these fields for creating the constructor
 * **/
	public Admin(String firstname, String lastname, String address, String phNum) {
		super(firstname, lastname, address, phNum);
	}
	public int getCustomerId() {
		return adminId;
	}
	public void setCustomerId(int customerId) {
		this.adminId = customerId;
	}
	/** This method is for checking the avilability of the flights based on the user prefernces  */
	public boolean makeUpdate() {
		//TO-DO have to write some code for checking the flight status
		
		return false;
	}

}
