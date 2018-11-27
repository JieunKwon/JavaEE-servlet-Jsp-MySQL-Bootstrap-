package com.bestshoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
 
import com.bestshoes.DBConnector;

/**
 * --------------------------------------------- 
 * @author JIEUN KWON (991447941)
 *	
 * TASK : Assignment 3 
 * MVC Modeling - Shoe Product Ordering System
 * 
 * created Date : Nov 25, 2018 
 * modified Date : Nov 25, 2018
 * --------------------------------------------- 
 *
 * Page Task	: CartDAO 
 * 				  all tasks related to access database 'Cart' 
 *
 * references db structure : 
 *
 */ 

public class CartDAO {

	// connection 
	Connection con = null;
	PreparedStatement pst;  
	 
	////////////////////////////////////////////////////////////////////////////
	// addRow : add new record 
	public void addRow( int itemId, String customerId, int quantity, double price)throws Exception {
 
		
		// make a query
        String insertQuery = "Insert into cart (itemId,customerId,quantity,price) "
        		+ "values (?,?,?,?)";
        
        
        // db connect
        try{
        	
        	// get connection
		    con = DBConnector.getConnection();
		    pst = con.prepareStatement(insertQuery);
		      
			// set
			pst.setInt(1,itemId);
			pst.setString(2,customerId);
			pst.setInt(3,quantity);
			pst.setDouble(4,price);
			
			// execute
            pst.executeUpdate();

            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
        	DBConnector.closeConnectionAll(con,pst,null);
        }
    }
	
}
