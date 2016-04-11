<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

    <title>用户管理</title>

    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>

    <meta content="" name="description"/>

    <meta content="" name="author"/>

    <!-- BEGIN GLOBAL MANDATORY STYLES -->

    <link href="media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

    <link href="media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>

    <link href="media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

    <link href="media/css/style-metro.css" rel="stylesheet" type="text/css"/>

    <link href="media/css/style.css" rel="stylesheet" type="text/css"/>

    <link href="media/css/style-responsive.css" rel="stylesheet" type="text/css"/>

    <link href="media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>

    <link href="media/css/uniform.default.css" rel="stylesheet" type="text/css"/>

    <!-- END GLOBAL MANDATORY STYLES -->

    <!-- BEGIN PAGE LEVEL STYLES -->
    <link rel="stylesheet" type="text/css" href="media/css/select2_metro.css"/>
    <link rel="stylesheet" href="media/css/DT_bootstrap.css"/>
    <!-- END PAGE LEVEL STYLES -->
    <link rel="shortcut icon" href="media/image/favicon.ico"/>

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
            <a class="brand" href="index.jsp">
                <img src="media/image/logo.png" alt="logo"/>
            </a>

            <ul class="nav pull-right">

                <li class="dropdown user">

                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img alt="" src="media/image/avatar1_small.jpg"/>
                        <span class="username">${admin.name}</span>
                        <i class="icon-angle-down"></i>

                    </a>

                    <ul class="dropdown-menu">

                        <li><a href="adminedit.jsp"><i class="icon-user"></i>修改信息</a></li>

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

                <a href="index.jsp">

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

                        <a href="bookadd.jsp">

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
            <li class="active">
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
                    <div class="media-body">
                        <div class="media" id="top-menu">
                            <div id="time" class="pull-right">
                                <span id="hours"></span> : <span id="min"></span> : <span id="sec"></span>
                            </div>
                        </div>
                    </div>
                    <!-- 设置按键-->
                    <div class="color-panel hidden-phone">

                        <div class="color-mode-icons icon-color"></div>

                        <div class="color-mode-icons icon-color-close"></div>

                        <div class="color-mode">

                            <p>THEME COLOR</p>

                            <ul class="inline">

                                <li class="color-black current color-default" data-style="default"></li>

                                <li class="color-blue" data-style="blue"></li>

                                <li class="color-brown" data-style="brown"></li>

                                <li class="color-purple" data-style="purple"></li>

                                <li class="color-grey" data-style="grey"></li>

                                <li class="color-white color-light" data-style="light"></li>

                            </ul>

                            <label>

                                <span>Layout</span>

                                <select class="layout-option m-wrap small">

                                    <option value="fluid" selected>Fluid</option>

                                    <option value="boxed">Boxed</option>

                                </select>

                            </label>

                            <label>

                                <span>Header</span>

                                <select class="header-option m-wrap small">

                                    <option value="fixed" selected>Fixed</option>

                                    <option value="default">Default</option>

                                </select>

                            </label>

                            <label>

                                <span>Sidebar</span>

                                <select class="sidebar-option m-wrap small">

                                    <option value="fixed">Fixed</option>

                                    <option value="default" selected>Default</option>

                                </select>

                            </label>

                            <label>

                                <span>Footer</span>

                                <select class="footer-option m-wrap small">

                                    <option value="fixed">Fixed</option>

                                    <option value="default" selected>Default</option>

                                </select>

                            </label>

                        </div>

                    </div>

                    <!-- 来源-->
                    <ul class="breadcrumb">

                        <li>

                            <i class="icon-home"></i>

                            <a href="index.jsp">Home</a>

                            <span class="icon-angle-right"></span>

                        </li>

                        <li><a href="getUsers">用户管理</a></li>

                    </ul>

                </div>

            </div>


            <!-- 内容展示-->
            <div class="row-fluid">

                <div class="span12">
                    <div class="portlet box green">

                        <div class="portlet-title">

                            <div class="caption"><i class="icon-globe"></i>用户详情</div>

                            <div class="tools">
                                <a href="javascript:;" class="collapse"></a>

                                <a href="javascript:;" class="reload"></a>

                                <a href="javascript:;" class="remove"></a>

                            </div>

                        </div>
                        <div class="portlet-body">

                            <table class="table table-striped table-hover table-bordered"
                                   id="sample_editable_1">

                                <thead>

                                <tr>
                                    <th class="hidden-480" width="7%">用户名</th>
                                    <th class="hidden-480" width="7%">姓名</th>
                                    <th class="hidden-480">性别</th>
                                    <th class="hidden-480" width="10%">电话</th>
                                    <th class="hidden-480" width="10%">Email</th>
                                    <th class="hidden-480" width="15%">地址</th>
                                    <th class="hidden-480" width="7%">邮编</th>
                                    <th class="hidden-480" width="9%">注册时间</th>
                                    <th class="hidden-480" width="10%">最后登录</th>
                                    <th class="hidden-480">会员</th>
                                    <th class="hidden-480">删除</th>
                                    <th class="hidden-480">升级</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${requestScope.users}" var="User">
                                    <tr>
                                        <td>${User.name}</td>
                                        <td>${User.realname}</td>
                                        <td>${User.sex}</td>
                                        <td>${User.tel}</td>
                                        <td>${User.email}</td>
                                        <td>${User.address}</td>
                                        <td>${User.zipcode}</td>
                                        <td>${User.joindatestr}</td>
                                        <td>${User.lastdatestr}</td>
                                        <td>${User.members==1?"是":"否"}</td>
                                        <td><a class="delete" href="UserDelete?id=${User.id}">删除</a></td>
                                        <td><a class="upgrade" href="UserUpgrade?id=${User.id}&members=${User.members}">升级</a>
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

    <div class="footer-inner">

        2013 &copy; Metronic by keenthemes.Collect from <a href="http://www.cssmoban.com/" title="网站模板" target="_blank">网站模板</a>
        - More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>

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

