/**
 * Created by Administrator on 2016/4/6 0006.
 * 管理员添加验证
 */
jQuery(document).ready(function ($) {
    $(".tooltips").tooltip();//启动提示
    //提交验证
    function Judge() {
        var name = $("#name").val();
        var password = $("#password").val();
        var password2 = $("#password2").val();
        var tel = $("#tel").val();
        var email = $("#email").val();
        var el = /[~#^$@%&!*.,。，()<>:;'"{}【】  ]/gi;
        if (name == "" || name.length > 10|| name.length < 3 || el.test(name)) {
            $.MsgBox({
                msg: "名称格式不正确！",
                type: "alert",
                opacity: .5 //遮罩层透明度
            });
            setTimeout('$("#msg_box,#msg_con").remove()', 1500);
            return false;
        }
        if (password != password2 || password.length > 16 || password2.length > 16 || password.length < 6 || password2.length < 6) {
            $.MsgBox({
                msg: "两次密码不一致或<br>长度小于6位大于16位！",
                type: "alert",
                opacity: .5 //遮罩层透明度
            });
            setTimeout('$("#msg_box,#msg_con").remove()', 1500);
            return false;
        }
        if (tel.length!=11) {
            $.MsgBox({
                msg: "不是11位手机号！",
                type: "alert",
                opacity: .5 //遮罩层透明度
            });
            setTimeout('$("#msg_box,#msg_con").remove()', 1500);
            return false;
        }
        el=/[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/;
        if (email == "" ||!el.test(email)) {
            $.MsgBox({
                msg: "Email格式不正确！",
                type: "alert",
                opacity: .5 //遮罩层透明度
            });
            setTimeout('$("#msg_box,#msg_con").remove()', 1500);
            return false;
        }
        return true;
    };


//表单提交
    $('#sub').click(function () {
        if (Judge()) {
            return true;
        } else {
            return false;
        }

    });

});