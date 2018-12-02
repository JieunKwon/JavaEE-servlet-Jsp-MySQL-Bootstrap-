<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
 * --------------------------------------------- 
 * @author JIEUN KWON (991447941)
 *	
 * TASK : Assignment 3 
 * MVC Modeling - Shoe Product Ordering System
 * 
 * created Date : Nov 26, 2018 
 * modified Date : Nov 26, 2018
 * --------------------------------------------- 
 *
 * Page Task :   My Cart for customer   
 *  
 * 
 *
 --%>
<!DOCTYPE html>
<html>
<head>
  <title> BEST SHOES </title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
body { padding-top: 70px; }
.itemTitle{ color:#4C4C4C; size:14px }
</style>  
   
  <script>
  
  // delete items from cart
  function delCart(itemId)
  {
 
	  document.cartForm.itemId.value = itemId; 
	  document.cartForm.action = "DelCartController";
	  document.cartForm.submit(); 
 
		  
  }
 
  // submit form to checkout
  function checkOut()
  {
	   
	  document.cartForm.submit();  
	  
  }
  </script>
  
</head>
<body>

 <div class="container-fluid">

 <!--  INCLUDE : TOP MENU NAVIGATION  -->
 <jsp:include page="/TopNav.jsp" />
 
 <div class="container">
 <div class="jumbotron">
 
<!--  Menu title  -->
 	 
<h1> <span class="label label-default">My Cart</span></h1><br>
 
 <ul class="list-group">

<!--  No List Check-->

	<c:choose>
		<c:when test="${!empty cartList }">
		
		
			<!-- /////////////    Cart List Start  : forEach  /////////////// -->
 
			<c:set var="total" value="${0}"/>
			
			<c:forEach var="cart" items="${requestScope.cartList}" begin="0" step="1" varStatus="status">
				<!-- total price for all items -->
				<c:set var="total" value="${total + cart.price}" />
			  
			  <li class="list-group-item">
			  	 
			  	<c:if test = "${status.end == 0}">
			  	Your cart is empty
			  	</c:if>
			 
			 	<table>
			  		<tr>
			  			<td width="100px">${status.count} &nbsp;
			  				<img src="images/shoe${cart.itemId}.jpg" width="50px" class="img-thumbnail" alt="Cinque Terre">&nbsp;&nbsp; 
			  			</td> 
			  			<td width="800px" class="itemTitle"><h3>${cart.itemName}</h3></td>
			  			<td align="right" width="100px"> size: ${cart.shoesize}</td>
			  			<td align="right" width="50px"> * ${cart.quantity}</td>
			  			<td align="right" width="100px"> <b><fmt:formatNumber value="${cart.price }" type="currency" /></b></td>
			  			<td align="right" width="50px"><a href="javascript:delCart('${cart.itemId}');"><img src="images/delete.jpg" width="30px"></a></td>
			  		</tr>
			  	</table>
		 
			  </li> 
				 
			</c:forEach>
	
			<li class="list-group-item">
				<table >
			  		<tr>
			  			 
			  			<td align="right" width="800px" align="right">  <h3> Total Items : <fmt:formatNumber value="${total }" type="currency" /></h3> </td> 
			  			<td align="right" width="200px"><button type="submit" class="btn btn-primary active" onclick="javascript:location.href='CheckoutController'">Check out</button></td>
			  		</tr>
			  	</table> 	    
			</li>
			<!-- /////////////   End  : forEach  /////////////// -->
			
	</c:when>
		
		<c:otherwise>
			<h3>  No Items </h3><br>
		</c:otherwise>
	</c:choose>
	
 </ul> 

   </div> 
 </div>
  
         <!-- form for cart --> 
		<form action="DelCartController" method="post" name="cartForm"> 
		 	<input type="hidden" value="" name="itemId">
		 	<input type="hidden" value="${sessionScope.customer.customerId }" name="customerId">
		 </form> 
         
</div> 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>

