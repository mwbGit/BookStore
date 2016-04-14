<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <title>博古书屋</title>
    <link rel="stylesheet" type="text/css" href="js/style.css"/>
</head>
<body>
<div>
    <!--Top展示-->
    <div class=" center header">
        <div class="logo"><a href="index"><img src="images/logo.gif" alt="" title="" border="0"/></a></div>
        <div id="menu">
            <ul>
                <li><a href="index">Home</a></li>
                <div id="booktypeshow">

                </div>

                <li><a href="getContact" style="float: right">联系我们 &nbsp</a></li>
                <!--判断用户是否登录-->
                <c:if test="${empty sessionScope.user}">
                    <li ><a href="Register" style="float: right">注册</a></li>
                    <li><a href="getLogin" style="float: right">登录</a></li>
                </c:if>

            </ul>
        </div>

    </div>


    <div class="center center_content">
        <!--左侧展示-->
        <input class="pagename" type="hidden" value="register"/>
        <div class="left_content">
            <div style="display:none" id="fyshow">
                <div class="crumb_nav">
                    <a href="javascript:;">Home</a> &gt;&gt; <span class="curType"></span>
                    <input id="typeid" type="hidden" value="0">
                </div>
                <div class="title "><span class="title_icon"><img src="images/bullet1.gif" alt="" title=""/></span>
                    <span class="curType"></span>书籍排行
                </div>
                <!--书籍展示-->
                <div class="new_products">

                    <div id="show">

                    </div>
                    <!--分页条-->
                    <div class="pagination">
                        <!-- 分页按键-->
                        <label class="lb "></label>

                        <div id="fy" class="page"></div>
                    </div>


                </div>

            </div>
            <div id="other">
                <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title=""/>
            </span>注册
                </div>

                <div class="feat_prod_box_details">
                    <div class="contact_form">
                        <div class="form_subtitle">注册信息</div>
                        <form name="register" action="getRegister" method="post">
                            <div class="form_row">
                                <label class="contact" for="name"><strong>用户名:</strong></label>
                                <input type="text" class="contact_input" name="name" id="name"
                                       onkeyup=" $('#err').hide();"
                                       value="${userAdd.name}"/>
                                <span id="err" style="color: #ff0000">${err}</span>
                            </div>
                            <div class="form_row">
                                <label class="contact" for="realname"><strong>真实姓名:</strong></label>
                                <input type="text" class="contact_input" name="realname" id="realname"
                                       value="${userAdd.realname}"/>
                            </div>
                            <div class="form_row">

                                <label class="contact" for="sex"><strong>性别:</strong></label>
                                <input type="radio" name="sex" value="男" checked="checked"/> 男
                                <input id="sex" type="radio" name="sex" value="女"/> 女
                            </div>

                            <div class="form_row">
                                <label class="contact" for="password"><strong>密码:</strong></label>
                                <input type="password" class="contact_input" name="password" id="password"
                                       onkeyup="value=value.replace(/[\W]/g,'') "
                                       onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"/>
                            </div>
                            <div class="form_row">
                                <label class="contact" for="password1"><strong>确认密码:</strong></label>
                                <input type="password" class="contact_input" name="password1" id="password1" onkeyup="value=value.replace(/[\W]/g,'')
                            "
                                       onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"/>
                            </div>


                            <div class="form_row">
                                <label class="contact" for="tel"><strong>手机号:</strong></label>
                                <input type="text" class="contact_input" name="tel" id="tel" value="${userAdd.tel}"/>
                            </div>
                            <div class="form_row">
                                <label class="contact" for="email"><strong>邮箱:</strong></label>
                                <input type="text" class="contact_input" name="email" id="email"
                                       value="${userAdd.email}"/>
                            </div>
                            <div class="form_row">
                                <label class="contact" for="address"><strong>地址:</strong></label>
                                <input type="text" class="contact_input" name="address" id="address"
                                       value="${userAdd.address}"/>
                            </div>

                            <div class="form_row">
                                <label class="contact" for="zipcode"><strong>邮编:</strong></label>
                                <input type="text" class="contact_input" name="zipcode" id="zipcode"
                                       value="${userAdd.zipcode}"/>
                            </div>

                            <div class="form_row">
                                <input id="sub" type="submit" class="register" value="注册"/>
                            </div>
                        </form>
                    </div>

                </div>

            </div>


            <div id="details"></div>
            <div class="clear"></div>
        </div>
        <!--end of left content-->
        <!--end of left content-->

        <!--右侧-->
        <div class="center right_content">

            <!--右侧关于我们-->
            <div class="title"><span class="title_icon"><img src="images/bullet3.gif" alt="" title=""/>
            </span>博古书屋
            </div>
            <div class="about">
                <p>
                    <img src="images/about.gif" alt="" title="" class="right"/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    博古书屋,专注于古典历史网上购物书店，致力于为消费者提供更多历史书籍选择、更低价格、更为便捷购物体验。
                    含括中国史、世界史、史家名著、文物考古、史学理论、逸闻野史、历史随笔、史料典籍、历史地理等众多类别,
                    支持全网比价、货到付款、上门退换货! </p>

            </div>
            <div class="clear"></div>
            <!--右侧热销-->
            <div class="right_box">

                <div class="title"><span class="title_icon"><img src="images/bullet4.gif" alt="" title=""/></span>热销书籍
                </div>
                <div id="bookhotshow"></div>

            </div>

            <!--右侧新书-->
            <div class="right_box">

                <div class="title"><span class="title_icon"><img src="images/bullet4.gif" alt="" title=""/></span>新书排行
                </div>

                <div id="booktnewshow"></div>

            </div>
        </div>
        <!--end of right content-->

        <div class="clear"></div>
    </div>
    <!--end of center content-->


    <div class="center footer">
        <div class="right_footer">
            <a href="javascript:;" target="_blank">
                &copy; 2015 com.mwb.cn email:562684394@qq.com</a>
            <a href="manager/adminlogin" target="_blank">管理</a>
        </div>
    </div>
</div>

<script type="application/javascript" src="js/jquery-1.10.1.min.js"></script>
<script type="application/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.goup.min.js"></script>
<script type="application/javascript" src="js/useredit.js"></script>
<script type="application/javascript" src="js/bookshow.js"></script>

</body>
</html>