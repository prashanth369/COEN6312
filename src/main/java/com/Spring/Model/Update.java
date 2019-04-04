package com.Spring.Model;
public class Update extends Reservation {

	private Booking b;
	static double price;	
	private Payment payment;
	public  Booking makeUpdate(String destination, String departureDate, String newDestination , String newDate, Customer c, Payment payment) {
		for(Booking b : c.getBookings()) {
			if(b.getBookedFlight().getDestination().equalsIgnoreCase(destination) && (b.getBookedFlight().getDepartureDate().equals(departureDate))) {
				c.removeBooking(b);
				this.payment.calPaymentForCancel();
				this.payment = payment;
				return checkUpdate(newDestination, newDate, c ,this.payment);
			}
		}
		return null;
		}
	
	public Booking checkUpdate(String destination, String newDate, Customer c, Payment payment) {
	 b =new Booking();
	if( b.addBooking(destination, newDate, c, payment)) {
		return b;
	}
	return null;
	 
	}
	@Override
	public void run() {
     		
	}

}
