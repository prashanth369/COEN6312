package com.Spring.Service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean checkLoginCredentials(String name, String password) {
		return (name.equalsIgnoreCase("COEN6312") && password.equalsIgnoreCase("COEN6312"));
	}
}
