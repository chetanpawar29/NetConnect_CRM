<%@page import="com.chetan.model.ServiceMan"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>View All Service Mans</h1>
	<br><br>
	
	
	
	<table border="1">
			
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Designation</th>
			<th>Department</th>
			<th>Pincode</th>
			<th>Contact</th>
			<th>Email</th>
			<th>Delete</th>
		</tr>
		
		<%
		List<ServiceMan> list = (List<ServiceMan>)request.getAttribute("serviceManList");
		
		for(ServiceMan sm : list )
		{
		%>
		<tr>
			<td><%=sm.getsId() %></td>
			<td><%=sm.getSname() %></td>
			<td><%=sm.getSdesignation() %></td>
			<td><%=sm.getSdepartment() %></td>
			<td><%=sm.getSpincode() %></td>
			<td><%=sm.getScontact() %></td>
			<td><%=sm.getSemail() %></td>
			<td><a href="deleteServiceMan?sId=<%=sm.getsId()%>">Delete</a></td>
			
		</tr>
		<%} %>
	</table>
</body>
</html>