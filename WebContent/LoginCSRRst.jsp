<%@page import="com.bestshoes.CSR"%>
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
  
</head>
<body>

 <div class="container-fluid">

 <!--  INCLUDE : TOP MENU NAVIGATION  -->
 <jsp:include page="/TopNavCSR.jsp" />
 
 <div class="container">
 <div class="jumbotron">
	 <%
	 //Session  
	 HttpSession sessionCsr = request.getSession();
	 
	 try{
		 
	 	CSR csr = (CSR)sessionCsr.getAttribute("csr"); 
	 %>
	   	
	  		  
    		<h2>Welcome,  <%=csr.getFirstName() %>!</h2>
    		  <button type="button" class="btn btn-default" onClick="location.href='CsrShoeList.jsp';">Go to Product Management</button>
    		  <button type="button" class="btn btn-default" onClick="location.href='CsrOrderList.jsp';">Go to Order Management</button>
		      <button type="button" class="btn btn-default" onClick="location.href='CsrCustList.jsp';">Go to Customer Management</button> 
		    
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

