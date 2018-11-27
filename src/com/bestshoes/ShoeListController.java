package com.bestshoes;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ShoeListController
 */

/**
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
 * Page Task	: Show Shoes' list 
 *				  select data (call ShoesDAO obj)-> set attribute for shoes Arraylist -> forward to ShoeList.jsp
 *
 * references db structure : 
 	 -- Shoes --
	itemId int NOT NULL auto_increment primary key,
    itemName varchar(50) NOT NULL,
    category varchar(10) NOT NULL,
    shoesize varchar(5) NOT NULL,
	quantity int NOT NULL,
    price	decimal(7,2) NOT NULL 
    
 *
 */ 
@WebServlet("/ShoeListController")
public class ShoeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoeListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// category for menu 
		String category = request.getParameter("category");
		 
		
		// Object for DB tasks
		ShoesDAO shoesDao = new ShoesDAO();
		
		// Arraylist for shoes' list
		ArrayList<Shoes> shoesList = new ArrayList<Shoes>();
		
		try {
			
			// call method for list
			shoesList = shoesDao.listShoes(category);
			
			// set attribute
			request.setAttribute("category", category);
	        request.setAttribute("shoesList", shoesList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		// Dispatcher - forward to result page
		getServletContext().getRequestDispatcher("/ShoeList.jsp").forward(request, response);
					
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
