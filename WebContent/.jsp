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
 * Page Task :  Customer Register Form  
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
 <jsp:include page="/TopNavLogin.jsp" />
 
 <div class="container"> 

<c:if test="${!empty sessionScope.customer.customerId}">
	<h1>${sessionScope.customer.userName}</h1> <br>
</c:if> 
 
<!--  Login Form  --> 
  <h2>Sign up </h2>
 
<%
// Msg from Controller : Fail to Register
 try{
	 String getMsg = (String)request.getAttribute("Msg");
	 
	 if(getMsg.equals("email"))
	 {
%>
		<div class='col-sm-3 col-md-6 col-lg-4' style='color:red;'>
		  The email address you entered is already exist.<br>
          Please enter a different email.<br>
		</div>
 
<%
	 }else if(getMsg.equals("fail"))
	 {
%>		 
		<div class='col-sm-3 col-md-6 col-lg-4' style='color:red;'>
		  Sorry, your registration was failed.<br>
          Please try again.<br>
		</div>
<%	 
	 }
 }
 catch(Exception e){
	  
 }
 %>   
<br> 
    
  <form class="form-inline"  method="post" name="RegistForm" action="" onSubmit="return false;">
    <div class="form-group">
      <label for="focusedInput">Email : </label><br>
      <input class="form-control" type="email" id="email" size="50" placeholder="Enter email" name="email">
      <i><font color="red">* it is your account</font></i>
   </div>
   <br>
   <div class="form-group">
      <label for="pwd">Password:</label><br>
      <input type="password" class="form-control" id="pwd" size="50" placeholder="Enter password" name="pwd">
       <i><font color="red">* at least 8 characters</font></i>
   </div>  
   <br>
   <div class="form-group">
      <label for="focusedInput">First Name : </label><br>
      <input class="form-control" type="text" id="firstName" size="50" placeholder="Enter your first name" name="firstName">
   </div>
   <br>
 	<div class="form-group">
      <label for="focusedInput">Last Name : </label><br>
      <input class="form-control" type="text" id="lastName" size="50" placeholder="Enter your last name" name="lastName">
   </div>
   <br>  
    
 	<div class="form-group">
      <label for="focusedInput">Address : </label><br>
      <input class="form-control" type="text" id="address" size="100" placeholder="Enter your address" name="address">
   </div>
   <br> 
   <div class="form-group">
      <label for="focusedInput">City : </label><br>
      <input class="form-control" type="text" id="city" size="50" placeholder="City" name="city">
   </div>
   <br> 
   <div class="form-group">
      <label for="focusedInput">Postal Code : </label><br>
      <input class="form-control" type="text" id="postalCode" size="10" placeholder="Postal code" name="postalCode">
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
