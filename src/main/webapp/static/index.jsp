<%@ page language="java" contentType="text/html; charset=UTF-8"
                pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8"/>
    <title>Book Store</title>
    <link rel="stylesheet" type="text/css" href="style.css"/>

</head>
<body>
<div>
    <% String path = request.getContextPath();%>
    <!--Top展示-->
    <div class=" center header">
        <div class="logo"><a href="index.html"><img src="images/logo.gif" alt="" title="" border="0"/></a></div>
        <div id="menu">
            <ul>
                <li class="selected"><a href="index">Home</a></li>
                <c:forEach items="${booktype}" var="BookType">
                    <li><a href="getTypeBooks?id=${BookType.id}">${BookType.name}</a></li>
                </c:forEach>

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
        <div class="left_content">
            <div class="crumb_nav">
                <a href="javascript:;">Home</a> &gt;&gt; 热销书籍
            </div>
            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title=""/></span>热销书籍</div>
            <!--书籍展示-->
            <div class="new_products">
                <c:forEach items="${hotbooks}" var="Book">
                    <div class="new_prod_box">
                        <a href="getBookDetails?id=${Book.id}">${Book.name}</a>

                        <div class="new_prod_bg">
                            <a href="getBookDetails?id=${Book.id}"><img src="<%=path%>${Book.img}" class="image thumb"
                                                                        border="0"/></a>
                        </div>
                    </div>
                </c:forEach>

                <!--分页条-->
                <div class="pagination">
                    <span class="disabled"><<</span><span class="current">1</span><a href="#?page=2">2</a><a
                        href="#?page=3">3</a>…<a href="#?page=199">10</a><a href="#?page=200">11</a><a href="#?page=2">>></a>
                </div>

            </div>


        </div>
        <!--end of left content-->

        <!--右侧-->
        <div class="center right_content">
            <!--判断用户是否登录-->
            <!--用户信息-->
            <c:if test="${!empty sessionScope.user}">
                <div class="currency">

                    <div class="home_cart_content">
                        您好 : ${user.name} | <a href="userEdit?id=${user.id}">修改信息</a> |<a href="logOut"> 退出</a></span>
                    </div>


                </div>

                <!--右侧购物车-->
                <div class="cart">
                    <div class="title">
                        <a href="getMyCar？id=${user.id}">
                        <span class="title_icon">
                    <img src="images/cart.gif"/> 购物车</span>
                        </a>
                    </div>
                    <div class="home_cart_content">
                        3本 | <span class="red">总价: 100元</span>
                    </div>


                </div>
            </c:if>
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

                <c:forEach items="${hotbook}" var="Book">

                    <div class="new_prod_box">
                        <a href="getBookDetails?id=${Book.id}">${Book.name}</a>

                        <div class="new_prod_bg">
                            <span class="new_icon"><img src="images/promo_icon.gif" alt="" title=""/></span>
                            <a href="getBookDetails?id=${Book.id}"><img src="<%=path%>${Book.img}" class="image thumb"
                                                                        border="0"/></a>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <!--右侧新书-->
            <div class="right_box">

                <div class="title"><span class="title_icon"><img src="images/bullet4.gif" alt="" title=""/></span>新书排行
                </div>
                <c:forEach items="${newbooks}" var="Book">

                    <div class="new_prod_box">
                        <a href="getBookDetails?id=${Book.id}">${Book.name}</a>

                        <div class="new_prod_bg">
                            <span class="new_icon"><img src="images/new_icon.gif" alt="" title=""/></span>
                            <a href="getBookDetails?id=${Book.id}"><img src="<%=path%>${Book.img}" class="image thumb"
                                                                        border="0"/></a>
                        </div>
                    </div>
                </c:forEach>

            </div>

        </div>
        <!--end of right content-->

        <div class="clear"></div>
    </div><!--end of center content-->


    <div class="center footer">
        <div class="left_footer"><img src="images/footer_logo.gif" alt="" title="" /><br /> <a href="http://www.cssmoban.com/" title="free templates">cssmoban</a></div>
        <div class="right_footer">
            <a href="#">home</a>
            <a href="#">about us</a>
            <a href="#">services</a>
            <a href="#">privacy policy</a>
            <a href="#">contact us</a>

        </div>


    </div>


</div>
</body>

</html>