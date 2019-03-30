package com.Spring.Model;

import java.util.List;

public class Airlines {
	private String name;
	private int numbFlights;
	private List<Flight> ownedFights;
	
	/**This constructor is for creating an Airlines with name, number of flights and the flights owned by it  */
	public Airlines(String name, int numbFlights, List<Flight> ownedFights) {
		this.name = name;
		this.numbFlights = numbFlights;
		this.ownedFights = ownedFights;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumbFlights() {
		return numbFlights;
	}
	public void setNumbFlights(int numbFlights) {
		this.numbFlights = numbFlights;
	}
	public List<Flight> getOwnedFights() {
		return ownedFights;
	}
	public void setOwnedFights(List<Flight> ownedFights) {
		this.ownedFights = ownedFights;
	}
	

}
