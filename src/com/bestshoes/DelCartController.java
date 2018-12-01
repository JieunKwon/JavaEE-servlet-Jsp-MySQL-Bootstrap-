package com.bestshoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyCartController
 */
/**
 * --------------------------------------------- 
 * @author JIEUN KWON (991447941)
 *	
 * TASK : Assignment 3 
 * MVC Modeling - Shoe Product Ordering System
 * 
 * created Date : Nov 27, 2018 
 * modified Date : Nov 27, 2018
 * --------------------------------------------- 
 *
 * Page Task	: Show cart list to place order ->
 *				  delete one item data from cart 
 *				 
 *   
 *
 */ 

@WebServlet("/DelCartController")
public class DelCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelCartController() {
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

		
		// objcustomerId
		CartDAO cartDao = new CartDAO();
		  
		// call method to delete item from cart
		try {
			// itemId 
			int itemId = Integer.parseInt(request.getParameter("itemId"));
			
			cartDao.delRow(itemId, customer.getCustomerId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

		// Dispatcher - forward to result page
		getServletContext().getRequestDispatcher("/MyCartController").forward(request, response);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
