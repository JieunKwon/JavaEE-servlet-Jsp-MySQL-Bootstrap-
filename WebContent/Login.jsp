<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <script>
  
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
			document.LoginForm.submit();
		}
		  
	  
  }
  
  $('#myModal').on('shown.bs.modal', function () {
	  $('#myInput').trigger('focus')
	})
	
  </script>
</head>
<body>

<div class="container">
 
 <!--  INCLUDE : TOP MENU NAVIGATION  -->
 <jsp:include page="/TopNavLogin.jsp" />
 
<!--  Login Form  -->

 <div class="container">
  <h2>Log In </h2>
  <form class="form-inline"  method="post" name="LoginForm" action="LoginController" onSubmit="return false;">
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
      <label><input type="checkbox" name="userType" id="userType" value="crs"> CRS </label>
      <label><input type="checkbox" name="userType" id="userType" checked value="user"> User</label>
    </div>
    <br>  <br>
    <button type="submit" class="btn btn-primary active" onclick="javascript:MsgLoginValid();">LOG IN</button>
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
</body>
</html>
