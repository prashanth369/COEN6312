package com.Spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Spring.Model.Admin;
import com.Spring.Model.Customer;
import com.Spring.Model.Flight;
import com.Spring.Service.LoginService;



@Controller
public class ReservationController {
	private static Customer customer;
	private static Admin admin;
	private static Flight flight;
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
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String getLogin(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String address,@RequestParam String phNum, @RequestParam String userName,@RequestParam String password, ModelMap model) throws Exception {
          boolean testing = false;
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
			return "customer";
		}
		else {
			customer = new Customer(firstName, lastName, address, phNum);
			service.addCustomerData(firstName.trim(), lastName.trim(), address.trim(), phNum.trim());
			model.addAttribute("firstName", firstName.trim());
			model.addAttribute("lastName", lastName.trim());

		return "index";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String makeLogin(@RequestParam String userName, @RequestParam String password, ModelMap model) throws Exception {
		
		boolean test =service.checkLoginCredentials(userName, password);
		if(!test) {
			model.clear();
			model.addAttribute("errorMessage", "Invalid Credentials");
			return "loginPage";
		}
		else
		return "index";
	}

}
