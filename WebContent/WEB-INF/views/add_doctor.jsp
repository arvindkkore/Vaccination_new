<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
    <title>Doctor Registration </title>
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
    <div style="margin-left:80px;">
    
    <div class="generic-container-login">
    <div class="well lead">Add Doctor User</div>
    <form:form method="POST" action="addDoctor" modelAttribute="doctor" class="form-horizontal">
        <%-- <form:input type="hidden" path="idchild" id="idchild"/> --%>
         
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="doctor_name">Doctor Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="doctor_name" id="doctor_name" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="doctor_name" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>  
        
        <div class="row">
            <div class="form-group col-md-12">
                <form:label path="contact" class="col-md-3 control-lable" for="contact">Contact</form:label>
                <div class="col-md-7">                    
                     <form:input type="text" path="contact" id="contact" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="contact" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>  
        
 
        <div class="row">
            <div class="form-actions floatRight">
                 <input type="submit" value="Add" class="btn btn-primary btn-sm"/>                
            </div>
        </div>
    </form:form>
    </div>
    
  
       </div> 
    </body>
</html>