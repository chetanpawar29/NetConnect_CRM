<%@page import="com.chetan.model.Complaint"%>
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
	<h1>View Unsolved Complaints</h1>
	
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Service Man Id</th>
			<th>Title</th>
			<th>Details</th>
			<th>Contact No.</th>
			<th>Address</th>
			<th>Date</th>
			<th>Time</th>
			<th>Status</th>
			<th>Action</th>
			
		</tr>
		
		<%
		List<Complaint> list = (List<Complaint>) request.getAttribute("complaintList");
		
		for(Complaint complaint : list)
		{
			if(complaint.getStatus().equals("Unsolved"))
			{
			%>
			
		<tr>
			<td><%=complaint.getComId() %></td>
			
			<td><%=complaint.getsId() %></td>
			
			<td><%=complaint.getTitle() %></td>
			
			<td><%=complaint.getDetails() %></td>
			
			<td><%=complaint.getContact() %></td>
			
			<td><%=complaint.getAddress() %></td>
			
			<td><%=complaint.getDate() %></td>
			
			<td><%=complaint.getTime()%></td>
			
			<td><%=complaint.getStatus() %></td>
			
			<td><a href="openassignComplaint?comId=<%=complaint.getComId() %>"><button>Assign to</button></a></td>
			
		</tr>
			
			<%}
		}
		%>
	</table>
	<br><br>
	<b>Note:</b><p> If the Service Man ID is 0, it means that you not yet assigned a service man. Assign Service Man to the respective Complaint as soon as possible!</p>
</body>
</html>