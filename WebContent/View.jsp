<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style2.css">
</head>
<body>
	<h1> Manage Contacts</h1>
	<nav class="menu">
	<div><a href="index.jsp">Create Contact</a></div>
	<div><a href="Update.jsp">Update Contact</a></div>
	<div><a href="Remove.jsp">Remove Contact</a></div>
	<div><a href="View.jsp">View Contact List</a></div>
	</nav>
	
	<form action="viewcontacts" method="get">
	<input type="submit" value="VIEW CONTACTS">
	</form>
	

</body>
</html>
