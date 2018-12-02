<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
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
 * Page Task :  Customers Register Form to edit their personal info 
 * 
 * Reference :  TABLE Customers  
 * 
 *
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
.itemTitle{ color:#4C4C4C; size:14px }
</style>  
 
</head>
<body>

<div class="container-fluid">
 
 <!--  INCLUDE : TOP MENU NAVIGATION  -->
 <jsp:include page="/TopNav.jsp" />
 
 <div class="container"> 
 
	<c:choose>
		<c:when test="${empty sessionScope.customer.customerId }"> 
		
			<jsp:forward page="Login.jsp" />
		</c:when>
		<c:otherwise> 
			<!--  Login Form  --> 
			  <h2>${sessionScope.customer.userName} </h2>
		 
				<br> 
		    
			  <form class="form-inline"  method="post" name="RegistForm" action="RegisterModiController" >
			    <div class="form-group">
			      <label for="focusedInput">Your Email Account : ${sessionScope.customer.customerId} </label><br><br>
		 
			   </div>  
			   <br> 
			 	<div class="form-group">
			      <label for="focusedInput">Address : </label><br>
			      <input class="form-control" type="text" id="address" size="100" value="${sessionScope.customer.address }" name="address">
			   </div>
			   <br> 
			   <div class="form-group">
			      <label for="focusedInput">City : </label><br>
			      <input class="form-control" type="text" id="city" size="50" value="${sessionScope.customer.city }" name="city">
			   </div>
			   <br> 
			   <div class="form-group">
			      <label for="focusedInput">Postal Code : </label><br>
			      <input class="form-control" type="text" id="postalCode" size="10" value="${sessionScope.customer.postalCode }" name="postalCode">
			   </div>
			   <br> 
			   
			   <br><br>
			    <button type="submit" class="btn btn-primary active" >Submit</button>
			  </form>
			   
		</c:otherwise>
	</c:choose> 
	</div> 
	</div> 
</body>
</html>

