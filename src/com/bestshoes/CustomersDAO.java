package com.bestshoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 

/**
 * --------------------------------------------- 
 * @author JIEUN KWON (991447941)
 *	
 * TASK : Assignment 3 
 * MVC Modeling - Shoe Product Ordering System
 * 
 * created Date : Nov 27, 2018 
 * modified Date : Nov 27, 2018
 * --------------------------------------------- 
 *
 * Page Task	: CustoemrsDAO 
 * 				  all tasks related to access database 'Customers' 
 *
 * references db structure : 
 *
 */ 

public class CustomersDAO {
	
	// connection 
	Connection con = null;
	PreparedStatement pst;  
	ResultSet rs = null;

	// ---------------------------------------------------------
	// 		METHOD searchAllCustomer()
	// ---------------------------------------------------------
	
	public ArrayList<Customer> searchAllCustomer() throws Exception{
 
		// make a query
		String selectQuery = "select customerId, userName, userPwd, firstName, lastName, address, city, postalcode from Customers order by customerId asc";
	
		//return value
		ArrayList<Customer> custList = new ArrayList<Customer>();
		 
		// db connection
		try{
           
		    con = DBConnector.getConnection();
		    pst = con.prepareStatement(selectQuery);
		    
			try {
				rs = pst.executeQuery();
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println(pst.toString());
				e.printStackTrace();
			}
		
			try {
				  
		         while(rs.next())
		  		 {
		        	   
		        	 // store information	
		        	 Customer customer = new Customer();
		        	 
		        	 customer.setCustomerId(rs.getString(1));
		        	 customer.setUserName(rs.getString(2));
		        	 customer.setUserPwd(rs.getString(3));
		        	 customer.setFirstName(rs.getString(4));
		        	 customer.setLastName(rs.getString(5));		        	 
		        	 customer.setAddress(rs.getString(6));
		        	 customer.setCity(rs.getString(7));
		        	 customer.setPostalCode(rs.getString(8)); 
		        	 
		        	 // add list
		        	 custList.add(customer);
		  		 }
		         
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
			  
        }catch(Exception e){
                e.printStackTrace();
        }finally{
              
        	DBConnector.closeConnectionAll(con,pst,rs);
        }
		
		// return 
		return custList;
	}
	
	// ---------------------------------------------------------
	// 		METHOD searchCustomer()
	// ---------------------------------------------------------
	
	public Customer searchCustomer(String customerId) throws Exception{
		
		// make a query
		String selectQuery = "select userName, userPwd, firstname, lastname, address, city, postalcode from Customers where customerId='" + customerId  + "'";
	
		// shoe for return value
		Customer customer = new Customer();
		
		// db connection
		try{
           
		    con = DBConnector.getConnection();
		    pst = con.prepareStatement(selectQuery);
		    
			try {
				rs = pst.executeQuery();
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println(pst.toString());
				e.printStackTrace();
			}
		
			try {
				  
		         while(rs.next())
		  		 {
		        	   
		        	 // store information	
		        	 /*
		        	  *  customer.setAddress(rs.getString(1));
		        	 customer.setCity(rs.getString(2));
		        	 customer.setPostalCode(rs.getString(3)); 
		        	 
		        	  */
		        	 customer.setCustomerId(customerId);
		        	 customer.setUserName(rs.getString(1));
		        	 customer.setUserPwd(rs.getString(2));
		        	 customer.setFirstName(rs.getString(3));
		        	 customer.setLastName(rs.getString(4));
		        	 customer.setAddress(rs.getString(5));
		        	 customer.setCity(rs.getString(6));
		        	 customer.setPostalCode(rs.getString(7)); 
		  		 }
		         
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
			  
        }catch(Exception e){
                e.printStackTrace();
        }finally{
              
        	DBConnector.closeConnectionAll(con,pst,rs);
        }
		
		// return 
		return customer;
	}

	////////////////////////////////////////////////////////////////////////////
	// updateRow
	//	
	// UPDATE : update address, city, postalcode info
	public void updateRow(String customerId, String address, String city, String postalCode) throws Exception{
		
		// make a query
		String updateQuery = "Update customers "
							+ "set address =?, city =?, postalCode =? "
							+ "where customerId = ?";
        
		// db connection
		try{
           
		    con = DBConnector.getConnection();
		    pst = con.prepareStatement(updateQuery);
		       
		    // set
		    pst.setString(1,customerId); 
			pst.setString(2,address);  
			pst.setString(3,city);
			pst.setString(4,postalCode);
			
			// execute
            pst.executeUpdate();
            
        }catch(Exception e){
                e.printStackTrace();
        }finally{
                DBConnector.closeConnectionAll(con,pst,null);
        }
    }

	////////////////////////////////////////////////////////////////////////////
	// updateRow
	//	
	// UPDATE : update address, city, postalcode info
	public void updateRow(String customerId, String customerPwd, String firstName, String lastName, String address, String city, String postalCode) throws Exception{
		
		// make a query
		String updateQuery = "Update customers "
							+ "set userName=?, userPwd=?, firstName=?, lastName=?, address =?, city =?, postalCode =? "
							+ "where customerId = ?";
        
		// db connection
		try{
           
		    con = DBConnector.getConnection();
		    pst = con.prepareStatement(updateQuery);
		       
		    // set
		    pst.setString(1,firstName+" " + lastName);
		    pst.setString(2,customerPwd); 
		    pst.setString(3,firstName); 
		    pst.setString(4,lastName); 
			pst.setString(5,address);  
			pst.setString(6,city);
			pst.setString(7,postalCode);
			pst.setString(8,customerId);
			
			// execute
            pst.executeUpdate();
            
        }catch(Exception e){
                e.printStackTrace();
        }finally{
                DBConnector.closeConnectionAll(con,pst,null);
        }
    }
	
	// ---------------------------------------------------------
	// 		METHOD delRow()
	// ---------------------------------------------------------
	
	public void delRow(String customerId) throws Exception {
 
		
		// make a query
        String insertQuery = "delete from customers where customerId=?";
         
        
        // db connect
        try{
        	
        	// get connection
		    con = DBConnector.getConnection();
		    pst = con.prepareStatement(insertQuery);
		      
			// set
			pst.setString(1,customerId);  
		 
			// execute
            pst.executeUpdate();

            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
        	DBConnector.closeConnectionAll(con,pst,null);
        }
    }
}
