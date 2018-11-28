package com.bestshoes;

/**
 * Servlet implementation class LoginController
 */
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
 * reference page : Customer.java (bean)
 * Task	: Register for customer  
 *
 * reference db structure:
 * Customers  
	customerNo	int NOT NULL auto_increment primary key,
	customerId	varchar(50) NOT NULL,
    username varchar(30) NOT NULL,
    userpwd	int NOT NULL,
    firstname varchar(30) NOT NULL,
    lastname varchar(30) NOT NULL,
    address varchar(100) NULL,
    city varchar(30) NULL,
    postalCode varchar(10) NULL
 
 *
 */ 

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con;
	PreparedStatement pst; 
	ResultSet rs;
	
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		// forward page 
		String nextPage = "";	 
		
		// variables
		 response.setContentType("text/html");
		 String connectionUrl = "jdbc:mysql://localhost:3306/MVCDB";
		 String connectionUser = "root";
		 String connectionPassword = "mydb1234";
				 
		// get params
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String postalCode = request.getParameter("postalCode");
		
		try {
			
			// 1. validate email address 
			String sql = "";			
	  
	        sql = "select * from Customers where customerId=?";
	         
	        // DB connection
	        Class.forName("com.mysql.jdbc.Driver").newInstance();     
			con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			
	        // resultSet
			pst = con.prepareStatement(sql);
			pst.setString(1,email); 
			rs = pst.executeQuery();
			
			// move to last row to count rows	          
	         rs.last();
	        
	         // 2. register
			if(rs.getRow() == 0) {
	        	
				
				// insert query
	        	String insertQuery = "insert into customers "
 					+ " (customerId, username, userpwd, firstname, lastname, address, city, postalCode) values (?,?,?,?,?,?,?,?)";
	        	 
	         
		 		pst=con.prepareStatement(insertQuery);
		 		
		 		// set
		 		pst.setString(1,email);
		 		pst.setString(2,firstName + " " + lastName);
		 		pst.setString(3,pwd);		 		 
		 		pst.setString(4,firstName);
		 		pst.setString(5,lastName);
		 		pst.setString(6,address);
		 		pst.setString(7,city);
		 		pst.setString(8,postalCode);
		 		
		 		int chk = pst.executeUpdate();
		 		
		 		// print result
		         if(chk == 0) {
		        	 
		        	 request.setAttribute("Msg", "fail");
		        	 nextPage = "/Register.jsp";
		        	 
		         }else {				         
		        	 
	        	 	
	        	 	
	        	 	// customer
	        		Customer customer = new Customer();
	        			
	        		// get information	  		   		        	  
		         	customer.setCustomerId(email);
		  		    customer.setFirstName(firstName);
		  		    customer.setLastName(lastName); 
		  		    customer.setAddress(rs.getString("address"));
		  		    customer.setCity(rs.getString("city"));
		  		    customer.setPostalCode(rs.getString("postalCode"));
		  		    
		  		    // session 
	        	 	HttpSession session = request.getSession();	
					session.setAttribute("userType", "customer");  
					session.setAttribute("customer", customer);
					
					// forward page
					nextPage = "/RegisterRst.jsp";
		         }
		         
		 		
			
			// 2.2 fail to register
	         }else 
	         { 
	        	 
	        	request.setAttribute("Msg", "email");
				nextPage = "/Register.jsp";
					 
	         }
			
		}catch(SQLException e)
	    {
		   e.printStackTrace(); 
	    }
	    catch(Exception e)
	    {
		   e.printStackTrace(); 
	    }
		finally{
			 if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	         if(pst!=null)
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
	         if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}    	
		}
		
		
		// forward to result page
		RequestDispatcher view = request.getRequestDispatcher(nextPage);
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
