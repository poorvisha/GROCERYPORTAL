<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Grocery Portal-Home</title>
<link href="style.css" rel="stylesheet" type="text/css"
         media="screen">
</head>
<body id="home">
<div id="mainwrapper">
<div id = "maincontainer">

<div id="headerwrap">
<div id="logosectionwrap">
<h2>Shop.com</h2>
<ul>
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

<div id="maincontentwrap">

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