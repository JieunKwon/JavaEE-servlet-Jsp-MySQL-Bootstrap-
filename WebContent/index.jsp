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
  
 * Task	: index page  
 *
 *
 */ 

 --%>

<!DOCTYPE html>
<html>
<head>
  <title> BEST SHOES </title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body { padding-top: 70px; }
</style>  
</head>
<body>

 <div class="container-fluid">

 <!--  INCLUDE : TOP MENU NAVIGATION  -->
  
	 <%
	 //Session check
	 HttpSession session2 = request.getSession();
	  
	 synchronized(session2) {
   	  
         String userType = (String)session2.getAttribute("userType");
         
         if (userType == null) {
        	 System.out.print("null");
     %>

     		<jsp:include page="TopNavLogin.jsp" />
     <%	
         } else {
        	 
        	 
        	 System.out.print(userType);
        	 
        	 if(userType.equals("csr")){
        		  
        		 %>
        		 		 <jsp:include page="TopNavCSR.jsp" />
        		 <%		 
        	 }else if(userType.equals("customer")){
       		  
       		 %>
       		 		 <jsp:include page="TopNav.jsp" />
       		 <%		 
       	 	} 	 
            
         } 
         
      }
	  
	 %>
	   	 
		 <div class = "container">
		 <div class="jumbotron">  		 
		    		 
		    		
    		
		      <button type="button" class="btn btn-default" onClick="location.href='ShoeList.jsp';">Go to shop</button>
		      <button type="button" class="btn btn-default" onClick="location.href='MyPage.jsp';">Go to My Page</button> 
		   
	   
	  
	 

	   </div> 
	   </div>
	 
</div> 
 
</body>
</html>

 