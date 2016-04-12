//mwb_日志查询


//判断查询条件
function Judge() {
    //选择的信息
    var type = $('.select_type option:selected').val();
    var mobile = $("#phone_number").val();
    var start = $("#start").val();
    var beginDate = $("#beginDate").val();
    var endDate = $("#endDate").val();
    var d1 = new Date(beginDate.replace(/\-/g, "\/"));
    var d2 = new Date(endDate.replace(/\-/g, "\/"));

    if (beginDate != "" && endDate != "" && d1 >= d2) {
         $.MsgBox({
                    msg: "开始时间不能大于结束时间！",
                    type: "alert"
          });
        return false;
    }
    if (mobile == "" || mobile.length < 3) {
        $.MsgBox({
            msg: "至少输入3位uri！",
            type: "alert",
            opacity: .5 //遮罩层透明度
        });
        var t1 = setTimeout('$("#msg_box,#msg_con").remove()', 1500);
        return false;
    }
    return true;
}
jQuery(document).ready(function ($) {
    $(".tooltips").tooltip();//启动提示
//点击查询 分页显示
    $("#select").click(function () {

        //判断条件
        if (!Judge()) {
            return false;
        }
        $.MsgBox({
            msg: "查询中...",
            type: "alert",
            opacity: .5//遮罩层透明度
        });

        setPage(1);//分页展示
      });
        $("#row").change(function () {//显示条数改变时
            setPage(1);
            return;
        });

        //分页展示   pageindex当前页数
        function setPage(pageindex) {
            var pages;//总页数
            var pageindex = pageindex;
            var a = [];
            var params = $('form').serialize(); //序列化表单的值
            //设置显示多少数据 container 显示容器，pages 总页数
             var size = $("#row option:selected").val();
             var container = document.getElementById("fy");
            //处理显示数据
            $.ajax({
                type: "post", //请求方式
                // async: false, //同步和异步的参数
                dataType: "json",
                url: "Log_Select?size=" + size + "&page=" + pageindex, //发送请求地址
                data: params,
                success: function (data) {

                    if (data.pages == 0) {
                        //请查看smallarAlert.js文件配置详情
                        $("#show").html("").hide();
                        $("#fy").html("").hide();
                        $(".lb").empty().hide();
                        $("#msg_box,#msg_con").remove();
                        $.MsgBox({
                            msg: "没有查询到数据，请重试！",
                            btnBg: "#666666",
                            type: "alert"
                        });
                        var t = setTimeout('$("#msg_box,#msg_con").remove()', 1000);
                        return false;
                    } else {
                        //显示内容div 分页div 总数据label,清空详情div
                        $("#show").html("").show();
                        $("#fy").html("").show();
                        $(".lb").empty().show();
                        var t = setTimeout('$("#msg_box,#msg_con").remove()', 100);
                    }

                    //每页要显示的条目数
                    pages = data.pages;
                    $(".lb").empty().append(" 共有" + data.count + "条结果");
                    var str = '<table class="table table-bordered table-hover" id="sample_1">';
                    str += '<thead><tr><th width="5%"></th>';
                    //获取head body
                    $.each(data.list, function (index, values) {
                        var Column = 1;
                        //现实表头
                        if (index == 0) {
                            $.each(values, function (index1, value1) {
//                      获取内容  没有固定要 显示或者不显示哪列 可用
//                            Column++;
//                            str += '<td >' + value2 + '</td>';
//                            if (Column % 6== 0) {
//                                return false;
//                            }
                                //要显示这列
                                if (index1 == "statusCode" || index1 == "messageTime" || index1 == "opTime" || index1 == "submitTime" || index1 == "completeTime" || index1 == "requestTime" || index1 == "responceTime") {
                                    str += '<th class="hidden-480" width="10%" height="1px">' + index1 + '</th>';
                                    Column++;
                                }
                                //不要显示这列
                                else if (Column > 4 || index1 == "id" || index1 == "sessionId" || index1 == "messageId" || index1 == "impi") {
                                }
                                else if (Column <= 4) {
                                    str += '<th class="hidden-480"  width="10%"  height=1px">' + index1 + '</th>';
                                    Column++;
                                }
                            });
                            str += '</tr></thead><tbody>';
                        }
                        //详情按键button
                        str += '<tr class="' + index + '"><td><button  type="button" id="' + index + '" class="bu" >+</button></td>';
                        Column = 1;
                        //显示内容
                        $.each(values, function (index2, value2) {
                            if (index2 == "statusCode" || index2 == "messageTime" || index2 == "opTime" || index2 == "submitTime" || index2 == "completeTime" || index2 == "requestTime" || index2 == "responceTime") {

                                str += '<th class="hidden-480" >' + value2 + '</th>';
                                Column++;
                            }
                            else if (Column > 4 || index2 == "id" || index2 == "sessionId" || index2 == "messageId" || index2 == "impi") {
                            }
                            else if (Column <= 4) {
                                if (value2 != null) {
                                    var i = value2.search("@");
                                    if (i != -1)
                                        value2 = value2.substring(0, i);
                                }
                                str += '<th class="hidden-480" >' + value2 + '</th>';
                                Column++;
                            }
                        });

                        str += '</tr><tr><td style="display:none" id="index' + index + '" colspan="16"></td></tr>';
                    })
                    str += "</tbody></table>";
                    $("#show").html(str);

                    //详情事件
                    for (var i = 0; i < size; i++) {

                        $("#" + i + "").click(function () {//+号详情事件
                            var row = $(this).attr("id");//获取第几行
                            Details(data, row);
                        });
                        $("." + i + "").dblclick(function () {//双击时间
                            var row = $(this).attr("class");//获取第几行
                            Details(data, row);
                        });
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
                    a[a.length] = "<input id=\"goto\"  type=\"text\" /> <a href=\"#\" class=\"go\">GO</a>";

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
function Details(data, row) {
    var body = '<table class="table table-striped table-bordered table-hover table-full-width" ';
    // var row = $(this).attr("id");//获取第几行
    $.each(data.list, function (index, values) {
        if (row == index) {
            $.each(values, function (index3, value3) {
                body += '<tr><th style="width:10px;">' + index3 + '</th><td >' + value3 + '</td></tr>';
            });
            return false;
        }
    });
    body += '</table>';
    var rowid = "#index" + row;
    $(rowid).show();
    if ($("#" + row).text() == '+') {

        $(rowid).html(body).show();
        $("#" + row).text('-');
    } else {
        $("#" + row).text('+');
        $(rowid).html(body).hide();
    }
}