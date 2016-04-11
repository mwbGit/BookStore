jQuery(document).ready(function () {
//mengweibo 管理员 -角色管理  2015.11.31

    var selected = $(".select option:selected").val();
    $.ajax({
        type: "post", //请求方式
        async: false, //同步和异步的参数
        dataType: "json",
        url: "User_Manage?html_type=rolemenu_manage&type=role",
        success: function (data) {
            $.each(data.role_list, function (index, values) {
                var op="";
                if(index<data.role_list.length){
                $.each(values, function (index1, value1){

                    if (index1 == "id"){
                        op+='<option value="' + value1 + '">';
                    }if (index1 == "description")
                        op+=value1 + '</option>';

            });}
            $(".sel").append(op);
        
    });

}
});
get_ajax("role_query", selected);
function get_ajax(type, params) {

    $("#all_selected:checkbox").removeAttr("checked");
    $("#remove:checkbox").removeAttr("checked");
    $("[name='Menu']").removeAttr("checked");
    $.ajax({
        type: "post", //请求方式
        async: false, //同步和异步的参数
        dataType: "json",
        url: "User_Manage?html_type=rolemenu_manage&type=" + type, //发送请求地址
        data: {role: params},
        success: function (data) {
            if (type == 'role_query') {
                $.each(data.list, function (index, values) {
                    $.each(values, function (index2, value2) {
                        if (index2 == "Id") {
                            $("input:checkbox[value='" + value2 + "']").attr("checked", 'true');
                        }
                    });
                });
            }
            return false;
        }
    });
}

//提交事件
$("#sub").click(function () {
 var op = $(".sel option:selected").val();
if(op=="err"){
  $.MsgBox({
            msg: "您没有选择角色!",
            type: "alert"
 });

    return false;
}
if(op=="10"){
  $.MsgBox({
            msg: "系统管理员不可被修改!",
            type: "alert"
 });

    return false;
}
    $.MsgBox({
        msg: "确定要修改吗？",
        type: "confirm",
        callback: function () {
            var role = $("#row option:selected").val();
            var type = "role_update";
            var params = $('form').serialize(); //序列化表单的值
            $.ajax({
                type: "post", //请求方式
                async: false, //同步和异步的参数
                dataType: "json",
                url: "User_Manage?html_type=rolemenu_manage&type=" + type, //发送请求地址
                data: params,
                success: function (data) {
                    $.MsgBox({
                        msg: "修改成功!",
                        type: "alert"
                    });
                    return false;
                }
            });
        }
    });


});
//select改变事件
$(".sel").change(function () {
    var params = $(".sel option:selected").val();
    get_ajax("role_query", params);
    return false;
});
//checkbox改变事件
$(".mydiv :checkbox").change(function () {
    var this_val = $(this).val();
    var one = 0;//代表整百 200
    var two = 0;//代表整10 310
    if (this_val % 100 != 0) one = parseInt(this_val / 100) * 100;
    if (this_val % 10 != 0) two = parseInt(this_val / 10) * 10;

    //里向外 外向里 选中
    if ($(this).attr("checked")) {
        $("#remove:checkbox").removeAttr("checked");
        $('input:checkbox').each(function () {
            //里向外
            if ($(this).val() == one) {
                $(this).attr("checked", 'true');
            } else if (two != 0 && $(this).val() == two) {
                $(this).attr("checked", 'true');
            }
            //外向里
            if (one == 0 && parseInt($(this).val() / 100) * 100 == this_val) {
                $(this).attr("checked", 'true');
            } else if (two == 0 && parseInt($(this).val() / 10) * 10 == this_val) {
                $(this).attr("checked", 'true');
            }

        });
    }
    //取消
    else {
        $("#all_selected:checkbox").removeAttr("checked");
        var num = 0;
        var num1 = 0;
        $('input:checkbox').each(function () {
            //外向里取消
            if (one == 0 && parseInt($(this).val() / 100) * 100 == this_val) {
                $(this).removeAttr("checked");
            } else if (two == 0 && parseInt($(this).val() / 10) * 10 == this_val) {
                $(this).removeAttr("checked");
            }
            //三级菜单样式
            if (two != 0 && one != 0) {
                if (parseInt($(this).val() / 10) == parseInt(this_val / 10)) {
                    if ($(this).attr("checked")) {
                        num++;
                    }
                }
            }
            //二级菜单样式
            if (two == 0) {
                if (parseInt($(this).val() / 100) == parseInt(this_val / 100)) {
                    if ($(this).attr("checked")) {
                        num1++;
                    }
                }
            }
        });
        //三级菜单没有被选中 取消二级菜单 如果二级菜单都为空 取消一级菜单
        if (num == 1) {
            $("input:checkbox[value='" + two + "']").removeAttr("checked");
            $('input:checkbox').each(function () {
                //一级菜单是否取消
                if (parseInt($(this).val() / 100) == parseInt(this_val / 100)) {
                    if ($(this).attr("checked")) {
                        num1++;
                    }
                }

            });
        }
        //二级菜单没有被选中 取消一级菜单
        if (num1 == 1) {
            $("input:checkbox[value='" + one + "']").removeAttr("checked");
        }


    }
});

//全选
$("#all_selected").click(function () {

    $("input[name='Menu']").attr("checked", 'true');
    $("#remove:checkbox").removeAttr("checked");
    return false;
});
//取消全选
$("#remove").click(function () {

    $("#all_selected:checkbox").removeAttr("checked");
    $("[name='Menu']").removeAttr("checked");
    return false;
});
//重置
$("#reset").click(function () {
    $("#all_selected:checkbox").removeAttr("checked");
    $("[name='Menu']").removeAttr("checked");
    return false;
});
})
;
