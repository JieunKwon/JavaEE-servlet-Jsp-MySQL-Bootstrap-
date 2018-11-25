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
 * Page : Customer.java (bean)
 * Task	: Login for customer and CRS  
 *
 Customers  
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
		        	
		        	 System.out.println(email);
		        	 
		        	 if(userType.equals("user")) {
		        		 
		        		// customer
		        		Customer customer = new Customer();
		        			
		        		// get information	  		   		        	  
			         	customer.setCustomerId(rs.getString("customerId"));
			  		    customer.setFirstName(rs.getString("firstName"));
			  		    customer.setLastName(rs.getString("lastName")); 
			  		    
			  		    // set session 
						HttpSession session = request.getSession();	
						session.setAttribute("user", "customer"); 
						session.setAttribute("customer", customer);
						 
		 	        	
		 	        }else if(userType.equals("csr")) {
		 	        	
		 	        	 System.out.println("crs ------");
		 	        	 
			 	        // CSR
		 	        	CSR csr = new CSR();
		 	   		
			 	        // get information	  		   		        	  
		 	        	csr.setEmployeeId(rs.getString("employeeId"));
		 	        	csr.setFirstName(rs.getString("firstName"));
		 	        	csr.setLastName(rs.getString("lastName")); 
			  		    
			  		    // set session 
						HttpSession session = request.getSession();	
						session.setAttribute("user", "csr"); 
						session.setAttribute("csr", csr);
						  
		 	        }
		        	 
		        	
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
		//RequestDispatcher view = request.getRequestDispatcher(nextPage);
		//view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
