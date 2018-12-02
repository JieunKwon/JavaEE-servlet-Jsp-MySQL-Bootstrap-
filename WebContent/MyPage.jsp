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
 * created Date : Nov 27, 2018 
 * modified Date : Nov 27, 2018
 * --------------------------------------------- 
 *
 * Page Task :   My page for customer   
 *  			1. show personal information to edit
 				2. show ordered status
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
   
  <script>
  
  // move form to add quantity
  function modifyOrder(orderId, quantity, mode)
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
 <jsp:include page="/TopNav.jsp" />
 
 <div class="container">
 <div class="jumbotron">
 
<!--  Menu title  -->
 <h1>${sessionScope.customer.userName}</h1> <br>
<h2> <span class="label label-default">My Order</span></h2><br>
 
 
 <ul class="list-group">
  
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
				  			<td width="500px" class="itemTitle"><h3>${orders.itemName}</h3> (size: ${orders.shoesize})</td>
				  			<td align="right" width="100px"> <b><fmt:formatNumber value="${orders.price }" type="currency" /></b></td>
				  			<td align="right" width="50px"> * ${orders.quantity} </td>
				  			<td align="right" width="100px">
				  				<c:if test="${orders.quantity > 1 && orders.orderStatus=='Order Placed'}">
					        		<button type="button" class="btn btn-warning" onClick="javascript:modifyOrder('${orders.orderId}','${orders.quantity-1}', 'down');"> -1 </button>
						  	    </c:if>
							  	    
				  				<c:if test="${orders.orderStatus=='Order Placed' }"> 
				  					<button type="button" class="btn btn-warning" onClick="javascript:modifyOrder('${orders.orderId}', '${orders.quantity+1}', 'add');"> +1 </button>
				  				</c:if>
				  			</td> 
				  			<td align="right" width="100px"> <font color="red"> ${orders.orderStatus}</font> </td>
				  			<td align="right" width="100px">
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
				<table>
			  		<tr> 
			  			<td align="right" width="800px" align="right">   
			  			<h3> Total Items :
			  			<fmt:formatNumber value="${total }" type="currency" />
			  			</h3> </td> 
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


<!-- Customer's delivery address information  -->

<h2> <span class="label label-default">My Address</span></h2><br>
 
 <ul class="list-group">
	<li class="list-group-item">
		 
	  	<b>Shipping Address :</b>  
	  	
	  	${sessionScope.customer.address}	 
	  	
	  	<br> 
		<b>City :</b>  

		 ${sessionScope.customer.city}	<br>
		 
		 <b>Postal Code :</b>  
		 
	  	 ${sessionScope.customer.postalCode} <br><br>
	  	 	 
	  	 <button type="button" class="btn btn-default" onclick="javascript:location.href='RegisterModi.jsp'">Modify Information</button>
	  	  
	  		 
	</li>
</ul> 

   </div> 
 </div>
 
 
         <!-- form to edit and delete --> 
		<form action="MyPageController" method="post" name="cartForm"> 
		 	<input type="hidden" value="" name="orderId">
		 	<input type="hidden" value="" name="mode">
		 	<input type="hidden" value="" name="quantity"> 
		</form> 
        
  
</div> 
</body>
</html>