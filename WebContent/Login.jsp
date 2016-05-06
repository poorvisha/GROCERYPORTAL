<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Grocery Portal-Login</title>
<link href="style.css" rel="stylesheet" type="text/css"
         media="screen">
</head>
<body>
<div id="mainwrapper">     
 		<div id ="maincontainer" class="logincontainer">
 		    <h1 class="align">Welcome !!!</h1>
 			<form id="login_form" action="LoginServlet" method="post">
              <table id="login">
              <tr>
              <td>
              <img src="http://www.jrpayne.com/wp-content/uploads/2015/10/shop_com_logo.jpg">
              </td>
              </tr>
                  <tr>
                  <td><input class="textboxwrap" type="text" size="30" id="email"  name="email" placeholder="Email"></td>
                  </tr>
                  <tr>
                  <td ><input class="textboxwrap" type="password"  size="30" id="password"  name="password" placeholder="Password"></td>
                  </tr>
                  <tr>
                  <td ><input class="buttonwrap"  type="submit" value="Sign in" /></td>
                  </tr>
                  <tr>        
                  <td><h2>Not a member?</h2><input class="buttonwrap"  type="button" value="Sign Up" onclick="document.location = 'Register.jsp';" ></td>
                  </tr>
              </table>
            </form>
        </div>
         </div>
</body>
</html>