package com.Spring.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {
	static BufferedWriter br;
	static String path = "logfile.txt";
	public void writeCredentialsToFile(String value) {
		try {
		 br = new BufferedWriter(new FileWriter(path, true));
		br.write(value);
		br.newLine();
		br.close();}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void writeUserDataToFile(String value)  {
		String path = "userdata.txt";
		try {
		br = new BufferedWriter(new FileWriter(path, true));
		br.write(value);
		br.newLine();
		br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public boolean readCredentials(String username, String password)  {
		try {
		BufferedReader br = new  BufferedReader(new FileReader(path));
		String lines;
		while((lines = br.readLine())!=null) {
			if(lines.contains(username)) {
				if(lines.split(" ")[0].equalsIgnoreCase(username) &&lines.split(" ")[1].equalsIgnoreCase(password)) {
					return true;
				}
			}
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		return false;
	}

}
