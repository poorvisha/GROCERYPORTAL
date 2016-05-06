<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Grocery Portal-Register User</title>
<link href="style.css" rel="stylesheet" type="text/css"
         media="screen">
</head>
<body>
<div id="mainwrapper">
<div id="maincontainer">
<h2 class="align">Sign Up now!!!</h2>
<form  id="register_form" action="RegisterServlet" method="post">
<table id="register">
       <tr>
        <td >First Name* :</td>
           <td ><input type="text" name="first_name" id="first_name" size="30" maxlength="15" /> </td>
       </tr>   
        <tr>
        <td >Last Name* :</td>
           <td><input type="text" name="last_name" id="last_name" size="30" maxlength="15" /> </td>
       </tr>  
       <tr>
          <td>E-mail* :</td>
            <td> <input type="text" name="email" size="30" id="email"> </td>
       </tr>
        <tr>
          <td>Password* :</td>
            <td> <input type="password" name="password" id="password" size="30" maxlength="10"/></td>
        </tr>
         <tr>
          <td>Confirm Password* :</td>
            <td> <input type="password" name="confirm_password" id="confirm_password" size="30" maxlength="10"/></td>
        </tr>
         <tr>
          <td>Address Line1* :</td>
            <td> <input type="text" name="addressline1" id="addressline1" size="30" maxlength="40"/></td>
        </tr>
         <tr>
          <td>Address Line2* :</td>
            <td> <input type="text" name="addressline2" id="addressline2" size="30" maxlength="40"/></td>
        </tr>
         <tr>
          <td>City* :</td>
            <td> <input type="text" name="city" id="city" size="30"> </td>
       </tr>
        <tr>
              <td>State* : </td>
                <td><select name="state" id="state">
                  <option  value="">--select--</option>
                  <option  value="Alabama">AL</option>
                  <option  value="Alaska">AK</option>
                  <option  value="Arizona">AZ</option>
                  <option  value="California">CA</option>
                  <option  value="Connecticut">CT</option>
                  <option  value="Florida">FL</option>
                  <option  value=" Illinois">IL</option>
                   </select>
                </td>
         </tr>
        <tr>
          <td>Country :</td>
            <td> <input type="text" name="country" id="country" size="30" value="USA"> </td>
       </tr>
        <tr>
          <td>Zipcode* :</td>
            <td> <input type="text" name="zipcode" id="zipcode" size="30" maxlength="9"> </td>
       </tr>
         <tr>
          <td>Phone :</td>
            <td> <input type="text" name="phone" id="phone" size="30" maxlength="12"> </td>
       </tr>
       
</table>
<div id="buttons">
	   <input class="registerbuttonwrap" type="submit" name="submit" value="Register"/>
       <input class="registerbuttonwrap" type="reset" name="reset" value="Cancel" /> 
       <a href = "Login.jsp" >Go to Login</a>
       </div>
</form>
</div>
</div>
</body>
</html>