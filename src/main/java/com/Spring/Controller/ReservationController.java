package com.Spring.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Spring.Model.Flight;
import com.Spring.Service.CustomerService;
import com.Spring.Service.FlightService;
import com.Spring.Service.LoginService;

@Controller
public class ReservationController {
	private static CustomerService customerService = new CustomerService(); 
    private String usernameForFlight="";
	private static FlightService flightService = new FlightService();
	static List<Flight> values = new ArrayList<>();
	static  List<Flight> userBookedFlights;


	
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
          userBookedFlights.clear();
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
			model.addAttribute("values", customerService.getTheCustomerInstance().getBookings());

		return "index";
		}
	}
	
	@RequestMapping(value = "/searchResults", method = RequestMethod.GET)
	public String getSearch() {
		return "userPage";
	}
	
	@RequestMapping(value = "/searchResults", method = RequestMethod.POST)
	public String getSearchResults(@RequestParam String destination, ModelMap model) {
		userBookedFlights = new ArrayList<Flight>();
		if(destination.isEmpty()) {
			model.addAttribute("errorMessage", "Select the destination first");
			return "userPage";
		}
		values =  flightService.getFlightsForDestination(destination);
		model.addAttribute("destination", destination);
		model.addAttribute("values", values);
		
		return "resultSearch";
	}
	
	@RequestMapping(value = "/booking", method = RequestMethod.POST)
	public String makeBookingForSelectedDestin(@RequestParam("naming") String[] naming, ModelMap model){
		if(naming[0].equalsIgnoreCase("value1")) {
			customerService.makeTypeBooking("Booking "+ values.get(0).toString().split(" ")[7] + " " + values.get(0).toString().split(" ")[17]);
			service.addUserFlightsData(usernameForFlight, values.get(0).toString());
		}else if(naming[0].equalsIgnoreCase("value2")) {
			customerService.makeTypeBooking("Booking "+ values.get(1).toString().split(" ")[7] + " " + values.get(1).toString().split(" ")[17]);
			service.addUserFlightsData(usernameForFlight, values.get(1).toString());

		}
				model.addAttribute("firstName", customerService.getTheCustomerInstance().getFirstname());
				model.addAttribute("lastName", customerService.getTheCustomerInstance().getLastname());
				
				String data = service.retrieveUserBookedData(usernameForFlight);
				 data = data.substring(0, data.length()-1);
				 String[] dataVariable = data.split(" ");
				 int counter1, counter2 =0;;
				 counter1 = dataVariable.length;
				 while(counter1 > counter2 ) {
				 userBookedFlights.add(flightService.getFlightsForDepartureAndDestination(data.split(" ")[counter2 + 8], data.split(" ")[counter2 + 18]));
				 counter2 = counter2 + 19;
				 }
				 model.addAttribute("values", userBookedFlights);
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
		else
			usernameForFlight = userName;
			model.addAttribute("firstName", test.split("  ")[1]);
		    model.addAttribute("lastName", test.split("  ")[2]);
			customerService.addCustomer(test.split("  ")[1], test.split("  ")[2], test.split("  ")[3], test.split("  ")[4]);
			 String data = service.retrieveUserBookedData(userName);
			 data = data.substring(0, data.length()-1);
			 String[] dataVariable = data.split(" ");
			 int counter1, counter2 =0;;
			 counter1 = dataVariable.length;
			 while(counter1 > counter2 ) {
			 userBookedFlights.add(flightService.getFlightsForDepartureAndDestination(data.split(" ")[counter2 + 8], data.split(" ")[counter2 + 18]));
			 counter2 = counter2 + 19;
			 }
			 model.addAttribute("values", userBookedFlights);
			 
		return "index";
	}

}
