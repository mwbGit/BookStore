/**
 * Created by Administrator on 2016/4/6 0006.
 */
jQuery(document).ready(function ($) {
    $.ajax({
        type: "post", //请求方式
        // async: false, //同步和异步的参数
        dataType: "json",
        url: "getBookType", //发送请求地址
       // data: params,
        success: function (data) {
            var str;
            $.each(data, function (index, value) {
               str+=' <option value="'+value.id+'">'+value.name +'</option>';
            });
            $("#type").html(str);
        }
    });
    //提交验证
    function Judge() {
        var name = $("#name").val();
        var press = $("#press").val();
        var pressdate = $("#pressdate").val();
        var author = $("#author").val();
        var introduction = $("#introduction").val().trim();
        var inventory = $("#inventory").val();

        if (name == "" || name.length > 30 ) {
            $.MsgBox({
                msg: "书名格式不正确！",
                type: "alert",
                opacity: .5 //遮罩层透明度
            });
            setTimeout('$("#msg_box,#msg_con").remove()', 1500);
            return false;
        }

        if (press == "" || press.length >30 ) {
            $.MsgBox({
                msg: "出版社格式不正确！",
                type: "alert",
                opacity: .5 //遮罩层透明度
            });
            setTimeout('$("#msg_box,#msg_con").remove()', 1500);
            return false;
        }
        //日期
        if(pressdate==""||pressdate==null){
            $.MsgBox({
                msg: "出版日期不能为空！",
                type: "alert",
                opacity: .5 //遮罩层透明度
            });
            setTimeout('$("#msg_box,#msg_con").remove()', 1500);
            return false;
        }
        if (author == "" || author.length > 20 ) {
            $.MsgBox({
                msg: "作者格式不正确！",
                type: "alert",
                opacity: .5 //遮罩层透明度
            });
            setTimeout('$("#msg_box,#msg_con").remove()', 1500);
            return false;
        }
        if (introduction == "" || introduction.length > 1000 ) {
            $.MsgBox({
                msg: "简介格式不正确！",
                type: "alert",
                opacity: .5 //遮罩层透明度
            });
            setTimeout('$("#msg_box,#msg_con").remove()', 1500);
            return false;
        }
        if(!price("marketprice")||!price("memberprice")){

            return false;
        }
        if(parseFloat($("#marketprice").val())<parseFloat($("#memberprice").val())){
            $.MsgBox({
                msg: "会员价应低于市场价！",
                type: "alert",
                opacity: .5 //遮罩层透明度
            });
            setTimeout('$("#msg_box,#msg_con").remove()', 1500);
            return false;
        }
        var sum= /^[1-9]\d*$/;
        if (inventory == "" || inventory.length > 20 || !sum.test(inventory)) {
            $.MsgBox({
                msg: "存量格式不正确！",
                type: "alert",
                opacity: .5 //遮罩层透明度
            });
            setTimeout('$("#msg_box,#msg_con").remove()', 1500);
            return false;
        }
        return true;
    };




    //金额格式验证
    function price(id){
        if(document.getElementById(id).value==""){
            $.MsgBox({
                msg: "金额为空！",
                type: "alert",
                opacity: .5 //遮罩层透明度
            });
            setTimeout('$("#msg_box,#msg_con").remove()', 1500);
            return false
        }else {
                var m = document.getElementById(id);
                var regex = /^\d+\.?\d{0,2}$/;
                if (!regex.test($("#"+id).val()))
                {
                    $.MsgBox({
                        msg: "金额输入有误！",
                        type: "alert",
                        opacity: .5 //遮罩层透明度
                    });
                    setTimeout('$("#msg_box,#msg_con").remove()', 1500);
                    $("#"+id).val("");
                    $("#"+id).focus();
                    return false;
                }else{
                    return true;
                }
        }

    }


//价格text按下验证
    $('#marketprice').keyup(function(){
        price("marketprice");
    });
    $('#memberprice').keyup(function(){
        price("memberprice");
        if(parseFloat($("#marketprice").val())<parseFloat($("#memberprice").val())){
            $.MsgBox({
                msg: "会员价应低于市场价！",
                type: "alert",
                opacity: .5 //遮罩层透明度
            });
            setTimeout('$("#msg_box,#msg_con").remove()', 1500);
            $("#memberprice").val("");
            $("#memberprice").focus();
            return false;
        }
    });

//表单提交
    $('#sub').click(function(){
        if(Judge()){
            return true;
        }else{
            return false;
        }

    });

});