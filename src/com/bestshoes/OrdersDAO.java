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
	    shoesize	varchar,
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
			String selectQuery = "select itemId, shoesize, quantity, price from Cart where customerId ='" + customerId + "' order by cartNo asc";
	        
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
			       
			        	 
			        	 // insert order 
			        	  String insertQuery = "Insert into Orders (itemId,customerId,shoesize, quantity,price,orderStatus,Orderdate) "
			  	        		+ "values (?,'"+ customerId +"',?,?,?,'Order Placed',date(now()))";
			  	         
			  	        
			  	        // db connect
			  	        try{
			  	        	
			  	        	// get connection
			  			    con = DBConnector.getConnection();
			  			    pst = con.prepareStatement(insertQuery);
			  			      
			  				// set
			  				pst.setInt(1,rs.getInt(1));
			  				pst.setString(2,rs.getString(2));
			  				pst.setInt(3,rs.getInt(3)); 
			  				pst.setDouble(4,rs.getDouble(4));
			  				
			  				// execute
			  	            pst.executeUpdate();

			  	           		  	            
			  	            
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
		// 		METHOD listAllOrders()
		// ---------------------------------------------------------
		
		// return arraylist for all orders with item name
		public ArrayList<Orders> listAllOrders() throws Exception{
			
			// make a query
			String selectQuery = "select o.orderID, o.itemId, o.customerId, o.shoesize, o.quantity, o.price, o.orderStatus, o.Orderdate, s.itemName "
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
			        	 order.setShoesize(rs.getString(4));
			        	 order.setQuantity(rs.getInt(5));
			        	 order.setPrice(rs.getDouble(6));
			        	 order.setOrderStatus(rs.getString(7));
			        	 //order.setOrderDate();
			        	 order.setItemName(rs.getString(9));
			        	 
			        		 
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
		
		// return orders list for the specific customer id 
		public ArrayList<Orders> listOrders(String customerId) throws Exception{
			
			// make a query
			String selectQuery = "select o.orderID, o.itemId, o.customerId, o.shoesize, o.quantity, o.price, o.orderStatus, o.Orderdate, s.itemName "
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
			        	 order.setShoesize(rs.getString(4));
			        	 order.setQuantity(rs.getInt(5));
			        	 order.setPrice(rs.getDouble(6));
			        	 order.setOrderStatus(rs.getString(7));
			        	 //order.setOrderDate();
			        	 order.setItemName(rs.getString(9));
			        	  
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
		// 		METHOD listOrdersPlaced()
		// ---------------------------------------------------------
		
		// return orders placed list for the specific customer id 
		public ArrayList<Orders> listOrdersPlaced(String customerId) throws Exception{
			
			// make a query
			String selectQuery = "select o.orderID, o.itemId, o.customerId, o.shoesize, o.quantity, o.price, o.orderStatus, o.Orderdate, s.itemName "
					+ " from Orders o, Shoes s "
					+ " where o.customerId ='" + customerId + "' and o.orderStatus = 'Order Placed' and o.itemId = s.itemId "
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
			        	 order.setShoesize(rs.getString(4));
			        	 order.setQuantity(rs.getInt(5));
			        	 order.setPrice(rs.getDouble(6));
			        	 order.setOrderStatus(rs.getString(7));
			        	 //order.setOrderDate();
			        	 order.setItemName(rs.getString(9));
			        	 
			        		 
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
		// 		METHOD addQty()
		// ---------------------------------------------------------
		
		public void downQty (int orderId, int quantity)throws Exception {
	 
			
			// make a query
	        String insertQuery = "update Orders set quantity=" + quantity + ", "
	        		+ "price = (price / (" + (quantity + 1) + ")) * " + quantity + " where orderId=?";
	        
	        
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
