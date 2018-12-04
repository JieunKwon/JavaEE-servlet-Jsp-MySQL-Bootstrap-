package com.bestshoes;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CsrOrderListController
 */
/*
* --------------------------------------------- 
* @author JIEUN KWON (991447941)
*	
* TASK : Assignment 3 
* MVC Modeling - Shoe Product Ordering System
* 
* created Date : Nov 28, 2018 
* modified Date : Nov 28, 2018
* --------------------------------------------- 
*
* Page Task :  CSR - Order management
* 				1. show orders list 
* 				2. update orderStatus
* 				3. cancel order  
* 				
* Reference DB :  Shoes 
* 
*/
@WebServlet("/CsrOrderListController")
public class CsrOrderListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CsrOrderListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// OrdersDAO obj
		OrdersDAO order= new OrdersDAO();	
		 
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
				
			// update quantity
			}else if(mode.equals("add")) {
			 
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				
				try {
					order.addQty(orderId, quantity);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			// decrease quantity
			}else if(mode.equals("down")) {
			 
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				
				try {
					order.downQty(orderId, quantity);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			// change order status	
			}else if(mode.equals("status")) {
				
				String orderStatus = request.getParameter("orderStatus");
				
				
				try {
					order.updateStatus(orderId, orderStatus);
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
			ordersList = order.listAllOrders();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//////////////////////////
		// set attribute  
        request.setAttribute("ordersList", ordersList);
		
		
		//////////////////////////
		// Dispatcher - forward to result page
		getServletContext().getRequestDispatcher("/CsrOrderList.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
