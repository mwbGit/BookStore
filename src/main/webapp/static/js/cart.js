/**
 * cart
 */
jQuery(document).ready(function () {
    //移除
    $(".delete").click(function () {
        if (window.confirm("确定移除此书籍？")) {
            return true;
        } else {
            return false;
        }
    });
    //清空
    $("#clear").click(function () {
        if (window.confirm("确定清空购物车？")) {
            return true;
        } else {
            return false;
        }
    });
    //结算
    $("#checkout").click(function () {
        if (window.confirm("货到付款，确定？")) {
            $("form").attr("action","checkOut").submit();
            return false;
        } else {
            return false;
        }
    });

    //清空未发货订单
    $("#clearoder").click(function () {//全选
        if (window.confirm("确定清空已发货订单？")) {
            return true;
        } else {
            return false;
        }
    });
    //订单删除
    $(".oderdelete").click(function () {
        var status=$(this).next().val();
        if(status=="0"){
            alert("不能移除未发货订单！");
            return false;
        }
        if (window.confirm("确定删除此订单？")) {
            return true;
        } else {
            return false;
        }
    });
    //加号按下
    $(".add").click(function () {
        var put=$(this).prev();
        var id=$(this).val();
        var type="add";
        $.ajax({
            type: "post", //请求方式
            async: false, //同步和异步的参数
            dataType: "json",
            url: "editCart", //发送请求地址
            data: {"type":type,"id":id},
            success: function (data) {
                put.val(data.num);
                if(data.flag){
                    $("#flag"+id).hide();
                }else{

                    $("#flag"+id).show();
                }
                $("#price"+id).html(data.price);
                count();
            }
        });
    });
    //减号按下
    $(".min").click(function () {
        var put=$(this).next();
        var id=$(this).val();
        var type="min";
        $.ajax({
            type: "post", //请求方式
            async: false, //同步和异步的参数
            dataType: "json",
            url: "editCart", //发送请求地址
            data: {"type":type,"id":id},
            success: function (data) {
                if(data.num==0){
                    //删除此行
                    put.parent().parent().remove();
                }else{
                    $("#price"+id).html(data.price);
                    put.val(data.num);
                    if(data.flag){
                        $("#flag"+id).hide();
                    }else{
                        $("#flag"+id).show();
                    }
                }
                count();
            }
        });
    });
    //书记数量按下
    $(".put").blur(function () {
        var put=$(this);
        var id=$(this).next().val();
        var type="put";
        var num=$(this).val();
        $.ajax({
            type: "post", //请求方式
            async: false, //同步和异步的参数
            dataType: "json",
            url: "editCart", //发送请求地址
            data: {"type":type,"id":id,"num":num},
            success: function (data) {
                if(data.num==0){
                    //删除此行
                    put.parent().parent().remove();
                }else{
                    $("#price"+id).html(data.price);
                    put.val(data.num);
                    if(data.flag){
                        $("#flag"+id).hide();
                    }else{
                        $("#flag"+id).show();
                    }
                }
                count();
            }
        });
    });
    //总计 右侧
    function count(){
        var price=0;
        var sum=0;
        $('.price').each(function () {
            price+=parseFloat($(this).text());
        });
        $('.put').each(function () {
            sum+=parseInt($(this).val());
        });
        price=price.toFixed(2);
        $("#count").html(sum+"本/"+price+"元");
        $("#price").html(price);
        $("#sum").html(sum);
    }
});
