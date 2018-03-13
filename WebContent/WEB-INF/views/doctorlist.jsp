
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
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

#doctorlist {
    top: 20px;
    background-color: #4CAF50;
}

#add_doctor {
    top: 80px;
    background-color: #2196F3;
}

#child_list {
    top: 140px;
    background-color: #f44336;
}

#add_child {
    top: 200px;
    background-color: #555
}


#logout {
    top: 260px;
    background-color:#bfc9ca 
}
</style>
</head>
<body>

<div id="mySidenav" class="sidenav">
   <a href="doctors" id="doctorlist">Doctor List</a>
  <a href="doctor" id="add_doctor">Add Doctor</a>
  <a href="childrenlist" id="child_list">Child List</a>
  <a href="child_admin" id="add_child">Add Child</a> <!-- for admin -->  
  <a href="#" id="logout">Logout</a>  
</div>
 <div class="generic-container" style="margin-left:100px;">
        <div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">List of Users </span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Doctor Name</th>
                        <th>Contact</th>                        
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${doctors}" var="doctor">
                    <tr>
                       <td>${doctor.doctor_name}</td>
                       <td>${doctor.contact}</td>                   
                       
                        <td><a href="<c:url value='doctor/edit/${doctor.iddoctor}' />" class="btn btn-success 
 
custom-width">edit</a></td>
                        <td><a href="<c:url value='doctor/delete/${doctor.iddoctor}' />" class="btn btn-danger  
custom-width">delete</a></td>

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