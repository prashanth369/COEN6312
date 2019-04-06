package com.Spring.Model;

import java.util.List;

public class Airlines {
	private String name;
	private int numbFlights;
	private static List<Flight> ownedFights;
	
	/**This constructor is for creating an Airlines with name, number of flights and the flights owned by it  */
	public Airlines(String name, int numbFlights, List<Flight> ownedFights) {
		this.name = name;
		this.numbFlights = numbFlights;
		Airlines.ownedFights = ownedFights;
	}
	/**
	 * Getter of Name
	 */
	
	public String getName() {
		return name;
	}
	/**
	 * Setter of Name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Getter of NumbFlight
	 */
	public int getNumbFlights() {
		return numbFlights;
	}
	/**
	 * Setter of NumbFlight
	 */
	public void setNumbFlights(int numbFlights) {
		this.numbFlights = numbFlights;
	}
	public List<Flight> getOwnedFights() {
		return ownedFights;
	}
	public void setOwnedFights(List<Flight> ownedFights) {
		Airlines.ownedFights = ownedFights;
	}
	
	public String toString() {
		return this.name + " has " + this.getOwnedFights() +" " + this.numbFlights;
	}
}
