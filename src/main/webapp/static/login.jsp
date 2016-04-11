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
                <li ><a href="index.jsp">Home</a></li>
                <div id="booktypeshow">

                </div>

                <!--判断用户是否登录-->
                <c:if test="${empty sessionScope.user}">
                    <li ><a  href="login.jsp">登录</a></li>
                    <li><a href="register.jsp">注册</a></li>
                </c:if>
                <li><a href="contact.jsp">联系我们</a></li>

            </ul>
        </div>

    </div>


    <div class="center center_content">
        <!--左侧展示-->
        <input class="pagename" type="hidden" value="login"/>
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
            </span>登录</div>
            <div class="feat_prod_box_details">
                <div class="contact_form">
                    <div class="form_subtitle">请输入登录信息</div>
                    <form name="register" action="Login" method="post">
                        <div class="form_row">
                            <label class="contact" for="name"><strong>Username:</strong></label>
                            <input type="text" class="contact_input"  id="name" name="name"/>
                        </div>


                        <div class="form_row">
                            <label class="contact" for="password"><strong>Password:</strong></label>
                            <input type="password" class="contact_input" id="password" name="password"
                                   onkeyup="value=value.replace(/[\W]/g,'') "
                                   onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"/>
                        </div>

                        <div class="form_row">
                            <div class="terms">
                                <input type="checkbox" name="terms" />
                                Remember me
                            </div>
                        </div>


                        <div class="form_row">
                            <input id="sub" type="submit" class="register" value="login" />
                        </div>

                    </form>

                </div>

            </div>
            </div>
            <div id="details"></div>




            <div class="clear"></div>
        </div><!--end of left content-->
        <!--end of left content-->

        <!--右侧-->
        <div class="center right_content">

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
</body>

</html>