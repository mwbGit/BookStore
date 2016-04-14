<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<% String ctx = request.getContextPath();%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title>遇到错误</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />

	<meta content="" name="author" />

	<!-- BEGIN GLOBAL MANDATORY STYLES -->

	<link href="<%=ctx %>/static/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

	<link href="<%=ctx %>/static/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>

	<link href="<%=ctx %>/static/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

	<link href="<%=ctx %>/static/media/css/style-metro.css" rel="stylesheet" type="text/css"/>

	<link href="<%=ctx %>/static/media/css/style.css" rel="stylesheet" type="text/css"/>

	<link href="<%=ctx %>/static/media/css/style-responsive.css" rel="stylesheet" type="text/css"/>

	<link href="<%=ctx %>/static/media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>

	<link href="<%=ctx %>/static/media/css/uniform.default.css" rel="stylesheet" type="text/css"/>

	<!-- END GLOBAL MANDATORY STYLES -->

	<!-- BEGIN PAGE LEVEL STYLES -->

	<link href="<%=ctx %>/static/media/css/error.css" rel="stylesheet" type="text/css"/>

	<!-- END PAGE LEVEL STYLES -->

	<link rel="shortcut icon" href="<%=ctx %>/static/media/image/favicon.ico" />

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-404-3">

	<div class="page-inner">

		<img src="<%=ctx %>/static/media/image/earth.jpg" alt="">

	</div>

	<div class="container error-404">

		<h1>Error</h1>

		<h2>Houston, we have a problem.</h2>

		<p>

		出现错误，请联系管理员562684394@qq.com,谢谢您的合作!

		</p>

		<p>

			<a href="<%=ctx %>/static/getContact">留言</a>

			<br>

		</p>

	</div>

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->

	<script src="<%=ctx %>/static/media/js/jquery-1.8.3.min.js" type="text/javascript"></script>   

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->  

	<script src="<%=ctx %>/static/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      

	<script src="<%=ctx %>/static/media/js/bootstrap.min.js" type="text/javascript"></script>

	<!--[if lt IE 9]>

	<script src="<%=ctx %>/static/media/js/excanvas.js"></script>

	<script src="<%=ctx %>/static/media/js/respond.js"></script>  

	<![endif]-->   

	<script src="<%=ctx %>/static/media/js/breakpoints.js" type="text/javascript"></script>  

	<!-- IMPORTANT! jquery.slimscroll.min.js depends on jquery-ui-1.10.1.custom.min.js --> 

	<script src="<%=ctx %>/static/media/js/jquery.uniform.min.js" type="text/javascript" ></script> 

	<!-- END CORE PLUGINS -->

	<script src="<%=ctx %>/static/media/js/app.js"></script>  

	<script>

		jQuery(document).ready(function() {    

		   App.init();

		});

	</script>

	<!-- END JAVASCRIPTS -->

</body>

<!-- END BODY -->

</html>