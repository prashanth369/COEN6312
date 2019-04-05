package com.Spring.Service;
import com.Spring.Model.Airlines;

public class AirlinesService {
	private Airlines airlines;
	FlightService flightService ; 

	
	public AirlinesService() {
		 flightService  = new FlightService();
		airlines = new Airlines("British Airways",10, flightService.getFlights());
	}

	public Airlines getAllAirlines() {
		return this.airlines;
	}

	

}
