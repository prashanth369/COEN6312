package com.Spring.Model;

public class Person {
	
	
	private String firstname;
	private String lastname;
	private String address;
	private String phNum;
	private Integer age;
	
	
	public Person(String firstname, String lastname, String address, String phNum2) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phNum = phNum2;
	}
	
	public Person() {}
	/**
	 * Getter of firstName
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * Setter of firstName
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * Getter of address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * Setter of address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhNum() {
		return phNum;
	}
	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}
	/**
	 * Getter of age
	 */
	public Integer getAge() {
	 	 return age; 
	}
	/**
	 * Setter of age
	 */
	public void setAge(Integer age) { 
		 this.age = age; 
	}
	
	
	

}
