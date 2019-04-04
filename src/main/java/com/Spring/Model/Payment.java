package com.Spring.Model;

public class Payment {
 
	 double price;
	 double priceForCurrentBooking;
	public void addPayment(double price) {
		this.priceForCurrentBooking = price;
		this.price = this.price + price;
	}
	public double calPaymentForCancel() {
		this.price = (price - (priceForCurrentBooking/2));
		return this.price;
	}
	
	public double getBookingPrice() {
		return this.price;
	}
}