<script src="media/js/jquery-1.10.1.min.js" type="text/javascript"></script>

<script src="media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>

<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

<script src="media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>

<script src="media/js/bootstrap.min.js" type="text/javascript"></script>

<!--[if lt IE 9]>

<script src="media/js/excanvas.min.js"></script>

<script src="media/js/respond.min.js"></script>

<![endif]-->

<script src="media/js/jquery.slimscroll.min.js" type="text/javascript"></script>

<script src="media/js/jquery.blockui.min.js" type="text/javascript"></script>

<script src="media/js/jquery.cookie.min.js" type="text/javascript"></script>

<script src="media/js/jquery.uniform.min.js" type="text/javascript"></script>

<!-- END CORE PLUGINS -->

<!-- BEGIN PAGE LEVEL PLUGINS -->

<script type="text/javascript" src="media/js/select2.min.js"></script>

<script type="text/javascript" src="media/js/jquery.dataTables.min.js"></script>

<script type="text/javascript" src="media/js/DT_bootstrap.js"></script>
<!-- END PAGE LEVEL PLUGINS -->

<!-- BEGIN PAGE LEVEL SCRIPTS -->

<script src="media/js/app.js"></script>

<script src="media/js/form-samples.js"></script>

<script src="media/js/app.js"></script>

<script src="media/js/table-advanced.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script src="media/js/a-user-editable.js"></script>
<script src="media/js/datetimepicker.min.js"></script>
<script src="media/js/functions.js"></script>

<script>

    jQuery(document).ready(function () {
        App.init();
        TableEditable.init();

        $(".upgrade").click(function () {
            var href = $(this).attr("href");
            var num = href.charAt(href.length - 1);
            if (num == '1') {
                alert("该用户已经是会员！");
                return false;
            } else {
                if (window.confirm("确定升级该用户为会员吗?")) {
                    //   $("form").attr("action", href).submit();
                    return true;
                } else {
                    return false;
                }
            }
        });

        $(".delete").click(function () {

            if (window.confirm("确定删除该用户？")) {
                return true;
            } else {
                return false;
            }

        });
    });

</script>

<!-- END JAVASCRIPTS -->

</body>

<!-- END BODY -->

</html>