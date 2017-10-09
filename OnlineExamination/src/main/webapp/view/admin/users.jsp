<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Users</title>
</head>
<body>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Users
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Users</a></li>
        <li class="active">User Details</li>
      </ol>
    </section>
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
	<div class="box">
	<div class="box-header">
	  <h3 class="box-title">User Details</h3>
	</div>
	<!-- /.box-header -->
	<div class="box-body">
	  <table id="example1" class="table table-bordered table-striped">
	    <thead>
	    <tr>
	    	<th>S.NO.</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Contact Number</th>
			<th>User Type</th>
			<th>Status</th>
			<th>Action</th>
	    </tr>
	    </thead>
	    <tbody>
	    <s:iterator value="userList" status="status" var="myobj">
			<s:if test="#myobj.userType.toString() != 'ADMIN' ">
	    <tr>
	      <td><s:property value="#status.count" /></td>
	      <td><s:property value="firstName" /></td>
	      <td><s:property value="lastName" /></td>
	      <td><s:property value="email" /></td>
	      <td><s:property value="mobileNumber" /></td>
	      <td><s:property value="userType" /></td>
	      <td><s:property value="status" /></td>
	      <td><a href="<s:url action="editUserAction"><s:param name="id"><s:property value="id"/></s:param></s:url>"><img style="cursor: pointer;" title="Edit" height="25" src="<c:out value="${basePath}"/>/includes/images/edit.png"></a>
	      <a href="javascript:deleteEntity(<s:property value="id"/>,'deleteUser');"><img style="cursor: pointer;" title="Delete" height="25" src="<c:out value="${basePath}"/>/includes/images/delete.png"></a></td>
	    </tr>
	    	</s:if>
		</s:iterator>
	    </tbody>
	  </table>
	  <div><a href="<s:url action="addUserAction" />" class="btn btn-primary" role="button">Add New User</a></div>
	 </div>
     <!-- /.box-body -->
   	</div>
   	<!-- /.box -->
 	</div>
 	<!-- /.col -->
	</div>
	<!-- /.row -->
	</section>
	</div>
</body>
</html>