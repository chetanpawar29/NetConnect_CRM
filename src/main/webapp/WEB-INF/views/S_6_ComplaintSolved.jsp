<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NetConnect_CRM</title>
<script>
    function showAlert(message, isSuccess) {
        let bgColor = isSuccess ? "green" : "red";
        alert(message);
    }
</script>
</head>
<body>
    <h1>Service is Successfully Done..! </h1>
    <br><br>

    <form action="complaintSolved" method="post">
        Complaint Id: <input type="number" name="comId" value="<%=request.getAttribute("comId") %>" readonly="readonly">
        <br><br>
        
        Service Code: <input type="text" name="serviceCode" placeholder="Enter Service Code Provided by Customer" required>
        <br><br>

        <input type="submit" value="Verify & Solve Complaint"> 
    </form>
    
    <p style="color: Green; font-weight: bold;">
        **Note for Service Man:** Please ask the customer for the **Service Code** to verify the complaint resolution.
    </p>

    <% 
        String successMessage = (String) request.getAttribute("successMessage");
        String errorMessage = (String) request.getAttribute("errorMessage");
        
        if (successMessage != null) { 
    %>
        <script>
            showAlert("<%= successMessage %>", true);
        </script>
    <% 
        } else if (errorMessage != null) { 
    %>
        <script>
            showAlert("<%= errorMessage %>", false);
        </script>
    <% } %>

</body>
</html>
