<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Login Form</title>
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
<div>
<div id="mySidenav" class="sidenav">
<a	href="childrenlist_filter" id="child_list_for_doctor">Child List</a>
<a href="child" id="add_child">Add Child</a> 
<a href="getDoctor" id="doctor_profile">Profile</a>
<a href="#" id="logout">logout</a> 
 
</div>
    <div style="margin-left:80px;">
    <div class="generic-container-login">
    <div class="well lead">Profile</div>
    
    
         
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="${doctor.doctor_name}">Name</label>
                <div class="col-md-7">
                    <label class="col-md-3 control-lable" for="${doctor.doctor_name}">"${doctor.doctor_name}"</label>
                </div>
            </div>
        </div>  
        
         <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="father_name">Contact</label>
                <div class="col-md-7">
                    
                  <label class="col-md-3 control-lable" for="${doctor.contact}">"${doctor.contact}"</label> 
                </div>
            </div>
        </div>  
 
         
    </div>
  
</div>

    </body>
</html>

