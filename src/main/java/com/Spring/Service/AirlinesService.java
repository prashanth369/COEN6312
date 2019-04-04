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

	

}
