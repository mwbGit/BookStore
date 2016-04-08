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
        var author = $("#author").val();
        var introduction = $("#introduction").val();
        var inventory = $("#inventory").val();

        if (name == "" || name.length > 20 ) {
           alert("书名格式不正确！")
            return false;
        }

        if (press == "" || press.length >30 ) {
            alert("出版社格式不正确！")
            return false;
        }
        if(!date()){
            return false;
        }
        if (author == "" || author.length > 20 ) {
           alert("作者格式不正确！")
            return false;
        }
        if (introduction == "" || introduction.length > 500 ) {
           alert("简介格式不正确！")
            return false;
        }
        if(!price("marketprice")||! price("memberprice")){
            return false;
        }
        if(parseInt($("#marketprice").val())<parseInt($("#memberprice").val())){
            alert("会员价应低于市场价！")
            return false;
        }
        var sum= /^[1-9]\d*$/;
        if (inventory == "" || inventory.length > 20 || !sum.test(inventory)) {
                alert("存量格式不正确！");
            return false;
        }
        return true;
    };


    //日期格式验证
    function date(){
        var a = /^(\d{4})-(\d{2})-(\d{2})$/
        if (!a.test(document.getElementById("date").value)) {
            alert("日期格式不正确!")
            return false
        }else{
            return true;
        }
    }
    //金额格式验证
    function price(id){
        if(document.getElementById(id).value==""){
            alert("金额为空!")
            return false
        }
        var a = /^(([1-9]\d*)|\d)(\.\d{1,2})?$/
        if (!a.test(document.getElementById(id).value)) {
            alert("金额格式不正确!")
            return false
        }else{
            return true;
        }
    }


//价格text离开验证
    $('#marketprice').blur(function(){
        price("marketprice");
    });
    $('#memberprice').blur(function(){
        price("memberprice");
        if(parseInt($("#marketprice").val())<parseInt($("#memberprice").val())){
            alert("会员价应低于市场价！")
            return false;
        }
    });
    $('#date').blur(function(){
        date();
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