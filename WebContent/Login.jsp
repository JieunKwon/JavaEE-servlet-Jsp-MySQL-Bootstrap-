<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
 
 
 <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">BEST SHOES</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">Page 1</a></li>
      <li><a href="#">Page 2</a></li>
      <li><a href="#">Page 3</a></li>
    </ul>
      <button type="Submit" class="btn btn-default">Log In</button>
      <button type="Submit" class="btn btn-default">Sign up</button>
  <button class="btn btn-danger navbar-btn">Button</button>
  </div>
</nav>
             


<!--  Login Form  -->

 <div class="container">
  <h2>Log In </h2>
  <form class="form-inline"  method="post" action="LoginController" >
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
    <button type="submit" class="btn btn-default">LOG IN</button>
  </form>
 
</div>

</body>
</html>
