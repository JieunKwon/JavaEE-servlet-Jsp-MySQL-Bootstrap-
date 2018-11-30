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
<style>
body { padding-top: 70px; }
.itemTitle{ color:#4C4C4C; size:14px }
</style>  
  <script>
  
  // move form to change order status
  function modifyOrder(orderId, orderStatus)
  {
 
	  var form = document.cartForm;
	  
	  form.orderId.value = orderId; 
	  form.orderStatus.value= orderStatus;
	  form.mode.value = "status";
	  form.submit(); 
 
		  
  }

  // move form with mode; add quantity / cancel order 
  function changeOrder(orderId, quantity, mode)
  {
 
	  var form = document.cartForm;
	  
	  form.orderId.value = orderId; 
	  form.quantity.value= quantity;
	  form.mode.value = mode;
	  form.submit(); 
 
		  
  }
  
  // move form to delete order
  function delOrder(orderId)
  {
 
	  var form = document.cartForm;
	  form.orderId.value = orderId;
	  form.mode.value = "del";
	  form.submit(); 
 
		  
  }
  
  </script>
  
</head>
<body>
 <div class="container-fluid">
 
  <!--  INCLUDE : TOP MENU NAVIGATION  -->
 <jsp:include page="/TopNavCSR.jsp" />
 
 <div class="container">
 
  <h1>Orders</h1> <br>
 
  <!--  Order List Check-->

	<c:choose>
		<c:when test="${!empty ordersList }"> 

		<!-- /////////////    Order List Start  : forEach  /////////////// -->
		 
			<c:set var="total" value="${0}"/>
		
			<table class="table">
			    <thead>
			      <tr class="active">
			        <th>No</th>
			        <th>Item Name</th>
			        <th>Customer</th>
			     <!--    <th>Size</th> -->
			        <th>Qty</th>
			        <th>Price</th>
			        <th>Status</th>
			        <th>Management</th>
			      </tr>
			    </thead>
			    <tbody>

  	
			<c:forEach var="orders" items="${requestScope.ordersList}" begin="0" step="1" varStatus="status">
				
				<!-- total price for all items -->
				<c:set var="total" value="${total + orders.price}" />
			   
				  	<c:if test = "${status.end == 0}">
				  	No List
				  	</c:if>
				 
				 	  <tr>
				        <td>${status.count} &nbsp;</td>
				        <td>${orders.itemName}</td>
				        <td>${orders.customerId}</td>
				    <!--   <td></td>  -->  
				        <td>${orders.quantity} 
				        	<c:if test="${orders.quantity > 1}">
				        	<button type="button" class="btn btn-primary btn-xs" onClick="javascript:changeOrder('${orders.orderId}','${orders.quantity-1}', 'down');"> - </button>
					  	    </c:if>
					  	    <button type="button" class="btn btn-primary btn-xs" onClick="javascript:changeOrder('${orders.orderId}','${orders.quantity+1}', 'add');"> + </button>
					  	</td>
				        <td>$${orders.price}</td>
				        <td>${orders.orderStatus}</td>
				        <td class="active"> 
					        <button type="button" class="btn btn-info btn-sm" onClick="javascript:modifyOrder('${orders.orderId}', 'In-Process');">In-Process</button>
					  		<button type="button" class="btn btn-warning btn-sm" onClick="javascript:modifyOrder('${orders.orderId}', 'Delivered');">Delivered</button>
					  		<button type="button" class="btn btn-danger btn-sm" onClick="javascript:delOrder('${orders.orderId}');">delete</button>
					    </td>
				      </tr>    
				       
				 
			</c:forEach>
			<!-- /////////////   End  : forEach  /////////////// -->	
			 </tbody>
		</table>
			
	</c:when>
		 
		<c:otherwise>
			<h3>  No Items </h3><br>
		</c:otherwise>
	</c:choose>
	
 </ul> 
  
  </div>
  
           <!-- form to edit and delete --> 
		<form action="CsrOrderListController" method="post" name="cartForm"> 
		 	<input type="hidden" value="" name="orderId">
		 	<input type="hidden" value="" name="mode">
		 	<input type="hidden" value="" name="quantity"> 
		 	<input type="hidden" value="" name="orderStatus"> 
		</form> 
		
		
</div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>