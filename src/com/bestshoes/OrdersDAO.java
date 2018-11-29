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
 * created Date : Nov 25, 2018 
 * modified Date : Nov 25, 2018
 * --------------------------------------------- 
 *
 * Page Task	: OrdersDAO 
 * 				  all tasks related to access database 'Orders' 
 *
 * references db structure : 
   Orders 
		orderId int NOT NULL auto_increment primary key,
	    itemId int NOT NULL,
	    customerNo	int NOT NULL,
		quantity int NOT NULL,
	    price	decimal(7,2) NOT NULL,
	    orderStatus varchar(10) null,
	    Orderdate date not null,
	    Foreign KEY (itemId) references shoes(itemId),
	    Foreign KEY (customerNo) references customers(customerNo)
	
    
 *
 */ 
public class OrdersDAO {

	// connection 
	Connection con = null;
	PreparedStatement pst;  
	ResultSet rs = null;
	
	
		// ---------------------------------------------------------
		// 		METHOD oderAllItems()
		// ---------------------------------------------------------
		
		// move all items from cart to order
		public void orderAllItems(String customerId) throws Exception {
	 
			
			// make a query
			String selectQuery = "select itemId, quantity, price from Cart where customerId ='" + customerId + "' order by cartNo asc";
	        
			// db connection
			try{
	           
			    con = DBConnector.getConnection();
			    pst = con.prepareStatement(selectQuery);
			    
				try {
					rs = pst.executeQuery();
					
				} catch (SQLException e) {
					System.out.println(e.getMessage()); 
				}
				
				// save all list to ArrayList
				try {
					  
			         while(rs.next())
			  		 {
			       
			        	 System.out.println("ok - insert start" + customerId);
			        	 
			        	 // insert order 
			        	  String insertQuery = "Insert into Orders (itemId,customerId,quantity,price,orderStatus,Orderdate) "
			  	        		+ "values (?,'"+ customerId +"',?,?,'Order Placed',date(now()))";
			  	         
			  	        
			  	        // db connect
			  	        try{
			  	        	
			  	        	// get connection
			  			    con = DBConnector.getConnection();
			  			    pst = con.prepareStatement(insertQuery);
			  			      
			  				// set
			  				pst.setInt(1,rs.getInt(1));
			  				pst.setInt(2,rs.getInt(2));
			  				pst.setDouble(3,rs.getDouble(3));
			  				
			  				// execute
			  	            pst.executeUpdate();

			  	            System.out.print(rs.getInt(1));
			  	            
			  	            
			  	        }catch(Exception e){
			  	            e.printStackTrace();
			  	        }finally{
			  	        	DBConnector.closeConnectionAll(con,pst,null);
			  	        }
			  	        /////////////////////////////////////////////////////
			 	   		 
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
			 
	      
	    }
		
		// ---------------------------------------------------------
		// 		METHOD listOrders()
		// ---------------------------------------------------------
		
		// return arraylist for all orders 
		public ArrayList<Orders> listAllOrders() throws Exception{
			
			// make a query
			String selectQuery = "select o.orderID, o.itemId, o.customerId, o.quantity, o.price, o.orderStatus, o.Orderdate, s.itemName "
					+ " from Orders o, Shoes s "
					+ " where o.itemId = s.itemId "
					+ " order by o.orderId asc";
	        
			// result
			ArrayList<Orders> ordersList = new ArrayList<Orders>();
			
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
			        	 
			        	 Orders order = new Orders();
				 	       
			        	 // store information	
			        	 order.setOrderId(rs.getInt(1));
			        	 order.setItemId(rs.getInt(2)); 
			        	 order.setCustomerId(rs.getString(3));
			        	 order.setQuantity(rs.getInt(4));
			        	 order.setPrice(rs.getDouble(5));
			        	 order.setOrderStatus(rs.getString(6));
			        	 //order.setOrderDate();
			        	 order.setItemName(rs.getString(8));
			        	 
			        		 
		        		// add to arraylist 
			        	 ordersList.add(order); 
			 	   		 
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
			return ordersList;
		}

		
		// ---------------------------------------------------------
		// 		METHOD listOrders()
		// ---------------------------------------------------------
		
		public ArrayList<Orders> listOrders(String customerId) throws Exception{
			
			// make a query
			String selectQuery = "select o.orderID, o.itemId, o.customerId, o.quantity, o.price, o.orderStatus, o.Orderdate, s.itemName "
					+ " from Orders o, Shoes s "
					+ " where o.customerId ='" + customerId + "' and o.itemId = s.itemId "
					+ " order by o.orderId asc";
	        
			// result
			ArrayList<Orders> ordersList = new ArrayList<Orders>();
			
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
			        	 
			        	 Orders order = new Orders();
				 	       
			        	 // store information	
			        	 order.setOrderId(rs.getInt(1));
			        	 order.setItemId(rs.getInt(2)); 
			        	 order.setCustomerId(rs.getString(3));
			        	 order.setQuantity(rs.getInt(4));
			        	 order.setPrice(rs.getDouble(5));
			        	 order.setOrderStatus(rs.getString(6));
			        	 //order.setOrderDate();
			        	 order.setItemName(rs.getString(8));
			        	 
			        		 
		        		// add to arraylist 
			        	 ordersList.add(order); 
			 	   		 
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
			return ordersList;
		}

		
		// ---------------------------------------------------------
		// 		METHOD delRow()
		// ---------------------------------------------------------
		
		public void delRow(int orderId) throws Exception {
	 
			
			// make a query
	        String insertQuery = "delete from Orders where orderId=?";
	         
	        
	        // db connect
	        try{
	        	
	        	// get connection
			    con = DBConnector.getConnection();
			    pst = con.prepareStatement(insertQuery);
			      
				// set
				pst.setInt(1,orderId);  
			 
				// execute
	            pst.executeUpdate();

	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }finally{
	        	DBConnector.closeConnectionAll(con,pst,null);
	        }
	    }
		
		// ---------------------------------------------------------
		// 		METHOD addQty()
		// ---------------------------------------------------------
		
		public void addQty (int orderId, int quantity)throws Exception {
	 
			
			// make a query
	        String insertQuery = "update Orders set quantity=" + quantity + ", "
	        		+ "price = (price / (" + (quantity - 1) + ")) * " + quantity + " where orderId=?";
	        
	        
	        // db connect
	        try{
	        	
	        	// get connection
			    con = DBConnector.getConnection();
			    pst = con.prepareStatement(insertQuery);
			      
				// set
				pst.setInt(1,orderId);  
			 
				// execute
	            pst.executeUpdate();

	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }finally{
	        	DBConnector.closeConnectionAll(con,pst,null);
	        }
	    }

		// ---------------------------------------------------------
		// 		METHOD updateStatus()
		// ---------------------------------------------------------
		
		public void updateStatus (int orderId, String orderStatus)throws Exception {
	 
			
			// make a query
	        String insertQuery = "update Orders set orderStatus = ?  where orderId=?";
	        
	        
	        // db connect
	        try{
	        	
	        	// get connection
			    con = DBConnector.getConnection();
			    pst = con.prepareStatement(insertQuery);
			      
				// set
			    pst.setString(1,orderStatus);
				pst.setInt(2,orderId);  
			 
				// execute
	            pst.executeUpdate();

	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }finally{
	        	DBConnector.closeConnectionAll(con,pst,null);
	        }
	    }
}
