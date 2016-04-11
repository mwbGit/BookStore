<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <title>Book Store</title>
    <link rel="stylesheet" type="text/css" href="js/style.css"/>
</head>
<body>
<div>
    <!--Top展示-->
    <div class=" center header">
        <div class="logo"><a href="index.html"><img src="images/logo.gif" alt="" title="" border="0"/></a></div>
        <div id="menu">
            <ul>
                <li class="selected"><a href="index.jsp">Home</a></li>
                <div id="booktypeshow">

                </div>

                <!--判断用户是否登录-->
                <c:if test="${empty sessionScope.user}">
                    <li><a href="login.jsp">登录</a></li>
                    <li><a href="register.jsp">注册</a></li>
                </c:if>
                <li><a href="contact.jsp">联系我们</a></li>

            </ul>
        </div>

    </div>


    <div class="center center_content">
        <!--左侧展示-->
        <input class="pagename" type="hidden" value="useredit"/>
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
            </span>修改
                </div>

                <div class="feat_prod_box_details">
                    <div class="contact_form">
                        <div class="form_subtitle">修改信息</div>
                        <form name="register" action="getEdit" method="post">
                            <div class="form_row">
                                <label class="contact" for="name"><strong>用户名:</strong></label>
                                <input type="hidden" name="id" value="${UserShow.id}"/>
                                <input type="text" value="${UserShow.name}" class="contact_input" name="name" id="name"
                                       onkeyup=" $('#err').hide();"/>
                                <span id="err" style="color: #ff0000">${err}</span>
                            </div>
                            <div class="form_row">
                                <label class="contact" for="realname"><strong>真实姓名:</strong></label>
                                <input type="text" value="${UserShow.realname}" class="contact_input" name="realname"
                                       id="realname"/>
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
                                <input type="text" value="${UserShow.tel}" class="contact_input" name="tel" id="tel"/>
                            </div>
                            <div class="form_row">
                                <label class="contact" for="email"><strong>邮箱:</strong></label>
                                <input type="text" value="${UserShow.email}" class="contact_input" name="email"
                                       id="email"/>
                            </div>
                            <div class="form_row">
                                <label class="contact" for="address"><strong>地址:</strong></label>
                                <input type="text" value="${UserShow.address}" class="contact_input" name="address"
                                       id="address"/>
                            </div>

                            <div class="form_row">
                                <label class="contact" for="zipcode"><strong>邮编:</strong></label>
                                <input type="text" value="${UserShow.zipcode}" class="contact_input" name="zipcode"
                                       id="zipcode"/>
                            </div>

                            <div class="form_row">
                                <input id="sub" type="submit" class="register" value="修改"/>
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
            <!--判断用户是否登录-->
            <!--用户信息-->
            <c:if test="${!empty sessionScope.user}">
                <div class="currency">
                    <div class="home_cart_content">
                        <span class="red">    您好<c:if test="${user.members!=0}">会员</span></c:if>: ${user.name} | <a href="userEdit">修改信息</a> |<a href="getOder"> 订单</a>|<a href="logOut">
                        退出</a></span>
                    </div>

                </div>

                <!--右侧购物车-->
                <div class="cart">
                    <div class="title">
                        <a href="getMyCar">
                        <span class="title_icon">
                    <img src="images/cart.gif"/> 购物车</span>
                        </a>
                    </div>
                    <div class="home_cart_content">
                        <span id="sum"></span>本 | <span class="red">总价: <span id="price"></span>元</span>
                    </div>

                </div>
            </c:if>
            <div class="clear"></div>

            <!--右侧关于我们-->
            <div class="title"><span class="title_icon"><img src="images/bullet3.gif" alt="" title=""/></span>About Our
                Store
            </div>
            <div class="about">
                <p>
                    <img src="images/about.gif" alt="" title="" class="right"/>
                    当当网，综合性网上购物中心。致力于为消费者提供更多选择、更低价格、更为便捷的一站式购物体验。包括服装、鞋包、图书、家居、孕.婴.童等众多品类,支持全网比价、货到付款、上门退换货! </p>

            </div>
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
        <div class="left_footer"><img src="images/footer_logo.gif" alt="" title=""/><br/> <a
                href="http://www.cssmoban.com/" title="free templates">cssmoban</a></div>
        <div class="right_footer">
            <a href="#">home</a>
            <a href="#">about us</a>
            <a href="#">services</a>
            <a href="#">privacy policy</a>
            <a href="#">contact us</a>

        </div>


    </div>


</div>

<script type="application/javascript" src="js/jquery-1.10.1.min.js"></script>
<script type="application/javascript" src="js/bookshow.js"></script>
<script type="application/javascript" src="js/useredit.js"></script>
</body>
</html>