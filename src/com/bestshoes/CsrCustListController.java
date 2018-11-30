package com.bestshoes;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		 
		// delete item or add quantity
/*		if(mode != null && !mode.isEmpty()) {
			 
			// customer id 
			String customerId = request.getParameter("orderId");
			 
			// delete customer
			if(mode.equals("del")) { 
				 
				try {
					custDao.delRow(customerId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 
			// change order status	
			}else if(mode.equals("status")) {
				
				String orderStatus = request.getParameter("orderStatus");
				
				try {
					custDao.updateStatus(orderId, orderStatus);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}


		}
	*/	
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
		// Dispatcher - forward to result page
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
