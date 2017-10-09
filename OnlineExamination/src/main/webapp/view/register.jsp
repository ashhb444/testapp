<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="<%=request.getContextPath()%>" scope="application"/>
<head>
<title>Signup</title>
<link rel="stylesheet" href="<c:out value="${basePath}"/>/includes/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:out value="${basePath}"/>/includes/css/style.css">
<script><c:out value="${basePath}"/>/includes/AdminLTE/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="<c:out value="${basePath}"/>/includes/bootstrap/js/bootstrap.min.js"></script>
</head>
<html>
<body>
<s:actionmessage/>
<s:actionerror/>

<div class="container">
	<div id="loginbox" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
    	<div class="panel panel-info" >
	        <div class="panel-heading">
	            <div class="panel-title">Sign Up</div>
	            <div id="forgotpassword"><a href="#">Forgot password?</a></div>
	        </div>     

        <div style="padding-top:30px" class="panel-body">
        	<div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                            
            <s:form action="register" namespace="/examination" method="POST" cssClass="form-horizontal">               
	            
	            <div style="margin-bottom: 25px" class="input-group">
	                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
	                <input id="login-username" type="text" class="form-control" name="firstName" value="" placeholder="first name" required pattern="[A-Za-z]+">                                        
                </div>
                <div style="margin-bottom: 25px" class="input-group">
	                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
	                <input id="login-username" type="text" class="form-control" name="lastName" value="" placeholder="last name" required pattern="[A-Za-z]+">                                        
                </div>
	            <div style="margin-bottom: 25px" class="input-group">
	                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
	                <input id="login-username" type="email" class="form-control" name="email" value="" placeholder="email" required>                                        
                </div>
                                
	            <div style="margin-bottom: 25px" class="input-group">
	                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
	                <input id="login-password" type="password" class="form-control" name="password" placeholder="password" pattern="^\S{6,}$" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Must have at least 6 characters' : ''); if(this.checkValidity()) form.password_two.pattern = this.value;" required> 
                </div>
                <div style="margin-bottom: 25px" class="input-group">
	                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
	                <input id="password_two" type="password" class="form-control" placeholder="confirm password" pattern="^\S{6,}$" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Password & Confirm password do not match' : '');" required>
                </div>
              	<div style="margin-top:10px" class="form-group">
               		<!-- Button -->
	                <div class="col-sm-12 controls">
	                  <button type="submit" class="btn btn-success">Sign Up</button>
	                </div>
	            </div>
                <div class="form-group">
                    <div class="col-md-12 control">
                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                            Already have an account? 
                        <a href="<c:out value="${basePath}"/>/index.jsp">
                            Sign In Here
                        </a>
                        </div>
                    </div>
                </div>    
            </s:form>     
        </div>                     
		</div>  
	</div>
</div>
</body>
</html>
