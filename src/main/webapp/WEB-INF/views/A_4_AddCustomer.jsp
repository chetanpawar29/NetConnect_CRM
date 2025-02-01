<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NetConnect_CRM</title>
</head>
<body>
	<h1>Add Customer</h1>
	<br><br>
	
	<form action="addCustomer" method="post">
		Name: <input type="text" name="cname" placeholder="Enter Name">
		<br><br>
		Address: <input type="text" name="caddress" placeholder="Enter Adrress">
		<br><br>
		Pin-code: <input type="text" name="cpincode" placeholder="Enter Pincode">
		<br><br>
		Contact: <input type="text" name="ccontact" placeholder="Enter Contact">
		<br><br>
		
		Email: <input type="text" name="cemail" placeholder="Enter Email Id">
		<br><br>
		Password: <input type="password" name="cpassword" placeholder="Enter Password">
		<br><br>
		<input type="submit" value="Add Customer"> 
	</form>
</body>
</html>