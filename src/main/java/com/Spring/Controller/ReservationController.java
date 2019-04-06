package com.Spring.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Spring.Model.Flight;
import com.Spring.Service.CustomerService;
import com.Spring.Service.FlightService;
import com.Spring.Service.LoginService;

@Controller
@SessionAttributes("userName")
public class ReservationController {
	private static CustomerService customerService = new CustomerService(); 
    private String usernameForFlight="";
	private static FlightService flightService = new FlightService();
	static List<Flight> values = new ArrayList<>();
	  List<Flight> userBookedFlights = new ArrayList<>();;
	  List<Flight> userCancelledFlights = new ArrayList<>();

	@Autowired
	LoginService service;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello() {
		return "Welcome";
	}
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String sayWelcome() {
		return "index";
	}
	@RequestMapping(value = "/logging", method = RequestMethod.GET)
	public String direct() {
		return "loginPage";
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegister() {
		return "customer";
	}
	
	/**The controller for creating the Customer profile that is for registering the user   */
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String getLogin(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String address,@RequestParam String phNum, @RequestParam String userName,@RequestParam String password, ModelMap model) throws Exception {
          boolean testing = false;
          if(userBookedFlights.size() > 0) {
          userBookedFlights.clear();}
		if(firstName.isEmpty()) {
			model.addAttribute("errorFirstName", " Firstname cannot be empty ");
			testing =true;
		}
		
		if(lastName.isEmpty()) {
			model.addAttribute("errorLastName", "  lastname cannot be empty ");
			testing =true;
		}
			
		if(address.isEmpty()) {
			model.addAttribute("errorAddress", "  address cannot be empty");
			testing =true;
		}

		if(phNum.isEmpty()) {
			model.addAttribute("errorPhoneNum", "  phone number cannot be empty");
			testing =true;
		}

		if(userName.isEmpty()) {
			model.addAttribute("errorUserName", "username cannot be empty ");
			testing =true;
		}

		if(password.isEmpty()) {
			model.addAttribute("errorPassword", "password cannot be empty ");
			testing =true;
		}
		service.addCredentials(userName, password);

		if(testing) {
			//model.clear();
			return "customer";
		}
		
		else {
			customerService.addCustomer(firstName, lastName, address, phNum);			
			service.addCustomerData(userName.trim(), firstName.trim(), lastName.trim(), address.trim(), phNum.trim());
			usernameForFlight = userName.trim();
			model.addAttribute("firstName", firstName.trim());
			model.addAttribute("lastName", lastName.trim());
			model.addAttribute("message", "The user " + firstName + " currenlt does not have any reservations ");
            model.addAttribute("price", 0.0);
		return "index";
		}
	}
	
	@RequestMapping(value = "/searchResults", method = RequestMethod.GET)
	public String getSearch() {
		return "userPage";
	}
	
	@RequestMapping(value = "/searchResults", method = RequestMethod.POST)
	public String getSearchResults(@RequestParam String destination, ModelMap model) {
		if(destination.isEmpty()) {
			model.addAttribute("errorMessage", "Select the destination first");
			return "userPage";
		}
		
		values =  flightService.getFlightsForDestination(destination);

		model.addAttribute("destination", destination);
		model.addAttribute("values", values);
		
		return "resultSearch";
	}
	
	
	//TODO have to include the cancelled data in the files
	@RequestMapping(value = "/booking", method = RequestMethod.POST)
	public String makeBookingForSelectedDestin(@RequestParam("naming") String[] naming, ModelMap model){
		int counter =1;
		
		
		while(counter <= values.size()) {
		if(naming[0].equalsIgnoreCase("value" + counter)) {			
			customerService.makeTypeBooking("Booking "+ values.get(counter -1).toString().split(" ")[7] + " " + values.get(counter -1).toString().split(" ")[17]);
			service.addUserFlightsData(usernameForFlight, values.get(counter-1).toString());
		   }
		counter++;

		 }
				model.addAttribute("firstName", customerService.getTheCustomerInstance().getFirstname());
				model.addAttribute("lastName", customerService.getTheCustomerInstance().getLastname());
				
				String data = service.retrieveUserBookedData(usernameForFlight);
				 String cancelledData = service.retrieveUserCancelledData(usernameForFlight);
				
				 if(!data.isEmpty()) {
				 data = data.substring(0, data.length()-1);
				 userBookedFlights = service.getTheChangedBookings(data, flightService);
				 }
				 if(!cancelledData.isEmpty()) {
					 userCancelledFlights = service.getTheChangedBookings(cancelledData, flightService);
						 userBookedFlights = service.getChangedListFromOriginal(userBookedFlights,userCancelledFlights);
				   }
				 model.addAttribute("values", userBookedFlights);
   				 model.addAttribute("price", customerService.getPaymentInstance().getBookingPrice(usernameForFlight));
				values.clear();
		return "index";
	}
		
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String makeLogin(@RequestParam String userName, @RequestParam String password, ModelMap model) throws Exception {
		String test =service.checkLoginCredentials(userName, password);
		userBookedFlights = new ArrayList<>();
		
		if(test.isEmpty()) {
			model.clear();
			model.addAttribute("errorMessage", "Invalid Credentials");
			return "loginPage";
		}
		
		else {
			usernameForFlight = userName;
			model.addAttribute("firstName", test.split("  ")[1]);
		    model.addAttribute("lastName", test.split("  ")[2]);
			customerService.addCustomer(test.split("  ")[1], test.split("  ")[2], test.split("  ")[3], test.split("  ")[4]);
			 
			model.addAttribute("firstName", customerService.getTheCustomerInstance().getFirstname());
			model.addAttribute("lastName", customerService.getTheCustomerInstance().getLastname());
			
			String data = service.retrieveUserBookedData(usernameForFlight);
			 String cancelledData = service.retrieveUserCancelledData(usernameForFlight);
			 
			 if(!data.isEmpty()) {
			 data = data.substring(0, data.length()-1);
                 userBookedFlights = service.getTheChangedBookings(data, flightService);
			 }
			
			 if(!cancelledData.isEmpty()) {
				 userCancelledFlights = service.getTheChangedBookings(cancelledData.substring(0, cancelledData.length()-1), flightService);	
				 userBookedFlights = service.getChangedListFromOriginal(userBookedFlights,userCancelledFlights);
			   }
			 
			 model.addAttribute("price", customerService.getPaymentInstance().getBookingPrice(usernameForFlight));
			 model.addAttribute("values", userBookedFlights);
			 
		return "index";
	}
	}
	
	@RequestMapping(value = "cancelBooking", method = RequestMethod.GET)
	public String getCancelBookings(ModelMap model) {
		
		if(userBookedFlights.isEmpty()) {
			model.addAttribute("emptyMessage", "No bookings to cancel");
			model.addAttribute("price", customerService.getPaymentInstance().getPayment());
			return "index";
		}
		model.addAttribute("naming", userBookedFlights);
		return "cancelBooking";
	}
	
	@RequestMapping(value = "cancelBooking", method = RequestMethod.POST)
	public String makeCancelBookings(@RequestParam String[] naming, ModelMap model) {
		int counter =1;
		while(counter <= userBookedFlights.size()) {
		if(naming[0].equalsIgnoreCase("value" + counter)) {
			customerService.makeTypeBooking("Cancel "+ userBookedFlights.get(counter-1).toString().split(" ")[7] + " " + userBookedFlights.get(counter-1).toString().split(" ")[17]);
			service.addCancelledBookings(usernameForFlight, userBookedFlights.get(counter-1).toString());
		         }
		  counter++;
		}
		
		String data = service.retrieveUserBookedData(usernameForFlight);
		 String cancelledData = service.retrieveUserCancelledData(usernameForFlight);
		 data = data.substring(0, data.length()-1);
		 userBookedFlights = service.getTheChangedBookings(data, flightService);
		 if(!cancelledData.isEmpty()) {
			 userCancelledFlights = service.getTheChangedBookings(cancelledData.substring(0, cancelledData.length()-1), flightService);
			 userBookedFlights = service.getChangedListFromOriginal(userBookedFlights,userCancelledFlights);
		   }
		double price = 0.0;
		price = customerService.getPaymentInstance().getBookingPrice(usernameForFlight);
		 model.addAttribute("price", price);
		model.addAttribute("values", userBookedFlights);
		return "index";
	}
	
	
	/** This method is to get  the update link to the update page  */
	
	@RequestMapping(value = "updateBooking", method = RequestMethod.GET)
	public String getUpdateBookings(ModelMap model) {
		if(userBookedFlights.isEmpty()) {
			
			model.addAttribute("emptyMessage", "No bookings Available to make the Update");
			model.addAttribute("price", customerService.getPaymentInstance().getPayment());
			return "index";
		}
		model.addAttribute("naming", userBookedFlights);
		return "updateBooking";
	}
	
	/** This method is to make the update to the available bookings */

	@RequestMapping(value = "updateBooking", method = RequestMethod.POST)
	public String makeUpdateBookings(@RequestParam String[] naming, ModelMap model) {
		int counter =1;
		if(naming.length==0) {
			model.addAttribute("errorMessage", "Please select the Booking to be updated");
			model.addAttribute("naming", userBookedFlights);
			return "updateBooking";
		}
		while(counter <= userBookedFlights.size()) {
		if(naming[0].equalsIgnoreCase("value" + counter)) {
			customerService.makeTypeBooking("Cancel "+ userBookedFlights.get(counter-1).toString().split(" ")[7] + " " + userBookedFlights.get(counter-1).toString().split(" ")[17]);
			service.addCancelledBookings(usernameForFlight, userBookedFlights.get(counter-1).toString());
		         }
		  counter++;
		}
		
		String data = service.retrieveUserBookedData(usernameForFlight);
		 String cancelledData = service.retrieveUserCancelledData(usernameForFlight);
		 data = data.substring(0, data.length()-1);
		 userBookedFlights = service.getTheChangedBookings(data, flightService);
		 if(!cancelledData.isEmpty()) {
			 userCancelledFlights = service.getTheChangedBookings(cancelledData.substring(0, cancelledData.length()-1), flightService);
			 userBookedFlights = service.getChangedListFromOriginal(userBookedFlights,userCancelledFlights);
		   }
		double price = 0.0;
		price = customerService.getPaymentInstance().getBookingPrice(usernameForFlight);
		 model.addAttribute("price", price);
		model.addAttribute("values", userBookedFlights);
		return "index";
	}
	


}
