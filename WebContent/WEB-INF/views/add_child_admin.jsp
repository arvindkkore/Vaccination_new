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
<div>
<div id="mySidenav" class="sidenav">
  <a href="doctors" id="doctorlist">Doctor List</a>
  <a href="doctor" id="add_doctor">Add Doctor</a>
  <a href="childrenlist" id="child_list">Child List</a>
  <a href="child_admin" id="add_child">Add Child</a> <!-- for admin -->  
  <a href="#" id="logout">Logout</a> 
 
</div>
    <div style="margin-left:80px;">
    <div class="generic-container-login">
    <div class="well lead">Login User</div>
    <form:form method="GET" action="addChildAdmin" modelAttribute="child" class="form-horizontal">
       <input type="hidden" name="idchild" value="${child.idchild}"/>
         
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="child_name">Child Name</label>
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
                <label class="col-md-3 control-lable" for="father_name">Father's Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="father_name" id="father_name" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="father_name" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>  
 
         <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="mother_name">Mother's Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="mother_name" id="mother_name" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="mother_name" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>  
        
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="date_of_birth">Date of Birth</label>
                <div class="col-md-7">
                    <form:input type="date" path="date_of_birth" id="date_of_birth" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="date_of_birth" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>  
        
          <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="parent_contact">Parents Contact</label>
                <div class="col-md-7">
                    <form:input type="text" path="parent_contact" id="parent_contact" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="parent_contact" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>  
        
       <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="parent_email">Parents Email</label>
                <div class="col-md-7">
                    <form:input type="text" path="parent_email" id="parent_email" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="parent_email" class="help-inline"/>
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
        
       <div class="row">
            <div class="form-group col-md-12">
              <form:label path="doc_id" class="col-md-3 control-lable" >Doctor</form:label>               
                <div class="col-md-7">
                    <form:select path="doc_id">
                  <form:option value="-1" label="..Select Type.." />                                    
	                      <form:options items="${doctors}" itemValue="iddoctor" itemLabel="doctor_name"/>
	                       </form:select>
                    <div class="has-error">
                        <form:errors path="doc_id" class="help-inline"/> 
                    </div>
                </div>
            </div>
        </div>        
               
         <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="vac_date">Vaccination Date(dd/MM/yyyy)</label>
                <div class="col-md-7">
                    <form:input type="date" path="vac_date" id="vac_date" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="vac_date" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div> 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="status">Vaccination Status</label>
                <div class="col-md-7">
                    <form:checkbox path="status" value="status" class="form-control input-sm"/>
                    <div class="has-error">
                        <%-- <form:errors path="vac_date" class="help-inline"/> --%>
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

