<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Processing...</title>

    <script type="text/javascript">
        window.onload = function() {
            var message = "<%= request.getAttribute("message") %>";
            var redirectUrl = "<%= request.getAttribute("redirectUrl") %>";

            if (message && redirectUrl) {
                alert(message); 
                window.location.href = redirectUrl;  
            }
        };
    </script>
</head>
<body>
</body>
</html>
