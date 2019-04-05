package com.Spring.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Spring.Model.Flight;

@Service
public class LoginService {
	FileHandling fh =new FileHandling();

	public String checkLoginCredentials(String name, String password)  {
		return fh.readCredentials(name, password);
	}
	
	public boolean addCredentials(String username, String password)  {
		
		try {
		if(checkLoginCredentials(username, password).isEmpty()) {
			fh.writeCredentialsToFile(username + " " + password);
		}
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void addCancelledBookings(String username, String cancelledData) {
		fh.addFlightsBookingsForUser("Cancel" + " " + username + " " + cancelledData + " " );
	}
	
	public void addCustomerData(String username,String firstName, String lastname, String address, String phNum) {
		
		fh.writeUserDataToFile(username + "  " + firstName + "  " + lastname + "  " + address + "  " + phNum);
	}
	
	public void addUserFlightsData(String username, String bookedData) {
		fh.addFlightsBookingsForUser("Booking" + " " + username + " " + bookedData + " " );
	}
	
	public String retrieveUserBookedData(String username) {
		return fh.bookedData(username);
	}
	
	public String retrieveUserCancelledData(String username) {
		return fh.cancelledData(username);
	}
	
	public List<Flight> getTheChangedBookings(String data, FlightService flightService){
		List<Flight> userChangedBookings = new ArrayList<>();		
		 String[] dataVariable = data.split(" ");
		 int counter1, counter2 =0;
		 counter1 = dataVariable.length;		
		 while(counter1 > counter2 ) {
			 userChangedBookings.add(flightService.getFlightsForDepartureAndDestination(data.split(" ")[counter2 + 9], data.split(" ")[counter2 + 19]));
		 counter2 = counter2 + 21;
		 }
		 
		return userChangedBookings;
	}
	
	public List<Flight> getChangedListFromOriginal(List<Flight> userBookedFlights, List<Flight> userCancelledFlight){
		
            for(int i=0;i<userCancelledFlight.size();i++) {
	              userBookedFlights.remove(userCancelledFlight.get(i));
                        }
		
		return userBookedFlights;
	}
	
	
}
