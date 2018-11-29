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
 * created Date : Nov 27, 2018 
 * modified Date : Nov 27, 2018
 * --------------------------------------------- 
 *
 * Page Task :  CSR - Order management
 * 				1. show orders list  
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
 <jsp:include page="/TopNavCSR.jsp" />
 
 <div class="container">
 
  <h1>Orders</h1> <br>
  
  <table class="table">
    <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>Default</td>
        <td>Defaultson</td>
        <td>def@somemail.com</td>
      </tr>    
      <tr class="active">
        <td>Active</td>
        <td>Activeson</td>
        <td>act@example.com</td>
      </tr>
    </tbody>
  </table>
  
  
  <!--  Order List Check-->

	<c:choose>
		<c:when test="${!empty ordersList }"> 

		<!-- /////////////    Order List Start  : forEach  /////////////// -->
		 
			<c:set var="total" value="${0}"/>
			
			<c:forEach var="orders" items="${requestScope.ordersList}" begin="0" step="1" varStatus="status">
				
				<!-- total price for all items -->
				<c:set var="total" value="${total + orders.price}" />
			  
				  <li class="list-group-item">
				  	 
				  	<c:if test = "${status.end == 0}">
				  	No List
				  	</c:if>
				 
				 	<table border=0>
				  		<tr>
				  			<td width="100px">${status.count} &nbsp;
				  				<img src="images/shoe${orders.itemId}.jpg" width="50px" class="img-thumbnail" alt="Cinque Terre">&nbsp;&nbsp;
				  		 
				  			</td> 
				  			<td width="500px" class="itemTitle"><h3>${orders.itemName}</h3></td>
				  			<td align="right" width="100px"> <b>$${orders.price}</b></td>
				  			<td align="right" width="100px"> * ${orders.quantity} 
				  				<c:if test="${orders.orderStatus=='Order Placed' }"> 
				  				<button type="button" class="btn btn-warning" onClick="javascript:modifyOrder('${orders.orderId}',  ${orders.quantity+1});"> +1 </button>
				  				</c:if>
				  			</td>
				  			
				  			<td align="right" width="200px"> <font color="red"> ${orders.orderStatus}</font> 
				  				<c:if test="${orders.orderStatus=='Order Placed' }"> 
				  				<button type="button" class="btn btn-danger" onClick="javascript:delOrder('${orders.orderId}');">cancel</button>
				  				</c:if>
				  			</td>
				  		</tr>
				  	</table>
			 
				  </li> 
				 
			</c:forEach>
			<!-- /////////////   End  : forEach  /////////////// -->	
			
			<!--  total amount -->
			<li class="list-group-item">
				<table border=0>
			  		<tr> 
			  			<td align="right" width="800px" align="right">  <h3> Total Items : $${total}</h3> </td> 
			  			<td align="right" width="200px">
			  			 
			  			</td>
			  		</tr>
			  	</table> 
			</li> 
			
	</c:when>
		 
		<c:otherwise>
			<h3>  No Items </h3><br>
		</c:otherwise>
	</c:choose>
	
 </ul> 
  
  </div>
</div>
</body>
</html>