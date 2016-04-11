/**
 * cart
 */
jQuery(document).ready(function () {
    $(".delete").click(function () {
        if (window.confirm("确定移除此书籍？")) {
            return true;
        } else {
            return false;
        }
    });
    $("#clear").click(function () {
        if (window.confirm("确定清空购物车？")) {
            return true;
        } else {
            return false;
        }
    });
    $("#checkout").click(function () {
        if (window.confirm("货到付款，确定？")) {
            $("form").submit();
            return false;
        } else {
            return false;
        }
    });
    $("#selectAll").click(function () {//全选
            $("input[name='cartid']").attr("checked", 'true');
            return false;
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

});
