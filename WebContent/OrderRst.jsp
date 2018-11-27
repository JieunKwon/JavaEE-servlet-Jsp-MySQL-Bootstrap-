<%@page import="com.bestshoes.Customer"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
 <jsp:include page="/TopNav.jsp" />
 
 <div class="container">
 <div class="jumbotron">
	 <%
	 //Session  
	 HttpSession sessionCustomer = request.getSession();
	 
	 try{
		 
	 	Customer customer = (Customer)sessionCustomer.getAttribute("customer"); 
	 %>
	   	
	  		 
    		 
    		<h2>Welcome,  <%=customer.getFirstName() %>!</h2>
    		
    		Thanks for signing up to BEST SHOES. 
		      
		      <button type="button" class="btn btn-default" onClick="location.href='ShoeList.jsp';">Go shopping</button>
		      <button type="button" class="btn btn-default" onClick="location.href='MyPage.jsp';">Go to My Page</button> 
		   
	   
	  
	 <%
	 	
	 }
	 catch(Exception e)
	 {
	%>
		
		The username or password you entered is incorrect.
		
	<%	 
	 }
	 %>
 

   </div> 
 </div>
 
</div> 
</body>
</html>

