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
 * Page Task :  Top navigation for customers  
 *  
 * 
 *
 --%>
 
	 <!--  TOP MENU : After Login -->
	 <nav class="navbar navbar-default navbar-fixed-top"> 
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="index.jsp">BEST SHOES</a>
	    </div>
 		<ul class="nav navbar-nav">
	       
	      <li><a href="ShoeListController">Women</a></li>
	      <li><a href="ShoeList.jsp">Men</a></li>
	      <li><a href="ShoeList.jsp">Kids</a></li>
	    </ul>
		<ul class="nav navbar-nav navbar-right">
	      <li><a href="MyPage.jsp"><span class="glyphicon glyphicon-user"></span> My Page</a></li> 
	      <li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
	    </ul>
	  </div>
	</nav>