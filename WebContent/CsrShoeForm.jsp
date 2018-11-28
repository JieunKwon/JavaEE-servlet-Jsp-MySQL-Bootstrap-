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
 * modified Date : Nov 28, 2018
 * --------------------------------------------- 
 *
 * Page Task :  CSR - Shoe information Form  
 * 
 * Reference :  TABLE Shoes  
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
  
	  function MsgLoginValid()
	  {
			var form = document.RegistForm;
			
		  	// validate null value 
			if(document.getElementById("email").value == "" || document.getElementById("pwd").value == "" || document.getElementById("firstName").value == "" || document.getElementById("lastName").value == "")
			{
				$('#myModal').modal('show'); 
				return;
			}
			else
			{
				 
				form.action = "RegisterController";
				 
				form.submit();
			}
			  
	  }
	  
	  $('#myModal').on('shown.bs.modal', function () {
		  $('#myInput').trigger('focus')
		})
	
  </script>
</head>
<body>

<div class="container-fluid">
 
 <!--  INCLUDE : TOP MENU NAVIGATION  -->
 <jsp:include page="/TopNavCSR.jsp" />
 
 <div class="container"> 
 
<!--  Login Form  --> 
  <h2>Shoes </h2>
    
  <form class="form-inline"  method="post" name="RegistForm" action="" onSubmit="return false;">
 

    <div class="checkbox">
      <label><input type="radio" name="category" id="category" value="Women" checked> Women </label>
      <label><input type="radio" name="category" id="category" value="Men"> Men </label>
      <label><input type="radio" name="category" id="category" value="Kids"> Kids </label>
    </div>
     <br><br>
   <div class="form-group">
      <label for="focusedInput">Shoe Name : </label><br>
      <input class="form-control" type="text" id="itemName" size="50" placeholder="Enter shoe name (50 characters)" name="itemName" maxlength="50"> 
       <i><font color="red">V</font></i>
   </div>
   <br>
 	<div class="form-group">
      <label for="focusedInput">Size : </label><br>
      <input class="form-control" type="text" id="Size" size="10" value="10" name="Size">
      <i><font color="red">V</font></i>
   </div>
   <br>  
    
 	<div class="form-group">
      <label for="focusedInput">Quantity : </label><br>
      <input class="form-control" type="text" id="Quantity" size="10" placeholder="100" name="Quantity">
      <i><font color="red">V</font></i>
   </div>
   <br> 
   <div class="form-group">
      <label for="focusedInput">Price : </label><br>
      <input class="form-control" type="text" id="Price" size="10" placeholder="000.00" name="Price">
      <i><font color="red">V</font></i>
   </div>
   <br> 
   <div class="form-group">
      <label for="focusedInput">Description : </label><br>
      <textarea class="form-control" id="content" size="100"  name="content" rows="5" cols="100"></textarea>
   </div>
   <br> 
   
   <br><br>
    <button type="submit" class="btn btn-primary active" onclick="javascript:MsgLoginValid();">Submit</button>
  </form>
 </div> 
 
<!-- the modal for Login Msg--> 
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Sign up</h4>
        </div>
        <div class="modal-body">
          <p>Please enter your email, password, and your name.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
  
</div> 
</body>
</html>
