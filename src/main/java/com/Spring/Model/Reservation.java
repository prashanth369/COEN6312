package com.Spring.Model;

public abstract class Reservation {
	
	private int seatNum;
	private double price;
	/**
	 * Getter of seatNum
	 */
	public int getSeatNum() {
		return seatNum;
	}
	/**
	 * Setter of seatNum
	 */
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	/**
	 * Getter of price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Setter of price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	public void run() {
		
	}

}
