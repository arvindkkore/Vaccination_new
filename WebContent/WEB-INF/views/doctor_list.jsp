<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="header.jsp" />

<body>

	<div class="container">

		<c:if test="${not empty user.username}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${user.username}</strong>
			</div>
		</c:if>

		<h1>All Users</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Doctor Name</th>
					<th>Contact</th>					
				</tr>
			</thead>

			<c:forEach items="${doctors}" var="doctor">
				<tr>
					<td>
						${doctor.iddoctor}
					</td>
					<td>${doctor.doctor_name}</td>
					<td>${doctor.contact}</td>
										
			
			</c:forEach>
		</table>

	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>