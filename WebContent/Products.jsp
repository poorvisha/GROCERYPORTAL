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
    $(".Addbutton").click(function() {
    	$('#message').html('')
      var itemId = ($(this).closest('form').find('input[name="item_id"]')).val();
      var quantity = ($(this).closest('form').find('input[name="quantity"]')).val();
      if(!(quantity > 0)){
    	  $('#message').html('Please enter a valid quantity');
    	  return false;
      }
      
      console.log('item id and quantity are'+itemId+quantity);
      var dataString = 'item_id='+ itemId + '&quantity=' + quantity;
      //alert (dataString);return false;
      $.ajax({
        type: "POST",
        url: "AddItemServlet",
        data: dataString,
        success: function() {
          console.log('SUCCESS');
          $('#message').html('Item successfully Added')
          .fadeIn(1500, function() {
              $('#message').append("<img id='checkmark' width='25px' height='25px' src='http://www.clker.com/cliparts/D/z/C/2/q/E/check-mark-th.png' />");
            });
          
        }
      });
      return false;
    });
  });
  
$(function() {
    $(".Removebutton").click(function() {
    	$('#message').html('')
      var itemId = ($(this).closest('form').find('input[name="item_id"]')).val();
      var dataString = 'item_id='+ itemId;
      //alert (dataString);return false;
      $.ajax({
        type: "POST",
        url: "RemoveItemServlet",
        data: dataString,
        success: function() {
          console.log('SUCCESS');
          $('#message').html('Item successfully Removed')
          .fadeIn(1500, function() {
        	  $('#message').append("<img id='checkmark' width='25px' height='25px' src='http://www.clker.com/cliparts/D/z/C/2/q/E/check-mark-th.png' />");
            });
        }
      });
      return false;
    });
  });

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
  			<div id="productsdisplay">
  			<c:forEach items="${itemsList}" var="element">	 			
			  <div id="itemdetailsdisplay">
			  <div id="itemimage">
			  <img src="${element.item_image_url}" alt="${element.item_name}">
			  </div>
			  <div id="itemdetails">
			    
			    <label>Product name : ${element.item_name}</label>
			    <br>
			    <label>Product Price : ${element.item_price}</label>
			    <br>
			    <label>Product Category : ${element.item_category}</label>
			    <br>
			    <label>Product Availability : ${element.item_avail}</label>
			    <label></label>
			  </div>
			  <div id ="itemform">
			    <form id="AddItemForm" action="" method="post" >
	              <table>
	                <tr>
	                  <td ><input type="hidden" id="item_id" name="item_id" value="${element.item_id}"></td>
	                  <td ><label for="quantity">Quantity</label>
	                  <input type="text" id="quantity"  name="quantity" maxlength="2" size="5"></td>
	                  <td><input type="submit" value="Add" class="Addbutton"/></td>
	                </tr>
	              </table>
            	</form>		  
			    <form id="RemoveItemForm" action="" method="post">
	              <table>
	                <tr>
	                  <td ><input type="hidden" id="item_id" name="item_id" value="${element.item_id}"></td>
	                  <td ><input type="submit" value="Remove" class="Removebutton"/></td>
	                </tr>
	              </table>
            	</form>
			 </div>
			 
			 	</div>	 
			 	<hr>	
			</c:forEach>
			 </div>
			
</div>			
			
<div id="footerwrap">
 Copyright © 2016. All Rights Reserved.
</div>
			</div>
			</div>
</body>
</html>