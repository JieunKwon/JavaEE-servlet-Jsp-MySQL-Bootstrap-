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
 * Servlet implementation class MyPageController
 */
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
* Page Task :  Customer - My Page
* 				1. show orders list 
* 				2. add quantity
* 				3. cancel order  
* 				
* Reference DB :  Shoes 
* 
*/

@WebServlet("/MyPageController")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageController() {
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
		
		// OrdersDAO obj
		OrdersDAO order= new OrdersDAO();	
		 
		if(customer==null ){
			// Dispatcher - forward to result page
			getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
		// params 
		String mode = request.getParameter("mode");
		 
		// delete item or add quantity
		if(mode != null && !mode.isEmpty()) {
			 
			//String orderId = request.getParameter(orderId);
			int orderId = Integer.parseInt(request.getParameter("orderId"));
			
			
			// delete ordered item
			if(mode.equals("del")) { 
				 
				try {
					order.delRow(orderId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			// update quantity (+ 1 )
			}else if(mode.equals("add")) {
			 
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				
				try {
					order.addQty(orderId, quantity);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			// update quantity (- 1)
			}else if(mode.equals("down")) {
			 
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				
				try {
					order.downQty(orderId, quantity);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		
		//////////////////////////
		// make orders Arraylist information 
		
		 ArrayList<Orders> ordersList = new  ArrayList<Orders>();
		 
		try {
			ordersList = order.listOrders(customer.getCustomerId());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//////////////////////////
		// set attribute  
        request.setAttribute("ordersList", ordersList);
		
		
		//////////////////////////
		// Dispatcher - forward to result page
		getServletContext().getRequestDispatcher("/MyPage.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
