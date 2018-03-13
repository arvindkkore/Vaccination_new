<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>

<style>
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}
</style>

</head>


<body>
	<h2>Welcome ${user.username}</h2>
	<table>


		<tr>
			<td><a href="<c:url value='/new' />">Add New Employee</a></td>
		</tr>
		<tr>
			<td><a href="<c:url value='/doctor' />">Add New Doctor</a></td>
		</tr>
		<tr>
			<td><a href="<c:url value='/child' />">Add New Child</a></td>
		</tr>
		
	</table>
	<br />

</body>
</html>