package com.Spring.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {
	static BufferedWriter bw;
	static BufferedReader br ;
	private final  String path = "logfile.txt";
	private final  String pathForUserData = "userdata.txt";
	private final  String pathForFlightData = "flightfile.txt";

	public void writeCredentialsToFile(String value) {
		try {
		 bw = new BufferedWriter(new FileWriter(path, true));
		bw.write(value);
		bw.newLine();
		bw.close();}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void writeUserDataToFile(String value)  {
		try {
		bw = new BufferedWriter(new FileWriter(pathForUserData, true));
		bw.write(value);
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
	
	public String readCredentials(String username, String password)  {
		try {
		br = new  BufferedReader(new FileReader(path));
		String lines;
		while((lines = br.readLine())!=null) {
			if(lines.contains(username)) {
				if(lines.split(" ")[0].equalsIgnoreCase(username) &&lines.split(" ")[1].equalsIgnoreCase(password)) {
					String userName = retrieveUserProfile(username);
					br.close();
					return userName;
				}
			}
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
		return "";
	}
	
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
	
	public String Bookedata(String username) {
		String data = "";
		try {
			br = new  BufferedReader(new FileReader(pathForFlightData));
			String lines;
			while((lines = br.readLine())!=null) {
				if(lines.contains(username)) {
					if(lines.split(" ")[0].equalsIgnoreCase(username) ) {
						data = data + lines + " ";
						
					}
				}
			}
			br.close();
            if(!data.isEmpty()) {
            	return data;
            }
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		
			return "";
	}

}
