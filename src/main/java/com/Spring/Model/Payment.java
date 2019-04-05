package com.Spring.Model;

import com.Spring.Service.LoginService;

public class Payment {
 
 double price;
 static LoginService service = new LoginService();
	 
	public double getBookingPrice(String username) {
		String data = service.retrieveUserBookedData(username);
		String cancelledData = service.retrieveUserCancelledData(username);
		double price = 0.0, priceForCancel = 0.0;
		 int counter1, counter2 =0;
		 counter1 = data.split(" ").length;		
		 while(counter1 > counter2 ) {
			 price = price + Double.parseDouble((data.split(" ")[20]).substring(1));
		 counter2 = counter2 + 21;
		 }
		 
		 counter1 = cancelledData.split(" ").length;
		 counter2 =0;
		 while(counter1 > counter2 ) {
			 priceForCancel = priceForCancel + Double.parseDouble((cancelledData.split(" ")[20]).substring(1));
		 counter2 = counter2 + 21;
		 }
		 
		 this.price = (price -(priceForCancel/2));
		return this.price;
	}
	public double getPayment() {
		return this.price;
	}
}
