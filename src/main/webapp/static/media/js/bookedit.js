jQuery(document).ready(function () {


    $(".sub").click(function () {
        var marketprice=$(".mk").val();
        var  memberprice=$(".mb").val();
        var inventory=$(".it").val();
        var id=$(".fid").val();

        var a = /^(([1-9]\d*)|\d)(\.\d{1,2})?$/;
        if (!a.test(marketprice)||!a.test(memberprice)) {
            $.MsgBox({
                msg: "金额格式不正确！",
                type: "alert",
                opacity: .5 //遮罩层透明度
            });
            setTimeout('$("#msg_box,#msg_con").remove()', 1500);
            return false;
        }
        if(parseFloat(memberprice)>parseFloat(marketprice)){
            $.MsgBox({
                msg: "会员价应小于市场价！",
                type: "alert",
                opacity: .5 //遮罩层透明度
            });
            setTimeout('$("#msg_box,#msg_con").remove()', 1500);
            return false;
        }
        var sum= /^[1-9]\d*$/;
        if (inventory == "" ||inventory.length > 20 || !sum.test(inventory)) {
            $.MsgBox({
                msg: "存量格式不正确！",
                type: "alert",
                opacity: .5 //遮罩层透明度
            });
            setTimeout('$("#msg_box,#msg_con").remove()', 1500);
            return false;
        }
        $.MsgBox({
            msg: "修改成功！",
            type: "alert",
            opacity: .5 //遮罩层透明度
        });
        setTimeout('$("#msg_box,#msg_con").remove()', 1500);
        $(".mk"+id).text(marketprice);
        $(".mb"+id).text(memberprice);
        $(".it"+id).text(inventory);
        $(".show").hide();
        $.ajax({
            type: "post", //请求方式
            async: false, //同步和异步的参数
            dataType: "json",
            url: "bookEdit?id="+id+"&marketprice="+marketprice+"&memberprice="+
            memberprice+"&inventory="+inventory,
            // data: params,
            success: function (data) {

            }
        });
    });
    $(".shwoedit").click(function () {
        var id= $(this).attr("href");
        $(".show").show();
        var marketprice= $(".mk"+id).text();
        var memberprice= $(".mb"+id).text();
        var inventory= $(".it"+id).text();
        var bookname= $(".bn"+id).text();
        $(".mk").val(marketprice);
        $(".mb").val(memberprice);
        $(".it").val(inventory);
        $(".fid").val(id);
        $(".bn").html(bookname);
        return false;
    });

    $(".cal").click(function () {
        $(".show").hide();
    });

    $(".delete").click(function () {
        if (window.confirm("确定删除?")) {
            return true;
        } else {
            return false;
        }

    });
});