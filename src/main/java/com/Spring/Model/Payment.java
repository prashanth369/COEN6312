package com.Spring.Model;

import com.Spring.Service.LoginService;

import java.util.List;

public class Payment {
	/**
	 * 
	 */
	public List<Reservation> completes;
	
	private double price;
	/**
	 * Getter of completes
	 */
	public List<Reservation> getCompletes() {
	 	 return completes; 
	}
	/**
	 * Setter of completes
	 */
	public void setCompletes(List<Reservation> completes) { 
		 this.completes = completes; 
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
	 
	public double getBookingPrice(String username) {
		  LoginService service = new LoginService();

		String data = service.retrieveUserBookedData(username);
		String cancelledData = service.retrieveUserCancelledData(username);
		double price = 0.0, priceForCancel = 0.0;
		 int counter1, counter2 =0;
		 counter1 = data.split(" ").length;		
		 while(counter1 > counter2 ) {
			 price = price + Double.parseDouble((data.split(" ")[20]).substring(1));
		 counter2 = counter2 + 21;
		  }
		 
		 if(!cancelledData.isEmpty()) {
		 counter1 = cancelledData.split(" ").length;
		 counter2 =0;
		 while(counter1 > counter2 ) {
			 priceForCancel = priceForCancel + Double.parseDouble((cancelledData.split(" ")[20]).substring(1));
		 counter2 = counter2 + 21;
		 }
		 }
		 this.price = (price -(priceForCancel/2));
		return this.price;
	}

	public void addPayment(double price) { 
		// TODO Auto-generated method
	 }
}
