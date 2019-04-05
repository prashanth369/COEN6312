package com.Spring.Model;


public class Cancel extends Reservation {
	
	public boolean addCancel(String destination, String departureDate, Customer c) {	

		for(Booking b : c.getBookings()) {
				if(b.getBookedFlight().getDestination().equalsIgnoreCase(destination) && (b.getBookedFlight().getDepartureDate().equalsIgnoreCase(departureDate))) {
					c.removeBooking(b);
					return true;
				  }
			}
		return false;
		}
		
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
