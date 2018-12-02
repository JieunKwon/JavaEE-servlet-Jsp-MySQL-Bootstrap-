package com.bestshoes;

/**
 * --------------------------------------------- 
 * @author JIEUN KWON (991447941)
 *	
 * TASK : Assignment 3 
 * MVC Modeling - Shoe Product Ordering System
 * 
 * created Date : Nov 22, 2018 
 * modified Date : Nov 22, 2018
 * --------------------------------------------- 
 *
 * Page : Customer.java (bean)
 * 
 * Reference :  TABLE Customers  
 * 
	customerNo	int NOT NULL auto_increment primary key,
	customerId	varchar(60) NOT NULL,
    username varchar(30) NOT NULL,
    userpwd	varchar(30) NOT NULL,
    firstname varchar(30) NOT NULL,
    lastname varchar(30) NOT NULL,
    address varchar(100) NULL,
    city varchar(30) NULL,
    postalCode varchar(10) NULL
 

 *
 */ 

public class Customer {
	
	// variables
	private String customerId; 
	private String userName;
	private String userPwd;
	private String firstName; 
	private String lastName;
	private String address;
	private String city;
	private String postalCode;
	
	// Getter and Setter
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	 
}
