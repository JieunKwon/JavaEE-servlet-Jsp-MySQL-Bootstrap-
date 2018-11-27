package com.bestshoes;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckoutController
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
 * Page Task	: check out from cart
 *				  1. move to order db
 *				  2. make cart empty
 *				  3. forward to result of order
 */ 

@WebServlet("/CheckoutController")
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("ok - checkout");
		
		HttpSession sessionCustomer = request.getSession();
		Customer customer = (Customer)sessionCustomer.getAttribute("customer"); 
		
		if(customer==null ){
			// Dispatcher - forward to result page
			getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
		//////////////////////////
		// 1. move to order 
		
		OrdersDAO ordersDao = new OrdersDAO();	//obj
		try {
			ordersDao.oderAllItems(customer.getCustomerId());
			
			System.out.println("ok - dbo");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//////////////////////////
		// 2. make cart empty 
		
		CartDAO cartDao = new CartDAO();	//obj
		try {
			cartDao.delAllRows(customer.getCustomerId());
			
			System.out.println("ok - delete cart");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//////////////////////////
		// 3. personal information 
	//	CustomersDAO cuts = new CustomersDAO();	//obj
	//	Customer customerIn = cuts.searchCustomer(customerId);
		
		
		//////////////////////////
		// 4. orders Arraylist information 
		 OrdersDAO order= new OrdersDAO();	//obj
		 ArrayList<Orders> ordersList = new  ArrayList<Orders>();
		 
		try {
			ordersList = order.listOrders(customer.getCustomerId());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//////////////////////////
		// 5. set attribute  
        request.setAttribute("ordersList", ordersList);
		
		
		//////////////////////////
		// 6. Dispatcher - forward to result page
		getServletContext().getRequestDispatcher("/OrderRst.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
