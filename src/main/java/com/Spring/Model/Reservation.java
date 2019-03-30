package com.Spring.Model;

public abstract class Reservation {
	
	private int seatNum;
	private double price;
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public abstract void run() ;

}
