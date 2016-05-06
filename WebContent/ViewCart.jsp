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
$(function() {
    $(".submitbutton").click(function() {
      var order_id = ($(this).closest('form').find('input[name="order_id"]')).val();
      console.log('order id is'+order_id);
      var dataString = 'order_id='+ order_id;
      //alert (dataString);return false;
      $.ajax({
        type: "POST",
        url: "SubmitOrderServlet",
        data: dataString,
        success: function() {
          console.log('SUCCESS');
          location.href = "/GROCERYPORTAL/FetchOrderListServlet";
        }
      });
      return false;
    });
  });
  
  function hideSubmitButtonOnViewOrder()
  {
	  if(document.getElementById("order_status").value != "SUBMITTED")
		  {
		  document.getElementById("submitButton").style.visibility = "visible";
		  }
	  else
		  {
		  document.getElementById("submitButton").style.visibility = "hidden";
		  }
  }
  
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
  		<div>
  		<div id="totalorderdisplay">
  		<label>Order status: <%=request.getAttribute("orderStatus")%></label>
  		<br>
  		<label>Order Total Price : <%=request.getAttribute("orderTotal")%></label>
  		</div>
  		<br>
  		<div id="productsdisplay">
  			<c:forEach items="${orderItemsList}" var="element">
  			<div id="itemdetailsdisplay">
			  <div id="itemimage">
			  <img src="${element.itemVo.item_image_url}" alt="${element.itemVo.item_name}">
			  </div>
			  <div id="itemdetails">
  			    <label>Product name : ${element.itemVo.item_name}</label>
			    <br>
			    <label>Product Price : ${element.itemVo.item_price}</label>
			    <br>
			    <label>Quantity ordered : ${element.quantity_ordered}</label>
			    <br>
			    <label>Product Total Price : ${element.total_price}</label>
			    
			  </div> 
			  </div>
			  <hr>
			</c:forEach>
			<form id="SubmitForm" action="" method="post">
	              <table id="ordersubmit">
	                <tr>
	                  <td ><input type="hidden" id="order_id" name="order_id" value="<%=request.getAttribute("orderid")%>"></td>
	                  <td><input type="hidden" id="order_status" name="order_status" value="<%=request.getAttribute("orderStatus")%>"></td>
	                  <td ><input type="submit" value="SubmitOrder" class="submitbutton" id="submitButton"/></td>
	                </tr>
	              </table>
            	</form>
            	
			</div>
		</div>
			</div>
			</div>
			<pre>
			
			
			
			
			
			
			
			
			
			
			
			</pre>
			<div id="footerwrap">
 Copyright © 2016. All Rights Reserved.
</div>
<script type="text/javascript">
hideSubmitButtonOnViewOrder();
            </script>
</body>
</html>