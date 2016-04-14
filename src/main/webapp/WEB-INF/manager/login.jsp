<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    String ctx = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!--
<!--[if IE 8]>
<html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]>
<html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!-->
<html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

    <meta charset="utf-8"/>

    <title>Admin Login</title>

    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>

    <meta content="" name="description"/>

    <meta content="" name="author"/>

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

    <link href="<%=ctx %>/static/media/css/login-soft.css" rel="stylesheet" type="text/css"/>

    <!-- END PAGE LEVEL STYLES -->

    <link rel="shortcut icon" href="<%=ctx %>/static/media/image/favicon.ico"/>

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="login">

<!-- BEGIN LOGO -->

<div class="logo">

    <img src="<%=ctx %>/static/media/image/logo-big.png" alt=""/>

</div>

<!-- END LOGO -->

<!-- BEGIN LOGIN -->

<div class="content">

    <!-- BEGIN LOGIN FORM -->

    <form class="form-vertical login-form" action="LoginAdmin" method="post">

        <h3 class="form-title">Login to your account</h3>


        <div class="control-group">

            <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->

            <label class="control-label visible-ie8 visible-ie9">Username</label>

            <div class="controls">

                <div class="input-icon left">

                    <i class="icon-user"></i>

                    <input name="name" class="m-wrap placeholder-no-fix" type="text" placeholder="Username"
                           name="username"/>

                </div>

            </div>

        </div>

        <div class="control-group">

            <label class="control-label visible-ie8 visible-ie9">Password</label>

            <div class="controls">

                <div class="input-icon left">

                    <i class="icon-lock"></i>

                    <input name="password" class="m-wrap placeholder-no-fix" type="password" placeholder="Password"
                           name="password"
                           onkeyup="value=value.replace(/[\W]/g,'') "
                           onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"/>

                </div>

            </div>

        </div>

        <div class="form-actions">
            <label class="checkbox">

                <input type="checkbox" name="remember" value="1"/> Remember Me

            </label>

            <button type="submit" class="btn blue pull-right">

                Login <i class="m-icon-swapright m-icon-white"></i>

            </button>
        </div>
    </form>

</div>

<!-- END LOGIN -->

<!-- BEGIN COPYRIGHT -->

<div class="copyright">

    <div class="" style=" margin:0 auto; width:400px; color: #ffffff ;font-size: small">
        &copy; 2015 com.mwb.cn email:562684394@qq.com
        <a href="<%=ctx %>/static/index" target="_blank">bookstore</a>

    </div>

</div>

<!-- END COPYRIGHT -->

<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

<!-- BEGIN CORE PLUGINS -->

<script src="<%=ctx %>/static/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>

<script src="<%=ctx %>/static/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>

<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

<script src="<%=ctx %>/static/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>

<script src="<%=ctx %>/static/media/js/bootstrap.min.js" type="text/javascript"></script>

<!--[if lt IE 9]>

<script src="<%=ctx %>/static/media/js/excanvas.min.js"></script>

<script src="<%=ctx %>/static/media/js/respond.min.js"></script>

<![endif]-->

<script src="<%=ctx %>/static/media/js/jquery.slimscroll.min.js" type="text/javascript"></script>

<script src="<%=ctx %>/static/media/js/jquery.blockui.min.js" type="text/javascript"></script>

<script src="<%=ctx %>/static/media/js/jquery.cookie.min.js" type="text/javascript"></script>

<script src="<%=ctx %>/static/media/js/jquery.uniform.min.js" type="text/javascript"></script>

<!-- END CORE PLUGINS -->

<!-- BEGIN PAGE LEVEL PLUGINS -->

<script src="<%=ctx %>/static/media/js/jquery.validate.min.js" type="text/javascript"></script>

<script src="<%=ctx %>/static/media/js/jquery.backstretch.min.js" type="text/javascript"></script>

<!-- END PAGE LEVEL PLUGINS -->

<!-- BEGIN PAGE LEVEL SCRIPTS -->

<script src="<%=ctx %>/static/media/js/app.js" type="text/javascript"></script>


<!-- END PAGE LEVEL SCRIPTS -->

<script>

    jQuery(document).ready(function () {
        App.init();

    });

</script>

<!-- END JAVASCRIPTS -->

</body>

<!-- END BODY -->

</html>