package com.Spring.Model;

public class Person {
	
	
	private String firstname;
	private String lastname;
	private String address;
	private int phNum;
	
	
	public Person(String firstname, String lastname, String address, int phNum) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phNum = phNum;
	}
	
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
	public int getPhNum() {
		return phNum;
	}
	public void setPhNum(int phNum) {
		this.phNum = phNum;
	}
	
	
	

}
