package com.Spring.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.Spring.Model.Flight;

public class FlightService {
	
	private static List<Flight> flights;
	
	
	public FlightService() {
		
		flights = Arrays.asList(new Flight("11-03-2019","11-04-2019",(long) 24.0,"BA101","INDIA",21, 980.76),
                new Flight("12-03-2019","12-04-2019",(long) 12,"BA102","FRANCE",11, 574.89),
                new Flight("13-03-2019","13-04-2019",(long) 28,"BA103","AUSTRALIA",20, 1025.76),
                new Flight("14-03-2019","14-04-2019",(long) 6,"BA104","CHICAGO",8, 576.90),
                new Flight("15-03-2019","15-04-2019",(long) 13,"BA105","LONDON",25, 650.45),
                new Flight("16-03-2019","16-04-2019",(long) 30,"BA106","INDIA",32, 1580.54),
                new Flight("17-03-2019","17-04-2019",(long) 17,"BA107","FRANCE",21, 680.43),
                new Flight("18-03-2019","18-04-2019",(long) 34,"BA108","AUSTRALIA",21, 2345.76),
                new Flight("19-03-2019","19-04-2019",(long) 8,"BA109","CHICAGO",8, 897.76),
                new Flight("20-03-2019","20-0-2019",(long) 16,"BA110","LONDON",10, 760.98));
	}

	public List<Flight> getFlights(){
		return flights;
	}
	
	public List<Flight> getFlightsForDestination(String destination){
		
		List<Flight> flightList = new ArrayList<>();
		for(Flight f: flights) {
			if(f.getDestination().equalsIgnoreCase(destination)) {
				flightList.add(f);
			}
		}
		return flightList;
	}
public Flight getFlightsForDepartureAndDestination(String destination, String departureDate){
		
		for(Flight f: flights) {
			if(f.getDestination().equalsIgnoreCase(destination) && f.getDepartureDate().equalsIgnoreCase(departureDate) ) {
                return f;		
                }
		}
		return null;
	}

}
