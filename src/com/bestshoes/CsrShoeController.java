package com.bestshoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CsrShoeController
 */
@WebServlet("/CsrShoeController")
public class CsrShoeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CsrShoeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		// Object for DB tasks
		ShoesDAO shoesDao = new ShoesDAO();
  
		try {
			
			// mode param for tasks 
			String mode = request.getParameter("mode");
			System.out.println(mode + "/from cont");
			
			// params
			int itemId = 0;
			String itemName = "";
			String category = "";
			String shoesize = "";
			String content = "";
			int quantity = 0;
			Double price = 0.0;
		
			// new shoes information
			if(mode.equals("new")) {
				
				 itemName = request.getParameter("itemName");
				 category = request.getParameter("category");
				 shoesize = request.getParameter("shoesize");
				 content = request.getParameter("content");
				 quantity = Integer.parseInt(request.getParameter("quantity"));
				 price = Double.parseDouble(request.getParameter("price"));
			
				
				// call method to insert data
				shoesDao.addRow( itemName, category, shoesize, quantity, price, content);
				
				// redirect page to form page
				response.sendRedirect("CsrShoeForm.jsp");
			
			// delete data
			}else if(mode.equals("del")) {
				
				itemId = Integer.parseInt(request.getParameter("itemId"));
				category = request.getParameter("category");
				
				// call method to delete data
				shoesDao.delRow(itemId);
				
				// forward page to shoes list
				request.setAttribute(category, "category");
				getServletContext().getRequestDispatcher("/CsrShoeListController").forward(request, response);
			
			// update data
			}else if(mode.equals("edit")) {
				
				 itemId = Integer.parseInt(request.getParameter("itemId"));
				 itemName = request.getParameter("itemName");
				 category = request.getParameter("category");
				 shoesize = request.getParameter("shoesize");
				 content = request.getParameter("content");
				 quantity = Integer.parseInt(request.getParameter("quantity"));
				 price = Double.parseDouble(request.getParameter("price"));
				 
				// call method to update data
				shoesDao.updateRow( itemId, itemName, category, shoesize, quantity, price, content);
				
				// forward page to shoes list
				request.setAttribute(category, "category");
				getServletContext().getRequestDispatcher("/CsrShoeListController").forward(request, response);
			
			// to search data for edit-page 
			}else if(mode.equals("search")) {
				
				itemId = Integer.parseInt(request.getParameter("itemId"));
				
				// call method to update data
				Shoes shoe = shoesDao.searchShoes(itemId);
				
				// forward page to shoes list 
				request.setAttribute("mode", "edit");   //  should be changed to edit mode
				request.setAttribute("shoes", shoe);
				getServletContext().getRequestDispatcher("/CsrShoeForm.jsp").forward(request, response);
				
			}	 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
