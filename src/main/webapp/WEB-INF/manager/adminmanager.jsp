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
  <!-- END PAGE LEVEL STYLES -->
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
      <li>

        <a href="javascript:;">
          <i class="icon-table"></i>
          <span class="title">图书管理</span>

          <span class="arrow "></span>

        </a>

        <ul class="sub-menu">

          <li>

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
      <li class="${admin.grade==1?'last':''} ">
        <a href="getUsers">
          <i class="icon-user"></i>
          <span class="title">用户管理</span>
        </a>

      </li>
      <c:if test="${admin.grade!=1}">
      <li class="active last">

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
</c:if>

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
             </span>
              </div>
            </div>
          </div>


          <!-- 来源-->
          <ul class="breadcrumb">

            <li>

              <i class="icon-home"></i>

              <a href="index">Home</a>

              <span class="icon-angle-right"></span>

            </li>

            <li><a href="getAdmins">管理员</a></li>

          </ul>

        </div>

      </div>


      <!-- 内容展示-->
      <div class="row-fluid">

        <div class="span12">
          <div class="portlet box green">

            <div class="portlet-title">

              <div class="caption"><i class="icon-globe"></i>管理员详情</div>

              <div class="tools">
                <a href="javascript:;" class="reload"></a>
                <a href="javascript:;" class="remove"></a>
              </div>
            </div>
            <div class="portlet-body">
              <table class="table table-striped table-hover table-bordered"
                     id="sample_editable_1">
                <thead>

                <tr>
                  <th class="hidden-480">用户名</th>
                  <th class="hidden-480">手机号</th>
                  <th class="hidden-480">邮箱</th>
                  <th class="hidden-480">最后登录时间</th>
                  <th class="hidden-480">级别</th>
                  <th class="hidden-480">删除</th>
                  <th class="hidden-480">升级</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.admins}" var="Admin">
                  <tr>
                    <td>${Admin.name}</td>
                    <td>${Admin.tel}</td>
                    <td>${Admin.email}</td>
                    <td>${Admin.lastdatestr}</td>
                    <td>${Admin.grade==1?"管理员":"高级管理员"}</td>
                    <td><a class="delete"
                           href="AdminDelete?id=${Admin.id}&grade=${Admin.grade}">删除</a></td>
                    <td><a class="upgrade" href="AdminUpgrade?id=${Admin.id}&grade=${Admin.grade}">升级</a>
                    </td>
                  </tr>
                </c:forEach>
                </tbody>


              </table>
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
<script src="<%=ctx %>/static/media/js/admin-editable.js"></script>
<script src="<%=ctx %>/static/media/js/datetimepicker.min.js"></script>
<script src="<%=ctx %>/static/media/js/functions.js"></script>

<script>
  jQuery(document).ready(function () {
    App.init();
    TableEditable.init();

  });
</script>

<!-- END JAVASCRIPTS -->

</body>

<!-- END BODY -->

</html>