<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NetConnect_CRM</title>
</head>
<body>
	<h1>Service Man Login</h1>
	<br><br>
	
	<form action="serviceManLogin" method="post">
		Id: <input type="number" name="sId" placeholder="Enter Id">
		<br><br>
		Email: <input type="text" name="semail" placeholder="Enter Email Id">
		<br><br>
		Password: <input type="password" name="spassword" placeholder="Enter Password">
		<br><br>
		<input type="submit" value="Login"> 
	</form>
	
</body>
</html>