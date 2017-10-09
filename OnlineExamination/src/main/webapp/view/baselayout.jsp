<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
       <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
         <title><tiles:insertAttribute name="title" /></title>
    <link rel="stylesheet" href="<c:out value="${applicationScope.basePath}"/>/includes/bootstrap/css/bootstrap.min.css">
    <!-- DataTables -->
  <link rel="stylesheet" href="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/plugins/datatables/dataTables.bootstrap.css">
	<link rel="stylesheet" href="<c:out value="${applicationScope.basePath}"/>/includes/css/style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
	  <!-- Ionicons -->
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
	  <!-- Theme style -->
	  <link rel="stylesheet" href="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/dist/css/AdminLTE.min.css">
	  <!-- AdminLTE Skins. Choose a skin from the css/skins
	       folder instead of downloading all of them to reduce the load. -->
	  <link rel="stylesheet" href="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/dist/css/skins/_all-skins.min.css">
	  <!-- iCheck -->
	  <link rel="stylesheet" href="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/plugins/iCheck/flat/blue.css">
	  <!-- Morris chart -->
	  <link rel="stylesheet" href="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/plugins/morris/morris.css">
	  <!-- jvectormap -->
	  <link rel="stylesheet" href="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
	  <!-- Date Picker -->
	  <link rel="stylesheet" href="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/plugins/datepicker/datepicker3.css">
	  <!-- Daterange picker -->
	  <link rel="stylesheet" href="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/plugins/daterangepicker/daterangepicker.css">
	  <!-- bootstrap wysihtml5 - text editor -->
	  <link rel="stylesheet" href="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
     <div class="wrapper">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="menu" />
		<tiles:insertAttribute name="content" />
		<!--<tiles:insertAttribute name="body" />-->
		<tiles:insertAttribute name="footer" />
	</div>
	<!-- jQuery 2.2.3 -->
<script src="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script src="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- DataTables -->
<script src="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script language="JavaScript" src="<c:out value="${applicationScope.basePath}"/>/includes/js/ajax-script.js"></script>
<script>
$(function () {
  $("#example1").DataTable();
});
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/bootstrap/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/plugins/morris/morris.min.js"></script>
<!-- Sparkline -->
<script src="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/plugins/knob/jquery.knob.js"></script>
<!-- daterangepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/dist/js/app.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<c:out value="${applicationScope.basePath}"/>/includes/AdminLTE/dist/js/demo.js"></script>

   </body>
</html>