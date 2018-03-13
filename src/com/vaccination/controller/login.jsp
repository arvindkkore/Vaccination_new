<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Login Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
 
    <div class="generic-container-login">
    <div class="well lead">Login User</div>
    <form:form method="POST" action="loginProcess" commandName="userTypes" modelAttribute="login" class="form-horizontal">
        <%-- <form:input type="hidden" path="idchild" id="idchild"/> --%>
         
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="username">User Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="username" id="username" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="username" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>  
        
        <div class="row">
            <div class="form-group col-md-12">
                <form:label path="password" class="col-md-3 control-lable" for="password">Password</form:label>
                <div class="col-md-7">
                    <form:password path="password" id="password" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="password" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>  
        
        <div class="row">
            <div class="form-group col-md-12">
              <form:label path="user_type" class="col-md-3 control-lable" >User type</form:label>               
                <div class="col-md-7">
                    <form:select path="user_type">
                  <form:option value="" label="..Select Type.." />                                    
	                      <form:options items="${userTypes}" itemValue="iduser_type" itemLabel="user_type"/>
	                       </form:select>
                    <div class="has-error">
                        <form:errors path="user_type" class="help-inline"/> 
                    </div>
                </div>
            </div>
        </div> 
               
        
 
        <div class="row">
            <div class="form-actions floatRight">
                 <input type="submit" value="Update" class="btn btn-primary btn-sm"/>                
            </div>
        </div>
    </form:form>
    </div>
</body>
</html>