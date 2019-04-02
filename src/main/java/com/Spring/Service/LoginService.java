package com.Spring.Service;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	FileHandling fh =new FileHandling();

	public boolean checkLoginCredentials(String name, String password)  {
		return fh.readCredentials(name, password);
	}
	public boolean addCredentials(String username, String password)  {
		
		try {
		if(!checkLoginCredentials(username, password)) {
			fh.writeCredentialsToFile(username + " " + password);
		}
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void addCustomerData(String firstName, String lastname, String address, String phNum) {
		
		fh.writeUserDataToFile(firstName + " " + lastname + " " + address + " " + phNum);
	}
}
