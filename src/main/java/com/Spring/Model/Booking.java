package com.Spring.Model;

import com.Spring.Service.AirlinesService;

public class Booking extends Reservation {
private Flight bookedFlights;
	
 
 public Flight getBookedFlight() {
	return bookedFlights;
}
 
	public boolean addBooking(String destination, String departureDate, Customer customer) {
		
          AirlinesService service = new AirlinesService(); 
   
	     for( Flight f:service.getAllAirlines().getOwnedFights()) {
		  if(f.getDestination().equalsIgnoreCase(destination) && f.getDepartureDate().equalsIgnoreCase(departureDate)) {
			  if(f.getCapacity() >0) {
			  add(f);
			  f.setCapacity(f.getCapacity()-1);
			  return true;
			  }
		  }
	  
         }
	     return false;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	public void add(Flight f) {
		this.bookedFlights = f;
	}
	
	public String toString() {
	
		return getBookedFlight() + " ";
	}
	
}
