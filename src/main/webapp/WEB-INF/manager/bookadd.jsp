<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String ctx = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!--[if IE 8]>
<html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]>
<html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!-->
<html lang="en" xmlns="http://www.w3.org/1999/html"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

    <meta charset="utf-8"/>

    <title>博古书屋</title>
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

    <link rel="stylesheet" type="text/css" href="<%=ctx %>/static/media/css/select2_metro.css"/>
    <link rel="stylesheet" href="<%=ctx %>/static/media/css/DT_bootstrap.css"/>
    <!-- END PAGE LEVEL SCRIPTS -->

    <link rel="shortcut icon" href="<%=ctx %>/static/media/image/favicon.ico"/>

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed">

<!--//右侧 -->

<div class="header navbar navbar-inverse navbar-fixed-top">

    <!-- BEGIN TOP NAVIGATION BAR -->

    <div class="navbar-inner">

        <div class="container-fluid">
            <!-- BEGIN LOGO -->
            <a class="brand" href="index">
                <img src="<%=ctx %>/static/media/image/logo.png" alt="logo"/>
            </a>

            <ul class="nav pull-right">

                <li class="dropdown user">

                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img alt="" src="<%=ctx %>/static/media/image/avatar1_small.jpg"/>
                        <span class="username">${admin.name}</span>
                        <i class="icon-angle-down"></i>

                    </a>

                    <ul class="dropdown-menu">

                        <li><a href="getAdminEdit"><i class="icon-user"></i>修改信息</a></li>

                        <li><a href="logOut"><i class="icon-key"></i> Log Out</a></li>

                    </ul>

                </li>

                <!-- END USER LOGIN DROPDOWN -->

            </ul>

            <!-- END TOP NAVIGATION MENU -->

        </div>

    </div>

    <!-- END TOP NAVIGATION BAR -->

</div>

<div class="page-container row-fluid">
    <!-- 左边菜单 -->
    <div class="page-sidebar nav-collapse collapse">

        <ul class="page-sidebar-menu">
            <li>

                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->

                <div class="sidebar-toggler hidden-phone"></div>

                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->

            </li>
            <li class="start ">

                <a href="index">

                    <i class="icon-home"></i>

                    <span class="title">Dashboard</span>

                </a>

            </li>
            <li class="active ">

                <a href="javascript:;">

                    <i class="icon-table"></i>

                    <span class="title">图书管理</span>

                    <span class="arrow "></span>

                </a>

                <ul class="sub-menu">

                    <li class="active">

                        <a href="getBookAdd">

                            添加图书</a>

                    </li>
                    <li>

                        <a href="getBooks">

                            展示图书</a>

                    </li>

                </ul>

            </li>
            <li>
                <a href="getBookTypes">
                    <i class="icon-bar-chart"></i>
                    <span class="title">类别管理</span>
                </a>

            </li>
            <li class="">

                <a href="javascript:;">

                    <i class="icon-file-text"></i>

                    <span class="title">订单管理</span>

                    <span class="arrow "></span>

                </a>

                <ul class="sub-menu">

                    <li>

                        <a href="getOders">

                            待处理</a>

                    </li>
                    <li>

                        <a href="getOderOver">

                            已处理</a>

                    </li>

                </ul>

            </li>
            <li>
                <a href="getMessage">
                    <i class="icon-gift"></i>
                    <span class="title">留言管理</span>
                </a>

            </li>
            <li>
                <a href="getUsers">
                    <i class="icon-user"></i>
                    <span class="title">用户管理</span>
                </a>

            </li>
            <li class="last">

                <a href="javascript:;">

                    <i class="icon-sitemap"></i>

                    <span class="title">管理员</span>

                    <span class="arrow "></span>

                </a>

                <ul class="sub-menu">

                    <li>

                        <a href="addAdmin">
                            添加管理员</a>
                    </li>
                    <li class="active">
                        <a href="getAdmins">
                            展示管理员</a>

                    </li>

                </ul>

            </li>

        </ul>

        <!-- END SIDEBAR MENU -->

    </div>
    <div class="page-content">
        <div class="container-fluid">
            <!-- 上方-->
            <div class="row-fluid">
                <div class="span12">
                    <div class="<%=ctx %>/static/media-body">
                        <div class="<%=ctx %>/static/media" id="top-menu">
                            <div id="time" class="pull-right">
                               <span style="font-size: large;"> <span id="hours"></span> : <span id="min"></span> : <span id="sec"></span>
                           </span> </div>
                        </div>
                    </div>


                    <!-- 来源-->
                    <ul class="breadcrumb">

                        <li>

                            <i class="icon-home"></i>

                            <a href="index">Home</a>

                            <span class="icon-angle-right"></span>

                        </li>

                        <li><a href="getBookAdd">添加图书</a></li>

                    </ul>

                </div>

            </div>

            <!-- 内容展示-->
            <div class="row-fluid">

                <div class="span12">

                    <div class="tabbable tabbable-custom boxless">
                        <div class="portlet box blue ">
                            <div class="portlet-title">
                                <div class="caption"><i class="icon-reorder"></i>添加图书</div>

                                <div class="tools">

                                    <a href="javascript:;" class="collapse"></a>

                                    <a href="javascript:;" class="reload"></a>

                                    <a href="javascript:;" class="remove"></a>

                                </div>

                            </div>
                            <div class="portlet-body form">

                                <!-- BEGIN FORM-->

                                <form action="bookAdd" method="post"
                                      class="form-horizontal form-bordered form-row-stripped"
                                      enctype="multipart/form-data">

                                    <div class="control-group">

                                        <label class="control-label" for="name">书名</label>

                                        <div class="controls">

                                            <input id="name" type="text" name="name"
                                                   class="m-wrap span6"/>

                                        </div>

                                    </div>

                                    <div class="control-group">

                                        <label class="control-label" for="type">类型</label>

                                        <div class="controls">

                                            <select class="m-wrap span6" name="booktype.id" id="type">

                                            </select>

                                        </div>

                                    </div>

                                    <div class="control-group">

                                        <label class="control-label" for="press">出版社</label>

                                        <div class="controls">

                                            <input id="press" type="text" name="press" class="m-wrap span6">

                                        </div>

                                    </div>
                                    <div class="control-group">

                                        <label class="control-label" for="pressdate">出版日期</label>

                                        <div class="controls">
                                            <input id="pressdate" name="pressdate"  class=" span6 Wdate" type="text"
                                                   onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="2016-01-01"/>
                                        </div>

                                    </div>
                                    <div class="control-group">

                                        <label class="control-label" for="author">作者</label>

                                        <div class="controls">

                                            <input id="author" type="text" name="author" class="m-wrap span6">

                                        </div>

                                    </div>
                                    <div class="control-group">

                                        <label class="control-label" for="introduction">简介</label>

                                        <div class="controls">
                                                    <textarea id="introduction" type="text" name="introduction" rows="10"
                                                              class="m-wrap span6"></textarea>
                                        </div>

                                    </div>
                                    <div class="control-group">

                                        <label class="control-label" for="marketprice">市场价(元)</label>

                                        <div class="controls">

                                            <input type="text" id="marketprice" name="marketprice" class="m-wrap span6">

                                        </div>

                                    </div>
                                    <div class="control-group">

                                        <label class="control-label" for="memberprice">会员价(元)</label>

                                        <div class="controls">

                                            <input type="text" id="memberprice" name="memberprice" class="m-wrap span6">

                                        </div>

                                    </div>
                                    <div class="control-group">

                                        <label class="control-label" for="inventory">存量(本)</label>

                                        <div class="controls">

                                            <input type="text" id="inventory" name="inventory" class="m-wrap span6" value="100">

                                        </div>

                                    </div>
                                    <div class="control-group">

                                        <label class="control-label">封面</label>

                                        <div class="controls">

                                            <input type="file" name="file" class="m-wrap span6">

                                        </div>

                                    </div>

                                    <div class="form-actions">

                                        <button id="sub" type="submit" class="btn blue"><i class="icon-ok"></i> Save
                                        </button>

                                        <button type="reset" class="btn blue">清空</button>

                                    </div>
                                </form>

                                <!-- END FORM-->

                            </div>
                        </div>

                    </div>

                </div>

            </div>

            <!-- END PAGE CONTENT-->

        </div>

        <!-- END PAGE CONTAINER-->

    </div>

    <!-- END PAGE -->

