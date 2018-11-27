package com.bestshoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
 * Page Task	: ShoesDAO 
 * 				  all tasks related to access database 'Shoes' 
 *
 * references db structure : 
 	Shoes 
	itemId int NOT NULL auto_increment primary key,
    itemName varchar(50) NOT NULL,
    category varchar(10) NOT NULL,
    shoesize varchar(5) NOT NULL,
	quantity int NOT NULL,
    price	decimal(7,2) NOT NULL 
    
 *
 */ 

public class ShoesDAO {

	// connection 
	Connection con = null;
	PreparedStatement pst; 
	ResultSet rs = null;
	 
/*
    private int itemId;
	private String itemName;
	private String category;
	private String shoesize; 
	private int quantity;
	private double price;
*/	

	// ---------------------------------------------------------
	// 		METHOD listAllShoes()
	// ---------------------------------------------------------
	
	public ArrayList<Shoes> listAllShoes() throws Exception{
		
		// make a query
		String selectQuery = "select itemId, itemName, category, shoesize, quantity, price, content from Shoes order by itemId desc";
        
		// result
		ArrayList<Shoes> shoesList = new ArrayList<Shoes>();
		
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
			
			// save all list to ArrayList
			try {
				  
		         while(rs.next())
		  		 {
		        	  
		        	 	Shoes shoe = new Shoes();
			 	       
		        	 	// store information	
		        		shoe.setItemId(rs.getInt(1));
		        		shoe.setItemName(rs.getString(2));
		        		shoe.setCategory(rs.getString(3));
		        		shoe.setShoesize(rs.getString(4));
		        		shoe.setQuantity(rs.getInt(5));
		        		shoe.setPrice(rs.getDouble(6));
		        		shoe.setContent(rs.getString(7));
		        		 
		        		// add to arraylist 
		        		shoesList.add(shoe); 
		 	   		 
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
		return shoesList;
	}
	
	// ---------------------------------------------------------
	// 		METHOD listShoes()
	// ---------------------------------------------------------
	
	public ArrayList<Shoes> listShoes(String category) throws Exception{
		
		// make a query
		String selectQuery = "select itemId, itemName, category, shoesize, quantity, price, content from Shoes ";
		
		// condition
		if (!category.isEmpty())
			selectQuery = selectQuery + "where category ='" + category + "' ";
		selectQuery = selectQuery + "order by itemId desc";
        
		// result
		ArrayList<Shoes> shoesList = new ArrayList<Shoes>();
		
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
			
			// save all list to ArrayList
			try {
				  
		         while(rs.next())
		  		 {
		        	  
		        	 	Shoes shoe = new Shoes();
			 	       
		        	 	// store information	
		        		shoe.setItemId(rs.getInt(1));
		        		shoe.setItemName(rs.getString(2));
		        		shoe.setCategory(rs.getString(3));
		        		shoe.setShoesize(rs.getString(4));
		        		shoe.setQuantity(rs.getInt(5));
		        		shoe.setPrice(rs.getDouble(6));
		        		shoe.setContent(rs.getString(7));
		        		 
		        		// add to arraylist 
		        		shoesList.add(shoe); 
		 	   		 
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
		return shoesList;
	}
	
	// ---------------------------------------------------------
	// 		METHOD searchShoes()
	// ---------------------------------------------------------
	
	public Shoes searchShoes(String itemId) throws Exception{
		
		// make a query
		String selectQuery = "select itemId, itemName, shoesize, price from Shoes where itemId=" + itemId;
	
		// shoe for return value
		Shoes shoe = new Shoes();
		
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
		        		shoe.setItemId(rs.getInt(1));
		        		shoe.setItemName(rs.getString(2));
		        		shoe.setShoesize(rs.getString(3));
		        		shoe.setPrice(rs.getDouble(4));
		        		  	   		 
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
		return shoe;
	}
	
}
