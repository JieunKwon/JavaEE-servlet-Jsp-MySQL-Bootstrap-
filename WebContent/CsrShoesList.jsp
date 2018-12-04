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
 * Page Task :  CSR - Shoes List   
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
<style>
body { padding-top: 70px; }
</style>  
<script>

// set to move form to edit info
function moveEditPage(itemId,mode){
		
	var form = document.listForm;
	
	form.mode.value = mode;
	form.itemId.value = itemId;
	form.submit();
}

</script>  
</head>
<body>

 <div class="container-fluid">

 <!--  INCLUDE : TOP MENU NAVIGATION  -->
 <jsp:include page="/TopNavCSR.jsp" />
 
 <div class="container">
 
   <ul class="pagination">
    <li><a href="CsrShoeListController?category=Women">Women</a></li>
    <li><a href="CsrShoeListController?category=Men">Men</a></li>
    <li><a href="CsrShoeListController?category=Kids">Kids</a></li>
  </ul>
  
 <div class="jumbotron">
<h3>${requestScope.category}</h3>

 <ul class="list-group">

<!-- /////////////    Shoes List Start  : forEach  /////////////// -->

	<c:forEach var="shoes" items="${requestScope.shoesList}" begin="0" step="1" varStatus="status">
	
	  <li class="list-group-item">
	  	<!--    /shoes info/     		
		${shoes.itemId} 
		${shoes.itemName} 
		${shoes.category} 
		${shoes.shoesize} 
		${shoes.quantity} 
		${shoes.price} 
		${shoes.content}
	 	-->
	  	
	  	<table >
	  		<tr>
	  			<td> <h4>${status.count}.</h4></td><td colspan="2"><h4><b>${shoes.itemName}</b></h4></td>
	  			<td align="right">
	  				<button type="button" class="btn btn-primary btn-sm" onClick="javascript:moveEditPage('${shoes.itemId}','search')">Edit</button> 
	  				<button class="btn btn-danger btn-sm" onClick="javascript:moveEditPage('${shoes.itemId}','del')">Delete</button>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td> </td><td width="120px"><img src="images/shoe${shoes.itemId}.jpg" width="100px" class="img-thumbnail" alt="Cinque Terre"></td>
	  			<td colspan="2"> 
	  			    - <b>$${shoes.price}</b><br>
	  			    - category: ${shoes.category} <br>
	  				- size: ${shoes.shoesize} <br>
	  				- qty: ${shoes.quantity} <br>
	  				- ${shoes.content}
	  			</td>
	  		</tr>
	  	</table>
	  		 
	  	  
	  </li> 
		 
	</c:forEach>
	
<!-- /////////////   End  : forEach  /////////////// -->	
 </ul> 

   </div> 
 </div>
          <!-- form for edit or del --> 
		 <form action="CsrShoeController" method="post" name="listForm"> 
		 	<input type="hidden" value="" name="mode">
		 	<input type="hidden" value="" name="itemId">
		 	<input type="hidden" value="${requestScope.category}" name="category">
		 </form> 
</div> 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>

