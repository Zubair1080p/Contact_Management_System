<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
<script>
setTimeout(function() {
    var messageDiv = document.getElementById("success-message");
    if (messageDiv) {
        messageDiv.style.display = "none";
    }
}, 5000); // 5000 milliseconds = 5 seconds
</script>
</head>
<body>
	<h1> Manage Contacts</h1>
	<nav class="menu">
	<div><a href="index.jsp">Create Contact</a></div>
	<div><a href="Update.jsp">Update Contact</a></div>
	<div><a href="Remove.jsp">Remove Contact</a></div>
	<div><a href="View.jsp">View Contact List</a></div>
	</nav>
	
	<form action="delete" method="post">
	<%
	String message = (String)session.getAttribute("message");
	
	if(message != null)
	{
		
	%>
	<strong id="success-message"><%= message %></strong>	
	<%
	session.removeAttribute("message");
	}
	%>
	<h2>Delete Contact</h2>
	<table align="center">
	
	<tr>
	<th>Enter Phone : </th>
	<td><input type="text" name="phone" required placeholder="Enter number"></td>
	</tr>
	
	
	<tr>
	<td colspan="2"><input type="submit" value="Remove" name="btn"></td>
	</tr>
	
	</table>
	</form>
</body>
</html>