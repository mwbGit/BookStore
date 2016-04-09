/**
 * 分页展示books
 */

jQuery(document).ready(function () {

        setPage(1);
        //分页展示   pageindex当前页数
        function setPage(pageindex) {
            var pages;//总页数
            var pageindex = pageindex;
            var a = [];
         //   var params = $('form').serialize(); //序列化表单的值
            //设置显示多少数据 container 显示容器，pages 总页数
            var size =12;
            var container = document.getElementById("fy");
            var id=$("#typeid").val();
            //处理显示数据
            $.ajax({
                type: "post", //请求方式
                // async: false, //同步和异步的参数
                dataType: "json",
                url: "getTypeBooksFy?id="+id+"&size=" + size + "&index=" + pageindex, //发送请求地址
                //data: params,
                success: function (data) {
                    var str="";
                    $.each(data.TypeBooks, function (index, Book) {
                        str+='<div class="new_prod_box"><a href="getBookDetails?id='+
                           Book.id+'">'+Book.name+'</a><div class="new_prod_bg"><a href="getBookDetails?id='+
                           Book.id+'"><img src="/bookstore'+Book.img+'" class="image thumb" border="0"/></a></div></div>';
                    });
                    //展示数据
                    $("#show").html(str);
                    pages=data.page.pages;

                    //共一页不显示分页按键
                    if(pages<2){
                        $("#fy").hide();
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
});
