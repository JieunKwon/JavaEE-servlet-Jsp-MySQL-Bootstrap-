package com.bestshoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterModiController
 */
@WebServlet("/RegisterModiController")
public class RegisterModiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterModiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession sessionCustomer = request.getSession();
		Customer customer = (Customer)sessionCustomer.getAttribute("customer"); 
		
		if(customer==null ){
			// Dispatcher - forward to result page
			getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
		//params
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String postalCode = request.getParameter("postalCode");
		
		//////////////////////////
		// update information 
		
		 CustomersDAO customers= new CustomersDAO();	//obj
		  
		try {
			customers.updateRow(customer.getCustomerId(), address, city, postalCode); 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//////////////////////////
		// update session  
 	   
	    customer.setAddress(address);
	    customer.setCity(city);
	    customer.setPostalCode(postalCode);
	    
	    sessionCustomer.setAttribute("customer", customer);
	    sessionCustomer.setMaxInactiveInterval(120*60); // for customer give 120 minutes 
		
		
		//////////////////////////
		// Dispatcher - forward to result page
		getServletContext().getRequestDispatcher("/MyPageController").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
