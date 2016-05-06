<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Grocery Portal-Products</title>
<link href="style.css" rel="stylesheet" type="text/css"
         media="screen">
<script src="js/jquery-1.12.2.min.js"></script>
	<script src="js/jquery.tools.min.js"></script>
	<script src="dist/js/vendor/jquery.min.js" type="text/javascript" ></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script type="text/javascript">


</script>
</head>
<body>
<div id="mainwrapper">
<div id="maincontainer">
<div id="headerwrap">
<div id="logosectionwrap">
<h2>Shop.com</h2>
<ul>
<li>
<a href="HomePage.jsp">Home</a>
</li>
<li>
<a href="FetchOrderServlet" id="fetchCurrentOrder">View Cart</a>
</li>
<li>
<a href="FetchOrderListServlet" id="fetchAllOrders">View All Orders</a>
</li>
<li>
<a href="Logout.jsp" >Logout</a></li>
</ul>
</div>
<div id="menuwrap">
<ul>
<li>
<a href="FetchProductsServlet?cat=FreshFoods" id="freshFoods">Fresh Foods</a>
</li>
<li>
<a href="FetchProductsServlet?cat=Drinks" id="drinks">Drinks</a></li>
<li>
<a href="FetchProductsServlet?cat=Snacks" id="snacks">Snacks</a></li>
<li>
<a href="FetchProductsServlet?cat=Beauty" id="beauty">Beauty</a></li>
</ul>
</div>
</div>
  			
<div id="mainproductswrap">		
  			<div id="message"></div>
  			<div>
  			<h2>Click below Order Numbers to View Orders</h2>
  			</div>
  			<div id="productsdisplay">
  			<c:forEach items="${orderIds}" var="element">		
			  <div id="itemdetailsdisplay">
			  <label>Order:</label>	
			  <a href="/GROCERYPORTAL/FetchOrderServlet?orderid=${element}">${element}</a>
			  </div>
			</c:forEach>
			 </div>
			
</div>			
		<pre>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		</pre>	
<div id="footerwrap">
 Copyright © 2016. All Rights Reserved.
</div>
			</div>
			</div>
</body>
</html>