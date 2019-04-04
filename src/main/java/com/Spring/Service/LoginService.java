package com.Spring.Service;
import org.springframework.stereotype.Service;

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
	
	public void addCustomerData(String username,String firstName, String lastname, String address, String phNum) {
		
		fh.writeUserDataToFile(username + "  " + firstName + "  " + lastname + "  " + address + "  " + phNum);
	}
	
	public void addUserFlightsData(String username, String bookedData) {
		fh.addFlightsBookingsForUser(username + " " + bookedData);
	}
	
	public String retrieveUserBookedData(String username) {
		return fh.Bookedata(username);
	}
	
	
}
