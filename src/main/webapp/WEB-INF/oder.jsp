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
        <div class="logo"><a href="index"><img src="images/logo.gif" alt="" title="" border="0"/></a></div>
        <div id="menu">
            <ul>
                <li ><a href="index">Home</a></li>
                <div id="booktypeshow">

                </div>

                <li><a href="getContact" style="float: right">联系我们 &nbsp</a></li>


            </ul>
        </div>

    </div>


    <div class="center center_content">
        <!--左侧展示-->
        <input class="pagename" type="hidden" value="oder"/>
        <form action="getMyCar" method="post"></form>
        <div class="left_content">
            <div style="display:none" id="fyshow">
                <div class="crumb_nav">
                    <a href="javascript:;">Home</a> &gt;&gt; <span class="curType"></span>
                    <input id="typeid" type="hidden" value="0">
                </div>
                <div class="title "><span class="title_icon"><img src="images/bullet1.gif" alt="" title=""/></span>
                    <span class="curType"></span>书籍排行</div>
                <!--书籍展示-->
                <div class="new_products">

                    <div id="show">

                    </div>
                    <!--分页条-->
                    <div class="pagination">
                        <!-- 分页按键-->
                        <label  class="lb " ></label>
                        <div id="fy" class="page"></div>
                    </div>


                </div>

            </div>
            <div id="other">
                <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" />
                </span>My Oder</div>

                <div class="feat_prod_box_details">
                    <c:if test="${empty requestScope.sky}">
                    <form action="getOder" method="post"></form>
                    <table class="cart_table">
                        <tr class="cart_title">
                            <td width="10%">图片</td>
                            <td width="*">书名</td>
                            <td width="10%">单价</td>
                            <td width="10%">本书</td>
                            <td width="12%">总价</td>
                            <td width="10%">状态</td>
                            <td width="10%">移除</td>
                        </tr>
                        <c:forEach items="${requestScope.oders}" var="OderDetails">
                        <tr>
                            <td><a class="details" href="${OderDetails.book.id}"><img src="${OderDetails.book.img}"  border="0" class="cart_thumb imgsmall" /></a></td>
                            <td>${OderDetails.book.name}</td>
                            <td>${OderDetails.oder.user.members!=0?OderDetails.book.memberprice:OderDetails.book.marketprice}</td>
                            <td>${OderDetails.num}本</td>
                            <td>${OderDetails.price}元</td>
                            <td>${OderDetails.status==0?"<span class='blue'> 未发货</span>":"<span class='red'> 已发货</span> "}</td>
                            <td><a class="oderdelete" href="deleteOder?id=${OderDetails.id}">删除</a><input type="hidden" value="${OderDetails.status}"/></td>
                        </tr>

                        </c:forEach>
                    </table>
                        <a id="clearoder" href="clearOder" class="checkout">清空已发货订单</a>
                    </c:if>
                    <c:if test="${!empty requestScope.sky}">
                      <h1> 您已经没有订单了！</h1>
                    </c:if>
                </div>
            </div>
            <div id="details"></div>




            <div class="clear"></div>
        </div><!--end of left content-->
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
<script type="application/javascript" src="js/jquery-1.10.1.min.js"></script>
<script type="application/javascript" src="js/bookshow.js"></script>
<script type="application/javascript" src="js/cart.js"></script>
</body>

</html>