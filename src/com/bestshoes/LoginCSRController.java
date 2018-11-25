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
 * created Date : Nov 20, 2018 
 * modified Date : Nov 22, 2018
 * --------------------------------------------- 
 *
 * Task	: Login for CRS  
 *
 *
 */ 


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginCSRController
 */
@WebServlet("/LoginCSRController")
public class LoginCSRController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	Connection con;
	PreparedStatement pst; 
	ResultSet rs;
	
	
	
    public LoginCSRController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		
		// variables
		 response.setContentType("text/html");
		 String connectionUrl = "jdbc:mysql://localhost:3306/MVCDB";
		 String connectionUser = "root";
		 String connectionPassword = "mydb1234";
		 
		// forward page 
			String nextPage = "";
			
		// get params
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		 
		
		try {
			
			// create sql according to login type ( customer or CRS )
			String sql = "";
			sql = "select * from CSR where employeeId=? and userpwd=? ";
	     
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
		        	 
			 	        // CSR
		 	        	CSR csr = new CSR();
		 	   		
			 	        // get information	  		   		        	  
		 	        	csr.setEmployeeId(rs.getString("employeeId"));
		 	        	csr.setFirstName(rs.getString("firstName"));
		 	        	csr.setLastName(rs.getString("lastName")); 
			  		    
			  		    // set session 
						HttpSession session = request.getSession();	
						session.setAttribute("userType", "csr"); 
						session.setAttribute("csr", csr);
						   
						nextPage = "/LoginCSRRst.jsp";
						 
				  
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
