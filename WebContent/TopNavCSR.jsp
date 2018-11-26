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
 * Page Task :  Top navigation for CSR  
 *  
 * 
 --%>
  
	 <!--  TOP MENU : After CRS Login-->
	 <nav class="navbar navbar-default navbar-fixed-top">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="Login.jsp">BEST SHOES</a>
	    </div>
 		<ul class="nav navbar-nav">
	       
	      <li><a href="CsrNewShoe.jsp">New Product</a></li>
	      <li><a href="CsrShoeListController">Product List</a></li>
	      <li><a href="CsrOrderList.jsp">Order List</a></li>
	      <li><a href="CsrCustList.jsp">Customers</a></li>
	    </ul>
		<ul class="nav navbar-nav navbar-right"> 
	      <li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
	    </ul>
	  </div>
	</nav>