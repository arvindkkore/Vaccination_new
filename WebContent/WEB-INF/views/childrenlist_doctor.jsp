<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>

<style>
#mySidenav a {
	position: absolute;
	left: -80px;
	transition: 0.3s;
	padding: 15px;
	width: 100px;
	text-decoration: none;
	font-size: 20px;
	color: white;
	border-radius: 0 5px 5px 0;
}

#mySidenav a:hover {
	left: 0;
}

#child_list_for_doctor {
    top: 20px;
    background-color: #4CAF50;
}

#add_child {
    top: 80px;
    background-color: #2196F3;
}

#doctor_profile {
    top: 140px;
    background-color: #f44336;
}

#logout {
    top: 200px;
    background-color: #555
}
</style>
</head>
<body>

	<div id="mySidenav" class="sidenav">
		<a	href="childrenlist_filter" id="child_list_for_doctor">Child List</a>
        <a href="child" id="add_child">Add Child</a> 
         <a href="getDoctor" id="doctor_profile">Profile</a>
         <a href="#" id="logout">Logout</a> 
	</div>
	<div class="generic-container" style="margin-left: 100px;">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<div>
					<span class="lead">List of Users </span>

				</div>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Child</th>
						<th>DOB</th>
						<th>Father</th>
						<th>Contact</th>
						<th>Email</th>
						<th>Vac Date</th>
						<th>Vac Name</th>

						<th width="100"></th>
						<th width="100"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${children}" var="child">
						<tr>
							<td>${child.child_name}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${child.date_of_birth}" /></td>
							<td>${child.father_name}</td>
							<td>${child.parent_contact}</td>
							<td>${child.parent_email}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${child.vac_date}" />
							<td>${child.vac_name}</td>

							<td><a
								href="<c:url value='add_vaccination-${child.idchild}' />"
								class="btn btn-success 
 
custom-width">Vaccinate</a></td>
							<td><a href="<c:url value='vaccination-${child.idchild}' />"
								class="btn btn-danger  
custom-width">History</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="well">

			<a href="<c:url value='child' />">Add New User</a>
		</div>
	</div>


</body>
</html>