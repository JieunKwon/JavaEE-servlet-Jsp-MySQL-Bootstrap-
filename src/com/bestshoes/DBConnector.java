package com.bestshoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * --------------------------------------------- 
 * @author JIEUN KWON (991447941)
 *	
 * TASK : Assighment3
 * --------------------------------------------- 
 *
 * CLASS: DBConnector class
 * 		- to connect database MVCDB
 * 
 * created Date : Nov 26, 2018
 * 
 */

public class DBConnector {
 
		private static final String url = "jdbc:mysql://localhost:3306/MVCDB";
	   // private static final String DriverClass = "com.mysql.jdbc.Driver";
	    private static final String user = "root";
	    private static final String password = "mydb1234";

	 /*   
	    String connectionUrl = "jdbc:mysql://localhost:3306/MVCDB";
		 String connectionUser = "root";
		 String connectionPassword = "mydb1234";
		 
		 
		// create sql  
			String sql = "select itemId, itemName, category, shoesize, quantity, price  from Shoes order by itemId desc ";
	     
	        // DB connection
	        Class.forName("com.mysql.jdbc.Driver").newInstance();     
			con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			
	        // resultSet
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery(); 
		*/	
			
	    private DBConnector() {
			 
		}
	 
	    public static Connection getConnection() throws Exception{
	    	Connection connection = null;
			try {
				 Class.forName("com.mysql.jdbc.Driver").newInstance();     
				connection = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				System.out.println("ERROR: Connection Failed "+e.getMessage());
			}
			return connection;

	   }
	 

	    public static void closeConnection(Connection con) throws Exception{
	            if(con!=null)
	                 con.close();	           
	    }
	    
	    public static void closeConnectionAll(Connection con, Statement st, ResultSet rs) throws Exception{
            if(con!=null)
                    con.close();
            if(st!=null)
                    st.close();
            if(rs!=null)
                    rs.close();
    }
	}