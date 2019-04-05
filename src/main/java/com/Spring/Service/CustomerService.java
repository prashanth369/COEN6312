package com.Spring.Service;

import com.Spring.Model.Booking;
import com.Spring.Model.Cancel;
import com.Spring.Model.Customer;
import com.Spring.Model.Payment;
import com.Spring.Model.Reservation;
import com.Spring.Model.Update;

public class CustomerService {
     private  Customer customer;
    private  AirlinesService as ;
    private Payment payment;
     
     
     public CustomerService() {
     as = new AirlinesService();
    	 customer = new Customer();
    	 payment = new Payment();
     }
	public boolean makeTypeBooking(String type)  {
		
		Reservation reserve;
		
		// The example type String for Booking is "Booking FRANCE 11-03-2019 
		if(type.contains("Booking")) {	
			String[] bookingArrays = type.split(" ");
			reserve = new Booking();
			if(((Booking) reserve).addBooking(bookingArrays[1],bookingArrays[2], customer)) {
				customer.addBooking((Booking)reserve);
				reserve = null;
			}
			return true;
		}
		 
		// The example type String for Updation is "Update FRANCE 11-03-2019 INDIA 12-03-2019
		if(type.contains("Update")) {	
			String[] updatingArrays = type.split(" ");
			reserve = new Update();
			 customer.addBooking(((Update) reserve).makeUpdate(updatingArrays[1],updatingArrays[2],updatingArrays[3], updatingArrays[4], customer));
		    reserve = null;
			return true;
		}
		if(type.contains("Cancel")) {	

			String[] cancellingArrays = type.split(" ");
			reserve = new Cancel();
			if(((Cancel) reserve).addCancel(cancellingArrays[1],cancellingArrays[2], customer)) {
				return true;
			}
		}	
		return false;
	}
	
	public void addCustomer(String firstName, String lastName, String address, String phNum) {
		customer = new Customer(firstName, lastName, address, phNum);
	}
	
	public Customer getTheCustomerInstance() {
		return customer;
	}
	
	public Payment getPaymentInstance() {
		return this.payment;
	}
}
