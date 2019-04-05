package com.Spring.Model;
public class Update extends Reservation {

	private Booking b;
	static double price;	
	public  Booking makeUpdate(String destination, String departureDate, String newDestination , String newDate, Customer c) {
		for(Booking b : c.getBookings()) {
			if(b.getBookedFlight().getDestination().equalsIgnoreCase(destination) && (b.getBookedFlight().getDepartureDate().equals(departureDate))) {
				c.removeBooking(b);
				return checkUpdate(newDestination, newDate, c);
			}
		}
		return null;
		}
	
	public Booking checkUpdate(String destination, String newDate, Customer c) {
	 b =new Booking();
	if( b.addBooking(destination, newDate, c)) {
		return b;
	}
	return null;
	 
	}
	@Override
	public void run() {
     		
	}

}
