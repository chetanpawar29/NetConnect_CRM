<%@page import="com.chetan.model.Customer"%>
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
	<h1>View All Customers</h1>
	<br><br>
	
	
	
	<table border="1">
			
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>contact</th>
			<th>address</th>
			<th>pincode</th>
			<th>Email</th>
			<th>Delete</th>
		</tr>
		
		<%
		List<Customer> list = (List<Customer>)request.getAttribute("customerList");
		
		for(Customer c : list )
		{
		%>
		<tr>
			<td><%=c.getcId() %></td>
			<td><%=c.getCname() %></td>
			<td><%=c.getCcontact() %></td>
			<td><%=c.getCaddress() %></td>
			<td><%=c.getCpincode() %></td>
			<td><%=c.getCemail() %></td>
			<td><a href="deleteCustomer?cId=<%=c.getcId()%>">Delete</a></td>
			
		</tr>
		<%} %>
	</table>
</body>
</html>