</div>

<!-- END CONTAINER -->

<!-- BEGIN FOOTER -->

<div class="footer">

    <div class="" style=" margin:0 auto; width:400px; color: #ffffff ;font-size: small">
        &copy; 2015 com.mwb.cn email:562684394@qq.com
        <a href="<%=ctx %>/static/index" target="_blank">博古</a>

    </div>

    <div class="footer-tools">

			<span class="go-top">

			<i class="icon-angle-up"></i>

			</span>

    </div>

</div>

<!-- END FOOTER -->

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

<script type="text/javascript" src="<%=ctx %>/static/media/js/select2.min.js"></script>

<script type="text/javascript" src="<%=ctx %>/static/media/js/jquery.dataTables.min.js"></script>

<script type="text/javascript" src="<%=ctx %>/static/media/js/DT_bootstrap.js"></script>
<!-- END PAGE LEVEL PLUGINS -->

<!-- BEGIN PAGE LEVEL SCRIPTS -->

<script src="<%=ctx %>/static/media/js/app.js"></script>

<script src="<%=ctx %>/static/media/js/form-samples.js"></script>

<script src="<%=ctx %>/static/media/js/app.js"></script>

<script src="<%=ctx %>/static/media/js/table-advanced.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script src="<%=ctx %>/static/media/js/table-editable.js"></script>
<script src="<%=ctx %>/static/media/js/bookadd.js"></script>
<script src="<%=ctx %>/static/media/js/datetimepicker.min.js"></script>
<script src="<%=ctx %>/static/media/js/functions.js"></script>
<script src="<%=ctx %>/static/media/js/smallarAlert.js"></script>
<script language="javascript" type="text/javascript" src="<%=ctx %>/static/My97DatePicker/WdatePicker.js"></script>

<script>

    jQuery(document).ready(function () {

        App.init();
        FormSamples.init();

    });

</script>

<!-- END JAVASCRIPTS -->

</body>

<!-- END BODY -->

</html>