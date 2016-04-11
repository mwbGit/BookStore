/**
 * 分页展示books
 */
jQuery(document).ready(function () {
    //每个面获取书籍信息展示 热销 类别 新书
    $.ajax({
        type: "post", //请求方式
        async: false, //同步和异步的参数
        dataType: "json",
        url: "getShow", //发送请求地址
        // data: params,
        success: function (map) {
            //购物车信息
            $("#sum").html(map.sum);
            $("#price").html(map.price);

            var hotbooks="";
            var newbooks="";
            var booktypes="";
            $.each(map.hotbooks, function (index, Book) {
                hotbooks+='<div class="new_prod_box"><a class="details" href="'+Book.id+'">'+Book.name+
                '</a><div class="new_prod_bg"><span class="new_icon"><img src="images/promo_icon.gif"/></span>' +
                '<a class="details" href="'+Book.id+'"><img src="'+Book.img+'" class="image thumb"' +
                ' border="0"/></a> </div></div>';
            });
            $.each(map.newbooks, function (index, Book) {
                newbooks+='<div class="new_prod_box"><a class="details" href="'+Book.id+'">'+Book.name+
                '</a><div class="new_prod_bg"><span class="new_icon"><img src="images/new_icon.gif"/></span>' +
                '<a  class="details" href="'+Book.id+'"><img src="'+Book.img+'" class="image thumb"' +
                ' border="0"/></a> </div></div>';
            });
            $.each(map.booktypes, function (index, BookType) {
                //     booktypes+='<li><a href="getTypeBooks?id='+BookType.id+'">'+BookType.name+'</a></li>';
                booktypes+='<li><a class="typeid" href="'+BookType.id+'">'+BookType.name+'</a></li>';
            });

            //展示数据
            $("#booktypeshow").html(booktypes);
            $("#bookhotshow").html(hotbooks);
            $("#booktnewshow").html(newbooks);
        }
    });

    if ($(".pagename").val() == "index") {
        setPage(1);
    }
    //分类被点击
    $(".typeid").click(function () {
        //页面来源
        $(".pagename").val("index");
        var href = $(this).attr("href");
        $("#typeid").val(href);
        $("#fyshow").show();
        $("#other").hide();
        $("#details").hide();
        setPage(1);
        return false;
    });
    //分页展示   pageindex当前页数
    function setPage(pageindex) {
        var pages;//总页数
        var pageindex = pageindex;
        var a = [];
        //   var params = $('form').serialize(); //序列化表单的值
        //设置显示多少数据 container 显示容器，pages 总页数
        var size = 12;
        var container = document.getElementById("fy");
        var id = $("#typeid").val();
        //处理显示数据
        $.ajax({
            type: "post", //请求方式
             async: false, //同步和异步的参数
            dataType: "json",
            url: "getTypeBooksFy?id=" + id + "&size=" + size + "&index=" + pageindex, //发送请求地址
            //data: params,
            success: function (data) {
                //当前类别
                $(".curType").html(data.curType.name);

                var str = "";
                $.each(data.TypeBooks, function (index, Book) {
                    str += '<div class="new_prod_box"><a  class="details" href="' +
                    Book.id + '">' + Book.name + '</a><div class="new_prod_bg"><a  class="details" href="' +
                    Book.id + '"><img src="' + Book.img + '" class="image thumb" border="0"/></a></div></div>';
                });
                //展示数据
                $("#show").html(str);

                //调用分类 详情监控
                details();
                pages = data.page.pages;

                //共一页不显示分页按键
                if (pages < 2) {
                    $("#fy").hide();
                }else{
                    $("#fy").show();
                }


                //分页按健展示
                //总页数少于10 全部显示,大于10 显示前3 后3 中间3 其余....
                if (pageindex == 1) {
                    a[a.length] = "<a href=\"#\" class=\"frist unclick\">首页</a><a href=\"#\" class=\"prev unclick\">上一页</a>";
                } else {
                    a[a.length] = "<a href=\"#\" class=\"frist\">首页</a><a href=\"#\" class=\"prev\">上一页</a>";
                }
                function setPageList() {
                    if (pageindex == i) {
                        a[a.length] = "<a href=\"#\" class=\"on\">" + i + "</a>";
                    } else {
                        a[a.length] = "<a href=\"#\">" + i + "</a>";
                    }
                }

                //总页数小于10
                if (pages <= 10) {
                    for (var i = 1; i <= pages; i++) {
                        setPageList();
                    }
                }
                //总页数大于10页
                else {
                    if (pageindex <= 4) {
                        for (var i = 1; i <= 5; i++) {
                            setPageList();
                        }
                        a[a.length] = "...<a href=\"#\">" + pages + "</a>";
                    } else if (pageindex >= pages - 3) {
                        a[a.length] = "<a href=\"#\">1</a>...";
                        for (var i = pages - 4; i <= pages; i++) {
                            setPageList();
                        }
                    }
                    else { //当前页在中间部分
                        a[a.length] = "<a href=\"#\">1</a>...";
                        for (var i = pageindex - 2; i <= pageindex + 2; i++) {

                            setPageList();
                        }
                        a[a.length] = "...<a href=\"#\">" + pages + "</a>";
                    }
                }
                if (pageindex == pages) {
                    a[a.length] = "<a href=\"#\" class=\"next unclick\">下一页</a><a href=\"#\" class=\"last unclick\">尾页 </a>";
                } else {
                    a[a.length] = "<a href=\"#\" class=\"next\">下一页</a><a href=\"#\" class=\"last\">尾页</a>";
                }
                a[a.length] = "<input id=\"goto\"  type=\"text\" style=\"width:30px;\"/> <a href=\"#\" class=\"go\">GO</a>";

                container.innerHTML = a.join("");

                //事件点击
                var pageClick = function () {
                    var oAlink = container.getElementsByTagName("a");
                    var inx = pageindex; //初始的页码
                    oAlink[0].onclick = function () { //点击首页
                        if (inx == 1) {
                            return false;
                        }
                        inx--;
                        setPage(1);
                        return false;
                    }
                    oAlink[1].onclick = function () { //点击上一页
                        if (inx == 1) {
                            return false;
                        }
                        inx--;
                        setPage(inx);

                        return false;
                    }
                    for (var i = 2; i < oAlink.length - 1; i++) { //点击页码
                        oAlink[i].onclick = function () {
                            inx = parseInt(this.innerHTML);
                            setPage(inx);
                            return false;
                        }
                    }
                    oAlink[oAlink.length - 3].onclick = function () { //点击下一页
                        if (inx == pages) {
                            return false;
                        }
                        inx++;
                        setPage(inx);
                        return false;
                    }
                    oAlink[oAlink.length - 2].onclick = function () { //点击尾页
                        if (inx == pages) {
                            return false;
                        }
                        inx++;
                        setPage(pages);
                        return false;
                    }
                    oAlink[0].onclick = function () { //点击首页
                        if (inx == 1) {
                            return false;
                        }
                        inx--;
                        setPage(1);
                        return false;
                    }
                    oAlink[oAlink.length - 1].onclick = function () { //点击跳转
                        inx = document.getElementById("goto").value;
                        //判断跳转是否符合条件
                        if (inx == "" || !(/^[0-9]*$/.test(inx)) || parseInt(inx) > pages) {
                            return false;
                        }
                        setPage(parseInt(inx));
                        return false;
                    }
                }()
            }
        });
    }


    //调用热销 新书 详情监控
    details();
    function details(){
        $(".details").click(function(){
            var href = $(this).attr("href");
            var str="";
            $.ajax({
                type: "post", //请求方式
                async: false, //同步和异步的参数
                dataType: "json",
                url: "getBookDetails?id="+href, //发送请求地址
                //data: params,
                success: function (Book) {
                    $("#fyshow").hide();
                    $("#other").hide();
                    $("#details").show();

                    str+='<div class="crumb_nav">'+
                    '<a href="javascript:;">Home</a> &gt;&gt; 书籍详情</div><div class="title"><span class="title_icon">' +
                    '<img src="images/bullet1.gif"/></span>'+Book.name+'</div><div class="feat_prod_box_details">' +
                    '<div class="prod_img"><a href="javascript:;"><img src="'+Book.img+'"' +
                    ' width="100px" height="150px" border="0"/></a><br/><br/><a target="_blank" href="'+Book.img+'"' +
                    ' rel="lightbox"><img src="images/zoom.gif" border="0"/></a> </div><div class="prod_det_box">' +
                    '<div class="box_top"></div><div class="box_center"><div class="prod_title"><h3>详情</h3></div>' +
                    '<div class="price"><strong>&nbsp;&nbsp; 名称:</strong> <span class="red">'+Book.name+'</span> </div>' +
                    '<div class="price"><strong> &nbsp;&nbsp; 作者:</strong> <span class="red">'+Book.author+'</span></div>' +
                    '<div class="price"><strong>&nbsp;&nbsp; 出版社:</strong> <span class="red">'+Book.press+'</span></div>' +
                    '<div class="price"><strong> &nbsp;&nbsp; 出版日期:</strong> <span class="red">'+Book.dateStr+'</span></div>' +
                    '<div class="price"><strong> &nbsp;&nbsp; 市场价:</strong> <span class="red">'+Book.marketprice+'</span></div>' +
                    '<div class="price"><strong> &nbsp;&nbsp; 会员价:</strong> <span class="red">'+Book.memberprice+'</span></div>' +
                    '<div class="price"><strong> &nbsp;&nbsp; 成交量:</strong> <span  class="red">'+Book.volume+'</span></div>' +
                    '<div class="price"><strong> &nbsp;&nbsp; 库存:</strong> <span class="red">'+Book.inventory+'</span></div>' +
                    '<a href="javascript:;" id="return" class="more"><input  type="button" class="register" value="返回"/></a>' +
                    '<a class="join" href="'+Book.id+'" class="more"> <input id="sub" type="button" class="register" value="加入"/></a>' +
                    '<div class="clear"></div></div><div class="box_bottom"></div></div><div class="clear"></div></div>' +
                    '<div id="demo" class="demolayout"><ul id="demo-nav" class="demolayout">' +
                    '<li><a class="active" href="#tab1">简介</a></li></ul><div class="tabs-container">' +
                    '<div style="display: block;" class="tab" id="tab1"><br> &nbsp;&nbsp;'+Book.introduction+'</div></div></div>';

                    $("#details").html(str);
                    ret();
                    join();
                }
            });
            return false;
        });

    }
    //点击返回
    function ret(){
        $("#return").click(function()       {
            if ($(".pagename").val() == "index") {
                $("#fyshow").show();
                $("#other").hide();

            }else if($(".pagename").val() == "cart"){
                $("form").attr("action", "getMyCar").submit();
            }else if($(".pagename").val() == "oder") {
                $("form").attr("action", "getOder").submit();
            }else
            {
                $("#fyshow").hide();
                $("#other").show();
            }
            $("#details").hide();
            return false;
        });
    }
    //加入购物车
    function join(){
        $(".join").click(function() {
            if(!window.confirm("确定将此书籍加入购物车？")){
                return false;
            }
          var id=  $(this).attr("href");
            $.ajax({
                type: "post", //请求方式
                async: false, //同步和异步的参数
                dataType: "json",
                url: "addCart", //发送请求地址
                 data: {id:id},
                success: function (map) {
                  if(map.err=="no"){
                      alert("请先登录！");
                  }else{
                      $("#sum").html(map.sum);
                      $("#price").html(map.price);
                  }
                }
            });

            return false;
        });
    }

});
