<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.chetan.model.Customer"%>
<%@page import="com.chetan.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Complaints</h1>
<br><br>
	
	<form action="addComplaints" method="post">
		<input type="hidden" name="cId" value="<%=request.getAttribute("cId") %>" placeholder="Enter Customer Id">
		<br><br>
		Title: <input type="text" name="title" placeholder="Enter Title of Complaint">
		<br><br>
		Details: <input type="text" name="details" placeholder="Enter Details of Complaint">
		<br><br>
		Contact: <input type="text" name="Contact" placeholder="Enter Contact No.">
		<br><br>
		Address: <input type="text" name="address" placeholder="Enter Address">
		<br><br>
		Date: <input type="date" name="date" placeholder="Enter Date">
		<br><br>
		Time: <input type="time" name="time" placeholder="Enter Time">
		<br><br>
		<input type="hidden" name="status" value="Unsolved" >
		<br><br>
		<input type="submit" value="Add Complaint">
		
		
	</form>
</body>
</html>