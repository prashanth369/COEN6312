package com.Spring.Service;
import com.Spring.Model.Airlines;

public class AirlinesService {
	private Airlines airlines;

	public void assignFlightsToAirlines() {
		
		FlightService flightService = new FlightService();
		 airlines = new Airlines("British Airways",10, flightService.getFlights());
		
	}
	
	public Airlines getAllAirlines() {
		assignFlightsToAirlines();
		return this.airlines;
	}
//	public static void main(String[] args) {
//		AirlinesService as = new AirlinesService();
//		as.assignFlightsToAirlines();
//		//System.out.println(as.getAllAirlines());
//		CustomerService cs = new CustomerService();
//		cs.addCustomer("Prashanth", "Somireddy", "Montreal", "5147787369");
//	    cs.makeTypeBooking("Booking FRANCE 12-03-2019");
//	    cs.makeTypeBooking("Booking INDIA 16-03-2019");
//	    cs.makeTypeBooking("Booking FRANCE 17-03-2019");
//
//		System.out.println(cs.getTheCustomerInstance().getBookings());
//		cs.makeTypeBooking("Update FRANCE 12-03-2019 INDIA 11-03-2019");
//		System.out.println(cs.getTheCustomerInstance().getBookings());
//        cs.makeTypeBooking("Cancel FRANCE 17-03-2019");
//		System.out.println(cs.getTheCustomerInstance().getBookings());
//
//	}
	

}
