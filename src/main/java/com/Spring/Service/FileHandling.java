package com.Spring.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileHandling {
	static BufferedWriter bw;
	static BufferedReader br ;
	private final  String path = "logfile.txt";
	private final  String pathForUserData = "userdata.txt";
	private final  String pathForFlightData = "flightfile.txt";
	
	
	public void writeCredentialsToFile(String credentials) {
		try {
		 bw = new BufferedWriter(new FileWriter(path, true));
		bw.write(credentials);
		bw.newLine();
		bw.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void writeUserDataToFile(String data)  {
		try {
		bw = new BufferedWriter(new FileWriter(pathForUserData, true));
		bw.write(data);
		bw.newLine();
		bw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addFlightsBookingsForUser(String bookedData) {
		try {
			bw = new BufferedWriter(new FileWriter(pathForFlightData, true));
			bw.write(bookedData);
			bw.newLine();
			bw.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	/**  This method is for validating the user and retrieving the profile of the user */
	
	public String readCredentials(String username, String password)  {
		try {
		br = new  BufferedReader(new FileReader(path));
		String lines;
		while((lines = br.readLine())!=null) {
				if(lines.split(" ")[0].equalsIgnoreCase(username) &&lines.split(" ")[1].equalsIgnoreCase(password)) {
					String userName = retrieveUserProfile(username);
					br.close();
					return userName;
				}
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
		return "";
	}
	
	
	/**  This method is for retrieving the user profile from the username*/
	public String retrieveUserProfile(String username) {
		try {
			br = new  BufferedReader(new FileReader(pathForUserData));
			String lines;
			while((lines = br.readLine())!=null) {
				if(lines.contains(username)) {
					if(lines.split("  ")[0].equalsIgnoreCase(username) ) {
						br.close();
						return lines;
					}
				}
			}
			
			}catch(Exception e) {
				e.printStackTrace();
			}	
			return "";
	}
	
	public String bookedData(String username) {
		String data = "";
		try {
			br = new  BufferedReader(new FileReader(pathForFlightData));
			String lines;
			while((lines = br.readLine())!=null) {
				if(lines.contains("Booking") && lines.contains(username)) {
						data = data + lines + " ";	
			  }
			}
			br.close();
			}
		catch(Exception e) {
				e.printStackTrace();
			}
    	return data;

	}
	public String cancelledData(String username) {
		String data = "";
		try {
			br = new  BufferedReader(new FileReader(pathForFlightData));
			String lines;
			while((lines = br.readLine())!=null) {
				if(lines.contains("Cancel") && lines.contains(username)) {
						data = data + lines + " ";	
			  }
			}
			br.close();
			}
		catch(Exception e) {
				e.printStackTrace();
			}
    	return data;

	}
	
}
