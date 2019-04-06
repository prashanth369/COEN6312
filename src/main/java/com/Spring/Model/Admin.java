package com.Spring.Model;
import java.util.List;

public class Admin extends Person {
	
private int adminId;
public List<Reservation> alters;


/**
 * use these fields for creating the constructor
 * **/
	public Admin(String firstname, String lastname, String address, String phNum) {
		super(firstname, lastname, address, phNum);
	}
	/**
	 * Getter of adminId
	 */
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int customerId) {
		this.adminId = customerId;
	}
	/**
	 * Getter of alters
	 */
	public List<Reservation> getAlters() {
	 	 return alters; 
	}
	/**
	 * Setter of alters
	 */
	public void setAlters(List<Reservation> alters) { 
		 this.alters = alters; 
	}
	/** This method is for checking the avilability of the flights based on the user prefernces  */
	public void makeUpdate() {
		//TO-DO have to write some code for checking the flight status
	}

}
