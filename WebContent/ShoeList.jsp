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
 * modified Date : Nov 26, 2018
 * --------------------------------------------- 
 *
 * Page Task :   shoes List   
 * 
 * Reference DB :  Shoes 
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
  
  // show modal window to confirm to add shoes to their cart
  function addCart(itemId,itemName)
  {
	  document.getElementById('modal_item_title').innerHTML = itemName;
	  
	  document.cartForm.itemId.value = itemId;
	  
	  $('#myModal').modal('show'); 
	  return;
	 	  
  }
  
  // close modal and then form submit
  function submitCart()
  {
	  
	  $('#myModal').modal('toggle'); 
	  document.cartForm.submit(); 
	 
  }
  
  $('#myModal').on('shown.bs.modal', function () {
	  $('#myInput').trigger('focus')
	})
	
  </script>
  
</head>
<body>

 <div class="container-fluid">

 <!--  INCLUDE : TOP MENU NAVIGATION  -->
 <jsp:include page="/TopNav.jsp" />
 
 <div class="container">
 <div class="jumbotron">
 
<!--  Menu title  -->
<c:if test="${!empty category }">		 
		<h1> <span class="label label-default">${category}</span></h1><br>
</c:if>
 
 <ul class="list-group">

<!--  No List -->

	<c:if test="${empty shoesList }">		 
			<h3>  No Items </h3><br>
	</c:if>

<!-- /////////////    Shoes List Start  : forEach  /////////////// -->

	<c:forEach var="shoes" items="${requestScope.shoesList}" begin="0" step="1" varStatus="status">
	
	  <li class="list-group-item">
	  	<!--         		
		${shoes.itemId} 
		${shoes.itemName} 
		${shoes.category} 
		${shoes.shoesize} 
		${shoes.quantity} 
		${shoes.price} 
	 	-->
	  	<c:if test = "${status.end == 0}">
	  	No list
	  	</c:if>
	 
	  	<table>
	  		<tr>
	  			<td>  </td><td colspan="2" class="itemTitle"><h3>${shoes.itemName}</h3></td>
	  			<td align="right" width="100px">
	  			<span class="badge">$${shoes.price}</span>
	  			<!-- show cart image when quantity is bigger than 0   -->
	  			<c:if test="${shoes.quantity > 0}">		 
						<a href="javascript:addCart('${shoes.itemId}','${shoes.itemName}');"><img src="images/cart.png" width="30px"></a> 
						
				</c:if> 
	  			</td>
	  		</tr>
	  		<tr>
	  			<td> </td><td width="180px"><img src="images/shoe${shoes.itemId}.jpg" width="150px" class="img-thumbnail" alt="Cinque Terre"></td>
	  			<td width="">  
	  				  <h4>size: <b> ${shoes.shoesize}</b></h4> <br>
	  				  
	  				  <i>${shoes.content} </i>  
	  			</td>
	  			<td align="right"> 
	  				
	  			</td>
	  		</tr>
	  	</table>
	  	  
	  </li> 
		 
	</c:forEach>
	
<!-- /////////////   End  : forEach  /////////////// -->	
 </ul> 

   </div> 
 </div>
 
 
 <!-- the modal to add cart item --> 
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button> 
          <div id="modal_item_title" class="modal-title"></div> 
        </div>
        <div class="modal-body">
          <p>Do you want to add this item?</p>
        </div>
         <!-- form for cart --> 
		<form action="cartController" method="post" name="cartForm">
		 	<input type="hidden" name="category" value="${category}">
		 	<input type="hidden" value="" name="itemId">
		 	<input type="hidden" value="${sessionScope.customer.customerId}" name="customerId">
		 </form> 
        <div class="modal-footer">
        <!-- data-dismiss="modal"  -->
          <button type="button" class="btn btn-default" onClick="javascript:submitCart();">Add to Cart </button>
        </div>
      </div>
    </div>
  </div>
 <!-- END : the modal to add cart item -->   
  
</div> 
</body>
</html>

