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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body { padding-top: 70px; }
</style>  
<script>

function moveEditPage(itemId){
	alert(itemId);
	
}

</script>  
</head>
<body>

 <div class="container-fluid">

 <!--  INCLUDE : TOP MENU NAVIGATION  -->
 <jsp:include page="/TopNavCSR.jsp" />
 
 <div class="container">
 <div class="jumbotron">

 <ul class="list-group">

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
	  	
	  	<table border="0" width="100%">
	  		<tr>
	  			<td> <h4>${status.count}.</h4></td><td colspan="2"><h4>${shoes.itemName}</h4></td>
	  			<td align="right">
	  				<button type="button" class="btn btn-primary btn-sm" onClick="javascript:moveEditPage(${shoes.itemId})">Edit</button> 
	  				<button class="btn btn-danger btn-sm">Delete</button>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td> </td><td width="120px"><img src="images/shoe${shoes.itemId}.jpg" width="100px" class="img-thumbnail" alt="Cinque Terre"></td>
	  			<td> 
	  			    - <b>$${shoes.price}</b><br>
	  			    - category: ${shoes.category} <br>
	  				- size: ${shoes.shoesize} <br>
	  				- qty: ${shoes.quantity} <br>
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
 
</div> 
</body>
</html>

