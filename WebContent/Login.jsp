<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--
 * --------------------------------------------- 
 * @author JIEUN KWON (991447941)
 *	
 * TASK : Assignment 3 
 * MVC Modeling - Shoe Product Ordering System
 * 
 * created Date : Nov 24, 2018 
 * modified Date : Nov 26, 2018
 * --------------------------------------------- 
 *
 * Page Task :  login form 
 *				customer / CSR 
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
  
	// show modal to validate null value 
  function MsgLoginValid()
  {
		
	  	// validate null value 
		if(document.getElementById("email").value == "" || document.getElementById("pwd").value == "")
		{
			$('#myModal').modal('show'); 
			return;
		}
		else
		{
			// submit form  
			var form = document.LoginForm;
			 
			if(form.userType[0].checked){
				 
				form.action = "LoginCSRController";
			}else
			{
				 
				form.action = "LoginController";
			}
		
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
 

<!--  Login Form  --> 
  <h2>Log In </h2>
 
<%
// Fail to login
 try{
	 String getMsg = (String)request.getAttribute("loginMsg");
	 
	 if(getMsg.equals("fail"))
	 {
%>
		<div class='col-sm-3 col-md-6 col-lg-4' style='color:red;'>
				 The email or password you entered is incorrect.<br>
		</div>
 
<%
	 }
 }
 catch(Exception e){
	  
 }
 %>   
<br>
  <form class="form-inline"  method="post" name="LoginForm" action="" onSubmit="return false;">
    <div class="form-group">
      <label for="focusedInput">Email : </label><br>
      <input class="form-control" type="email" id="email" size="50" placeholder="Enter email" name="email">
   </div>
   <br>
   <div class="form-group">
      <label for="pwd">Password:</label><br>
      <input type="password" class="form-control" id="pwd" size="50" placeholder="Enter password" name="pwd">
   </div>  
   <br>  <br>
    <div class="checkbox">
      <label><input type="radio" name="userType" id="userType" value="csr"> CSR </label>
      <label><input type="radio" name="userType" id="userType" checked value="user"> User</label>
    </div>
    <br><br>
    <button type="submit" class="btn btn-primary active" onclick="javascript:MsgLoginValid();">LOG IN</button>
    <button type="submit" class="btn btn-default active" onclick="javascript:location.href='Register.jsp';">Go to Sign up</button>
  </form>
 </div> 
<!-- the modal for Login Msg--> 
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Log In</h4>
        </div>
        <div class="modal-body">
          <p>Please enter your email and password</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
  
</div> 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
