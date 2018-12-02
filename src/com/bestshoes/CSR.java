package com.bestshoes;
 
/**
 * --------------------------------------------- 
 * @author JIEUN KWON (991447941)
 *	
 * TASK : Assignment 3 
 * MVC Modeling - Shoe Product Ordering System
 * 
 * created Date : Nov 20, 2018 
 * modified Date : Nov 22, 2018
 * --------------------------------------------- 
 *
 * Page : CSR.java (bean)
 * 
 * Reference :  CSR  
	csrNo	int NOT NULL auto_increment primary key,
	employeeId	varchar(60) NOT NULL,
    username varchar(30) NOT NULL,
    userpwd	varchar(30) NOT NULL,
    firstname varchar(30) NOT NULL,
    lastname varchar(30) NOT NULL 

 *
 */ 
public class CSR {

	// variables
		private String employeeId; 
		private String userName;
		private String userPwd;
		private String firstName; 
		private String lastName;
		
		public String getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(String employeeId) {
			this.employeeId = employeeId;
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
		
		
}
