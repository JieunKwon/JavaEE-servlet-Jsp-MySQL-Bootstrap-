package com.bestshoes;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
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
* Page Task :  CSR page -  Customers List Controller 
* 				1. show Customer list 
* 				2. delete Customer
* 				3. edit Customer  
* 				
* Reference DB :  Customers 
* 
*/
/**
 * Servlet implementation class CsrCustListController
 */
@WebServlet("/CsrCustListController")
public class CsrCustListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CsrCustListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// CustomersDAO obj
		CustomersDAO custDao= new CustomersDAO();	
		 
		// params 
		String mode = request.getParameter("mode");
		 
		// delete or edit info
		if(mode != null && !mode.isEmpty()) {
			 
			// customer id 
			String customerId = request.getParameter("customerId");
			 
			// delete customer
			if(mode.equals("del")) { 
				 
				try {
					custDao.delRow(customerId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 
			// search customer's info 	
			}else if(mode.equals("search")) {
				 
				try {
					
					
					Customer customer = custDao.searchCustomer(customerId);
					
					System.out.println(customerId);
					//////////////////////////
					// set attribute  
			        request.setAttribute("customer", customer);
					
					//////////////////////////
					// Dispatcher - forward to modification page
					getServletContext().getRequestDispatcher("/CsrCustModi.jsp").forward(request, response);
						 
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				
			// change order status	
			}else if(mode.equals("edit")) {
				
				// get params
			
				String pwd = request.getParameter("pwd");
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String address = request.getParameter("address");
				String city = request.getParameter("city");
				String postalCode = request.getParameter("postalCode");
				
				//System.out.println(customerId+pwd+ firstName+lastName+address+city+postalCode);
				 
				try {
					
					custDao.updateRow(customerId, pwd, firstName, lastName, address, city, postalCode);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}


		}
		
		//////////////////////////
		// make orders Arraylist information 
		
		 ArrayList<Customer> customerList = new ArrayList<Customer>();
		 
		try {
			customerList = custDao.searchAllCustomer();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//////////////////////////
		// set attribute  
        request.setAttribute("customerList", customerList);
		
		
		//////////////////////////
		// Dispatcher - forward to list page
		getServletContext().getRequestDispatcher("/CsrCustList.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
