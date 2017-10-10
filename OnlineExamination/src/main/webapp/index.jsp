<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="<%=request.getContextPath()%>" scope="application"/>
<head>
<title>Login</title>
<link rel="stylesheet" href="<c:out value="${basePath}"/>/includes/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:out value="${basePath}"/>/includes/css/style.css">
<script><c:out value="${basePath}"/>/includes/AdminLTE/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="<c:out value="${basePath}"/>/includes/bootstrap/js/bootstrap.min.js"></script>
</head>
<html>
<body>
<s:actionerror/>

<div class="container">
	<div id="loginbox" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
    	<div class="panel panel-info" >
	        <div class="panel-heading">
	            <div class="panel-title">Sign_In</div>
	            <div id="forgotpassword"><a href="#">Forgot password?</a></div>
	        </div>     

        <div style="padding-top:30px" class="panel-body">
        	<div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                            
            <s:form action="login" namespace="/examination" method="POST" cssClass="form-horizontal">               
	            <div style="margin-bottom: 25px" class="input-group">
	                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
	                <input id="login-username" type="text" class="form-control" name="email" value="" placeholder="email">                                        
                </div>
                                
	            <div style="margin-bottom: 25px" class="input-group">
	                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
	                <input id="login-password" type="password" class="form-control" name="password" placeholder="password">
                </div>
          	  	<div class="input-group">
	                <div class="checkbox">
	                  <label>
	                    <input id="login-remember" type="checkbox" name="remember" value="1"> Remember me
	                  </label>
	                </div>
                </div>
              	<div style="margin-top:10px" class="form-group">
               		<!-- Button -->
	                <div class="col-sm-12 controls">
	                  <button type="submit" class="btn btn-success">Sign In</button>
	                </div>
	            </div>
                <div class="form-group">
                    <div class="col-md-12 control">
                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                            Don't have an account! 
                        <a href="<c:out value="${basePath}"/>/view/register.jsp">
                            Sign Up Here
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
