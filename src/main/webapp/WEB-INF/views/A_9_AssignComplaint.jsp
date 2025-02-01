<%@page import="com.chetan.model.ServiceMan"%>
<%@page import="com.chetan.model.Complaint"%>
<%@page import="java.util.List"%>
<form action="assignComplaint" method="post">
    Complaint Id:
    <input type="number" name="comId" value="<%=request.getAttribute("comId") %>" readonly="readonly">
    <br><br>

    Assign to:
   
    <!-- Top Placeholder Option -->
    <select name="sId" id="serviceManDropdown">
    <option value="" disabled selected>Select Service Man</option>
    <%
   		List<ServiceMan> list = (List<ServiceMan>)request.getAttribute("serviceManList");
    for(ServiceMan sm : list )
	{
   %>
        <option value="<%=sm.getsId() %>"><%=sm.getSname() %></option>
    <%
    	} 
    %>
    </select>
    <br><br>

    <input type="submit" value="Assign">
</form>

<script>
    function filterServiceMen() {
        let searchValue = document.getElementById("searchServiceMan").value.toLowerCase();
        let dropdown = document.getElementById("serviceManDropdown");
        let options = Array.from(dropdown.options);

        // Get the top option (placeholder)
        let topOption = options[0];

        // Separate options into matching and non-matching categories
        let matchFirst = options.filter(option => option.text.toLowerCase().includes(searchValue));
        let nonMatch = options.filter(option => !option.text.toLowerCase().includes(searchValue) && option !== topOption);

        // Clear the dropdown and re-add the top placeholder option
        dropdown.innerHTML = "";
        dropdown.appendChild(topOption);

        // Add matching options first
        matchFirst.forEach(option => dropdown.appendChild(option));

        // Add non-matching options afterward
        nonMatch.forEach(option => dropdown.appendChild(option));
    }
</script>
