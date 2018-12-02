package com.bestshoes;

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
 * Servlet implementation class LoginController
 */
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
 * Page Task	: Login for customer 
 * 
 *
 */ 

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Connection con;
	PreparedStatement pst; 
	ResultSet rs;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String userType = request.getParameter("userType");
		
		try {
			
			// create sql according to login type ( customer or CRS )
			String sql = "";
			
	        if(userType.equals("user")) {
	        	sql = "select * from Customers where customerId=? and userpwd=? ";
	        	
	        }else if(userType.equals("csr")) {
	        	sql = "select * from CSR where employeeId=? and userpwd=? ";
	        }
	            
	        // DB connection
	        Class.forName("com.mysql.jdbc.Driver").newInstance();     
			con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			
	        // resultSet
			pst = con.prepareStatement(sql);
			pst.setString(1,email);
			pst.setString(2,pwd);
			rs = pst.executeQuery();
			
			// move to last row to count rows	          
	         rs.last();
	         
			if(rs.getRow() == 0) {
	        	
				// fail to login
	        	request.setAttribute("loginMsg", "fail");
				nextPage = "/Login.jsp";
	        	
	         }else { 
	        	 
	        	// move to first row
	        	 rs.beforeFirst();	
	        	 
		         // get result
		         while(rs.next())
		  		 { 
	        		// customer
	        		Customer customer = new Customer();
	        			
	        		// get information	  		   		        	  
		         	customer.setCustomerId(rs.getString("customerId"));
		         	customer.setUserName(rs.getString("userName"));
		  		    customer.setFirstName(rs.getString("firstName"));
		  		    customer.setLastName(rs.getString("lastName")); 
		  		    customer.setAddress(rs.getString("address"));
		  		    customer.setCity(rs.getString("city"));
		  		    customer.setPostalCode(rs.getString("postalCode"));
		  		
		  		    // set session 
					HttpSession session = request.getSession();	
					session.setAttribute("userType", "customer");  
					session.setAttribute("customer", customer);
					session.setMaxInactiveInterval(120*60); // for customer give 120 minutes 
					 
					nextPage = "/LoginRst.jsp";
				 
					  
		  		 }
	  		 
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
