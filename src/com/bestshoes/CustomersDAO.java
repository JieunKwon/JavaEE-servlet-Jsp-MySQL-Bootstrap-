package com.bestshoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 

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
	// 		METHOD searchCustomer()
	// ---------------------------------------------------------
	
	public Customer searchCustomer(String customerId) throws Exception{
		
		// make a query
		String selectQuery = "select address, city, postalcode from Customers where customerId='" + customerId  + "'";
	
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
		        	 customer.setAddress(rs.getString(1));
		        	 customer.setCity(rs.getString(2));
		        	 customer.setPostalCode(rs.getString(3)); 
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
}
