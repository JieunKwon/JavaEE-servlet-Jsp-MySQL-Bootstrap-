package com.bestshoes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cartController
 */
@WebServlet("/cartController")
public class cartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		 
		// param vars 
		String category = request.getParameter("category");
		String customerId = request.getParameter("customerId");
		String itemId = request.getParameter("itemId");
	 
		
		// search items
		ShoesDAO shoesDao = new ShoesDAO();
		Shoes shoe = new Shoes();
		try {
			shoe = shoesDao.searchShoes(itemId);
			 
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		// add to cart
		
		CartDAO cartDao = new CartDAO();
		try {
			cartDao.addRow(shoe.getItemId(), customerId, 1, shoe.getPrice());
			 
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		// set attribute
		request.setAttribute("category", category);
      
	 
		// Dispatcher - forward to result page
		getServletContext().getRequestDispatcher("/ShoeListController?category="+category).forward(request, response);
								
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
