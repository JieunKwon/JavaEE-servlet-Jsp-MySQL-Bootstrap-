<%@page import="com.bestshoes.Customer"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%--
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
  
 * Task	: index page  - forward page
 *
 *
 */ 
 --%>

	 <%
	 //Session check
	 HttpSession session2 = request.getSession();
	  
	 synchronized(session2) {
   	  
         String userType = (String)session2.getAttribute("userType");
         
         
         if (session.getAttribute("customer") == null && session.getAttribute("csr") == null) {
        
     %>

     		<jsp:forward page="Login.jsp" />
     <%	
         } else {
        	 
        	 
        	 //System.out.print(userType);
        	 
        	 if(userType.equals("csr")){
        		  
        		 %>
        		 		 <jsp:forward page="LoginCSRRst.jsp" />
        		 <%		 
        	 }else if(userType.equals("customer")){
       		  
       		 %>
       		 		 	<jsp:forward page="LoginRst.jsp" />
       		 <%		 
       	 	} 	 
            
         } 
         
      }
	  
	 %>
 

 