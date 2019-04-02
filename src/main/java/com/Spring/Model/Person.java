package com.Spring.Model;

public class Person {
	
	
	private String firstname;
	private String lastname;
	private String address;
	private String phNum;
	
	
	public Person(String firstname, String lastname, String address, String phNum) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phNum = phNum;
	}
	
	public Person() {}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhNum() {
		return phNum;
	}
	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}
	
	
	

}
