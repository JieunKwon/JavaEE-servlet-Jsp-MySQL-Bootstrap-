<%@page import="com.bestshoes.Customer"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

 <%//Session  
 HttpSession sessionCustomer = request.getSession();
 Customer customer = (Customer)sessionCustomer.getAttribute("customer");  
 %>
 
 Welcome, <%=customer.getFirstName() %>
</body>
</html>