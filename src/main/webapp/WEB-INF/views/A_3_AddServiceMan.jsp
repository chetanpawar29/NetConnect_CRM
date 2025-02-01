<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NetConnect_CRM</title>
</head>
<body>
	<h1>Add Service Man</h1>
	<br><br>
	
	<form action="addServiceMan" method="post">
		Name: <input type="text" name="sname" placeholder="Enter Name">
		<br><br>
		Designation: <input type="text" name="sdesignation" placeholder="Enter Designation">
		<br><br>
		Department: <input type="text" name="sdepartment" placeholder="Enter Department">
		<br><br>
		Pin-code: <input type="text" name="spincode" placeholder="Enter Pincode">
		<br><br>
		Contact: <input type="text" name="scontact" placeholder="Enter Contact">
		<br><br>
		
		Email: <input type="text" name="semail" placeholder="Enter Email Id">
		<br><br>
		Password: <input type="password" name="spassword" placeholder="Enter Password">
		<br><br>
		<input type="submit" value="Add Servica Man"> 
	</form>
</body>
</html>