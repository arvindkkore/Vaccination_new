<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Registration Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
 
    <div class="generic-container">
    <div class="well lead">Vaccination Form</div>
    <form:form method="GET" modelAttribute="child"  action="updateVaccination" class="form-horizontal">
        <form:input type="hidden" path="idchild" id="idchild"/>
         
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="firstName">First Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="child_name" id="child_name" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="child_name" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>  
        
        <div class="row">
            <div class="form-group col-md-12">
              <form:label path="vaccination_id" class="col-md-3 control-lable" >Vaccination type</form:label>               
                <div class="col-md-7">
                    <form:select path="vaccination_id">
                  <form:option value="" label="..Select Type.." />                                    
	                      <form:options items="${vaccinations}" itemValue="idvaccination" itemLabel="vaccination_name"/>
	                       </form:select>
                    <div class="has-error">
                        <form:errors path="vaccination_id" class="help-inline"/> 
                    </div>
                </div>
            </div>
        </div> 
               
        <%-- <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="lastName">Last Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="status" id="lastName" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="lastName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div> --%>
 
        <div class="row">
            <div class="form-actions floatRight">
                 <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>                
            </div>
        </div>
    </form:form>
    </div>
</body>
</html>